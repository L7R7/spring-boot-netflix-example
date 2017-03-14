#!/usr/bin/env bash
./gradlew build
./gradlew bootRun -p eureka-server &
./gradlew bootRun -p notifications-service &