package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;

public class SmsTemplate implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String context;

	private String comment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context == null ? null : context.trim();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}

	@Override
	public String toString() {
		return "SmsTemplate [id=" + id + ", context=" + context + ", comment=" + comment + "]";
	}

}