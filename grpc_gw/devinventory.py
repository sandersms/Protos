# Copyright (c) 
#
# License Here
#
# Python implementation of inventory handling
#
# Inventory Structure
#    BIOSInfo
#        vendor
#        version
#        date
#    SystemInfo
#        family
#        name
#        vendor
#        serial_number
#        uuid
#        sku
#        version
#    ChassisInfo
#        asset_tag
#        serial_number
#        type
#        type_description
#        vendor
#        version
#    BaseboardInfo
#        asset_tag
#        serial_number
#        vendor
#        version
#        product
#    CPUInfo
#        total_cores (psutil.cpu_count)
#        total_threads
#    MemoryInfo
#        total_physical_bytes
#        total_usable_bytes
#    PCIeDeviceInfo
#        driver
#        address
#        vendor
#        product
#        revision
#        subsystem
#        class
#        subclass
#

import subprocess
import psutil
from pylspci.command import IDResolveOption
from pylspci.parsers import VerboseParser

def get_bios_info():
    bios = dict()
    bios['vendor'] = subprocess.check_output("dmidecode --string bios-vendor", universal_newlines=True, shell=True)
    bios['version'] = subprocess.check_output("dmidecode --string bios-version", universal_newlines=True, shell=True)
    bios['date'] = subprocess.check_output("dmidecode --string bios-release-date", universal_newlines=True, shell=True)
#    print(bios)
    return bios

def get_system_info():
    system = dict()
    system['family'] = subprocess.check_output("dmidecode -t 1 | grep 'Family:' | awk '{print $2}'", universal_newlines=True, shell=True)
    system['name'] = subprocess.check_output("dmidecode --string system-product-name", universal_newlines=True, shell=True)
    system['vendor'] = subprocess.check_output("dmidecode --string system-manufacturer", universal_newlines=True, shell=True)
    system['serial_number'] = subprocess.check_output("dmidecode --string system-serial-number", universal_newlines=True, shell=True)
    system['uuid'] = subprocess.check_output("dmidecode --string system-uuid", universal_newlines=True, shell=True)
    system['sku'] = subprocess.check_output("dmidecode -t 1 | grep 'SKU Number:' | awk '{print $3}'", universal_newlines=True, shell=True)
    system['version'] = subprocess.check_output("dmidecode --string system-version", universal_newlines=True, shell=True)
#    print(system)
    return system

def get_chassis_info():
    chassis = dict()
    chassis['asset_tag'] = subprocess.check_output("dmidecode --string chassis-asset-tag", universal_newlines=True, shell=True)
    chassis['serial_number'] = subprocess.check_output("dmidecode --string chassis-serial-number", universal_newlines=True, shell=True)
    chassis['type'] = subprocess.check_output("dmidecode --string chassis-type", universal_newlines=True, shell=True)
    chassis['type_description'] = "-------------"
    chassis['vendor'] = subprocess.check_output("dmidecode --string chassis-manufacturer", universal_newlines=True, shell=True)
    chassis['version'] = subprocess.check_output("dmidecode --string chassis-version", universal_newlines=True, shell=True)
#    print(chassis)
    return chassis

def get_baseboard_info():
    baseboard = dict()
    baseboard['asset_tag'] = subprocess.check_output("dmidecode --string baseboard-asset-tag", universal_newlines=True, shell=True)
    baseboard['serial_number'] = subprocess.check_output("dmidecode --string baseboard-serial-number", universal_newlines=True, shell=True)
    baseboard['vendor'] = subprocess.check_output("dmidecode --string baseboard-manufacturer", universal_newlines=True, shell=True)
    baseboard['version'] = subprocess.check_output("dmidecode --string baseboard-version", universal_newlines=True, shell=True)
    baseboard['product'] = subprocess.check_output("dmidecode --string baseboard-product-name", universal_newlines=True, shell=True)
#    print(baseboard)
    return baseboard

def get_cpu_info():
    cpu = dict()
    cpu['total_cores'] = psutil.cpu_count(logical=False)
    cpu['total_threads'] = psutil.cpu_count()
    return cpu

def get_memory_info():
    memory = dict()
    memory['total_physical_bytes'] = psutil.virtual_memory().total
    memory['total_usable_bytes'] = psutil.virtual_memory().available
    return memory

def get_pci_info():
    devices = VerboseParser().run(id_resolve_option=IDResolveOption.NameOnly)
    pcis = []
    slot = None
    for device in devices:
#        print(device)
        if device:
            slot = {}
            slot['address'] = f'{device.slot}'
            slot['driver'] = f'{device.driver}'
            slot['vendor'] = f'{device.vendor}'
            slot['class'] = f'{device.cls}'
            slot['product'] = f'{device.device}'
            slot['revision'] = f'{device.revision}'
            slot['subsystem'] = f'{device.subsystem_device}'
            pcis.append(slot)
#            print(slot)
#    print(pcis)
    return pcis

def gather_device_info():
    inventory = dict()
    # get the bios information
    inventory['bios'] = get_bios_info()
    inventory['system'] = get_system_info()
    inventory['chassis'] = get_chassis_info()
    inventory['baseboard'] = get_baseboard_info()
    inventory['processor'] = get_cpu_info()
    inventory['memory'] = get_memory_info()
    inventory['pci'] = get_pci_info()

    return inventory

if __name__ == '__main__':
    inv = gather_device_info()
    print(inv)