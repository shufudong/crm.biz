package com.yyabl.api.crm.biz.Exception;

public class SystemException extends Exception {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private int errorCode = 10000;
	private static final long serialVersionUID = 1L;

	public SystemException(String mess) {
		super(mess);
	}

	public SystemException(int erroeCode) {
		super("");
		this.errorCode = erroeCode;
	}

	public SystemException(String mess, int erroeCode) {
		super(mess);
		this.errorCode = erroeCode;
	}

	public int getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
