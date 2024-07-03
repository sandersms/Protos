// Copyright (c) xxxx, .

// Package dpudev (DPU Device) is the main package of the application
package dpudev

import (
	"context"
	"fmt"
	"log"

	"github.com/sandersms/Protos/nwgate/pkg/utils"
	"github.com/vishvananda/netlink"
	"golang.org/x/sys/unix"

	ipb "github.com/opiproject/opi-api/network/opinetcommon/v1alpha1/gen/go"
)

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

// InitNetworkData initialize the network device information
func InitNetworkData() {
	// Get the list of links on the device
	net_intfs, err := netlink.LinkList()
	if err != nil {
		panic(err)
	}

	//Initialize the datastore
	Intfs := make(map[int]*Ifports)

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

// GetNetInterface gets the network interface information
func (s *Server) GetNetInterface(_ context.Context, in *ipb.GetNetInterfaceRequest) (*ipb.NetInterface, error) {
	log.Printf("GetNetInterface: Received from client %v", in)
	return &ipb.NetInterface{}, nil
}

// ListNetInterfaces provides a list of the network interfaces
func (s *Server) ListNetInterfaces(_ context.Context, in *ipb.ListNetInterfacesRequest) (*ipb.ListNetInterfacesResponse, error) {
	log.Printf("ListNetInterface: Received from client %v", in)

	// TODO Check any required fields
	if err := s.validateListNetInterfacesRequest(in); err != nil {
		log.Printf("ListNetInterfaces(): validation failure: %v", err)
		return nil, err
	}

	// fetch pagination from the database, calculate size and offset
	size, offset, err := utils.ExtractPagination(in.PageSize, in.PageToken, s.Pagination)
	if err != nil {
		return nil, err
	}

	return &ipb.ListNetInterfacesResponse{}, nil
}
