/**
 * @Title: ReqSendVerifyCodeByCardNo.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014-9-9 上午9:33:51
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.NotNull;

/**
 * @author Maven
 * @version 2014-9-9
 * 
 *          /**
 * @ClassName: ReqSendVerifyCodeByCardNo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Maven
 * @date 2014-9-9 上午9:33:51
 * 
 */
public class ReqSendVerifyCodeByCardNoBean extends RequestBaseBean {
	
	/** 
	 * cardNo:会员卡号
	 * @since JDK 1.7
	 */
	@NotNull(message = "错误：参数'cardNo'不能为空。")
	private String cardNo;
	
	/** 
	 * bizType:业务类型代码
	 * @since JDK 1.7
	 */
	@NotNull(message = "错误：参数'bizType'不能为空。")
	private Integer bizType;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getBizType() {
		return bizType;
	}

	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	@Override
	public String toString() {
		return "ReqSendVerifyCodeByCardNoBean [cardNo=" + cardNo + ", bizType=" + bizType + ", toString()=" + super.toString() + "]";
	}
}
