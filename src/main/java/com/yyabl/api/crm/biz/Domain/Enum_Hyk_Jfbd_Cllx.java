package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;

public class Enum_Hyk_Jfbd_Cllx implements Serializable{
   
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}