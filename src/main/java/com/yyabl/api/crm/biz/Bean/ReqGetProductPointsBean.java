package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/** 
 * ClassName: ReqGetProductPointsBean <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2015年2月4日 下午2:56:15 <br/> 
 * @author 舒阜东
 * @version  
 * @since JDK 1.7
 */
public class ReqGetProductPointsBean extends RequestBaseBean {

	/**
	 * @Fields mallId : 实体门店ID
	 */
	@NotNull(message = "参数'mallId'不能为空.")
	private Integer mallId;
	
	/**
	 * @Fields cardId : 会员卡ID
	 */
	@NotNull(message = "参数'cardId'不能为空.")
	private Integer cardId;
	
	/**
	 * @Fields erpCode : 商品的ERP编码
	 */
	@NotEmpty(message = "错误：参数'erpCode'不能为空。")
	private String erpCode;
	
	/**
	 * @Fields payType : 支付方式
	 */
	@NotEmpty(message = "错误：参数'payType'不能为空。")
	private String payType;
	
	/**
	 * @Fields payment : 支付金额
	 */
	@NotEmpty(message = "错误：参数'payment'不能为空。")
	private String payment;

	public Integer getMallId() {
		return mallId;
	}

	public void setMallId(Integer mallId) {
		this.mallId = mallId;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public String getErpCode() {
		return erpCode;
	}

	public void setErpCode(String erpCode) {
		this.erpCode = erpCode;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "ReqGetProductPointsBean [mallId=" + mallId + ", cardId=" + cardId + ", erpCode=" + erpCode + ", payType=" + payType + ", payment=" + payment
				+ ", toString()=" + super.toString() + "]";
	}

}
