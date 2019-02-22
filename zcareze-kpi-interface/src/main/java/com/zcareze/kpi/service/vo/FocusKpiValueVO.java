/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.vo;

import java.math.BigDecimal;
import java.util.List;

import com.zcareze.commons.IdStrEntity;

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
public class FocusKpiValueVO extends IdStrEntity {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -4042505243549817525L;
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
	 * 显示模式 1-单值标签；2-单值图表；3-变化趋势图表；4-组织构成图表；5-项目分解图表
	 */
	private Integer pattern;	
	/**
	 * 聚合维度
	 */
	private String ployDim;	
	/**
	 * 图表类型
	 */
	private Integer chart;	
	/**
	 * 组织Id
	 */
	private String orgId;
	/**
	 * 行号
	 */
	private Integer rowNum;	
	/**
	 * 组织名称(无不显示组织标签则为空)
	 */
	private String orgName;
	/**
	 * 周期名称(不显示则为空)
	 */
	private String cycValue;
	/**
	 * 指标数据 1-单值标签；2-单值图表 使用
	 */
	private BigDecimal kpiValue;
	/**
	 * 指标数据字符串 3-变化趋势图表；4-组织构成图表 使用,为键值对组成的json字符串
	 */
	private String kpiJsonValue;
	/**
	 * 有效低值
	 */
	private BigDecimal validMin;
	/**
	 * 有效高值
	 */
	private BigDecimal validMax;
	/**
	 * 总数
	 */
	private BigDecimal totleValue;
	/**
	 * 单位(不显示单位则为空)
	 */
	private String unit;
	/**
	 * 指标定级规则
	 */
	private List<KpiRatingVO> kpiRatings;
	
	/**
	 * 是否需要查阅
	 */
	private Boolean noRead;
	/**
	 * 授权状态
	 * 0:有授权;1:无授权（授权被取消）
	 */
	private Integer grantTo;

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

	public Integer getPattern() {
		return pattern;
	}

	public void setPattern(Integer pattern) {
		this.pattern = pattern;
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

	public String getKpiJsonValue() {
		return kpiJsonValue;
	}

	public void setKpiJsonValue(String kpiJsonValue) {
		this.kpiJsonValue = kpiJsonValue;
	}

	public BigDecimal getTotleValue() {
		return totleValue;
	}

	public void setTotleValue(BigDecimal totleValue) {
		this.totleValue = totleValue;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Boolean getNoRead() {
		return noRead;
	}

	public void setNoRead(Boolean noRead) {
		this.noRead = noRead;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getChart() {
		return chart;
	}

	public void setChart(Integer chart) {
		this.chart = chart;
	}

	public List<KpiRatingVO> getKpiRatings() {
		return kpiRatings;
	}

	public void setKpiRatings(List<KpiRatingVO> kpiRatings) {
		this.kpiRatings = kpiRatings;
	}

	public BigDecimal getValidMin() {
		return validMin;
	}

	public void setValidMin(BigDecimal validMin) {
		this.validMin = validMin;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

	public BigDecimal getValidMax() {
		return validMax;
	}

	public void setValidMax(BigDecimal validMax) {
		this.validMax = validMax;
	}

	public Integer getGrantTo() {
		return grantTo;
	}

	public void setGrantTo(Integer grantTo) {
		this.grantTo = grantTo;
	}

	public String getPloyDim() {
		return ployDim;
	}

	public void setPloyDim(String ployDim) {
		this.ployDim = ployDim;
	}
}
