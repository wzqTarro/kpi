/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @Filename KpiManageVO.java
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
public class KpiManageVO implements Serializable {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 3804435635924300453L;

	private String kpiId;

	private String name;

	/**
	 * 组织层次
	 * 0-全域;1-机构;2-科室;3-医生团队
	 */
	private Integer orgLayer;
	
	private String orgId;

	private String orgName;	

	private List<KpiGrantToVO> kpiGrantTos;
	
	public String getKpiId() {
		return kpiId;
	}

	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<KpiGrantToVO> getKpiGrantTos() {
		return kpiGrantTos;
	}

	public void setKpiGrantTos(List<KpiGrantToVO> kpiGrantTos) {
		this.kpiGrantTos = kpiGrantTos;
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
}
