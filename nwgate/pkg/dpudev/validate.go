// Copyright (c) xxxx, .

// Package dpudev (DPU Device) is the main package of the application
package dpudev

import (
	"go.einride.tech/aip/fieldbehavior"
	"go.einride.tech/aip/resourcename"

	ipb "github.com/opiproject/opi-api/network/opinetcommon/v1alpha1/gen/go"
)

func (s *Server) validateListNetInterfacesRequest(in *ipb.ListNetInterfacesRequest) error {
	// check required fields
	if err := fieldbehavior.ValidateRequiredFields(in); err != nil {
		return err
	}
	return nil
}

func (s *Server) validateGetNetInterfaceRequest(in *ipb.GetNetInterfaceRequest) error {
	// check required fields
	if err := fieldbehavior.ValidateRequiredFields(in); err != nil {
		return err
	}
	// Validate that a resource name conforms to the restrictions outlined in AIP-122.
	return resourcename.Validate(in.Name)
}