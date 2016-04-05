/**
 * @Title: RespGetCardIdByVerifyInfoBean.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-9 上午11:17:36
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

/**
 * @author Maven
 * @version 2014-9-9
 * 
 *          /**
 * @ClassName: RespGetCardIdByVerifyInfoBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-9 上午11:17:36
 * 
 */
public class RespGetCardIdByVerifyInfoBean extends ResponseBaseBean {
	private int cardId;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	@Override
	public String toString() {
		return "RespGetCardIdByVerifyInfoBean [cardId=" + cardId + ", toString()=" + super.toString() + "]";
	}
}
