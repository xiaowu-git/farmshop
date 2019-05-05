package com.farm.exception;

/**
 * 业务异常类
 */
@SuppressWarnings({"serial"})
public class BusinessException extends Exception {
	
	private String code;
	/**
	 * 参数构造器
	 * 
	 * @param message 错误信息
	 * @param code 错误码
	 */
	public BusinessException(String code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * 带参数构造器
	 * 
	 * @param message 错误信息
	 * @param cause 错误原因
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 带参数构造器
	 * 
	 * @param message 错误信息
	 */
	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super("", cause);
	}

	public String getCode() {
		return code;
	}

}
