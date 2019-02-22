/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.vo;

import java.math.BigDecimal;

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
public class KpiRecordVO extends IdStrEntity {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -6351907569403156047L;

	/**
	 * 组织Id
	 */
	private String orgId;
	/**
	 * 指标Id
	 */
	private String kpiId;	
	/**
	 * 周期数值
	 */
	private String cycValue;
	/**
	 * 指标数值
	 */
	private BigDecimal kpiValue;	
	
	/**
	 * 审核权
	 * （1表示有审核权）
	 */
	private Integer audit;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}
}
