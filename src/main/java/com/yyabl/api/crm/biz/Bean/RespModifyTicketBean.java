/** 
 * Project Name:crm.biz 
 * File Name:RespModifyTicketBean.java 
 * Package Name:com.yyabl.api.crm.biz.Bean 
 * Date:2015年2月3日下午2:09:14 
 * Copyright (c) 2015, All Rights Reserved. 
 * Company 湖南友阿云商网络有限公司
 */

package com.yyabl.api.crm.biz.Bean;

/**
 * ClassName: RespModifyTicketBean <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年2月3日 下午2:09:14 <br/>
 * 
 * @author 舒阜东
 * @version
 * @since JDK 1.7
 */
public class RespModifyTicketBean extends ResponseBaseBean {
	/** 
	 * orderNo:订单编号
	 * @since JDK 1.7
	 */
	private int orderNo;

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "RespModifyTicketBean [orderNo=" + orderNo + ", toString()=" + super.toString() + "]";
	}

}
