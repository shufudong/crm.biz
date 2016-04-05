/**
 * @Title: RespSendVerifyCodeByCardNo.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-9 上午9:51:48
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author Maven
 * @version 2014-9-9
 * 
 *          /**
 * @ClassName: RespSendVerifyCodeByCardNo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-9 上午9:51:48
 * 
 */

@Component("respSendVerifyCodeByCardNo")
public class RespSendVerifyCodeByCardNoBean extends ResponseBaseBean {
	private boolean isComplete;

	private int bizType;

	private Date sendDate;

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public int getBizType() {
		return bizType;
	}

	public void setBizType(int bizType) {
		this.bizType = bizType;
	}

	@Override
	public String toString() {
		return "RespSendVerifyCodeByCardNoBean [isComplete=" + isComplete + ", bizType=" + bizType + ", sendDate=" + sendDate + ", toString()=" + super.toString() + "]";
	}
}
