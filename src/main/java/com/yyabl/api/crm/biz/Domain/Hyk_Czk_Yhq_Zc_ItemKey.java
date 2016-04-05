package com.yyabl.api.crm.biz.Domain;

import java.util.Date;

public class Hyk_Czk_Yhq_Zc_ItemKey {
    private Integer czjpjJlbh;

    private Integer hyidZc;

    private Short yhqid;

    private Date jsrq;

    private String mdfwdm;

    public Integer getCzjpjJlbh() {
        return czjpjJlbh;
    }

    public void setCzjpjJlbh(Integer czjpjJlbh) {
        this.czjpjJlbh = czjpjJlbh;
    }

    public Integer getHyidZc() {
        return hyidZc;
    }

    public void setHyidZc(Integer hyidZc) {
        this.hyidZc = hyidZc;
    }

    public Short getYhqid() {
        return yhqid;
    }

    public void setYhqid(Short yhqid) {
        this.yhqid = yhqid;
    }

    public Date getJsrq() {
        return jsrq;
    }

    public void setJsrq(Date jsrq) {
        this.jsrq = jsrq;
    }

    public String getMdfwdm() {
        return mdfwdm;
    }

    public void setMdfwdm(String mdfwdm) {
        this.mdfwdm = mdfwdm == null ? null : mdfwdm.trim();
    }
}