/**
 * @Title: ReqCutTicket.java
 * @Package com.yyabl.api.crm.biz.Bean
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Maven
 * @date 2014年12月16日 下午3:00:39
 * @version V1.0
 */
package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * ClassName: ReqCutTicketBean <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年2月4日 下午2:38:02 <br/>
 * 
 * @author 舒阜东
 * @version
 * @since JDK 1.7
 */
public class ReqCutTicketBean extends RequestBaseBean {

	{
		super.setKeyFields(new String[] { "cardId", "tradeNo" });
	}

	/**
	 * @Fields tradeNo : 第三方商户的单据号
	 */
	@NotNull(message = "属性'tradeNo'不能为空.")
	private String tradeNo;

	/**
	 * @Fields cardId : 会员卡ID
	 */
	@NotNull(message = "参数'cardId'不能为空.")
	private Integer cardId;

	/**
	 * @Fields values : 要扣减的券值
	 */
	@NotNull
	@Min(value = 1, message = "错误:参数'values'不能小余1.")
	private Double values;

	/**
	 * @Fields bizType : 业务类型
	 */
	@NotNull(message = "参数'bizType'不能为空.")
	private Integer bizType;

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Double getValues() {
		return values;
	}

	public void setValues(Double values) {
		this.values = values;
	}

	public Integer getBizType() {
		return bizType;
	}

	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	@Override
	public String toString() {
		return "ReqCutTicketBean [tradeNo=" + tradeNo + ", cardId=" + cardId + ", values=" + values + ", bizType=" + bizType + ", toString()=" + super.toString() + "]";
	}
}
