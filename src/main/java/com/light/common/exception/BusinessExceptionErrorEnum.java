package com.light.common.exception;

public enum BusinessExceptionErrorEnum  {
	SYSTEM_ERROR(10000, "服务器处理异常！"),
	TEST_ERROR(1001, "test error");
	private int code;
	private String message;
	
	BusinessExceptionErrorEnum(int code, String desc) {
		this.setCode(code);
		this.setMessage(desc);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
