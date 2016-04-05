package com.yyabl.api.crm.biz.Bean;

import org.hibernate.validator.constraints.NotEmpty;

/** 
 * ClassName: ReqGetMobileNoByCardNoBean <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2015年2月4日 下午2:55:49 <br/> 
 * @author 舒阜东
 * @version  
 * @since JDK 1.7
 */
public class ReqGetMobileNoByCardNoBean extends RequestBaseBean {
	
	/** 
	 * cardNo:会员卡号
	 * @since JDK 1.7
	 */
	@NotEmpty(message="错误：参数'cardNo'不能为空。")
	private String cardNo;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@Override
	public String toString() {
		return "ReqGetMobileNoByCardNoBean [cardNo=" + cardNo + ", toString()=" + super.toString() + "]";
	}
}
