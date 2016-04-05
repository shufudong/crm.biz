/**
 * @Title: ReqGetCardIdByCardNoAndPhoneNo.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月18日 下午3:57:10
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @ClassName: ReqGetCardIdByCardNoAndPhoneNo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014年12月18日 下午3:57:10
 * 
 */
public class ReqGetCardIdByCardNoAndPhoneNoBean extends RequestBaseBean {
	
	/**
	 * @Fields cardNo : 会员卡号
	 */
	@NotNull(message = "属性'cardNo'不能为空.")
	@Size(min = 1, max = 20, message = "属性'cardNo'的长度必须在{min}与{max}之间.")
	private String cardNo;
	
	/**
	 * @Fields phoneNo : 手机号码
	 */
	@NotNull(message = "属性'phoneNo'不能为空.")
	@Size(min = 7, max = 12, message = "属性'phoneNo'的长度必须在{min}与{max}之间.")
	private String phoneNo;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "ReqGetCardIdByCardNoAndPhoneNoBean [cardNo=" + cardNo + ", phoneNo=" + phoneNo + ", toString()=" + super.toString() + "]";
	}
	
}
