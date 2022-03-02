package com.jinheung.project.domain.signaling.redis.entity;

import com.ctc.wstx.shaded.msv_core.reader.xmlschema.WSDLGrammarReaderController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomInfo {
    private Long roomId;
    private String topic;
    private List<String>
}
