package com.yyabl.api.crm.biz.Domain;

public class Shht {
	private Integer shhtid;

	private String shdm;

	private String hth;

	private String ghsdm;

	private String gshmc;

	private Integer shbmid;

	private Short bjYx;

	public Integer getShhtid() {
		return shhtid;
	}

	public void setShhtid(Integer shhtid) {
		this.shhtid = shhtid;
	}

	public String getShdm() {
		return shdm;
	}

	public void setShdm(String shdm) {
		this.shdm = shdm == null ? null : shdm.trim();
	}

	public String getHth() {
		return hth;
	}

	public void setHth(String hth) {
		this.hth = hth == null ? null : hth.trim();
	}

	public String getGhsdm() {
		return ghsdm;
	}

	public void setGhsdm(String ghsdm) {
		this.ghsdm = ghsdm == null ? null : ghsdm.trim();
	}

	public String getGshmc() {
		return gshmc;
	}

	public void setGshmc(String gshmc) {
		this.gshmc = gshmc == null ? null : gshmc.trim();
	}

	public Integer getShbmid() {
		return shbmid;
	}

	public void setShbmid(Integer shbmid) {
		this.shbmid = shbmid;
	}

	public Short getBjYx() {
		return bjYx;
	}

	public void setBjYx(Short bjYx) {
		this.bjYx = bjYx;
	}

	@Override
	public String toString() {
		return "Shht [shhtid=" + shhtid + ", shdm=" + shdm + ", hth=" + hth + ", ghsdm=" + ghsdm + ", gshmc=" + gshmc + ", shbmid=" + shbmid + ", bjYx=" + bjYx
				+ "]";
	}

}