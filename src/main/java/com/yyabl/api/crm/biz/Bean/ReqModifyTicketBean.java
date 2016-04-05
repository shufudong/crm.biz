package com.yyabl.api.crm.biz.Bean;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

/**
 * ClassName: ReqModifyTicketBean <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2015年2月3日 下午2:10:36 <br/>
 * 
 * @author 舒阜东
 * @version
 * @since JDK 1.7
 */
public class ReqModifyTicketBean extends RequestBaseBean {

	{
		super.setKeyFields(new String[] { "cardId", "tradeNo" });
	}

	/**
	 * cardId:会员卡ID
	 * @since JDK 1.7
	 */
	@NotNull(message = "错误：参数'cardId'不能为空.")
	private Integer cardId;

	/**
	 * value:金额
	 * @since JDK 1.7
	 */
	@NotNull(message = "错误：参数'values'不能为空.")
	private BigDecimal values;

	/**
	 * tradeNo:第三方商户生成的单据号.
	 * @since JDK 1.7
	 */
	@NotNull(message = "错误：参数'tradeNo'不能为空.")
	private String tradeNo;
	
	/** 
	 * bizType:业务类型，由友阿进行分配
	 * @since JDK 1.7
	 */
	@NotNull(message ="错误：参数'bizType'不能为空.")
	private Integer bizType;

	/**
	 * ticketType:优惠券类型ID
	 * @since JDK 1.7
	 */
	private Integer ticketType;

	/**
	 * validDate:优惠券有效期时间戳
	 * @since JDK 1.7
	 */
	private Long validDate;

	/**
	 * useScope:优惠券使用范围(为空表示不限制使用范围)
	 * @since JDK 1.7
	 */
	private String useScope;

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public BigDecimal getValues() {
		return values;
	}

	public void setValues(BigDecimal values) {
		this.values = values;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Integer getBizType() {
		return bizType;
	}

	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	public Integer getTicketType() {
		return ticketType;
	}

	public void setTicketType(Integer ticketType) {
		this.ticketType = ticketType;
	}

	public Long getValidDate() {
		return validDate;
	}

	public void setValidDate(Long validDate) {
		this.validDate = validDate;
	}

	public String getUseScope() {
		return useScope;
	}

	public void setUseScope(String useScope) {
		this.useScope = useScope;
	}

	@Override
	public String toString() {
		return "ReqModifyTicketBean [cardId=" + cardId + ", values=" + values + ", tradeNo=" + tradeNo + ", bizType=" + bizType + ", ticketType=" + ticketType + ", validDate=" + validDate
				+ ", useScope=" + useScope + ", toString()=" + super.toString() + "]";
	}
}
