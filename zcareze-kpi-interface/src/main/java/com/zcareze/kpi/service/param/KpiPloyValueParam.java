/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.param;

import java.io.Serializable;

/**
 *                       
 * @Filename KpiSplitValueParam.java
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
 * <li>Author: 虾米</li>
 * <li>Date: 2017年5月17日</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
public class KpiPloyValueParam implements Serializable{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 7152783347782035698L;
	
	/**
	 * 指标id
	 */
	private String kpiId;
	/**
	 * 组织Id
	 */
	private String orgId;
	/**
	 * 周期数据
	 */
	private String cycValue;	
	/**
	 * 维度
	 */
	private String ployDim;
		
	public String getCycValue() {
		return cycValue;
	}
	public void setCycValue(String cycValue) {
		this.cycValue = cycValue;
	}	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getKpiId() {
		return kpiId;
	}
	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}
	public String getPloyDim() {
		return ployDim;
	}
	public void setPloyDim(String ployDim) {
		this.ployDim = ployDim;
	}		
}
