// Copyright (c) xxxx, .

// Package utils is common support functions of the application
package common

import (
	"google.golang.org/protobuf/proto"
)

// ProtoClone creates a deep copy of a provided gRPC structure
func ProtoClone[T proto.Message](protoStruct T) T {
	return proto.Clone(protoStruct).(T)
}
