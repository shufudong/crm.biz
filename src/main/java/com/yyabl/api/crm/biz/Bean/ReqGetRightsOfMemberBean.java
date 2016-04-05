package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.NotNull;

/** 
 * ClassName: ReqGetRightsOfMemberBean <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2015年2月4日 下午2:58:11 <br/> 
 * @author 舒阜东
 * @version  
 * @since JDK 1.7
 */
public class ReqGetRightsOfMemberBean extends RequestBaseBean {
	/**
	 * @Fields cardId : 会员卡ID
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
		return "ReqGetRightsOfMemberBean [cardId=" + cardId + ", toString()=" + super.toString() + "]";
	}

}
