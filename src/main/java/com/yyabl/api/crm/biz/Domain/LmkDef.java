package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;

public class LmkDef implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer lmkId;

    private String lmkCode;

    private String lmkName;

    private Integer orgId;

    private Integer lenCdnr;

    private Integer lenBegin;

    private Integer lenEnd;

    private Short hyktype;

    private Byte canNew;

    private Byte canZf;

    private Byte canHk;

    private Byte canGs;

    private Byte canJg;

    public Integer getLmkId() {
        return lmkId;
    }

    public void setLmkId(Integer lmkId) {
        this.lmkId = lmkId;
    }

    public String getLmkCode() {
        return lmkCode;
    }

    public void setLmkCode(String lmkCode) {
        this.lmkCode = lmkCode == null ? null : lmkCode.trim();
    }

    public String getLmkName() {
        return lmkName;
    }

    public void setLmkName(String lmkName) {
        this.lmkName = lmkName == null ? null : lmkName.trim();
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getLenCdnr() {
        return lenCdnr;
    }

    public void setLenCdnr(Integer lenCdnr) {
        this.lenCdnr = lenCdnr;
    }

    public Integer getLenBegin() {
        return lenBegin;
    }

    public void setLenBegin(Integer lenBegin) {
        this.lenBegin = lenBegin;
    }

    public Integer getLenEnd() {
        return lenEnd;
    }

    public void setLenEnd(Integer lenEnd) {
        this.lenEnd = lenEnd;
    }

    public Short getHyktype() {
        return hyktype;
    }

    public void setHyktype(Short hyktype) {
        this.hyktype = hyktype;
    }

    public Byte getCanNew() {
        return canNew;
    }

    public void setCanNew(Byte canNew) {
        this.canNew = canNew;
    }

    public Byte getCanZf() {
        return canZf;
    }

    public void setCanZf(Byte canZf) {
        this.canZf = canZf;
    }

    public Byte getCanHk() {
        return canHk;
    }

    public void setCanHk(Byte canHk) {
        this.canHk = canHk;
    }

    public Byte getCanGs() {
        return canGs;
    }

    public void setCanGs(Byte canGs) {
        this.canGs = canGs;
    }

    public Byte getCanJg() {
        return canJg;
    }

    public void setCanJg(Byte canJg) {
        this.canJg = canJg;
    }
}