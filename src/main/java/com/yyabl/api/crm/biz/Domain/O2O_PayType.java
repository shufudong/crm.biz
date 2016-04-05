package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;


public class O2O_PayType extends O2O_PayTypeKey implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String name;

	private Integer kkid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getKkid() {
		return kkid;
	}

	public void setKkid(Integer kkid) {
		this.kkid = kkid;
	}

	@Override
	public String toString() {
		return "O2O_PayType [name=" + name + ", kkid=" + kkid + "]";
	}

}