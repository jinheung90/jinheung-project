package com.jinheung.project.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.windfally.audivice.errorHandling.ErrorResponse;
import com.windfally.audivice.errorHandling.errorEnums.GlobalErrorCode;
import com.windfally.audivice.errorHandling.errorEnums.IErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAccessDeniedHandler implements ServerAccessDeniedHandler {

    private final ObjectMapper objectMapper;



//    private void sendErrorMessage(HttpServletResponse res) throws IOException {
//        res.setStatus(HttpServletResponse.SC_FORBIDDEN); // 권한 부족 403
//        res.setContentType(MediaType.APPLICATION_JSON.toString());
//        res.getWriter().write(this.objectMapper
//                .writeValueAsString(ErrorResponse.responseBody(((IErrorCode) GlobalErrorCode.NOT_ALLOW_USER).getCode(), "not allow this user not enough authority", HttpStatus.resolve(((IErrorCode) GlobalErrorCode.NOT_ALLOW_USER).getStatus()))));
//    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, AccessDeniedException denied) {
        return null;
    }
}
