/**
 * @Title: ResponseBean.java
 * @Package com.yyabl.api.crm.biz.Sms
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-9 上午4:30:50
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Sms;

/**
 * @author Maven
 * @version 2014-9-9
 * 
 *          /**
 * @ClassName: ResponseBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-9 上午4:30:50
 * 
 */
public class SmsSendReport {
	private int state;
	private int id;
	private String failPhone;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFailPhone() {
		return failPhone;
	}

	public void setFailPhone(String failPhone) {
		this.failPhone = failPhone;
	}

	@Override
	public String toString() {
		return "SmsSendReport [state=" + state + ", id=" + id + ", failPhone=" + failPhone + "]";
	}

}
