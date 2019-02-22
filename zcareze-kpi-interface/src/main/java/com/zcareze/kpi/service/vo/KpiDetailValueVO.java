/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * @Filename KpiRowValueVO.java
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
public class KpiDetailValueVO implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -4879607782932844391L;
	/**
	 * 指标Id
	 */
	private String kpiId;
	/**
	 * 指标标题
	 */
	private String kpiTitle;
	
	/**
	 * 组织机构Id
	 */
	private String orgId;
	/**
	 * 组织机构名称
	 */
	private String orgName;		
	/**
	 * 當前周期值
	 */
	private String cycValue;	
	/**
	 * 當前指标值
	 */
	private BigDecimal kpiValue;
	/**
	 * 當前稽核状态
	 * 0:没有数据;1:自动生成的;2:输入未审;3:已审
	 */
	private Integer auditState;
	
	/**
	 * 单位
	 */
	private String unit;
	/**
	 * 细分指标ID
	 */
	private String splitId;
	/**
	 * 是否已经收藏
	 */
	private Boolean usually;
	/**
	 * 是否有稽核权限
	 */
	private Integer audit;
	/**
	 * 是否有输入权限
	 */
	private Integer input;
	/**
	 * 周期类型
	 */
	private String cycKind;
	/**
	 * 环比数据
	 */
	private BigDecimal lpValue;
	/**
	 * 同比数据
	 */
	private BigDecimal spValue;
	/**
	 * 详细数据
	 */
	private List<KpiRowValueVO> rowValues;
	/**
	 * 指标可查看报表列表
	 */
	private List<KpiReportVO> reports;
	
	/**
	 * 分解维度列表
	 */
	private List<String> ployDims;
	
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
	public Integer getAuditState() {
		return auditState;
	}
	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Boolean getUsually() {
		return usually;
	}
	public void setUsually(Boolean usually) {
		this.usually = usually;
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
	public BigDecimal getLpValue() {
		return lpValue;
	}
	public void setLpValue(BigDecimal lpValue) {
		this.lpValue = lpValue;
	}
	public BigDecimal getSpValue() {
		return spValue;
	}
	public void setSpValue(BigDecimal spValue) {
		this.spValue = spValue;
	}
	public List<KpiRowValueVO> getRowValues() {
		return rowValues;
	}
	public void setRowValues(List<KpiRowValueVO> rowValues) {
		this.rowValues = rowValues;
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
	public List<KpiReportVO> getReports() {
		return reports;
	}
	public void setReports(List<KpiReportVO> reports) {
		this.reports = reports;
	}
	public String getSplitId() {
		return splitId;
	}
	public void setSplitId(String splitId) {
		this.splitId = splitId;
	}
	public List<String> getPloyDims() {
		return ployDims;
	}
	public void setPloyDims(List<String> ployDims) {
		this.ployDims = ployDims;
	}	
}
