package com.yyabl.api.crm.biz.Domain;

public class Hyk_MdjfKey {
	private Integer hyid;

	private Integer mdid;

	public Integer getHyid() {
		return hyid;
	}

	public void setHyid(Integer hyid) {
		this.hyid = hyid;
	}

	public Integer getMdid() {
		return mdid;
	}

	public void setMdid(Integer mdid) {
		this.mdid = mdid;
	}

	@Override
	public String toString() {
		return "Hyk_MdjfKey [hyid=" + hyid + ", mdid=" + mdid + "]";
	}

}