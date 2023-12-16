# Makefile for Docker Build and Push


# Define variables
DOCKER_REGISTRY ?= artifactory.myartifact.com
# Image name
IMAGE_NAME ?= your-image-name
#take version from artifactory - latest commit id
IMAGE_TAG ?= 0.0.2

DOCKER_USERNAME = TAKE FROM PIPELINE VARIABLES
DOCKER_PASSWORD = TAKE FROM PIPELINE AES VARIABLES
DOCKER_REGISTRY ?= artifactory.myartifact.com

# docker commands

#username and password if it is required
DOCKER_LOGIN = docker login -u username -p password $(DOCKER_LOGIN)

#docker build command, below is the combination of final docker image pull url. e.g artifactory.xyz.com/my-project:0.0.2
DOCKER_BUILD = docker build -t $(DOCKER_REGISTRY)/$(IMAGE_NAME):$(IMAGE_TAG) .

#docker push command to push the image on artifactory
DOCKER_PUSH = docker push $(DOCKER_REGISTRY)/$(IMAGE_NAME):$(IMAGE_TAG)

# Additional steps
.DEFAULT_GOAL := help

.PHONY: help
help:
	@echo "Available targets:"
	@echo "  make login        - Log in to the Docker registry"
	@echo "  make build        - Build the Docker image"
	@echo "  make push         - Push the Docker image to the registry"
	@echo "  make all          - Log in, build, and push the Docker image"
	@echo "  make clean        - Remove local Docker image"
	@echo "  make help         - Show this help message"

#.PHONY: login
#login:
	#$(DOCKER_LOGIN)

.PHONY: build
build:
	$(DOCKER_BUILD)

#.PHONY: push
#push:
	#$(DOCKER_PUSH)

.PHONY: all
all: build
#login build push

#.PHONY: clean
#clean:
#	docker rmi $(DOCKER_REGISTRY)/$(IMAGE_NAME):$(IMAGE_TAG) || true










