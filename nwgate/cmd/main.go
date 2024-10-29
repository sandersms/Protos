// Copyright (c) 2023-2024 xxxx

// Package main is the main package for the application
package main

import (
	"flag"
	"fmt"
	"log"
	"net"

	inv "github.com/opiproject/opi-api/inventory/v1/gen/go"
	ipb "github.com/opiproject/opi-api/network/opinetcommon/v1alpha1/gen/go"
	"github.com/sandersms/Protos/nwgate/pkg/dpudev"

	"google.golang.org/grpc"
	"google.golang.org/grpc/reflection"
)

func main() {
	var grpcPort int
	flag.IntVar(&grpcPort, "grpc_port", 50153, "The gRPC server port")

	var httpPort int
	flag.IntVar(&httpPort, "http_port", 8082, "The HTTP server port")

	flag.Parse()

	fmt.Println("Starting grpcServer on port", fmt.Sprintf(":%d", grpcPort))
	lis, err := net.Listen("tcp", fmt.Sprintf(":%d", grpcPort))
	if err != nil {
		log.Fatalf("listen failed: %v", err)
	}
	grpcServer := grpc.NewServer()
	opiServ := dpudev.NewServer()

	// Initialize the Network Device Information
	dpudev.InitNetworkData(opiServ)

	inv.RegisterInventoryServiceServer(grpcServer, opiServ)
	ipb.RegisterNetInterfaceServiceServer(grpcServer, opiServ)
	reflection.Register(grpcServer)

	log.Printf("Server listening at %v", lis.Addr())
	if err := grpcServer.Serve(lis); err != nil {
		log.Fatalf("server failed: %v", err)
	}
}
