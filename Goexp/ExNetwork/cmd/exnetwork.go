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
	st_admin bool
	st_oper  string
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
		fmt.Println("OperState", intf.Attrs().OperState)
		fmt.Println("Raw Attributes", intf.Attrs())
		if intf.Attrs().RawFlags&unix.IFF_LOOPBACK != 0 {
			fmt.Println("Loopback interface")
		}
		fmt.Println("Encap Type", intf.Attrs().EncapType)
		fmt.Println("----------")
		// check for an actual device and not loopback interface
		if intf.Type() == "device" && intf.Attrs().EncapType != "loopback" {
			netif := new(Ifports)
			// Add the information to the Interface structure for the fixed interfaces
			netif.name = intf.Attrs().Name
			netif.ifindex = intf.Attrs().Index
			netif.iftype = intf.Attrs().EncapType
			netif.mtu = intf.Attrs().MTU
			if intf.Attrs().RawFlags&unix.IFF_LOOPBACK != 0 {
				netif.loopback = true
			}
			netif.st_oper = fmt.Sprint(intf.Attrs().OperState)
			//netif.st_oper = fmt.Println(intf.Attrs().OperState)
			if intf.Attrs().RawFlags&unix.IFF_UP != 0 {
				netif.st_admin = true
			}
			//fmt.Println("NetInterface:", netif)
			Intfs[idx] = netif
			// increment index
			idx++
		}
	}
	for i := range Intfs {
		fmt.Println(Intfs[i].name, Intfs[i].iftype, Intfs[i].mtu, Intfs[i].loopback, Intfs[i].ifindex, Intfs[i].st_admin, Intfs[i].st_oper)
	}
}
