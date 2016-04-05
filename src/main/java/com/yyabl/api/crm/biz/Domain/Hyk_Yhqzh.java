package com.yyabl.api.crm.biz.Domain;

import java.math.BigDecimal;
import java.util.Arrays;

public class Hyk_Yhqzh extends Hyk_YhqzhKey {
	private BigDecimal je;

	private BigDecimal jydjje;

	private byte[] tm;

	public BigDecimal getJe() {
		return je;
	}

	public void setJe(BigDecimal je) {
		this.je = je;
	}

	public BigDecimal getJydjje() {
		return jydjje;
	}

	public void setJydjje(BigDecimal jydjje) {
		this.jydjje = jydjje;
	}

	public byte[] getTm() {
		return tm;
	}

	public void setTm(byte[] tm) {
		this.tm = tm;
	}

	@Override
	public String toString() {
		return "Hyk_Yhqzh [je=" + je + ", jydjje=" + jydjje + ", tm=" + Arrays.toString(tm) + ", toString()=" + super.toString() + "]";
	}

}