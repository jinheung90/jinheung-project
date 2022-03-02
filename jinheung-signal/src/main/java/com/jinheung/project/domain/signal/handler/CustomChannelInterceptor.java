package com.jinheung.project.domain.signal.handler;




import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

import java.util.Objects;

@RequiredArgsConstructor
//@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE + 99)
public class CustomChannelInterceptor implements ChannelInterceptor {
//    @Autowired
    private final ApplicationEventPublisher applicationEventPublisher;

    private static final String SDP_HEADER_NAME = "sdp";
    private static final String CANDIDATE_HEADER_NAME = "candidate";


    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor stompHeaderAccessor = StompHeaderAccessor.wrap(message);

        if (StompCommand.DISCONNECT.equals(stompHeaderAccessor.getCommand())) {

        }

        return message;
    }





//    default void postSend(Message<?> message, MessageChannel channel, boolean sent) {
//    }
//
//    default void afterSendCompletion(
//        Message<?> message, MessageChannel channel, boolean sent, @Nullable Exception ex) {
//    }
//
//    default boolean preReceive(MessageChannel channel) {
//        return true;
//    }
//
//
//    @Nullable
//    default Message<?> postReceive(Message<?> message, MessageChannel channel) {
//        return message;
//    }
//
//    default void afterReceiveCompletion(@Nullable Message<?> message, MessageChannel channel,
//                                        @Nullable Exception ex) {
//    }

}
