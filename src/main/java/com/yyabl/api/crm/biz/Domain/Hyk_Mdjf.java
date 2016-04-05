package com.yyabl.api.crm.biz.Domain;

import java.math.BigDecimal;
import java.util.Arrays;

public class Hyk_Mdjf extends Hyk_MdjfKey {
	private Double wcljf;

	private Double xfje;

	private BigDecimal zkje;

	private Double bqjf;

	private Double ljjf;

	private BigDecimal ljxfje;

	private BigDecimal ljzkje;

	private Integer xfcs;

	private Integer thcs;

	private byte[] tm;

	public Double getWcljf() {
		return wcljf;
	}

	public void setWcljf(Double wcljf) {
		this.wcljf = wcljf;
	}

	public Double getXfje() {
		return xfje;
	}

	public void setXfje(Double xfje) {
		this.xfje = xfje;
	}

	public BigDecimal getZkje() {
		return zkje;
	}

	public void setZkje(BigDecimal zkje) {
		this.zkje = zkje;
	}

	public Double getBqjf() {
		return bqjf;
	}

	public void setBqjf(Double bqjf) {
		this.bqjf = bqjf;
	}

	public Double getLjjf() {
		return ljjf;
	}

	public void setLjjf(Double ljjf) {
		this.ljjf = ljjf;
	}

	public BigDecimal getLjxfje() {
		return ljxfje;
	}

	public void setLjxfje(BigDecimal ljxfje) {
		this.ljxfje = ljxfje;
	}

	public BigDecimal getLjzkje() {
		return ljzkje;
	}

	public void setLjzkje(BigDecimal ljzkje) {
		this.ljzkje = ljzkje;
	}

	public Integer getXfcs() {
		return xfcs;
	}

	public void setXfcs(Integer xfcs) {
		this.xfcs = xfcs;
	}

	public Integer getThcs() {
		return thcs;
	}

	public void setThcs(Integer thcs) {
		this.thcs = thcs;
	}

	public byte[] getTm() {
		return tm;
	}

	public void setTm(byte[] tm) {
		this.tm = tm;
	}

	@Override
	public String toString() {
		return "Hyk_Mdjf [wcljf=" + wcljf + ", xfje=" + xfje + ", zkje=" + zkje + ", bqjf=" + bqjf + ", ljjf=" + ljjf + ", ljxfje=" + ljxfje + ", ljzkje="
				+ ljzkje + ", xfcs=" + xfcs + ", thcs=" + thcs + ", tm=" + Arrays.toString(tm) + "]";
	}

}