/**
 * @Title: RespGetCardIdByCardNo.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2015年1月5日 下午1:53:52
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

/**
 * @ClassName: RespGetCardIdByCardNo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2015年1月5日 下午1:53:52
 * 
 */
public class RespGetCardIdByCardNoBean extends ResponseBaseBean {
	private int cardId;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	@Override
	public String toString() {
		return "RespGetCardIdByCardNoBean [cardId=" + cardId + ", toString()=" + super.toString() + "]";
	}
}
