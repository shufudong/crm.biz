package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;


public class O2O_Mall implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer mdid;

    private String shmc;

    private String bmdm;

    private String shdm;

    public Integer getMdid() {
        return mdid;
    }

    public void setMdid(Integer mdid) {
        this.mdid = mdid;
    }

    public String getShmc() {
        return shmc;
    }

    public void setShmc(String shmc) {
        this.shmc = shmc == null ? null : shmc.trim();
    }

    public String getBmdm() {
        return bmdm;
    }

    public void setBmdm(String bmdm) {
        this.bmdm = bmdm == null ? null : bmdm.trim();
    }

    public String getShdm() {
        return shdm;
    }

    public void setShdm(String shdm) {
        this.shdm = shdm == null ? null : shdm.trim();
    }

	@Override
	public String toString() {
		return "O2O_Mall [mdid=" + mdid + ", shmc=" + shmc + ", bmdm=" + bmdm + ", shdm=" + shdm + "]";
	}
    
}