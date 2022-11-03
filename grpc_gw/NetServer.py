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
        for item in json.load(interface_info):
            setting = oc_interfaces_pb2.Interface(
                name=item["name"]
            #    config=
            )
            interface_list.append(setting)
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
        return inventory_pb2.InventoryGetResponse(status=inventory_pb2.API_STATUS_OK, DevInfo=self.dev_data)

class NetInterfaceServicer(oc_interfaces_pb2_grpc.NetInterfaceServicer):

    def __init__(self):
        # Add initialization stuff
        if_data = read_interface_info()
    
    def NetInterfaceGet(self, request, context):
        print("### Get Interface ###")

    def NetInterfaceList(self, request, context):
        print("### List Interfaces ###")
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