package com.yyabl.api.crm.biz.Domain;

public class Hyk_SMS_Verify_CodeKey {
	private Integer hyid;

	private Integer bizType;

	public Integer getHyid() {
		return hyid;
	}

	public void setHyid(Integer hyid) {
		this.hyid = hyid;
	}

	public Integer getBizType() {
		return bizType;
	}

	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	@Override
	public String toString() {
		return "Hyk_SMS_Verify_CodeKey [hyid=" + hyid + ", bizType=" + bizType + "]";
	}

}