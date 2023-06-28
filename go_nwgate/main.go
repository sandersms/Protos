// Copyright (c) 2023 xxxx

// Package main is the main package for the application
package main

import (
	"flag"
	"fmt"
	"net"
	"log"

	"google.golang.org/grpc"
)

var (
	port = flag.Int("port", 50153, "Server Port")
)

func main() {
	flag.Parse()
	lis, err := net.Listen("tcp", fmt.Sprintf(":%d", *port))
	if err != nil {
		log.Fatalf("listen failed: %v", err)
	}
	serv := grpc.NewServer()

	log.Printf("Server listening at %v", lis.Addr())
	if err := serv.Serve(lis); err != nil {
		log.Fatalf("serve failed: %v", err)
	}
}