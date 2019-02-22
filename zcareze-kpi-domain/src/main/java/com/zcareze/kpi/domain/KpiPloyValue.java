/**
 * Zcareze Inc.
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.zcareze.kpi.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *                       
 * @Filename KpiRadarValue.java
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
 * <li>Date: 2018年1月19日</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
public class KpiPloyValue implements Serializable{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -1894875515135199290L;

	@JSONField(serialize = false)
	private String id;
	
	@JSONField(serialize = false)
	private String kpiId;
	
	private String kpiName;
	
	/**
	 * 指标数
	 */
	private BigDecimal kpiValue;
	
	/**
	 * 有效低值
	 */
	private BigDecimal validMin;
	
	/**
	 * 有效高值
	 */
	private BigDecimal validMax;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKpiId() {
		return kpiId;
	}

	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}

	public String getKpiName() {
		return kpiName;
	}

	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}

	public BigDecimal getKpiValue() {
		return kpiValue;
	}

	public void setKpiValue(BigDecimal kpiValue) {
		this.kpiValue = kpiValue;
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
}
