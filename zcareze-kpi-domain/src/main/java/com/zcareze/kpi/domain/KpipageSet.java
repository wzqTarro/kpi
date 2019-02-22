/**
 * Zcareze Inc.
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.zcareze.kpi.domain;

import com.zcareze.commons.IdStrEntity;

/**
 * 
 * @Filename KpipageSet.java
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
 *          <li>Date: 2018年5月14日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class KpipageSet extends IdStrEntity {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 6165678255867962084L;

	private String pageId;
	
	private String kpiId;

	private String kpiTitle;
	
	private Integer orgLayer;
	
	private String orgId;

	private Integer rowNum;

	private Integer seqNum;

	private Integer pattern;
	
	private String chart;
	
	private String ployDim;

	private Integer prevCycle;
	
	private Integer cycShow;
	
	private Integer orgShow;
	
	private Integer unitShow;

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
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

	public Integer getOrgLayer() {
		return orgLayer;
	}

	public void setOrgLayer(Integer orgLayer) {
		this.orgLayer = orgLayer;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
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

	public String getPloyDim() {
		return ployDim;
	}

	public void setPloyDim(String ployDim) {
		this.ployDim = ployDim;
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
}
