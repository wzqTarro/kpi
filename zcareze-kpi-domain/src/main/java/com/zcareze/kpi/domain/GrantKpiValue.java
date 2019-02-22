/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @Filename FocusKpiValue.java
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
 *          <li>Date: 2017年5月12日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class GrantKpiValue implements Serializable {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -8133250704462541309L;
	/**
	 * 指标Id
	 */
	private String kpiId;
	/**
	 * 指标标题
	 */
	private String kpiTitle;
	/**
	 * 排列号
	 */
	private Integer seqNum;
	
	/**
	 * 组织层次
	 * 0-全域;1-机构;2-科室;3-医生团队
	 */
	private Integer orgLayer;	
	/**
	 * 组织Id
	 */
	private String orgId;
	/**
	 * 角色字符串
	 */
	private String roles;
	/**
	 * 组织名称
	 */
	private String orgName;
	/**
	 * 周期名称
	 */
	private String cycValue;
	/**
	 * 指标数据
	 */
	private BigDecimal kpiValue;
	/**
	 * 单位
	 */
	private String unit;	
	/**
	 * 是否有管理权限
	 */
	private Integer manage;
	/**
	 * 是否有输入权限
	 */
	private Integer input;
	/**
	 * 周期类型
	 */
	private String cycKind;	

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

	public String getCycKind() {
		return cycKind;
	}

	public void setCycKind(String cycKind) {
		this.cycKind = cycKind;
	}

	public String getKpiId() {
		return kpiId;
	}

	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}

	public String getKpiTitle() {
		return kpiTitle;
	}

	public void setKpiTitle(String kpiTitle) {
		this.kpiTitle = kpiTitle;
	}

	public Integer getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getOrgLayer() {
		return orgLayer;
	}

	public void setOrgLayer(Integer orgLayer) {
		this.orgLayer = orgLayer;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
}
