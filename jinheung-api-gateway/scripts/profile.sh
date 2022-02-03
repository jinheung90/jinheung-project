function find_idle_profile(){
 RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost/nginx)

 if [ ${RESPONSE_CODE} -ge 400 ] # 400 보다 크면(즉, 40x/50x 에러 모두 포함)
 then
     CUREENT_PROFILE=real2
 else
     CUREENT_PROFILE=$(curl -s http://localhost/nginx)
 fi

 if [ $(CUREENT_PROFILE) == real1 ]
 then
     IDLE_PROFILE=real2
 else
     IDLE_PROFILE=real1
 fi

 echo "${IDLE_PROFILE}"
}

# 쉬고 있는 profile의 port 찾기
function find_idel_port() {
   IDLE_PROFILE=$(find_idle_profile)

   if [ ${IDLE_PROFILE} == real1 ]
   then
       echo "8081"
   else
       echo "8082"
   fi
}