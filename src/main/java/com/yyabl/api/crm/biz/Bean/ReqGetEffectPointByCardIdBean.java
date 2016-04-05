package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.NotNull;

/** 
 * ClassName: ReqGetEffectPointByCardIdBean <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2015年2月4日 下午2:53:37 <br/> 
 * @author 舒阜东
 * @version  
 * @since JDK 1.7
 */
public class ReqGetEffectPointByCardIdBean extends RequestBaseBean {

	/** 
	 * cardId:会员ID
	 * @since JDK 1.7
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
		return "ReqGetEffectPointByCardIdBean [cardId=" + cardId + ", toString()=" + super.toString() + "]";
	}

}
