/**
 * @Title: RespGetCardIdByCardNoAndPhoneNo.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月18日 下午8:48:32
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

/**
 * @ClassName: RespGetCardIdByCardNoAndPhoneNo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年12月18日 下午8:48:32
 * 
 */
public class RespGetCardIdByCardNoAndPhoneNoBean extends ResponseBaseBean {
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
	 * @param cardId the cardId to set
	 */
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	@Override
	public String toString() {
		return "RespGetCardIdByCardNoAndPhoneNoBean [cardId=" + cardId + ", toString()=" + super.toString() + "]";
	}
}
