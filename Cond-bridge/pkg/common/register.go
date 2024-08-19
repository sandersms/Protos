// SPDX-License-Identifier: Apache-2.0

// utility support functions for registration handler functions
package utils

import (
	"context"
	"log"

	"github.com/grpc-ecosystem/grpc-gateway/runtime"
	"google.golang.org/grpc"
)

type registerHandlerFunc func(context.Context, *runtime.ServeMux, string, []grpc.DialOption) error

func registerGatewayHandler(ctx context.Context, mux *runtime.ServeMux, endpoint string, opts []grpc.DialOption, registerFunc registerHandlerFunc, serviceName string) {
	err := registerFunc(ctx, mux, endpoint, opts)
	if err != nil {
		log.Panicf("cannot register %s handler server: %v", serviceName, err)
	}
}
