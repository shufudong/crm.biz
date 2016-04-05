package com.yyabl.api.crm.biz.Domain;

import java.util.Arrays;

public class ShSpxx {
	private Integer shspid;

	private String shdm;

	private String spdm;

	private String spmc;

	private String spjc;

	private String pym;

	private String unit;

	private String sphs;

	private String spgg;

	private String hh;

	private Integer shspflid;

	private Integer shsbid;

	private Integer shhtid;

	private byte[] tm;

	public Integer getShspid() {
		return shspid;
	}

	public void setShspid(Integer shspid) {
		this.shspid = shspid;
	}

	public String getShdm() {
		return shdm;
	}

	public void setShdm(String shdm) {
		this.shdm = shdm == null ? null : shdm.trim();
	}

	public String getSpdm() {
		return spdm;
	}

	public void setSpdm(String spdm) {
		this.spdm = spdm == null ? null : spdm.trim();
	}

	public String getSpmc() {
		return spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc == null ? null : spmc.trim();
	}

	public String getSpjc() {
		return spjc;
	}

	public void setSpjc(String spjc) {
		this.spjc = spjc == null ? null : spjc.trim();
	}

	public String getPym() {
		return pym;
	}

	public void setPym(String pym) {
		this.pym = pym == null ? null : pym.trim();
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
	}

	public String getSphs() {
		return sphs;
	}

	public void setSphs(String sphs) {
		this.sphs = sphs == null ? null : sphs.trim();
	}

	public String getSpgg() {
		return spgg;
	}

	public void setSpgg(String spgg) {
		this.spgg = spgg == null ? null : spgg.trim();
	}

	public String getHh() {
		return hh;
	}

	public void setHh(String hh) {
		this.hh = hh == null ? null : hh.trim();
	}

	public Integer getShspflid() {
		return shspflid;
	}

	public void setShspflid(Integer shspflid) {
		this.shspflid = shspflid;
	}

	public Integer getShsbid() {
		return shsbid;
	}

	public void setShsbid(Integer shsbid) {
		this.shsbid = shsbid;
	}

	public Integer getShhtid() {
		return shhtid;
	}

	public void setShhtid(Integer shhtid) {
		this.shhtid = shhtid;
	}

	public byte[] getTm() {
		return tm;
	}

	public void setTm(byte[] tm) {
		this.tm = tm;
	}

	@Override
	public String toString() {
		return "ShSpxx [shspid=" + shspid + ", shdm=" + shdm + ", spdm=" + spdm + ", spmc=" + spmc + ", spjc=" + spjc + ", pym=" + pym + ", unit=" + unit
				+ ", sphs=" + sphs + ", spgg=" + spgg + ", hh=" + hh + ", shspflid=" + shspflid + ", shsbid=" + shsbid + ", shhtid=" + shhtid + ", tm="
				+ Arrays.toString(tm) + "]";
	}

}