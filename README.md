# jinheung-project

### jinheung-api-gateway

```
    infra
    redis localhost:6379
    spring server port : 8081
    
    reactive logging
    https://cloud.spring.io/spring-cloud-gateway/multi/multi__reactor_netty_access_logs.html
     
    main function
    gateway, authorization, logging
     
```

### jinheung-euraka-server

```
    https://velog.io/@jinheung90/spring-cloud-eureka-%EC%84%A4%EC%A0%95
```

### jinheung-user-profile (oauth resource server)

```
    spring server port : 8082
```

### jinheung-shop

```
    참고 및 도움이 되었던 글 (너무 잘봤습니다)
    https://www.popit.kr/rest-%EA%B8%B0%EB%B0%98%EC%9D%98-%EA%B0%84%EB%8B%A8%ED%95%9C-%EB%B6%84%EC%82%B0-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EA%B5%AC%ED%98%84-1%ED%8E%B8/
   
    shop main
 
 
    shop product
    es (docker desktop error only singlenode)
    docker run -d -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" --name elasticsearch7 docker.elastic.co/elasticsearch/elasticsearch:7.9.0


```
설계도
![](../Downloads/Untitled Diagram.png)