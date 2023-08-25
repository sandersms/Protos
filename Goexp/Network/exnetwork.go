package main

import (
	"fmt"

	"github.com/vishvananda/netlink"
	// ipb "github.com/sandersms/Protos/protobuf/network/opencfg/v1alpha1/gen/go"
)

type Netintfs struct {
	Intfs map[string]*Ifports
	// Intfs map[string]*ipb.NetInterface
}

type Ifports struct {
	name   string
	iftype string
}

func main() {
	// Get the list of links on the device
	net_intfs, err := netlink.LinkList()
	if err != nil {
		panic(err)
	}

	//Initialize the datastore
	Intfs := make(map[string]*Ifports)
	fmt.Println("Intfs:", Intfs)

	// Output the parameters retrieved for the list of links
	for _, intf := range net_intfs {
		if intf.Type() == "device" {
			netif := new(Ifports)
			fmt.Println("type", intf.Type())
			fmt.Println("Index", intf.Attrs().Index)
			fmt.Println("Name", intf.Attrs().Name)
			fmt.Println("Raw Attributes", intf.Attrs())
			// Add the information to the Interface structure for the fixed interfaces
			netif.name = intf.Attrs().Name
			netif.iftype = intf.Type()
			fmt.Println("NetInterface:", netif)
			Intfs = netif
		}
	}
	// fmt.Println(intfList)
}
