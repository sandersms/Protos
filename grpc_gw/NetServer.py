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
import openconfig_interfaces_pb2
import openconfig_interfaces_pb2_grpc
import inventory_pb2
import inventory_pb2_grpc


def read_interface_info():
    # read the interface information and populate the network interface settings
    interface_list = []
    for intf, if_info in psutil.net_if_stats().items():
        ifset = openconfig_interfaces_pb2.NetInterface(
            name=intf,
            config=openconfig_interfaces_pb2.Config(
                name=intf
            ),
            state = openconfig_interfaces_pb2.State(
            name=intf,
            type=0,
            mtu=if_info.mtu,
            loopback_mode=0,
            description=intf,
            enabled=1,
            ifindex=0,
            admin_state=1,
            oper_state= (1 if if_info.isup else 0)
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
                "yes" if entry.state.enabled else "no", "up" if entry.state.admin_state else "down",
                "up" if entry.state.oper_state else "down"))

    return interface_list

class InventoryServicer(inventory_pb2_grpc.InventorySvc):

    def __init__(self):
        # Add Initialization Stuff
        self.inv_data = devinventory.gather_device_info()

    def GetInventory(self, request, context):
        print("### Received Get for the Device Inventory ###")
        for entry, value in self.inv_data.items():
            print(entry)
            print("Variable type ", type(value))
            print(value)
            if entry == 'bios':
                biosdata = dict()
                biosdata = value
                print(biosdata)
            if entry == 'system':
                sysdata = dict()
                sysdata = value
                print(sysdata)
            if entry == 'baseboard':
                boarddata = dict()
                boarddata = value
                print(boarddata)
            if entry == 'chassis':
                platdata = dict()
                platdata = value
                print(platdata)
            if entry == 'processor':
                cpudata = dict()
                cpudata = value
                print(cpudata)
            if entry == 'memory':
                memdata = dict()
                memdata = value
                print(memdata)
            if entry == 'pci':
                busdata = dict()
                busdata = value
                print(busdata)
        data = inventory_pb2.Inventory(
            bios=biosdata,
            system=sysdata,
            baseboard=boarddata,
            chassis=platdata,
            processor=cpudata,
            memory=memdata,
            pci=busdata
        )
        print("Inventory data: ", data)
        return data

class NetInterfaceServicer(openconfig_interfaces_pb2_grpc.NetInterfaceService):

    def __init__(self):
        # Add initialization stuff
        self.if_data = read_interface_info()
    
    def GetNetInterface(self, request, context):
        print("### Get Interface ###")

    def ListNetInterfaces(self, request, context):
        print("### List Interfaces Request ###")
        print(self.if_data)
        listResponse = openconfig_interfaces_pb2.ListNetInterfacesResponse(net_interfaces=self.if_data)
        return listResponse

    def UpdateNetInterface(self,request, context):
        print("### Update Interface ###")

def AddNetServicertoserver(server):
    # Add the various servicer functions to the server
    openconfig_interfaces_pb2_grpc.add_NetInterfaceServiceServicer_to_server(NetInterfaceServicer(), server)
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