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
func InitNetworkData(s *Server) {
	// Get the list of links on the device
	net_intfs, err := netlink.LinkList()
	if err != nil {
		panic(err)
	}

	// Output the parameters retrieved for the list of links
	var ifloop bool = false
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
			ifloop = true
		}

		fmt.Println("----------")
		// check for an actual device and ethernet interface
		if intf.Type() == "device" && intf.Attrs().EncapType == "ether" {
			// check if the device exists
			netif, ok := s.Intfs[intf.Attrs().Name]
			if ok {
				log.Printf("Already existing interface %v", intf.Attrs().Name)
				fmt.Println("Interface %v exists", netif)
			}
			// Create the device in the list
			fmt.Println("Create the physical device in the list")

			Netintf := ipb.NetInterface{}
			Netintf.Config = &ipb.NetInterfaceConfig{
				Name:         intf.Attrs().Name,
				Type:         ipb.InterfaceType_INTERFACE_TYPE_ETHERNET,
				Mtu:          uint32(intf.Attrs().MTU),
				LoopbackMode: ifloop,
			}
			Netintf.State = &ipb.NetInterfaceState{
				Name:         intf.Attrs().Name,
				Type:         ipb.InterfaceType_INTERFACE_TYPE_ETHERNET,
				Mtu:          uint32(intf.Attrs().MTU),
				LoopbackMode: ifloop,
			}

			// add the interface to the detected set by adding to the list.
			s.Intfs[intf.Attrs().Name] = &ipb.NetInterface{
				Name:   intf.Attrs().Name,
				Config: Netintf.Config,
				State:  Netintf.State,
			}

			//			netif := new(s.Intfs)
			// Add the information to the Interface structure for the fixed interfaces
			//			netif.name = intf.Attrs().Name
			//			netif.ifindex = intf.Attrs().Index
			//			netif.iftype = intf.Attrs().EncapType
			//			netif.mtu = intf.Attrs().MTU
			//			if intf.Attrs().RawFlags&unix.IFF_LOOPBACK != 0 {
			//				netif.loopback = true
			//			}
			//			netif.st_oper = fmt.Sprint(intf.Attrs().OperState)
			//			if intf.Attrs().RawFlags&unix.IFF_UP != 0 {
			//				netif.st_admin = true
			//			}
			//fmt.Println("NetInterface:", netif)
			//			Intfs[idx] = netif
			// increment index
			//			idx++
		}
	}
	for _, Intfs := range s.Intfs {
		fmt.Println(Intfs.Name, Intfs.State.Name, Intfs.State.Type, Intfs.State.Mtu, Intfs.State.LoopbackMode)
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

	// Check any required fields
	if err := s.validateListNetInterfacesRequest(in); err != nil {
		log.Printf("ListNetInterfaces(): validation failure: %v", err)
		return nil, err
	}

	// fetch pagination from the database, calculate size and offset
	size, offset, err := utils.ExtractPagination(in.PageSize, in.PageToken, s.Pagination)
	if err != nil {
		return nil, err
	}

	// check the pagination for the response
	log.Printf("Limiting result len(%d) to [%d:%d]", len(s.Intfs), offset, size)

	return &ipb.ListNetInterfacesResponse{}, nil
}
