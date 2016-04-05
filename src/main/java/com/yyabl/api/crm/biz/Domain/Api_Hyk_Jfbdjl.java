package com.yyabl.api.crm.biz.Domain;

import java.util.Date;

public class Api_Hyk_Jfbdjl {
    private Integer jlbh;

    private String tradeNo;

    private Integer cardId;

    private Double points;

    private Integer bizType;

    private Integer callerId;

    private String callerName;

    private Date callDate;

    private Boolean flagFlushed;

    public Integer getJlbh() {
        return jlbh;
    }

    public void setJlbh(Integer jlbh) {
        this.jlbh = jlbh;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public Integer getCallerId() {
        return callerId;
    }

    public void setCallerId(Integer callerId) {
        this.callerId = callerId;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName == null ? null : callerName.trim();
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public Boolean getFlagFlushed() {
        return flagFlushed;
    }

    public void setFlagFlushed(Boolean flagFlushed) {
        this.flagFlushed = flagFlushed;
    }
}