package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class HykDef implements Serializable{

	private static final long serialVersionUID = 1L;

	private Short hyktype;

    private Short hykkzid;

    private String hykname;

    private Short fxfs;

    private Short hmcd;

    private String khqdm;

    private String khhzm;

    private Short ffdx;

    private String yxqcd;

    private Byte bjPsw;

    private Byte bjXsjl;

    private Byte bjJf;

    private Byte bjYhqzh;

    private Byte bjCzzh;

    private Byte bjCzk;

    private Short yhfs;

    private BigDecimal fkqdxfje;

    private Byte kxbj;

    private Byte tkbj;

    private Byte zfbj;

    private Short hykjcid;

    private BigDecimal kfje;

    private Short bjCdnrjm;

    private Short cdjz;

    private Short bjCzyhq;

    private Short bjXtzk;

    private Short fsYxq;

    private Short bjQzyk;

    private Short bjCx;

    private Short bjZqhy;

    private Integer lenCdnr;

    private String imageUrl;

    private byte[] tm;

    public Short getHyktype() {
        return hyktype;
    }

    public void setHyktype(Short hyktype) {
        this.hyktype = hyktype;
    }

    public Short getHykkzid() {
        return hykkzid;
    }

    public void setHykkzid(Short hykkzid) {
        this.hykkzid = hykkzid;
    }

    public String getHykname() {
        return hykname;
    }

    public void setHykname(String hykname) {
        this.hykname = hykname == null ? null : hykname.trim();
    }

    public Short getFxfs() {
        return fxfs;
    }

    public void setFxfs(Short fxfs) {
        this.fxfs = fxfs;
    }

    public Short getHmcd() {
        return hmcd;
    }

    public void setHmcd(Short hmcd) {
        this.hmcd = hmcd;
    }

    public String getKhqdm() {
        return khqdm;
    }

    public void setKhqdm(String khqdm) {
        this.khqdm = khqdm == null ? null : khqdm.trim();
    }

    public String getKhhzm() {
        return khhzm;
    }

    public void setKhhzm(String khhzm) {
        this.khhzm = khhzm == null ? null : khhzm.trim();
    }

    public Short getFfdx() {
        return ffdx;
    }

    public void setFfdx(Short ffdx) {
        this.ffdx = ffdx;
    }

    public String getYxqcd() {
        return yxqcd;
    }

    public void setYxqcd(String yxqcd) {
        this.yxqcd = yxqcd == null ? null : yxqcd.trim();
    }

    public Byte getBjPsw() {
        return bjPsw;
    }

    public void setBjPsw(Byte bjPsw) {
        this.bjPsw = bjPsw;
    }

    public Byte getBjXsjl() {
        return bjXsjl;
    }

    public void setBjXsjl(Byte bjXsjl) {
        this.bjXsjl = bjXsjl;
    }

    public Byte getBjJf() {
        return bjJf;
    }

    public void setBjJf(Byte bjJf) {
        this.bjJf = bjJf;
    }

    public Byte getBjYhqzh() {
        return bjYhqzh;
    }

    public void setBjYhqzh(Byte bjYhqzh) {
        this.bjYhqzh = bjYhqzh;
    }

    public Byte getBjCzzh() {
        return bjCzzh;
    }

    public void setBjCzzh(Byte bjCzzh) {
        this.bjCzzh = bjCzzh;
    }

    public Byte getBjCzk() {
        return bjCzk;
    }

    public void setBjCzk(Byte bjCzk) {
        this.bjCzk = bjCzk;
    }

    public Short getYhfs() {
        return yhfs;
    }

    public void setYhfs(Short yhfs) {
        this.yhfs = yhfs;
    }

    public BigDecimal getFkqdxfje() {
        return fkqdxfje;
    }

    public void setFkqdxfje(BigDecimal fkqdxfje) {
        this.fkqdxfje = fkqdxfje;
    }

    public Byte getKxbj() {
        return kxbj;
    }

    public void setKxbj(Byte kxbj) {
        this.kxbj = kxbj;
    }

    public Byte getTkbj() {
        return tkbj;
    }

    public void setTkbj(Byte tkbj) {
        this.tkbj = tkbj;
    }

    public Byte getZfbj() {
        return zfbj;
    }

    public void setZfbj(Byte zfbj) {
        this.zfbj = zfbj;
    }

    public Short getHykjcid() {
        return hykjcid;
    }

    public void setHykjcid(Short hykjcid) {
        this.hykjcid = hykjcid;
    }

    public BigDecimal getKfje() {
        return kfje;
    }

    public void setKfje(BigDecimal kfje) {
        this.kfje = kfje;
    }

    public Short getBjCdnrjm() {
        return bjCdnrjm;
    }

    public void setBjCdnrjm(Short bjCdnrjm) {
        this.bjCdnrjm = bjCdnrjm;
    }

    public Short getCdjz() {
        return cdjz;
    }

    public void setCdjz(Short cdjz) {
        this.cdjz = cdjz;
    }

    public Short getBjCzyhq() {
        return bjCzyhq;
    }

    public void setBjCzyhq(Short bjCzyhq) {
        this.bjCzyhq = bjCzyhq;
    }

    public Short getBjXtzk() {
        return bjXtzk;
    }

    public void setBjXtzk(Short bjXtzk) {
        this.bjXtzk = bjXtzk;
    }

    public Short getFsYxq() {
        return fsYxq;
    }

    public void setFsYxq(Short fsYxq) {
        this.fsYxq = fsYxq;
    }

    public Short getBjQzyk() {
        return bjQzyk;
    }

    public void setBjQzyk(Short bjQzyk) {
        this.bjQzyk = bjQzyk;
    }

    public Short getBjCx() {
        return bjCx;
    }

    public void setBjCx(Short bjCx) {
        this.bjCx = bjCx;
    }

    public Short getBjZqhy() {
        return bjZqhy;
    }

    public void setBjZqhy(Short bjZqhy) {
        this.bjZqhy = bjZqhy;
    }

    public Integer getLenCdnr() {
        return lenCdnr;
    }

    public void setLenCdnr(Integer lenCdnr) {
        this.lenCdnr = lenCdnr;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public byte[] getTm() {
        return tm;
    }

    public void setTm(byte[] tm) {
        this.tm = tm;
    }
}