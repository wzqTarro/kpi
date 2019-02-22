/**
 * Zcareze Inc.
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.zcareze.kpi.service.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @Filename KpiFocusPatternVO.java
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
 *          <li>Date: 2018年1月18日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class KpiFocusPatternVO implements Serializable {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -6163799549885573476L;
	/**
	 * 指标Id
	 */
	private String kpiId;
	
	/**
	 * 能否选择定级条(1:可选)
	 */
	private Integer gradeChart;

	/**
	 * 能否选择组织构成图(1:可选)
	 */
	private Integer orgChart;

	/**
	 * 能否选择项目分解图(1:可选)
	 */
	private Integer ployChart;

	/**
	 * 分解维度
	 */
	private List<String> ployDims;

	public String getKpiId() {
		return kpiId;
	}

	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}

	public Integer getOrgChart() {
		return orgChart;
	}

	public void setOrgChart(Integer orgChart) {
		this.orgChart = orgChart;
	}

	public Integer getPloyChart() {
		return ployChart;
	}

	public void setPloyChart(Integer ployChart) {
		this.ployChart = ployChart;
	}

	public List<String> getPloyDims() {
		return ployDims;
	}

	public void setPloyDims(List<String> ployDims) {
		this.ployDims = ployDims;
	}

	public Integer getGradeChart() {
		return gradeChart;
	}

	public void setGradeChart(Integer gradeChart) {
		this.gradeChart = gradeChart;
	}
}
