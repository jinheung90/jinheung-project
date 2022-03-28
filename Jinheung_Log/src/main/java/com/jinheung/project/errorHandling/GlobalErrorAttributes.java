package com.jinheung.project.errorHandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;


@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes { // handler 중간단계


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request,
                                                  ErrorAttributeOptions options) {

        Map<String, Object> map = super.getErrorAttributes(request , options);

        if(getError(request) instanceof RuntimeExceptionWithCode){
            RuntimeExceptionWithCode runtimeException = (RuntimeExceptionWithCode)getError(request);

            logger.info(runtimeException.toString());
            map.put("message",runtimeException.getMessage());
            map.put("status", runtimeException.getCode().getStatus());
            map.put("code", runtimeException.getCode().getCode());
            map.remove("error");
        }

        return map;
    }

}
