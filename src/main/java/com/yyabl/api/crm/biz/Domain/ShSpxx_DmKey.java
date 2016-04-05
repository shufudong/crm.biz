package com.yyabl.api.crm.biz.Domain;

public class ShSpxx_DmKey {
	private String shdm;

	private String spdm;

	public String getShdm() {
		return shdm;
	}

	public void setShdm(String shdm) {
		this.shdm = shdm == null ? null : shdm.trim();
	}

	public String getSpdm() {
		return spdm;
	}

	public void setSpdm(String spdm) {
		this.spdm = spdm == null ? null : spdm.trim();
	}

	@Override
	public String toString() {
		return "ShSpxx_DmKey [shdm=" + shdm + ", spdm=" + spdm + "]";
	}

}