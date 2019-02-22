/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.domain;

import java.io.Serializable;

/**
 * 
 * @Filename KpiRptInput.java
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
 *          <li>Date: 2017年5月24日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class KpiRptInput implements Serializable {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 7742628678570211598L;
	/**
	 * 指标id
	 */
	private String kpiId;
	/**
	 * 报表Id
	 */
	private String rptId;
	/**
	 * 参数名称
	 */
	private String name;
	/**
	 * 赋值方式 0-使用报表本身设置默认值；1-指标期间；2-指标组织ID
	 */
	private int valLet;

	public String getKpiId() {
		return kpiId;
	}

	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}

	public String getRptId() {
		return rptId;
	}

	public void setRptId(String rptId) {
		this.rptId = rptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValLet() {
		return valLet;
	}

	public void setValLet(int valLet) {
		this.valLet = valLet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
