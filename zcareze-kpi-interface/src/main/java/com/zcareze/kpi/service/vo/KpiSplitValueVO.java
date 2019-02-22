/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.vo;

import java.math.BigDecimal;

import com.zcareze.commons.IdStrEntity;

/**
 * 
 * @Filename KpiSplitValueVO.java
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
 *          <li>Date: 2017年5月17日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class KpiSplitValueVO extends IdStrEntity {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 42423722016013901L;
	/**
	 * 机构Id
	 */
	private String orgId;
	/**
	 * 机构名称
	 */
	private String orgName;
	/**
	 * 指标值
	 */
	private BigDecimal kpiValue;

	public KpiSplitValueVO() {

	}

	public KpiSplitValueVO(String orgId, String orgName, BigDecimal kpiValue) {
		this.orgId = orgId;
		this.orgName = orgName;
		this.kpiValue = kpiValue;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
}
