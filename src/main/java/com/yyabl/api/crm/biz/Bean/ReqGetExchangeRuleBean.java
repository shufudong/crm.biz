/**
 * @Title: ReqGetExchangeRuleBean.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月30日 上午5:35:52
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: ReqGetExchangeRuleBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年12月30日 上午5:35:52
 * 
 */
public class ReqGetExchangeRuleBean extends RequestBaseBean {
	
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
		return "ReqGetExchangeRuleBean [cardId=" + cardId + ", toString()=" + super.toString() + "]";
	}

}
