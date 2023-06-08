# Copyright (c) 
#
# License Here
#
# Python implementation of a gprc client for testing Network Capabilities

import logging

import grpc

import openconfig_interfaces_pb2
import openconfig_interfaces_pb2_grpc
import inventory_pb2
import inventory_pb2_grpc

def get_DeviceInventory(stub):
    response = stub.GetInventory(inventory_pb2.GetInventoryRequest())
    if response:
        print("Received Device Inventory")
        print(response)
    else:
        print("Error in Device Inventory Request")

def intf_UpdateInterface(stub):
    print("****** Not Implemented Yet ******")

def intf_GetInterface(stub):
    print("****** Not Implemented Yet ******")

def intf_listInterfaces(stub):
    # The list request is empty, so the response is the return of the request
    response = stub.ListNetInterfaces(openconfig_interfaces_pb2.ListNetInterfacesRequest())
    print("Received Interfaces List Response")
    print(response)
    for intf in response:
        print("Interface Name:", intf.name)

def runClient():
    # NOTE(gRPC Python Team): .close() is possible on a channel and should be
    # used in circumstances in which the with statement does not fit the needs
    # of the code.
    print("Will try to get the Device data ...")
    with grpc.insecure_channel('localhost:50051') as channel:
        # Get the inventory data first
        stub = inventory_pb2_grpc.InventorySvcStub(channel)
        print("---- Get Device Inventory ----")
        get_DeviceInventory(stub)
        # Get the interface information
        stub = openconfig_interfaces_pb2_grpc.NetInterfaceServiceStub(channel)
        print("---- List Interfaces ----")
        intf_listInterfaces(stub)
        print("---- Retrieve Interface ----")
        intf_GetInterface(stub)
        print("---- Update Interface ----")
        intf_UpdateInterface(stub)

if __name__ == '__main__':
    logging.basicConfig()
    runClient()
