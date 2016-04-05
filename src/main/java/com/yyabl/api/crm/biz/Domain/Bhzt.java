package com.yyabl.api.crm.biz.Domain;

public class Bhzt {
	private String tblname;

	private Integer recNum;

	public String getTblname() {
		return tblname;
	}

	public void setTblname(String tblname) {
		this.tblname = tblname == null ? null : tblname.trim();
	}

	public Integer getRecNum() {
		return recNum;
	}

	public void setRecNum(Integer recNum) {
		this.recNum = recNum;
	}

	@Override
	public String toString() {
		return "Bhzt [tblname=" + tblname + ", recNum=" + recNum + "]";
	}

}