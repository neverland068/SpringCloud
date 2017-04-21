#!/usr/bin/env bash


# Delete all images
#docker rmi $(docker images -q)

docker rm $(docker ps -q -f status=exited)

docker rmi $(docker images -f "dangling=true" -q)

