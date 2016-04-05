package com.yyabl.api.crm.biz.Bean;

public class RespGetEffectTicketByCardIdBean extends ResponseBaseBean {
	/**
	 * @Fields tickets : 优惠券金额
	 */
	private int tickets;

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "RespGetEffectTicketByCardIdBean [tickets=" + tickets + ", toString()=" + super.toString() + "]";
	}

}
