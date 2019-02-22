/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.param;

import java.io.Serializable;

/**
 * 
 * @Filename KpiRowValueParam.java
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
public class KpiRowValueParam implements Serializable {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 6697469757959792783L;
	/**
	 * 指標Id
	 */
	private String kpiId;
	/**
	 * 组织机构Id
	 */
	private String orgId;
	/**
	 * 周期類型
	 */
	private String cycKind;
	/**
	 * 输入权限
	 */
	private Integer input;
	/**
	 * 当前页
	 */
	private Integer pageNow;
	/**
	 * 每页行数
	 */
	private Integer pageSize;

	public String getKpiId() {
		return kpiId;
	}

	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getCycKind() {
		return cycKind;
	}

	public void setCycKind(String cycKind) {
		this.cycKind = cycKind;
	}

	public Integer getInput() {
		return input;
	}

	public void setInput(Integer input) {
		this.input = input;
	}

	public Integer getPageNow() {
		return pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
