package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;

public class PrivApiKey implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer personId;

	private Integer apiId;

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public Integer getApiId() {
		return apiId;
	}

	public void setApiId(Integer apiId) {
		this.apiId = apiId;
	}

	@Override
	public String toString() {
		return "PrivApiKey [personId=" + personId + ", apiId=" + apiId + "]";
	}

}