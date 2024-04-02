// Copyright (c) 2023-2024 xxxx

// Package main is the main package for the application
package main

import (
	"context"
	"flag"
	"fmt"
	"log"
	"os"
	"time"

	inv "github.com/opiproject/opi-api/inventory/v1/gen/go"

	"google.golang.org/grpc"
)

var (
	port = flag.Int("port", 50153, "Server port")
)

func main() {
	ProgName := os.Args[0]
	fmt.Println("Starting", ProgName)

	// address to connect to Server
	ServAddr := os.Args[1]
	ServAddr += fmt.Sprintf(":%d", *port)
	fmt.Println(ServAddr)

	flag.Parse()
	fmt.Println("Connecting to grpcServer on", ServAddr)

	// Setup the connection to the server for testing
	cxn, err := grpc.Dial(ServAddr, grpc.WithInsecure())
	if err != nil {
		log.Fatalf("grpc.Dial err: %v", err)
	}
	defer cxn.Close()

	InvClient := inv.NewInventoryServiceClient(cxn)

	// Get the inventory data
	cntx, cancel := context.WithTimeout(context.Background(), time.Second)
	defer cancel()
	rsp, err := InvClient.GetInventory(cntx, &inv.GetInventoryRequest{})
	if err != nil {
		log.Fatalf("error getting inventory: %v", err)
	}
	log.Printf("%s", rsp)
}
