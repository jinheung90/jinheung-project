#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/scripts/profile.sh

REPOSITORY=/opt/app
PROJECT_NAME=springboot-webservice

echo "> Build 파일 복사"
echo "> cp $REPOSITORY/zip/*.jar $REPOSITORY/"

cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> 새 애플리케이션 배포"
JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR Name : $JAR_NAME"

echo "> $JAR_NAME 에 실행권한 추가"

chmod +x $JAR_NAME

echo "> $JAR_NAME 실행"

IDLE_PROFILE=$(find_idle_profile)

echo "> $JAR_NAME 를 profile=$IDLE_PROFILE 로 실행합니다."

nohup java -jar \
    -Dspring.config.location=/opt/yaml/application-real.yaml \
    -Dspring.profiles.active=real \
    -Dserver.port=8083 \ # 예제에서는 properties를 두개만들었지만 걍 포트 바꾸는 식으로 가려고함
  $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &