package com.yyabl.api.crm.biz.Domain;

import java.util.Date;

public class Hyk_YhqzhKey {
	private Integer hyid;

	private Short yhqid;

	private Date jsrq;

	private String mdfwdm;

	public Integer getHyid() {
		return hyid;
	}

	public void setHyid(Integer hyid) {
		this.hyid = hyid;
	}

	public Short getYhqid() {
		return yhqid;
	}

	public void setYhqid(Short yhqid) {
		this.yhqid = yhqid;
	}

	public Date getJsrq() {
		return jsrq;
	}

	public void setJsrq(Date jsrq) {
		this.jsrq = jsrq;
	}

	public String getMdfwdm() {
		return mdfwdm;
	}

	public void setMdfwdm(String mdfwdm) {
		this.mdfwdm = mdfwdm == null ? null : mdfwdm.trim();
	}

	@Override
	public String toString() {
		return "Hyk_YhqzhKey [hyid=" + hyid + ", yhqid=" + yhqid + ", jsrq=" + jsrq + ", mdfwdm=" + mdfwdm + "]";
	}

}