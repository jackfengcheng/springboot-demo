package com.xwtech.bit.api.exception;

public class ApiException extends Exception{
	
	private static final long serialVersionUID = -4757195338457959269L;
	
	private String code;

	public ApiException(String message) {
		super(message);
	}

	public ApiException( String code,String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
