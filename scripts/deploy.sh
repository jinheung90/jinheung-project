#!/usr/bin/env bash

PROFILE_FILE="/opt/yaml/profile.txt"



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

sudo chmod -R 775 /opt/yaml/
sudo chmod -R 775 /logs

# Code deploy can not inject environment variables
# So, profile should be checked in deploy script
# test server is only one and develop deploy is changed



APP_JAR_NEW=deploy.jar
BUILD_DIR="/opt/app/" # 바뀐 지점
#DEPLOY_PATH_AND_JAR="/home/ec2-user/deploy.jar"
BUILD_FILEPATH=$BUILD_DIR$APP_JAR_NEW
#sudo mv BUILD_FILEPATH DEPLOY_PATH_AND_JAR
STDOUT=/logs/gateway/stdout.log
STDERR=/logs/gateway/stderr.log
SPRING_OPTIONS="-Dspring.profiles.active=prod -Dserver.port=8081"
sudo fuser -k 8081/tcp
sudo nohup java -jar $SPRING_OPTIONS BUILD_FILEPATH 1>>$STDOUT 2>> $STDERR &
#
#  BUILD_DIR="/opt/app/client/jinhueng-eureka-server/build/libs/"
#  SPRING_OPTIONS="-Dspring.profiles.active=$ACTIVE_PROFILE -Dserver.port=8082"
#  sudo nohup java -jar $SPRING_OPTIONS $APPLICATION_JAR 1>>$STDOUT 2>>$STDERR &
#
#  BUILD_DIR="/opt/app/shop-main/jinhueng-eureka-server/build/libs/"
#  SPRING_OPTIONS="-Dspring.profiles.active=$ACTIVE_PROFILE -Dserver.port=8084"
#  sudo nohup java -jar $SPRING_OPTIONS $APPLICATION_JAR 1>>$STDOUT 2>>$STDERR &


