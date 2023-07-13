// Copyright (c) 2023 xxxx

// Package main is the main package for the application
package main

import (
	"flag"
	"fmt"
	"log"
	"net"

	inv "github.com/opiproject/opi-api/common/v1/gen/go"
	"github.com/sandersms/Protos/nwgate/pkg/inventory"

	"google.golang.org/grpc"
	"google.golang.org/grpc/reflection"
)

var (
	port = flag.Int("port", 50153, "Server Port")
)

func main() {
	flag.Parse()
	fmt.Println("Starting grpcServer on port", fmt.Sprintf(":%d", *port))

	lis, err := net.Listen("tcp", fmt.Sprintf(":%d", *port))
	if err != nil {
		log.Fatalf("listen failed: %v", err)
	}
	grpcServer := grpc.NewServer()

	inv.RegisterInventorySvcServer(grpcServer, &inventory.Server{})
	reflection.Register(grpcServer)

	log.Printf("Server listening at %v", lis.Addr())
	if err := grpcServer.Serve(lis); err != nil {
		log.Fatalf("serve failed: %v", err)
	}
}
