package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** 
 * ClassName: ReqModifyPointBean <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2015年2月4日 下午3:00:19 <br/> 
 * @author 舒阜东
 * @version  
 * @since JDK 1.7
 */
public class ReqModifyPointBean extends RequestBaseBean {

	{
		super.setKeyFields(new String[] { "cardId", "tradeNo" });
	}

	/**
	 * @Fields tradeNo : 第三方商户的单据号
	 */
	@NotNull(message = "属性'tradeNo'不能为空.")
	@Size(max = 50, message = "参数'tradeNo'长度不能大于50个字符。")
	private String tradeNo;

	/**
	 * @Fields cardId : 会员卡ID
	 */
	@NotNull(message = "参数'cardId'不能为空.")
	private Integer cardId;

	/**
	 * @Fields values : 要扣减的积分值
	 */
	@NotNull(message = "参数'values'不能为空.")
	private Double values;

	/**
	 * @Fields bizType : 业务类型
	 */
	@NotNull(message="参数'bizType'不能为空.")
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
		return "ReqModifyPointBean [tradeNo=" + tradeNo + ", cardId=" + cardId + ", values=" + values + ", bizType=" + bizType + ", toString()=" + super.toString() + "]";
	}

}
