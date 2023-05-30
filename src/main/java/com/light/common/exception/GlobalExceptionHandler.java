package com.light.common.exception;

import com.light.common.response.ResponseData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseData<?> businessHandler(BusinessException e, HttpServletRequest request) {
        return new ResponseData<>(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseData<?> exceptionHandler(Throwable e, HttpServletRequest request) {
        return new ResponseData<>(BusinessExceptionErrorEnum.SYSTEM_ERROR.getCode(), BusinessExceptionErrorEnum.SYSTEM_ERROR.getMessage());
    }
}
