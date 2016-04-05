package com.yyabl.api.crm.biz.Bean;

import org.springframework.stereotype.Component;

/**
 * @ClassName: ResponseBaseBean
 * @Description: 这是响应类的基类，所有返回给调用者的参数中必须包含这个类中的两个参数，并且这两个参数不能为空。
 * @author Maven
 * @date 2014-6-25 下午1:14:32
 * 
 */
@Component("responseBaseBean")
public class ResponseBaseBean {
	/**
	 * @Fields status : 状态码
	 */
	private int status;
	/**
	 * @Fields message : 状态文字描述
	 */
	private String message;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseBaseBean [status=" + status + ", message=" + message + "]";
	}

}
