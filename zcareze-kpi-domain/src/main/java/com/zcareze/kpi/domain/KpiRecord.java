/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.zcareze.commons.IdStrEntity;

/**
 * 指标数据
 * @Filename KpiData.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author 虾米
 *
 * @Email xiazongyan@zcareze.com
 * 
 * @History
 *          <li>Author: 虾米</li>
 *          <li>Date: 2017年5月9日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class KpiRecord extends IdStrEntity {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -6351907569403156047L;

	/**
	 * 组织Id
	 */
	private String orgId;	
	/**
	 * 组织名称
	 */
	private String orgName;	
	/**
	 * 指标Id
	 */
	private String kpiId;
	/**
	 * 指标名称
	 */
	private String kpiName;
	/**
	 * 计算单位
	 */
	private String kpiUnit;
	/**
	 * 周期种类
	 */
	private String cycKind;
	/**
	 * 周期数值
	 */
	private String cycValue;
	/**
	 * 指标数值
	 */
	private BigDecimal kpiValue;		
	/**  */
	private Date editTime;
	/**  */
	private String editorId;
	/**  */
	private String editorName;
	/** 发布稽核 */
	private Integer adAudit;
	/** 稽核时间 */
	private Date auditTime;
	/** 稽核姓名 */
	private String auditorName;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getKpiId() {
		return kpiId;
	}

	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}

	public String getKpiName() {
		return kpiName;
	}

	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}

	public String getKpiUnit() {
		return kpiUnit;
	}

	public void setKpiUnit(String kpiUnit) {
		this.kpiUnit = kpiUnit;
	}

	public String getCycKind() {
		return cycKind;
	}

	public void setCycKind(String cycKind) {
		this.cycKind = cycKind;
	}

	public String getCycValue() {
		return cycValue;
	}

	public void setCycValue(String cycValue) {
		this.cycValue = cycValue;
	}

	public BigDecimal getKpiValue() {
		return kpiValue;
	}

	public void setKpiValue(BigDecimal kpiValue) {
		this.kpiValue = kpiValue;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getEditorId() {
		return editorId;
	}

	public void setEditorId(String editorId) {
		this.editorId = editorId;
	}

	public String getEditorName() {
		return editorName;
	}

	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}

	public Integer getAdAudit() {
		return adAudit;
	}

	public void setAdAudit(Integer adAudit) {
		this.adAudit = adAudit;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getAuditorName() {
		return auditorName;
	}

	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}	
}
