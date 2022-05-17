                                                                                                                                                                       # jinheung-project
```
간단한 소개
개인적으로 커머스 쪽에 관심이 많고 msa에 관심이 많아서 
구현하고 있는 사이드 프로젝트 입니다
장바구니, 주문, 결제, 검색등을 업데이트 해 나갈 예정입니다 
아래에는 제가 구현할 부분의 설계도를 업데이트 시켰습니다
```


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

### jinheung-user-profile 

```
    spring server port : 8082
    
    기능 : 유저의 정보, jwt 토큰 발행 및 파싱
```

### client-proxy 

```
    spring server port : 8083
    
    기능: kafka에서 보낸 여러 이벤트 들을 받아서 websocket으로 
    유저에게 전달 (ex 재고가 부족해요!, 잔액이 부족해요!)
```



### jinheung-shop

```
    shop main 8084
    기능 : 아임포트 결제 pay verify, 장바구니 

    shop product 8085
    기능 : 재고를 차감하는 서비스
    재고가 없으면 메세지를 날린다
    재고의 수를 shop search와 동기화 시킨다 
    
    shop search 8086
    기능 : es를 이용한 제품 검색 

    

```
설계도

![](전체_구조.jpg)

결제 시스템
![](결제_다이어그램.jpg)