package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;

public class ApiPersonDef implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Integer personId;

    private Integer orgId;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
}