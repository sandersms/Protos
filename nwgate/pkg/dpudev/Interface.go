// Copyright (c) xxxx, .

// Package dpudev (DPU Device) is the main package of the application
package dpudev

import (
	"context"
	"fmt"
	"log"

	"github.com/vishvananda/netlink"

	ipb "github.com/sandersms/Protos/protobuf/network/opencfg/v1alpha1/gen/go"
)

// Initialize the network device information
func InitNetworkData() {
	// Get the list of links on the device
	n_ifs, err := netlink.LinkList()
	if err != nil {
		panic(err)
	}

	// Output the parameters retrieved for the list of links
	for _, intf := range n_ifs {
		fmt.Println("Name", intf.Attrs().Name)
	}
}

// GetNetInterface gets the network interface information
func (s *Server) GetNetInterface(_ context.Context, in *ipb.GetNetInterfaceRequest) (*ipb.NetInterface, error) {
	log.Printf("GetNetInterface: Received from client %v", in)
}

// ListNetInterfaces provides a list of the network interfaces
func (s *Server) ListNetInterfaces(_ context.Context, in *ipb.ListNetInterfacesRequest) (*ipb.ListNetInterfacesResponse, error) {
	log.Printf("ListNetInterface: Received from client %v", in)
}
