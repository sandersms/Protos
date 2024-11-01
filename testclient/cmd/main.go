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
	ipb "github.com/opiproject/opi-api/network/opinetcommon/v1alpha1/gen/go"

	"google.golang.org/grpc"
)

var (
	port = flag.Int("port", 50153, "Server port")
)

func main() {
	ProgName := os.Args[0]
	fmt.Println("Starting", ProgName)

	// address to connect to Server
	flag.Parse()
	//ServAddr := os.Args[1]
	//ServAddr += fmt.Sprintf(":%d", *port)
	fmt.Println("connecting to grpcServer on port", fmt.Sprintf(":%d", *port))

	//fmt.Println("Connecting to grpcServer on", ServAddr)

	// Setup the connection to the server for testing
	cxn, err := grpc.Dial(fmt.Sprintf(":%d", *port), grpc.WithInsecure())
	if err != nil {
		log.Fatalf("grpc.Dial err: %v", err)
	}
	defer cxn.Close()

	InvClient := inv.NewInventoryServiceClient(cxn)
	NetClient := ipb.NewNetInterfaceServiceClient(cxn)

	// Get the inventory data
	log.Printf("Get the Inventory data from the target")
	cntx, cancel := context.WithTimeout(context.Background(), time.Second)
	defer cancel()
	rsp, err := InvClient.GetInventory(cntx, &inv.GetInventoryRequest{})
	if err != nil {
		log.Fatalf("error getting inventory: %v", err)
	}
	log.Printf("%s", rsp)

	// Get the Network Interface List
	log.Printf("Get the Network Interface List of devices")
	cntx, cancel = context.WithTimeout(context.Background(), time.Second)
	defer cancel()
	resp, err := NetClient.ListNetInterfaces(cntx, &ipb.ListNetInterfacesRequest{Parent: "network"})
	if err != nil {
		log.Fatalf("error getting interface list: %v", err)
	}
	for _, intf := range resp.NetInterfaces {
		if intf.Name != "" {
			log.Printf("%s", intf)
		}
	}
//	log.Printf("%s", resp)

}
