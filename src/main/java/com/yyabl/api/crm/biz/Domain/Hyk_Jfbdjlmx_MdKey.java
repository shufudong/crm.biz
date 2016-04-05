package com.yyabl.api.crm.biz.Domain;

import java.util.Date;

public class Hyk_Jfbdjlmx_MdKey {
	private Integer hyid;

	private Date rq;

	private Short cllx;

	private Integer mdid;

	public Integer getHyid() {
		return hyid;
	}

	public void setHyid(Integer hyid) {
		this.hyid = hyid;
	}

	public Date getRq() {
		return rq;
	}

	public void setRq(Date rq) {
		this.rq = rq;
	}

	public Short getCllx() {
		return cllx;
	}

	public void setCllx(Short cllx) {
		this.cllx = cllx;
	}

	public Integer getMdid() {
		return mdid;
	}

	public void setMdid(Integer mdid) {
		this.mdid = mdid;
	}

	@Override
	public String toString() {
		return "Hyk_Jfbdjlmx_MdKey [hyid=" + hyid + ", rq=" + rq + ", cllx=" + cllx + ", mdid=" + mdid + "]";
	}

}