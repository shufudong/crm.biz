/**
 * @Title: ReqGetCardIdByVerifyInfoBean.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-9 上午11:11:44
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author Maven
 * @version 2014-9-9
 * 
 *          /**
 * @ClassName: ReqGetCardIdByVerifyInfoBean
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-9 上午11:11:44
 * 
 */
public class ReqGetCardIdByVerifyInfoBean extends RequestBaseBean {
	
	/** 
	 * cardNo:会员卡号
	 * @since JDK 1.7
	 */
	@NotNull(message = "错误：参数'cardNo'不能为空.")
	private String cardNo;
	
	/** 
	 * verifyCode:验证码
	 * @since JDK 1.7
	 */
	@Length(min = 6, max = 6, message = "错误：参数'verifyCode'的长度必须是{min}位.")
	private String verifyCode;
	
	/** 
	 * bizType:业务类型代码
	 * @since JDK 1.7
	 */
	@NotNull(message = "错误：参数'bizType'不能为空.")
	private Integer bizType;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public Integer getBizType() {
		return bizType;
	}

	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	@Override
	public String toString() {
		return "ReqGetCardIdByVerifyInfoBean [cardNo=" + cardNo + ", verifyCode=" + verifyCode + ", bizType=" + bizType + ", toString()=" + super.toString() + "]";
	}
}
