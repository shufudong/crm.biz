package com.yyabl.api.crm.biz.Domain;

import java.math.BigDecimal;
import java.util.Date;

public class Hyk_Zfjl {
    private Integer jlbh;

    private Short hyktype;

    private String zy;

    private BigDecimal je;

    private Integer djr;

    private String djrmc;

    private Date djsj;

    private Integer zxr;

    private String zxrmc;

    private Date zxrq;

    private Short bjHf;

    private String czdd;

    private Short bjHyk;

    public Integer getJlbh() {
        return jlbh;
    }

    public void setJlbh(Integer jlbh) {
        this.jlbh = jlbh;
    }

    public Short getHyktype() {
        return hyktype;
    }

    public void setHyktype(Short hyktype) {
        this.hyktype = hyktype;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy == null ? null : zy.trim();
    }

    public BigDecimal getJe() {
        return je;
    }

    public void setJe(BigDecimal je) {
        this.je = je;
    }

    public Integer getDjr() {
        return djr;
    }

    public void setDjr(Integer djr) {
        this.djr = djr;
    }

    public String getDjrmc() {
        return djrmc;
    }

    public void setDjrmc(String djrmc) {
        this.djrmc = djrmc == null ? null : djrmc.trim();
    }

    public Date getDjsj() {
        return djsj;
    }

    public void setDjsj(Date djsj) {
        this.djsj = djsj;
    }

    public Integer getZxr() {
        return zxr;
    }

    public void setZxr(Integer zxr) {
        this.zxr = zxr;
    }

    public String getZxrmc() {
        return zxrmc;
    }

    public void setZxrmc(String zxrmc) {
        this.zxrmc = zxrmc == null ? null : zxrmc.trim();
    }

    public Date getZxrq() {
        return zxrq;
    }

    public void setZxrq(Date zxrq) {
        this.zxrq = zxrq;
    }

    public Short getBjHf() {
        return bjHf;
    }

    public void setBjHf(Short bjHf) {
        this.bjHf = bjHf;
    }

    public String getCzdd() {
        return czdd;
    }

    public void setCzdd(String czdd) {
        this.czdd = czdd == null ? null : czdd.trim();
    }

    public Short getBjHyk() {
        return bjHyk;
    }

    public void setBjHyk(Short bjHyk) {
        this.bjHyk = bjHyk;
    }
}