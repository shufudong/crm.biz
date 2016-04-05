package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;

public class ApiDef implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String url;

	private String comment;

	private Boolean enabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "ApiDef [id=" + id + ", url=" + url + ", comment=" + comment + ", enabled=" + enabled + "]";
	}

}