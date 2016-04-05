package com.yyabl.api.crm.biz.Domain;

import java.math.BigDecimal;

public class Hyk_Vipjlcljlmx extends Hyk_VipjlcljlmxKey {
	private Double jfQc;

	private Double jfCl;

	private BigDecimal jlje;

	private String content;

	private Short hbfs;

	private Integer cs;

	public Double getJfQc() {
		return jfQc;
	}

	public void setJfQc(Double jfQc) {
		this.jfQc = jfQc;
	}

	public Double getJfCl() {
		return jfCl;
	}

	public void setJfCl(Double jfCl) {
		this.jfCl = jfCl;
	}

	public BigDecimal getJlje() {
		return jlje;
	}

	public void setJlje(BigDecimal jlje) {
		this.jlje = jlje;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Short getHbfs() {
		return hbfs;
	}

	public void setHbfs(Short hbfs) {
		this.hbfs = hbfs;
	}

	public Integer getCs() {
		return cs;
	}

	public void setCs(Integer cs) {
		this.cs = cs;
	}

	@Override
	public String toString() {
		return "Hyk_Vipjlcljlmx [jfQc=" + jfQc + ", jfCl=" + jfCl + ", jlje=" + jlje + ", content=" + content + ", hbfs=" + hbfs + ", cs=" + cs + "]";
	}

}