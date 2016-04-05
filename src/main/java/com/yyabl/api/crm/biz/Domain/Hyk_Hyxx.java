package com.yyabl.api.crm.biz.Domain;

import java.util.Arrays;
import java.util.Date;

public class Hyk_Hyxx {
	private Integer hyid;

	private Short hyktype;

	private String hykNo;

	private String hyName;

	private String cdnr;

	private Date jkrq;

	private Date yxq;

	private Date zhxfrq;

	private Short bjPsw;

	private String password;

	private Date djsj;

	private Integer djr;

	private String djrmc;

	private Short status;

	private Short jgid;

	private Short ffsx;

	private String oldHykno;

	private String ybgdd;

	private Integer khid;

	private Integer mdid;

	private Integer gkid;

	private Date createdat;

	private Date updatedat;

	private HykDef hykType;

	private Hyk_Gkda hykGkda;

	private Hyk_Status hykStatus;

	private byte[] tm;

	public Integer getHyid() {
		return hyid;
	}

	public void setHyid(Integer hyid) {
		this.hyid = hyid;
	}

	public Short getHyktype() {
		return hyktype;
	}

	public void setHyktype(Short hyktype) {
		this.hyktype = hyktype;
	}

	public String getHykNo() {
		return hykNo;
	}

	public void setHykNo(String hykNo) {
		this.hykNo = hykNo == null ? null : hykNo.trim();
	}

	public String getHyName() {
		return hyName;
	}

	public void setHyName(String hyName) {
		this.hyName = hyName == null ? null : hyName.trim();
	}

	public String getCdnr() {
		return cdnr;
	}

	public void setCdnr(String cdnr) {
		this.cdnr = cdnr == null ? null : cdnr.trim();
	}

	public Date getJkrq() {
		return jkrq;
	}

	public void setJkrq(Date jkrq) {
		this.jkrq = jkrq;
	}

	public Date getYxq() {
		return yxq;
	}

	public void setYxq(Date yxq) {
		this.yxq = yxq;
	}

	public Date getZhxfrq() {
		return zhxfrq;
	}

	public void setZhxfrq(Date zhxfrq) {
		this.zhxfrq = zhxfrq;
	}

	public Short getBjPsw() {
		return bjPsw;
	}

	public void setBjPsw(Short bjPsw) {
		this.bjPsw = bjPsw;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Date getDjsj() {
		return djsj;
	}

	public void setDjsj(Date djsj) {
		this.djsj = djsj;
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

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getJgid() {
		return jgid;
	}

	public void setJgid(Short jgid) {
		this.jgid = jgid;
	}

	public Short getFfsx() {
		return ffsx;
	}

	public void setFfsx(Short ffsx) {
		this.ffsx = ffsx;
	}

	public String getOldHykno() {
		return oldHykno;
	}

	public void setOldHykno(String oldHykno) {
		this.oldHykno = oldHykno == null ? null : oldHykno.trim();
	}

	public String getYbgdd() {
		return ybgdd;
	}

	public void setYbgdd(String ybgdd) {
		this.ybgdd = ybgdd == null ? null : ybgdd.trim();
	}

	public Integer getKhid() {
		return khid;
	}

	public void setKhid(Integer khid) {
		this.khid = khid;
	}

	public Integer getMdid() {
		return mdid;
	}

	public void setMdid(Integer mdid) {
		this.mdid = mdid;
	}

	public Integer getGkid() {
		return gkid;
	}

	public void setGkid(Integer gkid) {
		this.gkid = gkid;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	public Date getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}

	public byte[] getTm() {
		return tm;
	}

	public void setTm(byte[] tm) {
		this.tm = tm;
	}

	public HykDef getHykType() {
		return hykType;
	}

	public void setHykType(HykDef hykType) {
		this.hykType = hykType;
	}

	public Hyk_Gkda getHykGkda() {
		return hykGkda;
	}

	public void setHykGkda(Hyk_Gkda hykGkda) {
		this.hykGkda = hykGkda;
	}

	public Hyk_Status getHykStatus() {
		return hykStatus;
	}

	public void setHykStatus(Hyk_Status hykStatus) {
		this.hykStatus = hykStatus;
	}

	@Override
	public String toString() {
		return "Hyk_Hyxx [hyid=" + hyid + ", hyktype=" + hyktype + ", hykNo=" + hykNo + ", hyName=" + hyName + ", cdnr=" + cdnr + ", jkrq=" + jkrq + ", yxq="
				+ yxq + ", zhxfrq=" + zhxfrq + ", bjPsw=" + bjPsw + ", password=" + password + ", djsj=" + djsj + ", djr=" + djr + ", djrmc=" + djrmc
				+ ", status=" + status + ", jgid=" + jgid + ", ffsx=" + ffsx + ", oldHykno=" + oldHykno + ", ybgdd=" + ybgdd + ", khid=" + khid + ", mdid="
				+ mdid + ", gkid=" + gkid + ", createdat=" + createdat + ", updatedat=" + updatedat + ", hykType=" + hykType + ", hykGkda=" + hykGkda
				+ ", hykStatus=" + hykStatus + ", tm=" + Arrays.toString(tm) + "]";
	}

}