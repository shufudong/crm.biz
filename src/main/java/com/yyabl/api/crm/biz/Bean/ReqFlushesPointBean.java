package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.NotNull;

/** 
 * ClassName: ReqFlushesPointBean <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2015年2月4日 下午2:43:44 <br/> 
 * @author 舒阜东
 * @version  
 * @since JDK 1.7
 */
public class ReqFlushesPointBean extends RequestBaseBean {
	{
		super.setKeyFields(new String[]{"orderNo"});
	}
	
	/**
	 * @Fields orderNo : 单据编号
	 */
	@NotNull(message = "参数'orderNo'不能为空.")
	private Integer orderNo;

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "ReqFlushesPointBean [orderNo=" + orderNo + ", toString()=" + super.toString() + "]";
	}
}
