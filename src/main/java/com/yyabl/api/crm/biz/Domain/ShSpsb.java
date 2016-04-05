package com.yyabl.api.crm.biz.Domain;

public class ShSpsb {
	private Integer shsbid;

	private String shdm;

	private String sbdm;

	private String sbmc;

	private String pym;

	private String syz;

	private Byte mjbj;

	private Integer sbid;

	public Integer getShsbid() {
		return shsbid;
	}

	public void setShsbid(Integer shsbid) {
		this.shsbid = shsbid;
	}

	public String getShdm() {
		return shdm;
	}

	public void setShdm(String shdm) {
		this.shdm = shdm == null ? null : shdm.trim();
	}

	public String getSbdm() {
		return sbdm;
	}

	public void setSbdm(String sbdm) {
		this.sbdm = sbdm == null ? null : sbdm.trim();
	}

	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc == null ? null : sbmc.trim();
	}

	public String getPym() {
		return pym;
	}

	public void setPym(String pym) {
		this.pym = pym == null ? null : pym.trim();
	}

	public String getSyz() {
		return syz;
	}

	public void setSyz(String syz) {
		this.syz = syz == null ? null : syz.trim();
	}

	public Byte getMjbj() {
		return mjbj;
	}

	public void setMjbj(Byte mjbj) {
		this.mjbj = mjbj;
	}

	public Integer getSbid() {
		return sbid;
	}

	public void setSbid(Integer sbid) {
		this.sbid = sbid;
	}

	@Override
	public String toString() {
		return "ShSpsb [shsbid=" + shsbid + ", shdm=" + shdm + ", sbdm=" + sbdm + ", sbmc=" + sbmc + ", pym=" + pym + ", syz=" + syz + ", mjbj=" + mjbj
				+ ", sbid=" + sbid + "]";
	}

}