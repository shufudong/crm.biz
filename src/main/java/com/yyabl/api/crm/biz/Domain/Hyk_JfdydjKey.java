package com.yyabl.api.crm.biz.Domain;

public class Hyk_JfdydjKey {
	private Short hyktype;

	private String shdm;

	private String shbmdm;

	public Short getHyktype() {
		return hyktype;
	}

	public void setHyktype(Short hyktype) {
		this.hyktype = hyktype;
	}

	public String getShdm() {
		return shdm;
	}

	public void setShdm(String shdm) {
		this.shdm = shdm == null ? null : shdm.trim();
	}

	public String getShbmdm() {
		return shbmdm;
	}

	public void setShbmdm(String shbmdm) {
		this.shbmdm = shbmdm == null ? null : shbmdm.trim();
	}

	@Override
	public String toString() {
		return "Hyk_JfdydjKey [hyktype=" + hyktype + ", shdm=" + shdm + ", shbmdm=" + shbmdm + "]";
	}

}