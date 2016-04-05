/**
 * @Title: RespCutPoint.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月16日 下午3:01:22
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

/**
 * @ClassName: RespCutPoint
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年12月16日 下午3:01:22
 * 
 */
public class RespModifyPointBean extends ResponseBaseBean {
	/**
	 * @Fields orderNo : 单据号
	 */
	private int orderNo;

	/**
	 * @return the orderNo
	 */
	public int getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "RespModifyPointBean [orderNo=" + orderNo + ", toString()=" + super.toString() + "]";
	}
}
