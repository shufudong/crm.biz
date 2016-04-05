package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;
import java.util.Date;

public class Hyk_Jfflgz implements Serializable {

	private static final long serialVersionUID = 1L;

	private Short hyktype;

	private Short clrc;

	private Date ksrq;

	private Short clfw;

	private String qzqd;

	private Date jsrq;

	private Byte yxbjsclBj;

	private Integer djr;

	private String djrmc;

	private Date djsj;

	private Short status;

	private Date syjsrq;

	private Integer yhqyxts;

	public Short getHyktype() {
		return hyktype;
	}

	public void setHyktype(Short hyktype) {
		this.hyktype = hyktype;
	}

	public Short getClrc() {
		return clrc;
	}

	public void setClrc(Short clrc) {
		this.clrc = clrc;
	}

	public Date getKsrq() {
		return ksrq;
	}

	public void setKsrq(Date ksrq) {
		this.ksrq = ksrq;
	}

	public Short getClfw() {
		return clfw;
	}

	public void setClfw(Short clfw) {
		this.clfw = clfw;
	}

	public String getQzqd() {
		return qzqd;
	}

	public void setQzqd(String qzqd) {
		this.qzqd = qzqd == null ? null : qzqd.trim();
	}

	public Date getJsrq() {
		return jsrq;
	}

	public void setJsrq(Date jsrq) {
		this.jsrq = jsrq;
	}

	public Byte getYxbjsclBj() {
		return yxbjsclBj;
	}

	public void setYxbjsclBj(Byte yxbjsclBj) {
		this.yxbjsclBj = yxbjsclBj;
	}

	public Integer getDjr() {
		return djr;
	}

	public void setDjr(Integer djr) {
		this.djr = djr;
	}

	public String getDjrmc() {
		return djrmc;
	}

	public void setDjrmc(String djrmc) {
		this.djrmc = djrmc == null ? null : djrmc.trim();
	}

	public Date getDjsj() {
		return djsj;
	}

	public void setDjsj(Date djsj) {
		this.djsj = djsj;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Date getSyjsrq() {
		return syjsrq;
	}

	public void setSyjsrq(Date syjsrq) {
		this.syjsrq = syjsrq;
	}

	public Integer getYhqyxts() {
		return yhqyxts;
	}

	public void setYhqyxts(Integer yhqyxts) {
		this.yhqyxts = yhqyxts;
	}
}