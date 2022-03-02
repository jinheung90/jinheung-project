package com.jinheung.project.domain.signal.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "chatting_room")
//@RedisHash(value = "chatting_room", timeToLive = 30)
public class ChattingRoom {
    @Id
    private String id;
    private String roomName;
}
