package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;

public class Hyk_Bgdd implements Serializable{
 
	private static final long serialVersionUID = 1L;

	private String bgdddm;

    private String bgddmc;

    private Byte zkBj;

    private Byte xsBj;

    private Short mjbj;

    private Integer mdid;

    public String getBgdddm() {
        return bgdddm;
    }

    public void setBgdddm(String bgdddm) {
        this.bgdddm = bgdddm == null ? null : bgdddm.trim();
    }

    public String getBgddmc() {
        return bgddmc;
    }

    public void setBgddmc(String bgddmc) {
        this.bgddmc = bgddmc == null ? null : bgddmc.trim();
    }

    public Byte getZkBj() {
        return zkBj;
    }

    public void setZkBj(Byte zkBj) {
        this.zkBj = zkBj;
    }

    public Byte getXsBj() {
        return xsBj;
    }

    public void setXsBj(Byte xsBj) {
        this.xsBj = xsBj;
    }

    public Short getMjbj() {
        return mjbj;
    }

    public void setMjbj(Short mjbj) {
        this.mjbj = mjbj;
    }

    public Integer getMdid() {
        return mdid;
    }

    public void setMdid(Integer mdid) {
        this.mdid = mdid;
    }
}