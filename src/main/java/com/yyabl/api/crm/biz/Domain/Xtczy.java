package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;
import java.util.Arrays;

public class Xtczy implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer personId;

	private String operStation;

	private byte[] loginPassword;

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getOperStation() {
		return operStation;
	}

	public void setOperStation(String operStation) {
		this.operStation = operStation == null ? null : operStation.trim();
	}

	public byte[] getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(byte[] loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public String toString() {
		return "Xtczy [personId=" + personId + ", operStation=" + operStation + ", loginPassword=" + Arrays.toString(loginPassword) + "]";
	}

}