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

tools:
	go get golang.org/x/tools/cmd/goimports
	go get github.com/kisielk/errcheck
	go get github.com/axw/gocov/gocov
	go get github.com/matm/gocov-html
	go get github.com/tools/godep
	go get github.com/mitchellh/gox
	go get github.com/golang/lint/golint

vet:
	@CGO_ENABLED=0 go vet -v ./...

lint:
	golint ./...

imports:
	goimports -l -w .

fmt:
	@CGO_ENABLED=0 go fmt ./...
