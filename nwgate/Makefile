# Copyright (c) 2024 Widgets.

ROOT_DIR='.'
PROJECTNAME=$(shell basename "$(PWD)")

compile: get build

build:
	@echo "  >  Building binaries..."
	@CGO_ENABLED=0 GOOS=$(uname) go build -o ${PROJECTNAME} ./cmd/...

get:
	@echo "  >  Checking if there are any missing dependencies..."
	@CGO_ENABLED=0 go get -u ./cmd
	@CGO_ENABLED=0 go mod tidy
