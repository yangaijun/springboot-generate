package com.light.common.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
	private Integer code;
	private String message;

	public BusinessException(BusinessExceptionErrorEnum businessExceptionErrorEnum) {
		this.code = businessExceptionErrorEnum.getCode();
		this.message = businessExceptionErrorEnum.getMessage();
	}

	public BusinessException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
