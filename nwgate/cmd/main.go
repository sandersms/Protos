// Copyright (c) 2023 xxxx

// Package main is the main package for the application
package main

import (
	"flag"
	"fmt"
	"log"
	"net"

	inv "github.com/opiproject/opi-api/inventory/v1/gen/go"
	"github.com/sandersms/Protos/nwgate/pkg/dpudev"

	"google.golang.org/grpc"
	"google.golang.org/grpc/reflection"
)

var (
	port = flag.Int("port", 50153, "Server Port")
)

func main() {
	flag.Parse()
	//	ServAddr := os.Args[1]
	//	ServAddr += fmt.Sprintf(":%d", *port)
	fmt.Println("Starting grpcServer on port", fmt.Sprintf(":%d", *port))

	lis, err := net.Listen("tcp", fmt.Sprintf(":%d", *port))
	if err != nil {
		log.Fatalf("listen failed: %v", err)
	}
	grpcServer := grpc.NewServer()
	opiServ := dpudev.NewServer()

	inv.RegisterInventoryServiceServer(grpcServer, opiServ)
	reflection.Register(grpcServer)

	// Initialize the Network Device Information
	dpudev.InitNetworkData()

	log.Printf("Server listening at %v", lis.Addr())
	if err := grpcServer.Serve(lis); err != nil {
		log.Fatalf("serve failed: %v", err)
	}
}
