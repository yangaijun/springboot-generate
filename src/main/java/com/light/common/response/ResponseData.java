package com.light.common.response;

import lombok.Data;

@Data
public class ResponseData<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseData(){
        this(0,"调用成功！",null);
    }

    public ResponseData(T data){
        this(0,"调用成功！", data);
    }

    public ResponseData(Integer code, String message){
        this(code,message,null);
    }

    public ResponseData(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
