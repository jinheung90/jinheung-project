package com.jinheung.common.dto.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KafkaEventDto {
    private String eventId;
    private String userId;
    private String jwtToken;
    private String jsonData;
}
