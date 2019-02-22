/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.domain;

import java.io.Serializable;

/**
 * 有管理权限的指标
 * 
 * @Filename KpiList.java
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
public class KpiGrantToManageList implements Serializable {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -6455761244929136226L;

	/**
	 * 指标Id
	 */
	private String kpiId;
	/**
	 * 指标标题
	 */
	private String kpiTitle;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 单位
	 */
	private String unit;
	/**
	 * 周期种类
	 */
	private String cycKind;
	/**
	 * 组织层次
	 */
	private Integer orgLayer;
	/**
	 * 授权组织Id
	 */
	private String orgId;
	
	/**
	 * 授权组织Id上级Id
	 */
	private String ParentOrgId;
	/**
	 * 组织码
	 */
	private String orgCode;
	
	/**
	 * 查詢用的orgId
	 */
	private String SearchOrgId;
	/**
	 * 授权组织名称
	 */
	private String orgName;
	/**
	 * 组织性质
	 */
	private String OrgKind;	
	/**
	 * 授予角色，01-健康助理;02-基层医生;03-专科医生;04-医学专家;05-专业技师;11-业务管理
	 */
	private String roles;	
	/**
	 * 有管理权限
	 */
	private Integer manage;
	/**
	 * 输入权
	 */
	private Integer input;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getOrgLayer() {
		return orgLayer;
	}

	public void setOrgLayer(Integer orgLayer) {
		this.orgLayer = orgLayer;
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

	public Integer getManage() {
		return manage;
	}

	public void setManage(Integer manage) {
		this.manage = manage;
	}

	public String getOrgKind() {
		return OrgKind;
	}

	public void setOrgKind(String orgKind) {
		OrgKind = orgKind;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getKpiTitle() {
		return kpiTitle;
	}

	public void setKpiTitle(String kpiTitle) {
		this.kpiTitle = kpiTitle;
	}

	public String getKpiId() {
		return kpiId;
	}

	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSearchOrgId() {
		return SearchOrgId;
	}

	public void setSearchOrgId(String searchOrgId) {
		SearchOrgId = searchOrgId;
	}

	public String getParentOrgId() {
		return ParentOrgId;
	}

	public void setParentOrgId(String parentOrgId) {
		ParentOrgId = parentOrgId;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}
