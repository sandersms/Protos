# Copyright (c) 
#
# License Here
#
# Python implementation of inventory handling
#   To retrieve the inventory information, the user/process needs to be running as root since the "dmidecode"
#   operation requires root level to perform the function.  Since some parameters are available from the 
#   /sys/class/dmi/id folder as read access, those could be retrieved from there; but, some are only root
#   privilege readable.  Using the dmidecode is more universal.
#

import subprocess
import psutil
from pylspci.command import IDResolveOption
from pylspci.parsers import VerboseParser

def read_sysvalue(item):
    base_cmd = "dmidecode --string "
    dmi_cmd = base_cmd + item
    try:
        value = subprocess.check_output(dmi_cmd, universal_newlines=True, shell=True)
    except:
        value = "Not Specified"
    return value

def get_bios_info():
    bios = dict()
    bios['vendor'] = read_sysvalue("bios-vendor")
    bios['version'] = read_sysvalue("bios-version")
    bios['date'] = read_sysvalue("bios-release-date")
#    print(bios)
    return bios

def get_system_info():
    system = dict()
    system['family'] = read_sysvalue("system-family")
    system['name'] = read_sysvalue("system-product-name")
    system['vendor'] = read_sysvalue("system-manufacturer")
    system['serial_number'] = read_sysvalue("system-serial-number")
    system['uuid'] = read_sysvalue("system-uuid")
    system['sku'] = read_sysvalue("system-sku-number")
    system['version'] = read_sysvalue("system-version")
#    print(system)
    return system

def get_chassis_info():
    chassis = dict()
    chassis['asset_tag'] = read_sysvalue("chassis-asset-tag")
    chassis['serial_number'] = read_sysvalue("chassis-serial-number")
    chassis['type'] = read_sysvalue("chassis-type")
    chassis['type_description'] = "-------------"
    chassis['vendor'] = read_sysvalue("chassis-manufacturer")
    chassis['version'] = read_sysvalue("chassis-version")
#    print(chassis)
    return chassis

def get_baseboard_info():
    baseboard = dict()
    baseboard['asset_tag'] = read_sysvalue("baseboard-asset-tag")
    baseboard['serial_number'] = read_sysvalue("baseboard-serial-number")
    baseboard['vendor'] = read_sysvalue("baseboard-manufacturer")
    baseboard['version'] = read_sysvalue("baseboard-version")
    baseboard['product'] = read_sysvalue("baseboard-product-name")
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