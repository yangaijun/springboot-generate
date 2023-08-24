package com.light.common.exception;

public enum BusinessExceptionErrorEnum  {
	SYSTEM_ERROR(10000, "服务器处理异常！"),
	TOKEN_EXPIRED(10001, "token 不合法！"),
	TOKEN_PARSE_ERROR(10002, "token 解析失败！"),

	USER_NAME_OR_PASSWORD_ERROR(20001, "用户名或密码错误！");
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
