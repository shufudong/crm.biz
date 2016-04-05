package com.yyabl.api.crm.biz.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Ryxx implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer personId;

	private String personName;

	private Date lzrq;

	private Byte workType;

	private Date gxrq;

	private String pym;

	private String rydm;

	private List<ApiDef> lstApiDef;

	private Xtczy xtczy;

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName == null ? null : personName.trim();
	}

	public Date getLzrq() {
		return lzrq;
	}

	public void setLzrq(Date lzrq) {
		this.lzrq = lzrq;
	}

	public Byte getWorkType() {
		return workType;
	}

	public void setWorkType(Byte workType) {
		this.workType = workType;
	}

	public Date getGxrq() {
		return gxrq;
	}

	public void setGxrq(Date gxrq) {
		this.gxrq = gxrq;
	}

	public String getPym() {
		return pym;
	}

	public void setPym(String pym) {
		this.pym = pym == null ? null : pym.trim();
	}

	public String getRydm() {
		return rydm;
	}

	public void setRydm(String rydm) {
		this.rydm = rydm == null ? null : rydm.trim();
	}

	public List<ApiDef> getLstApiDef() {
		return lstApiDef;
	}

	public void setLstApiDef(List<ApiDef> lstApiDef) {
		this.lstApiDef = lstApiDef;
	}

	public Xtczy getXtczy() {
		return xtczy;
	}

	public void setXtczy(Xtczy xtczy) {
		this.xtczy = xtczy;
	}

	@Override
	public String toString() {
		return "Ryxx [personId=" + personId + ", personName=" + personName + ", lzrq=" + lzrq + ", workType=" + workType + ", gxrq=" + gxrq + ", pym=" + pym
				+ ", rydm=" + rydm + ", lstApiDef=" + lstApiDef + ", xtczy=" + xtczy + "]";
	}

}