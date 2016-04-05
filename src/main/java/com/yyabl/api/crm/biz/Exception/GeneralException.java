package com.yyabl.api.crm.biz.Exception;

public class GeneralException extends Exception {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private int errorCode = 10000;
	private static final long serialVersionUID = 1L;

	public GeneralException(String mess) {
		super(mess);
	}

	public GeneralException(int erroeCode) {
		super("");
		this.errorCode = erroeCode;
	}

	public GeneralException(String mess, int erroeCode) {
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
