/**
 * @Title: RespGetExchangeRuleBean.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月30日 上午5:36:52
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

import java.util.Arrays;

/**
 * @ClassName: RespGetExchangeRuleBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年12月30日 上午5:36:52
 * 
 */
public class RespGetExchangeRuleBean extends ResponseBaseBean {
	
	private int point;
	
	private int ticket;
	
	private String[] context;

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public String[] getContext() {
		return context;
	}

	public void setContext(String[] context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "RespGetExchangeRuleBean [point=" + point + ", ticket=" + ticket + ", context=" + Arrays.toString(context) + ", toString()=" + super.toString()
				+ "]";
	}

}
