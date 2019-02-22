/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.domain;

import java.io.Serializable;

/**
 * 指标聚合信息
 * 
 * @Filename KpiPloyInfo.java
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
public class KpiPloyInfo implements Serializable {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -8443517487858738481L;

	/**
	 * 指标Id
	 */
	private String kpiId;	

	/**
	 * 指标名称
	 */
	private String kpiName;

	/**
	 * 聚合维度
	 */
	private String ployDim;

	public String getKpiId() {
		return kpiId;
	}

	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}	

	public String getPloyDim() {
		return ployDim;
	}

	public void setPloyDim(String ployDim) {
		this.ployDim = ployDim;
	}

	public String getKpiName() {
		return kpiName;
	}

	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}
}
