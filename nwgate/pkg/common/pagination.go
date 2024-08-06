// Copyright (c) xxxx, .

// Package common is the common support functions of the application
package common

import (
	"log"

	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/status"
)

// ExtractPagination fetches pagination from the database, calculate size and offset
func ExtractPagination(pageSize int32, pageToken string, pagination map[string]int) (size int, offset int, err error) {
	const (
		maxPageSize     = 250
		defaultPageSize = 50
	)
	switch {
	case pageSize < 0:
		return -1, -1, status.Error(codes.InvalidArgument, "negative PageSize is not allowed")
	case pageSize == 0:
		size = defaultPageSize
	case pageSize > maxPageSize:
		size = maxPageSize
	default:
		size = int(pageSize)
	}
	// fetch offset from the database using opaque token
	offset = 0
	if pageToken != "" {
		var ok bool
		offset, ok = pagination[pageToken]
		if !ok {
			return -1, -1, status.Errorf(codes.NotFound, "unable to find pagination token %s", pageToken)
		}
		log.Printf("Found offset %d from pagination token: %s", offset, pageToken)
	}
	return size, offset, nil
}
