/**
 * @Title: RespGetCardInfoByCardId.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-9 上午11:47:30
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

import com.yyabl.api.crm.biz.Domain.Hyk_Hyxx;

/**
 * @author Maven
 * @version 2014-9-9
 * 
 *          /**
 * @ClassName: RespGetCardInfoByCardId
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-9 上午11:47:30
 * 
 */
public class RespGetCardInfoByCardIdBean extends ResponseBaseBean {
	
	private Hyk_Hyxx hyk_Hyxx;

	private int pointTotal;

	private int ticketTotal;

	public Hyk_Hyxx getHyk_Hyxx() {
		return hyk_Hyxx;
	}

	public void setHyk_Hyxx(Hyk_Hyxx hyk_Hyxx) {
		this.hyk_Hyxx = hyk_Hyxx;
	}

	public int getPointTotal() {
		return pointTotal;
	}

	public void setPointTotal(int pointTotal) {
		this.pointTotal = pointTotal;
	}

	public int getTicketTotal() {
		return ticketTotal;
	}

	public void setTicketTotal(int ticketTotal) {
		this.ticketTotal = ticketTotal;
	}

	@Override
	public String toString() {
		return "RespGetCardInfoByCardIdBean [hyk_Hyxx=" + hyk_Hyxx + ", pointTotal=" + pointTotal + ", ticketTotal=" + ticketTotal + ", toString()=" + super.toString() + "]";
	}

}
