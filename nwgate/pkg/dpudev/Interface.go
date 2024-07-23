// Copyright (c) xxxx, .

// Package dpudev (DPU Device) is the main package of the application
package dpudev

import (
	"context"
	"fmt"
	"log"
	"net"

	"github.com/sandersms/Protos/nwgate/pkg/utils"
	"github.com/vishvananda/netlink"
	"golang.org/x/sys/unix"

	ipb "github.com/opiproject/opi-api/network/opinetcommon/v1alpha1/gen/go"
)

// InitNetworkData initialize the network device information
func InitNetworkData(s *Server) {
	// Get the list of links on the device
	net_intfs, err := netlink.LinkList()
	if err != nil {
		panic(err)
	}

	// Output the parameters retrieved for the list of links
	for _, intf := range net_intfs {
		var ifloop bool = false
		var ifenabled bool = false
		var ifadmin ipb.AdminState = ipb.AdminState_ADMIN_STATE_UNSPECIFIED
		var ifoper ipb.OperState = ipb.OperState_OPER_STATE_UNSPECIFIED

		fmt.Println("type", intf.Type())
		fmt.Println("Index", intf.Attrs().Index)
		fmt.Println("Name", intf.Attrs().Name)
		// Process the interface flags to get loopback and Admin state
		ifflags := intf.Attrs().Flags
		fmt.Println("Flags", ifflags)
		if ifflags&net.FlagUp != 0 {
			ifenabled = true
			ifadmin = ipb.AdminState_ADMIN_STATE_ENABLE
		} else {
			ifadmin = ipb.AdminState_ADMIN_STATE_DISABLE
		}
		if ifflags&net.FlagLoopback != 0 {
			fmt.Println("Loopback on interface")
			ifloop = true
		}
		fmt.Println("MTU", intf.Attrs().MTU)
		// Check and map the operational state reported by the interface
		ostate := intf.Attrs().OperState
		fmt.Println("OperState", ostate)
		switch ostate {
		case netlink.OperUnknown:
			ifoper = ipb.OperState_OPER_STATE_UNKNOWN
		case netlink.OperNotPresent:
			ifoper = ipb.OperState_OPER_STATE_NOT_PRESENT
		case netlink.OperDown:
			ifoper = ipb.OperState_OPER_STATE_DOWN
		case netlink.OperLowerLayerDown:
			ifoper = ipb.OperState_OPER_STATE_LOWER_LAYER_DOWN
		case netlink.OperTesting:
			ifoper = ipb.OperState_OPER_STATE_TESTING
		case netlink.OperDormant:
			ifoper = ipb.OperState_OPER_STATE_DORMANT
		case netlink.OperUp:
			ifoper = ipb.OperState_OPER_STATE_UP
		default:
			ifoper = ipb.OperState_OPER_STATE_UNSPECIFIED
		}
		fmt.Println("Raw Attributes", intf.Attrs())
		if intf.Attrs().RawFlags&unix.IFF_LOOPBACK != 0 {
			fmt.Println("Loopback interface")
		}

		fmt.Println("----------")
		// check for an actual device and ethernet interface
		if intf.Type() == "device" && intf.Attrs().EncapType == "ether" {
			// check if the device exists
			_, ok := s.Intfs[intf.Attrs().Name]
			if ok {
				log.Printf("Already existing interface %v", intf.Attrs().Name)
				continue
			}
			// Create the device in the list
			fmt.Println("Create the physical device in the list")

			Netintf := ipb.NetInterface{}
			Netintf.Config = &ipb.NetInterfaceConfig{
				Name:         intf.Attrs().Name,
				Type:         ipb.InterfaceType_INTERFACE_TYPE_ETHERNET,
				Mtu:          uint32(intf.Attrs().MTU),
				LoopbackMode: ifloop,
				Description:  "",
				Enabled:      ifenabled,
			}
			Netintf.State = &ipb.NetInterfaceState{
				Name:         intf.Attrs().Name,
				Type:         ipb.InterfaceType_INTERFACE_TYPE_ETHERNET,
				Mtu:          uint32(intf.Attrs().MTU),
				LoopbackMode: ifloop,
				Description:  "",
				Enabled:      ifenabled,
				Ifindex:      uint32(intf.Attrs().Index),
				AdminState:   ifadmin,
				OperState:    ifoper,
			}

			// add the interface to the detected set by adding to the list.
			s.Intfs[intf.Attrs().Name] = &ipb.NetInterface{
				Name:   intf.Attrs().Name,
				Config: Netintf.Config,
				State:  Netintf.State,
			}
		}
	}
	for _, Intfs := range s.Intfs {
		fmt.Println(Intfs.Name, Intfs.State.Type, Intfs.State.Mtu, Intfs.State.LoopbackMode, Intfs.State.Enabled, Intfs.State.Ifindex, Intfs.State.AdminState, Intfs.State.OperState)
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
