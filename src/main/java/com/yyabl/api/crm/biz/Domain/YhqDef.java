package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;
import java.util.Arrays;

public class YhqDef implements Serializable{

	private static final long serialVersionUID = 1L;

	private Short yhqid;

	private String yhqmc;

	private Short bjDzyhq;

	private Short bjTy;

	private Short bjFq;

	private Short fsYqmdfw;

	private Short fsFqmdfw;

	private Integer yxqts;

	private Short bjCxyhq;

	private byte[] tm;

	public Short getYhqid() {
		return yhqid;
	}

	public void setYhqid(Short yhqid) {
		this.yhqid = yhqid;
	}

	public String getYhqmc() {
		return yhqmc;
	}

	public void setYhqmc(String yhqmc) {
		this.yhqmc = yhqmc == null ? null : yhqmc.trim();
	}

	public Short getBjDzyhq() {
		return bjDzyhq;
	}

	public void setBjDzyhq(Short bjDzyhq) {
		this.bjDzyhq = bjDzyhq;
	}

	public Short getBjTy() {
		return bjTy;
	}

	public void setBjTy(Short bjTy) {
		this.bjTy = bjTy;
	}

	public Short getBjFq() {
		return bjFq;
	}

	public void setBjFq(Short bjFq) {
		this.bjFq = bjFq;
	}

	public Short getFsYqmdfw() {
		return fsYqmdfw;
	}

	public void setFsYqmdfw(Short fsYqmdfw) {
		this.fsYqmdfw = fsYqmdfw;
	}

	public Short getFsFqmdfw() {
		return fsFqmdfw;
	}

	public void setFsFqmdfw(Short fsFqmdfw) {
		this.fsFqmdfw = fsFqmdfw;
	}

	public Integer getYxqts() {
		return yxqts;
	}

	public void setYxqts(Integer yxqts) {
		this.yxqts = yxqts;
	}

	public Short getBjCxyhq() {
		return bjCxyhq;
	}

	public void setBjCxyhq(Short bjCxyhq) {
		this.bjCxyhq = bjCxyhq;
	}

	public byte[] getTm() {
		return tm;
	}

	public void setTm(byte[] tm) {
		this.tm = tm;
	}

	@Override
	public String toString() {
		return "YhqDef [yhqid=" + yhqid + ", yhqmc=" + yhqmc + ", bjDzyhq=" + bjDzyhq + ", bjTy=" + bjTy + ", bjFq=" + bjFq + ", fsYqmdfw=" + fsYqmdfw
				+ ", fsFqmdfw=" + fsFqmdfw + ", yxqts=" + yxqts + ", bjCxyhq=" + bjCxyhq + ", tm=" + Arrays.toString(tm) + "]";
	}

}