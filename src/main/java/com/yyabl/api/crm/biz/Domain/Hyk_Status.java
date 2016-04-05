package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;

public class Hyk_Status implements Serializable {

	private static final long serialVersionUID = 1L;

	private Short id;

	private String name;

	private Integer flag;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Hyk_Status [id=" + id + ", name=" + name + ", flag=" + flag + "]";
	}

}