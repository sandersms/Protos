# Copyright (c) 2024 Widgets.

ROOT_DIR='.'
PROJECTNAME=$(shell basename "$(PWD)")

compile: get build

build:
	@echo "  >  Building binaries..."
	go build -o ${PROJECTNAME} ./cmd/...

get:
	@echo "  >  Checking if there are any missing dependencies..."
	go get -u ./cmd
	go mod tidy
