#!/bin/bash

cd ..
./gradlew clean fatJar

cp build/libs/server.jar docker/server.jar

cd docker

docker build . -t localazy/collect_server:latest
docker push localazy/collect_server:latest
