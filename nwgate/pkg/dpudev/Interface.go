// Copyright (c) xxxx, .

// Package dpudev (DPU Device) is the main package of the application
package dpudev

import (
	"context"
	"fmt"
	"log"

	"github.com/vishvananda/netlink"

	ipb "github.com/sandersms/Protos/Experiment/network/opencfg/v1alpha1/gen/go"
)

// InitNetworkData initialize the network device information
func InitNetworkData() {
	// Get the list of links on the device
	nifs, err := netlink.LinkList()
	if err != nil {
		panic(err)
	}

	// Output the parameters retrieved for the list of links
	for _, intf := range nifs {
		fmt.Println("Name", intf.Attrs().Name)
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
	return &ipb.ListNetInterfacesResponse{}, nil
}
