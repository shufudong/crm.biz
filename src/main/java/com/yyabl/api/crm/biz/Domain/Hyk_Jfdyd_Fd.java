package com.yyabl.api.crm.biz.Domain;

import java.util.Arrays;
import java.util.Date;

public class Hyk_Jfdyd_Fd extends Hyk_Jfdyd_FdKey {
	private Date ksrq;

	private Date jsrq;

	private byte[] sd;

	public Date getKsrq() {
		return ksrq;
	}

	public void setKsrq(Date ksrq) {
		this.ksrq = ksrq;
	}

	public Date getJsrq() {
		return jsrq;
	}

	public void setJsrq(Date jsrq) {
		this.jsrq = jsrq;
	}

	public byte[] getSd() {
		return sd;
	}

	public void setSd(byte[] sd) {
		this.sd = sd;
	}

	@Override
	public String toString() {
		return "Hyk_Jfdyd_Fd [ksrq=" + ksrq + ", jsrq=" + jsrq + ", sd=" + Arrays.toString(sd) + "]";
	}

}