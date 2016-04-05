package com.yyabl.api.crm.biz.Domain;

import java.util.Date;

public class ApiFlushesPoint {
    private Integer jlbh;

    private Integer oldJlbh;

    private Integer callerId;

    private String callerName;

    private Date callDate;

    public Integer getJlbh() {
        return jlbh;
    }

    public void setJlbh(Integer jlbh) {
        this.jlbh = jlbh;
    }

    public Integer getOldJlbh() {
        return oldJlbh;
    }

    public void setOldJlbh(Integer oldJlbh) {
        this.oldJlbh = oldJlbh;
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