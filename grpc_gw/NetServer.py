# Copyright (c) 
#
# License Here
#
# Python implementation of a gprc network service handler

from concurrent import futures
import logging

import json
from google.protobuf import json_format
import psutil

import grpc

import devinventory
import oc_interfaces_pb2
import oc_interfaces_pb2_grpc
import inventory_pb2
import inventory_pb2_grpc


def read_interface_info():
    # read the interface information and populate the network interface settings
    interface_list = []
    for intf, if_info in psutil.net_if_stats().items():
        ifset = oc_interfaces_pb2.Interface(
            name=intf,
            config=oc_interfaces_pb2.Config(
                name=intf
            ),
            state = oc_interfaces_pb2.State(
            name=intf,
            type=0,
            mtu=if_info.mtu,
            loopback_mode=0,
            description=intf,
            enabled=1,
            ifindex=0,
            admin_status=1,
            oper_status= (1 if if_info.isup else 0)
            )
        )
        interface_list.append(ifset)
#        print("mtu=%s, oper state=%s, speed=%s" % (if_info.mtu,
#              "up" if if_info.isup else "down", if_info.speed))
    for entry in interface_list:
        print(entry.state.name)
        print("type=%s, mtu=%s, loopback=%s, enabled=%s, admin status=%s, oper status=%s" % (
                "?" if entry.state.type else "Ethernet", entry.state.mtu,
                "yes" if entry.state.loopback_mode else "no",
                "yes" if entry.state.enabled else "no", "up" if entry.state.admin_status else "down",
                "up" if entry.state.oper_status else "down"))

    return interface_list

def read_device_info():
    # read the device info file and populate the settings
    dev_info = []
    with open("device_info.json") as dev_data:
        for item in json.load(dev_data):
            devset = inventory_pb2.DeviceInfo(
                name=item["name"],
                description=item["description"],
                id=item["id"],
                mfgname=item["manufacturing_name"],
                mfg_date=item["manufacturing_date"],
                hw_version=item["hardware_version"],
                fw_version=item["firmware_version"],
                sw_version=item["software_version"],
                serial_no=item["serial_number"],
                part_no=item["part_number"]
            )
            dev_info.append(devset)
            print(dev_info)
    return dev_info

class InventoryServicer(inventory_pb2_grpc.InventorySvc):

    def __init__(self):
        # Add Initialization Stuff
        self.inv_data = devinventory.gather_device_info()

    def GetInventory(self, request, context):
        print("### Received Get for the Device Inventory ###")
#        data = dict(self.inv_data)
#        inven = dict(inventory_pb2.Inventory)
#        print("## Base message ", inven)
        for entry, value in self.inv_data.items():
            print(entry)
            print("Variable type ", type(value))
            print(value)
            if entry == 'bios':
                biosdata = dict()
                biosdata=value
                print(biosdata)
#                j_string = json.dumps(value)
#                print("## j_string", j_string)
#                data = dict(inventory_pb2.Inventory)(
#                    bios=value
#                    json_format.ParseDict(value, dict('bios'))
 #               )
#                json_format.ParseDict(value, data[entry])
#            data[entry] = j_string
#        data = inventory_pb2.Inventory
#        json_format.ParseDict(self.inv_data, data)
        data = inventory_pb2.Inventory(
            bios=biosdata
        )
        print("Inventory data: ", data)
        return data

class NetInterfaceServicer(oc_interfaces_pb2_grpc.NetInterfaceServicer):

    def __init__(self):
        # Add initialization stuff
        self.if_data = read_interface_info()
    
    def NetInterfaceGet(self, request, context):
        print("### Get Interface ###")

    def NetInterfaceList(self, request, context):
        print("### List Interfaces Request ###")
        listResponse = oc_interfaces_pb2.NetInterfaceListResponse()
        return listResponse

    def NetInterfaceUpdate(self,request, context):
        print("### Update Interface ###")

def AddNetServicertoserver(server):
    # Add the various servicer functions to the server
    oc_interfaces_pb2_grpc.add_NetInterfaceServicer_to_server(NetInterfaceServicer(), server)
    inventory_pb2_grpc.add_InventorySvcServicer_to_server(InventoryServicer(), server)

def server():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=4))
    AddNetServicertoserver(server)
    server.add_insecure_port('[::]:50051')
    server.start()
    print("Gateway started.  Awaiting inputs...")

    server.wait_for_termination()


if __name__ == '__main__':
    logging.basicConfig()
    server()