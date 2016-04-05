package com.yyabl.api.crm.biz.Domain;

public class Hyk_Jfdyd_Sp extends Hyk_Jfdyd_SpKey {
	private Double fz;

	private Integer xh;

	private Short bjCj;

	public Double getFz() {
		return fz;
	}

	public void setFz(Double fz) {
		this.fz = fz;
	}

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public Short getBjCj() {
		return bjCj;
	}

	public void setBjCj(Short bjCj) {
		this.bjCj = bjCj;
	}

	@Override
	public String toString() {
		return "Hyk_Jfdyd_Sp [fz=" + fz + ", xh=" + xh + ", bjCj=" + bjCj + "]";
	}

}