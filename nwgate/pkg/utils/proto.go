// Copyright (c) xxxx, .

// Package utils is support functions of the application
package utils

import (
	"google.golang.org/protobuf/proto"
)

// ProtoClone creates a deep copy of a provided gRPC structure
func ProtoClone[T proto.Message](protoStruct T) T {
	return proto.Clone(protoStruct).(T)
}
