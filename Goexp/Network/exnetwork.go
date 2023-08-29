package main

import (
	"fmt"

	"github.com/vishvananda/netlink"
	// ipb "github.com/sandersms/Protos/protobuf/network/opencfg/v1alpha1/gen/go"
	"golang.org/x/sys/unix"
)

//type Netintfs struct {
//	Intfs map[string]*Ifports
// Intfs map[string]*ipb.NetInterface
//}

type Ifports struct {
	name     string
	ifindex  int
	iftype   string
	mtu      int
	loopback bool
	enabled  bool
	logical  bool
}

func main() {
	// Get the list of links on the device
	net_intfs, err := netlink.LinkList()
	if err != nil {
		panic(err)
	}

	//Initialize the datastore
	Intfs := make(map[int]*Ifports)
	// fmt.Println("Intfs:", Intfs)

	// Output the parameters retrieved for the list of links
	var idx int = 0
	for _, intf := range net_intfs {
		fmt.Println("type", intf.Type())
		fmt.Println("Index", intf.Attrs().Index)
		fmt.Println("Name", intf.Attrs().Name)
		fmt.Println("Flags", intf.Attrs().Flags)
		fmt.Println("MTU", intf.Attrs().MTU)
		fmt.Println("Raw Attributes", intf.Attrs())
		if intf.Attrs().RawFlags&unix.IFF_LOOPBACK != 0 {
			fmt.Println("Loopback interface")
		}
		fmt.Println("Encap Type", intf.Attrs().EncapType)
		// check for an actual device and not loopback interface
		if intf.Type() == "device" {
			netif := new(Ifports)
			// Add the information to the Interface structure for the fixed interfaces
			netif.name = intf.Attrs().Name
			netif.ifindex = intf.Attrs().Index
			netif.iftype = intf.Attrs().EncapType
			netif.mtu = intf.Attrs().MTU
			//fmt.Println("NetInterface:", netif)
			Intfs[idx] = netif
			// increment index
			idx++
		}
	}
	for i := range Intfs {
		fmt.Println(Intfs[i].name, Intfs[i].iftype, Intfs[i].mtu, Intfs[i].ifindex)
	}
}
