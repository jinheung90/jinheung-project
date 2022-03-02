package com.jinheung.project.domain.signaling.redis.repository;

import com.jinheung.project.domain.signaling.redis.entity.RoomInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class RoomInfoRepository {

//    private final ReactiveRedisTemplate<String, RoomInfo> roomInfoReactiveRedisTemplate;
//    private final ReactiveRedisTemplate<String, Long> roomUsers;
//    private static final String USER_KEY = "user-key";
//    private static final String ROOM_KEY = "room-key";
//
//    public RoomInfo saveRoomInfo() {
//        return null;
//    }
//    public Mono<RoomInfo> getRoomId(String roomId) {
//        Mono<RoomInfo> roomInfoMono = Mono.create(roomInfoMonoSink -> {
//            roomInfoReactiveRedisTemplate.opsForHash().get(ROOM_KEY, roomId).cast(RoomInfo.class)
//                .
//
//        })
//
//        return
//    }

}

