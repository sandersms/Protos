// Copyright (c) 2023 xxxx

// Package main is the main package for the application
package main

import (
	"flag"
	"fmt"
	"os"
)

var (
	port = flag.Int("port", 50153, "Server port")
)

func main() {
	ProgName := os.Args[0]
	fmt.Println(ProgName)

	// address to connect to Server
	ServAddr := os.Args[1]
	fmt.Println(ServAddr)

	flag.Parse()
	fmt.Println("Connecting to grpcServer on port ", ServAddr, fmt.Sprintf(":%d", *port))

	// Setup the connection to the server for testing
	//cxn, err := grpc.Dial()
}
