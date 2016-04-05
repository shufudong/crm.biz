package com.yyabl.api.crm.biz.Domain;

import java.util.Date;

public class ApiMergeCard {
    private Integer jlbh;

    private Integer sourceCardId;

    private Integer targetCardId;

    private Integer callerId;

    private String callerName;

    private Date callDate;

    public Integer getJlbh() {
        return jlbh;
    }

    public void setJlbh(Integer jlbh) {
        this.jlbh = jlbh;
    }

    public Integer getSourceCardId() {
        return sourceCardId;
    }

    public void setSourceCardId(Integer sourceCardId) {
        this.sourceCardId = sourceCardId;
    }

    public Integer getTargetCardId() {
        return targetCardId;
    }

    public void setTargetCardId(Integer targetCardId) {
        this.targetCardId = targetCardId;
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
}