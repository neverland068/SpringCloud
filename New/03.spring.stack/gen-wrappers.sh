#!/usr/bin/env bash

set -xe

cd util;                                              ./gradlew wrapper; cd -

cd microservices/core/product-service;                ./gradlew wrapper; cd -
cd microservices/core/recommendation-service;         ./gradlew wrapper; cd -
cd microservices/core/review-service;                 ./gradlew wrapper; cd -
cd microservices/composite/product-composite-service; ./gradlew wrapper; cd -

cd microservices/support/auth-server;                 ./gradlew wrapper; cd -
cd microservices/support/config-server;               ./gradlew wrapper; cd -
cd microservices/support/discovery-server;            ./gradlew wrapper; cd -
cd microservices/support/edge-server;                 ./gradlew wrapper; cd -
cd microservices/support/monitor-dashboard;           ./gradlew wrapper; cd -
cd microservices/support/turbine;                     ./gradlew wrapper; cd -
cd microservices/support/zipkin-server;                     ./gradlew wrapper; cd -
