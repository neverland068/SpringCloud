#!/usr/bin/env bash

function note() {
    local GREEN NC
    GREEN='\033[0;32m'
    NC='\033[0m' # No Color
    printf "\n${GREEN}$@  ${NC}\n" >&2
}

set -xe

COMPILE_OPTS="--stacktrace --info"
TASKS="build -xtest"
OTHER_OPTS=""

cd util;                                              note "Building util..."; ./gradlew $COMPILE_OPTS $TASKS publishToMavenLocal $OTHER_OPTS; cd -

cd microservices/core/product-service;                note "Building prod..."; ./gradlew $COMPILE_OPTS $TASKS $OTHER_OPTS; cd -
cd microservices/core/recommendation-service;         note "Building rec...";  ./gradlew $COMPILE_OPTS $TASKS $OTHER_OPTS; cd -
cd microservices/core/review-service;                 note "Building rev...";  ./gradlew $COMPILE_OPTS $TASKS $OTHER_OPTS; cd -
cd microservices/composite/product-composite-service; note "Building comp..."; ./gradlew $COMPILE_OPTS $TASKS $OTHER_OPTS; cd -
#cd microservices/api/product-api-service;             note "Building api..."; ./gradlew $COMPILE_OPTS $TASKS $OTHER_OPTS; cd -

# server
cd microservices/support/auth-server;                 note "Building auth..."; ./gradlew $COMPILE_OPTS $TASKS $OTHER_OPTS; cd -
cd microservices/support/config-server;               note "Building conf..."; ./gradlew $COMPILE_OPTS $TASKS $OTHER_OPTS; cd -
cd microservices/support/discovery-server;            note "Building disc..."; ./gradlew $COMPILE_OPTS $TASKS $OTHER_OPTS; cd -
cd microservices/support/edge-server;                 note "Building edge..."; ./gradlew $COMPILE_OPTS $TASKS $OTHER_OPTS; cd -
cd microservices/support/zipkin-server;                note "Building zipkin..."; ./gradlew $COMPILE_OPTS $TASKS $OTHER_OPTS; cd -
cd microservices/support/monitor-dashboard;           note "Building mon...";  ./gradlew $COMPILE_OPTS $TASKS $OTHER_OPTS; cd -
cd microservices/support/turbine;                     note "Building turb..."; ./gradlew $COMPILE_OPTS $TASKS $OTHER_OPTS; cd -

find . -name *SNAPSHOT.jar -exec du -h {} \;

docker-compose build

docker rmi $(sudo docker images -f "dangling=true" -q)
