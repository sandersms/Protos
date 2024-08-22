// SPDX-License-Identifier: Apache-2.0

// Registration functions for the inventory package
package inventory

import (
	"context"
	"log"

	ipb "github.com/opiproject/opi-api/inventory/v1/gen/go"

	"github.com/grpc-ecosystem/grpc-gateway/runtime"
	"google.golang.org/grpc"
)

// abstracted registration functions for adding inventory services
func registerInventorytoGateway(ctx context.Context, mux *runtime.ServeMux, endpoint string, opts []grpc.DialOption) {
	//	err := ipb.RegisterInventoryServiceHandlerFromEndpoint(ctx, mux, endpoint, opts)
	//	if err != nil {
	//		log.Panicf("cannot register %s handler server: %v", "inventory", err)
	//	}
	log.Printf("Register Inventory Handlers to gateway")
	brutils.registerGatewayHandler(ctx, mux, endpoint, opts, ipb.RegisterInventoryServiceHandlerFromEndpoint, "inventory")
}

func registerInventorytoGrpc(svr grpc.ServiceRegistrar) {
	log.Printf("Register Inventory Service Server to grpc")
	ipb.RegisterInventoryServiceServer(svr, &Server{})
}
