# Copyright (c) 2024 Widgets.

ROOT_DIR='.'
PROJECTNAME=$(shell basename "$(PWD)")

compile: get build

build:
	@echo "  >  Building binaries..."
	@CGO_ENABLED=0 GOOS=$(uname) go build -o ${PROJECTNAME} ./cmd/...

get:
	@echo "  >  Checking if there are any missing dependencies..."
	go get -u ./cmd
	go mod tidy
