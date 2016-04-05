package com.yyabl.api.crm.biz.Domain;

import java.util.Date;

public class Rcl extends RclKey {
	private Integer operatorId;

	private Date procKssj;

	private Date procJssj;

	private String stationId;

	private Short status;

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public Date getProcKssj() {
		return procKssj;
	}

	public void setProcKssj(Date procKssj) {
		this.procKssj = procKssj;
	}

	public Date getProcJssj() {
		return procJssj;
	}

	public void setProcJssj(Date procJssj) {
		this.procJssj = procJssj;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId == null ? null : stationId.trim();
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Rcl [operatorId=" + operatorId + ", procKssj=" + procKssj + ", procJssj=" + procJssj + ", stationId=" + stationId + ", status=" + status + "]";
	}

}