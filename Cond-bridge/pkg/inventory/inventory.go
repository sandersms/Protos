// SPDX-License-Identifier: Apache-2.0

// utility support functions for registration handler functions
package inventory

import (
	"context"
	"log"

	ipb "github.com/opiproject/opi-api/inventory/v1/gen/go"

	"github.com/grpc-ecosystem/grpc-gateway/runtime"
	"google.golang.org/grpc"
)

func registerInventorytoGateway(ctx context.Context, mux *runtime.ServeMux, endpoint string, opts []grpc.DialOption) {
	err := ipb.RegisterInventoryServiceHandlerFromEndpoint(ctx, mux, endpoint, opts)
	if err != nil {
		log.Panicf("cannot register %s handler server: %v", "inventory", err)
	}
}
