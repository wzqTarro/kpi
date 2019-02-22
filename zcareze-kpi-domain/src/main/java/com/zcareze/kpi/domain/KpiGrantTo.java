/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 指标授权
 * @Filename KpiGrantTo.java
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
public class KpiGrantTo implements Serializable {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 4390103869446512800L;

	/**
	 * 指标Id
	 */
	private String kpiId;
	/**
	 * 机构Id
	 */
	private String orgId;
	/**
	 * 授予角色，01-健康助理;02-基层医生;03-专科医生;04-医学专家;05-专业技师;11-业务管理
	 */
	private String roles;
	/**
	 * 授权包含下级
	 */
	private Integer manage;
	/**
	 * 是否授予该指标数据的编辑权
	 */
	private Integer input;
	/**
	 * 授权者
	 */
	private String granter;
	/**
	 * 授权时间
	 */
	private Date grantTime;

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

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Integer getManage() {
		return manage;
	}

	public void setManage(Integer manage) {
		this.manage = manage;
	}

	public Integer getInput() {
		return input;
	}

	public void setInput(Integer input) {
		this.input = input;
	}

	public String getGranter() {
		return granter;
	}

	public void setGranter(String granter) {
		this.granter = granter;
	}

	public Date getGrantTime() {
		return grantTime;
	}

	public void setGrantTime(Date grantTime) {
		this.grantTime = grantTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
