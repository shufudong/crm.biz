package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.NotNull;

/** 
 * ClassName: ReqGetEffectTicketByCardIdBean <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2015年2月4日 下午2:53:49 <br/> 
 * @author 舒阜东
 * @version  
 * @since JDK 1.7
 */
public class ReqGetEffectTicketByCardIdBean extends RequestBaseBean {
	/**
	 * @Fields cardId : 会员ID
	 */
	@NotNull(message = "参数'cardId'不能为空.")
	private Integer cardId;

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	@Override
	public String toString() {
		return "ReqGetEffectTicketByCardIdBean [cardId=" + cardId + ", toString()=" + super.toString() + "]";
	}

}
