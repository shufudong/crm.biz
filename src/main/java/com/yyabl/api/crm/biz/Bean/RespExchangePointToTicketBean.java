package com.yyabl.api.crm.biz.Bean;

/**
 * @ClassName: RespExchangePointToTicket
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年11月19日 上午6:07:36
 * 
 */
public class RespExchangePointToTicketBean extends ResponseBaseBean {

	/**
	 * @Fields orderNo : 由CRM系统生成、用于记录积分兑换优惠券操作记录的记录号
	 */
	private int orderNo;

	/**
	 * @Fields point : 本次“积分兑券”消耗积的分值
	 */
	private int point;

	/**
	 * @Fields ticket : 本次“积分兑券”增加的券金额
	 */
	private int ticket;

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

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

	@Override
	public String toString() {
		return "RespExchangePointToTicketBean [orderNo=" + orderNo + ", point=" + point + ", ticket=" + ticket + ", toString()=" + super.toString() + "]";
	}

}
