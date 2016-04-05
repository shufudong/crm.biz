package com.yyabl.api.crm.biz.Domain;

public class ShSpfl {
	private Integer shspflid;

	private String shdm;

	private String spfldm;

	private String spflmc;

	private String pym;

	private Byte mjbj;

	private Integer spflid;

	public Integer getShspflid() {
		return shspflid;
	}

	public void setShspflid(Integer shspflid) {
		this.shspflid = shspflid;
	}

	public String getShdm() {
		return shdm;
	}

	public void setShdm(String shdm) {
		this.shdm = shdm == null ? null : shdm.trim();
	}

	public String getSpfldm() {
		return spfldm;
	}

	public void setSpfldm(String spfldm) {
		this.spfldm = spfldm == null ? null : spfldm.trim();
	}

	public String getSpflmc() {
		return spflmc;
	}

	public void setSpflmc(String spflmc) {
		this.spflmc = spflmc == null ? null : spflmc.trim();
	}

	public String getPym() {
		return pym;
	}

	public void setPym(String pym) {
		this.pym = pym == null ? null : pym.trim();
	}

	public Byte getMjbj() {
		return mjbj;
	}

	public void setMjbj(Byte mjbj) {
		this.mjbj = mjbj;
	}

	public Integer getSpflid() {
		return spflid;
	}

	public void setSpflid(Integer spflid) {
		this.spflid = spflid;
	}

	@Override
	public String toString() {
		return "ShSpfl [shspflid=" + shspflid + ", shdm=" + shdm + ", spfldm=" + spfldm + ", spflmc=" + spflmc + ", pym=" + pym + ", mjbj=" + mjbj
				+ ", spflid=" + spflid + "]";
	}

}