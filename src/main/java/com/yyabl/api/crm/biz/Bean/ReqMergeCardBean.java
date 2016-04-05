package com.yyabl.api.crm.biz.Bean;

import javax.validation.constraints.NotNull;

/** 
 * ClassName: ReqMergeCardBean <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2015年2月4日 下午2:58:29 <br/> 
 * @author 舒阜东
 * @version  
 * @since JDK 1.7
 */
public class ReqMergeCardBean extends RequestBaseBean {
	
	{
		super.setKeyFields(new String[]{"sourceCardId","targetCardId"});
	}

	/**
	 * @Fields sourceCardId : 源会员卡id
	 */
	@NotNull(message="错误：参数'sourceCardId'不能为空.")
	private Integer sourceCardId;

	/**
	 * @Fields targetCardId : 目标会员卡id
	 */
	@NotNull(message="错误：参数'targetCardId'不能为空.")
	private Integer targetCardId;


	public Integer getSourceCardId() {
		return sourceCardId;
	}

	public void setSourceCardId(Integer sourceCardId) {
		this.sourceCardId = sourceCardId;
	}

	public Integer getTargetCardId() {
		return targetCardId;
	}

	public void setTargetCardId(Integer targetCardId) {
		this.targetCardId = targetCardId;
	}

	@Override
	public String toString() {
		return "ReqMergeCardBean [sourceCardId=" + sourceCardId + ", targetCardId=" + targetCardId + ", toString()=" + super.toString() + "]";
	}
}
