// Copyright (c) xxxx, .

// Package dpudev (DPU Device) is the main package of the application
package dpudev

import (
	
	"go.einride.tech/aip/fieldbehavior"

	ipb "github.com/opiproject/opi-api/network/opinetcommon/v1alpha1/gen/go"
)

func (s *Server) validateListNetInterfacesRequest(in *ipb.ListNetInterfacesRequest) error {
	// check required fields
	if err := fieldbehavior.ValidateRequiredFields(in); err != nil {
		return err
	}
	return nil
}
