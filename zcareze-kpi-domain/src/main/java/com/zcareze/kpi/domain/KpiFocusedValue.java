/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.zcareze.commons.IdStrEntity;

/**
 * 个人关注指标
 * 
 * @Filename KpiFocused.java
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
public class KpiFocusedValue extends IdStrEntity {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 8277517704688794218L;

	/**
	 * 指标Id
	 */
	private String kpiId;
	/**
	 * 职员Id
	 */
	private String staffId;
	/**
	 * 指标标题
	 */
	private String kpiTitle;
	/**
	 * 周期种类
	 */
	private String cycKind;
	/**
	 * 有效低值
	 */
	private BigDecimal validMin;
	/**
	 * 有效高值
	 */
	private BigDecimal validMax;
	/**
	 * 单位
	 */
	private String unit;
	/**
	 * 明细指标Id
	 */
	private String splitId;
	/**
	 * 组织Id
	 */
	private String orgId;
	/**
	 * 组织名称
	 */
	private String orgName;
	/**
	 * 行号
	 */
	private Integer rowNum;	
	/**
	 * 排列号
	 */
	private Integer seqNum;
	/**
	 * 模式
	 */
	private Integer pattern;
	/**
	 * 聚合维度
	 */
	private String ployDim;	
	/**
	 * 图表
	 */
	private String chart;
	/**
	 * 显示上期
	 */
	private Integer prevCycle;
	/**
	 * 显示期间标签
	 */
	private Integer cycShow;
	/**
	 * 显示组织标签
	 */
	private Integer orgShow;
	/**
	 * 显示单位标签
	 */
	private Integer unitShow;
	/**
	 * 查看时间
	 */
	private Date readTime;
	/**
	 * 组织层次
	 * 0-全域;1-机构;2-科室;3-医生团队
	 */
	private Integer orgLayer;
	
	/**
	 * 周期数
	 */
	private String cycValue;
	/**
	 * 指标数
	 */
	private BigDecimal kpiValue;

	public String getKpiId() {
		return kpiId;
	}

	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getKpiTitle() {
		return kpiTitle;
	}

	public void setKpiTitle(String kpiTitle) {
		this.kpiTitle = kpiTitle;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Integer getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}

	public Integer getPattern() {
		return pattern;
	}

	public void setPattern(Integer pattern) {
		this.pattern = pattern;
	}

	public String getChart() {
		return chart;
	}

	public void setChart(String chart) {
		this.chart = chart;
	}

	public Integer getPrevCycle() {
		return prevCycle;
	}

	public void setPrevCycle(Integer prevCycle) {
		this.prevCycle = prevCycle;
	}

	public Integer getCycShow() {
		return cycShow;
	}

	public void setCycShow(Integer cycShow) {
		this.cycShow = cycShow;
	}

	public Integer getOrgShow() {
		return orgShow;
	}

	public void setOrgShow(Integer orgShow) {
		this.orgShow = orgShow;
	}

	public Integer getUnitShow() {
		return unitShow;
	}

	public void setUnitShow(Integer unitShow) {
		this.unitShow = unitShow;
	}

	public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCycKind() {
		return cycKind;
	}

	public void setCycKind(String cycKind) {
		this.cycKind = cycKind;
	}

	public String getSplitId() {
		return splitId;
	}

	public void setSplitId(String splitId) {
		this.splitId = splitId;
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

	public Integer getOrgLayer() {
		return orgLayer;
	}

	public void setOrgLayer(Integer orgLayer) {
		this.orgLayer = orgLayer;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

	public BigDecimal getValidMin() {
		return validMin;
	}

	public void setValidMin(BigDecimal validMin) {
		this.validMin = validMin;
	}

	public BigDecimal getValidMax() {
		return validMax;
	}

	public void setValidMax(BigDecimal validMax) {
		this.validMax = validMax;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getPloyDim() {
		return ployDim;
	}

	public void setPloyDim(String ployDim) {
		this.ployDim = ployDim;
	}
}
