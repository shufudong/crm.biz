package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;

public class ApiOrgDef implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String orgName;

	private Integer mdid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName == null ? null : orgName.trim();
	}

	public Integer getMdid() {
		return mdid;
	}

	public void setMdid(Integer mdid) {
		this.mdid = mdid;
	}
}