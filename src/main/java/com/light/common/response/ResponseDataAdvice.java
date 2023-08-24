package com.light.common.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice({"com.light.business", "com.light.test"})
@RestControllerAdvice({"com.light.business", "com.light.test"})
public class ResponseDataAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(ResponseData.class.isInstance(body)){
            return body;
        } else if (body instanceof String) {
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseData r = new ResponseData<>(body);

            try {
                return objectMapper.writeValueAsString(r);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        return new ResponseData<>(body);
    }
}
