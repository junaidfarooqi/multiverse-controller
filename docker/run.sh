#!/usr/bin/env bash

set -e

# export IP
IP=127.0.0.1
export EXTERNAL_IP=$IP

# export volume location
export CONTROLLER_VOL=$1

# Get this script directory (to find yml from any directory)
export DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# Stop
docker-compose -f $DIR/docker-compose.yml stop

# Start container cluster
# First start persistence and auth container and wait for it
docker-compose -f $DIR/docker-compose.yml up -d mysql mongo activemq
echo "Waiting for persistence init..."
sleep 30

docker-compose -f $DIR/docker-compose.yml up -d notification-microservice
sleep 5

docker-compose -f $DIR/docker-compose.yml up -d topology-microservice 
sleep 5
# Start other containers
docker-compose -f $DIR/docker-compose.yml up