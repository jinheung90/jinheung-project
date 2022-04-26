# jinheung-project

### jinheung-api-gateway

```

     spring server port : 8081
     
     기능 : 글로벌 인증 필터 
     헤더에 파싱된 유저아이디, 유저롤을 넣어줍니다
     
     
```

### jinheung-euraka-server

```
    기능 : 유레카 서버 해당 서비스 목록을 확인할 수 있다
```

### jinheung-user-profile (resource server)

```
    spring server port : 8082
    
    기능 : 유저의 정보, jwt 토큰 발행 및 파싱
```

### client-proxy 

```
    spring server port : 8084
    
    기능: kafka에서 보낸 여러 이벤트 들을 받아서 websocket으로 
    유저에게 전달 (ex 재고가 부족해요!, 잔액이 부족해요!)
    
```



### jinheung-shop

```
    shop main
    spring sever port : 8083
    
    기능 : api로 맨 처음 받는 서비스 shop product, 
    shop payment 등 에게 카프카로 메세지 날림
    주문 결제에 관한 메세지를 모두 모아서 mongodb에 저장했다가 
    all success면 client proxy에 전달 (orchestration)
 
    shop product
    기능 : 재고를 차감하는 서비스
    재고가 없으면 메세지를 날린다
    재고의 수를 shop search와 동기화 시킨다 
    
    shop search 
    기능 : es를 이용한 제품 검색 
    
    shop payment
    기능 : 결제기능 아임포트와 연결 
    아임포트의 검증 시스템 사용하여 문제가 있으면 
    scheduler를 이용해 재시도
    아니면 성공과 함께 메세지 

```
설계도

![](포트폴리오.png)