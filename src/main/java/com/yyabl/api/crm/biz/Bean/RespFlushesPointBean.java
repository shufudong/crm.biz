/**
 * @Title: RespFlushesPoint.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月16日 下午3:02:10
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

/**
 * @ClassName: RespFlushesPoint
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年12月16日 下午3:02:10
 * 
 */
public class RespFlushesPointBean extends ResponseBaseBean {
	
	/**
	 * @Fields orderNo : 单据编号
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
		return "RespFlushesPointBean [orderNo=" + orderNo + ", toString()=" + super.toString() + "]";
	}
}
