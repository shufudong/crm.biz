/**
 * @Title: ReqGetCardIdByCardNo.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2015年1月5日 下午1:53:35
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @ClassName: ReqGetCardIdByCardNo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2015年1月5日 下午1:53:35
 * 
 */
public class ReqGetCardIdByCardNoBean extends RequestBaseBean {
	
	/** 
	 * cardNo:会员卡号.
	 * @since JDK 1.7
	 */
	@NotNull(message = "属性'cardNo'不能为空.")
	@Size(min = 1, max = 20, message = "属性'cardNo'的长度必须在{min}与{max}之间.")
	private String cardNo;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@Override
	public String toString() {
		return "ReqGetCardIdByCardNoBean [cardNo=" + cardNo + ", toString()=" + super.toString() + "]";
	}

}
