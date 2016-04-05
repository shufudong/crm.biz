package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @ClassName: ReqExchangePointToTicket
 * @Description: 会员积分兑换为券
 * @author Maven
 * @date 2014年11月19日 上午6:05:10
 * 
 */

public class ReqExchangePointToTicketBean extends RequestBaseBean {
	
	{
		super.setKeyFields(new String[]{"cardId"});
	}

	/**
	 * @Fields cardId : 会员卡ID
	 */
	@NotNull(message="参数'cardId'不能为空.")
	private Integer cardId;

	/**
	 * @Fields point : 用于兑券的积分值
	 */
	@NotNull(message="参数'point'不能为空.")
	@Min(value = 1, message = "错误:参数'point'不能小余1.")
	private Integer point;

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "ReqExchangePointToTicketBean [cardId=" + cardId + ", point=" + point + ", toString()=" + super.toString() + "]";
	}
	
}
