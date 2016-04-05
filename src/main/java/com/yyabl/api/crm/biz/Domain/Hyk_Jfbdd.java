package com.yyabl.api.crm.biz.Domain;

import java.math.BigDecimal;
import java.util.Date;

public class Hyk_Jfbdd {
	private Integer jlbh;

	private String czdd;

	private Integer hyid;

	private Double wcljfOld;

	private BigDecimal xfje;

	private Double tzjf;

	private String zy;

	private Integer djr;

	private String djrmc;

	private Date djsj;

	private Integer zxr;

	private String zxrmc;

	private Date zxrq;

	public Integer getJlbh() {
		return jlbh;
	}

	public void setJlbh(Integer jlbh) {
		this.jlbh = jlbh;
	}

	public String getCzdd() {
		return czdd;
	}

	public void setCzdd(String czdd) {
		this.czdd = czdd == null ? null : czdd.trim();
	}

	public Integer getHyid() {
		return hyid;
	}

	public void setHyid(Integer hyid) {
		this.hyid = hyid;
	}

	public Double getWcljfOld() {
		return wcljfOld;
	}

	public void setWcljfOld(Double wcljfOld) {
		this.wcljfOld = wcljfOld;
	}

	public BigDecimal getXfje() {
		return xfje;
	}

	public void setXfje(BigDecimal xfje) {
		this.xfje = xfje;
	}

	public Double getTzjf() {
		return tzjf;
	}

	public void setTzjf(Double tzjf) {
		this.tzjf = tzjf;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy == null ? null : zy.trim();
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

	public Integer getZxr() {
		return zxr;
	}

	public void setZxr(Integer zxr) {
		this.zxr = zxr;
	}

	public String getZxrmc() {
		return zxrmc;
	}

	public void setZxrmc(String zxrmc) {
		this.zxrmc = zxrmc == null ? null : zxrmc.trim();
	}

	public Date getZxrq() {
		return zxrq;
	}

	public void setZxrq(Date zxrq) {
		this.zxrq = zxrq;
	}

	@Override
	public String toString() {
		return "Hyk_Jfbdd [jlbh=" + jlbh + ", czdd=" + czdd + ", hyid=" + hyid + ", wcljfOld=" + wcljfOld + ", xfje=" + xfje + ", tzjf=" + tzjf + ", zy=" + zy
				+ ", djr=" + djr + ", djrmc=" + djrmc + ", djsj=" + djsj + ", zxr=" + zxr + ", zxrmc=" + zxrmc + ", zxrq=" + zxrq + "]";
	}

}