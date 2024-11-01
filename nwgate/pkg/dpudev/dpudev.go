// Copyright (c) xxxx, .

// Package dpudev (DPU Device) is the main package of the application
package dpudev

import (
	"fmt"

	pb "github.com/opiproject/opi-api/inventory/v1/gen/go"
	ipb "github.com/opiproject/opi-api/network/opinetcommon/v1alpha1/gen/go"
)

// The Server Object
type Server struct {
	pb.UnimplementedInventoryServiceServer
	ipb.UnimplementedNetInterfaceServiceServer
	Pagination map[string]int
	Dpus       map[string]*pb.Inventory
	Intfs      map[string]*ipb.NetInterface
}

// NewServer creates the initialized instance of the Dpu Device server
func NewServer() *Server {
	fmt.Println("Creating DPU Device Server")
	return &Server{
		Pagination: make(map[string]int),
		Dpus:       make(map[string]*pb.Inventory),
		Intfs:      make(map[string]*ipb.NetInterface),
	}
}
