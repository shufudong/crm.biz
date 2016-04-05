/**
 * @Title: RespGenerateCardBean.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月16日 下午5:35:37
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

/**
 * @ClassName: RespGenerateCardBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年12月16日 下午5:35:37
 * 
 */
public class RespGenerateCardBean extends ResponseBaseBean {
	/**
	 * @Fields cardId : 会员卡ID
	 */
	private int cardId;

	/**
	 * @return the cardId
	 */
	public int getCardId() {
		return cardId;
	}

	/**
	 * @param cardId
	 *            the cardId to set
	 */
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	@Override
	public String toString() {
		return "RespGenerateCardBean [cardId=" + cardId + ", toString()=" + super.toString() + "]";
	}

}
