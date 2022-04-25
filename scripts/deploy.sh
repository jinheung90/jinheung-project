#!/usr/bin/env bash

PROFILE_FILE="/opt/yaml/profile.txt"
APPLICATION_JAR_NAME=springboot-deploy.jar
APP_JAR_NEW=audivice-signal-main-1.0.1.jar
DEPLOY_PATH="/home/ec2-user/"
BUILD_DIR="/opt/app/user/jinhueng-api-gateway/build/libs/" # 바뀐 지점
BUILD_FILEPATH=$BUILD_DIR$APP_JAR_NEW
APPLICATION_JAR=$DEPLOY_PATH$APPLICATION_JAR_NAME
STDOUT=/logs/user/stdout.log
STDERR=/logs/user/stderr.log


if [ ! -d "/opt/yaml" ]; then
  sudo mkdir /opt
  sudo mkdir /opt/yaml
fi

if [ ! -d "/logs/gateway" ]; then
  sudo mkdir /logs
  sudo mkdir /logs/client
  sudo mkdir /logs/gateway
  sudo mkdir /logs/eureka

fi

sudo chmod -R 777 /opt/yaml/
sudo chmod -R 777 /logs
# Code deploy can not inject environment variables
# So, profile should be checked in deploy script
# test server is only one and develop deploy is changed
if [ "$APPLICATION_NAME" == "jinheung-project" ]; then
  ACTIVE_PROFILE=local
  BUILD_DIR="/opt/app/gateway/jinhueng-api-gateway/build/libs/"
  SPRING_OPTIONS="-Dspring.profiles.active=$ACTIVE_PROFILE -Dserver.port=8081"
  sudo nohup java -jar $SPRING_OPTIONS $APPLICATION_JAR 1>>$STDOUT 2>>$STDERR &

  BUILD_DIR="/opt/app/gateway/jinhueng-eureka-server/build/libs/"
  SPRING_OPTIONS="-Dspring.profiles.active=$ACTIVE_PROFILE -Dserver.port=8082"
  sudo nohup java -jar $SPRING_OPTIONS $APPLICATION_JAR 1>>$STDOUT 2>>$STDERR &

  BUILD_DIR="/opt/app/gateway/jinhueng-eureka-server/build/libs/"
  SPRING_OPTIONS="-Dspring.profiles.active=$ACTIVE_PROFILE -Dserver.port=8082"
  sudo nohup java -jar $SPRING_OPTIONS $APPLICATION_JAR 1>>$STDOUT 2>>$STDERR &

fi
