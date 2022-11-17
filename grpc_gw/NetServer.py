# Copyright (c) 
#
# License Here
#
# Python implementation of a gprc network service handler

from concurrent import futures
import logging

import json

import grpc
import oc_interfaces_pb2
import oc_interfaces_pb2_grpc
import inventory_pb2
import inventory_pb2_grpc


def read_interface_info():
    # read the interface information and populate the network interface settings
    interface_list = []
    with open("interface_info.json") as interface_info:
        if_data = json.load(interface_info)
        for item in if_data:
            setting = oc_interfaces_pb2.Interface(
                name=item["name"],
                config = oc_interfaces_pb2.Config(
                    name=item["config"]["name"]
                ),
                state = oc_interfaces_pb2.State(
                    name=item["state"]["name"],
                    type=item["state"]["InterfaceType"],
                    mtu=item["state"]["mtu"],
                    loopback_mode=item["state"]["loopback"],
                    description=item["state"]["description"],
                    enabled=item["state"]["enabled"],
                    ifindex=item["state"]["IfIndex"],
                    admin_status=item["state"]["admin_status"],
                    oper_status=item["state"]["oper_status"]
                )
            )

            interface_list.append(setting)
            print(interface_list)
    return interface_list

def read_device_info():
    # read the device info file and populate the settings
    dev_info = []
    with open("device_info.json") as dev_data:
        for item in json.load(dev_data):
            devset = inventory_pb2.DeviceInfo(
                Name=item["name"],
                Description=item["description"],
                id=item["id"],
                mfg_name=item["manufacturing_name"],
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

class InventoryServicer(inventory_pb2_grpc.InventorySvcServicer):

    def __init__(self):
        # Add Initialization Stuff
        self.dev_data = read_device_info()

    def InventoryGet(self, request, context):
        print("### Received Get for the Device Inventory ###")
        with open("device_info.json") as device_data:
            for device in json.load(device_data):
                info = inventory_pb2.DeviceInfo(
                    Name=device["name"],
                    Description=device["description"],
                    id=device["id"],
                    mfg_name=device["manufacturing_name"],
                    mfg_date=device["manufacturing_date"],
                     hw_version=device["hardware_version"],
                    fw_version=device["firmware_version"],
                    sw_version=device["software_version"],
                    serial_no=device["serial_number"],
                    part_no=device["part_number"]
            )
        return inventory_pb2.InventoryGetResponse(status=inventory_pb2.API_STATUS_OK, DevInfo=info)

class NetInterfaceServicer(oc_interfaces_pb2_grpc.NetInterfaceServicer):

    def __init__(self):
        # Add initialization stuff
        if_data = read_interface_info()
    
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