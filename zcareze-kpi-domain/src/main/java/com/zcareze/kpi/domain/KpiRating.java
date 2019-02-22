/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *   指标定级规则                    
 * @Filename KpiRank.java
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
 * <li>Date: 2017年5月9日</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
public class KpiRating implements Serializable{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 5898262534231424666L;

	/** 指标ID */
	private String kpiId;
	/** 分段号 */
	private Integer seqNo;
	/** 边界值 */
	private BigDecimal boundary;
	/** 含义 */
	private String meaning;
	/** 颜色 */
	private String color;
	
	public String getKpiId() {
		return kpiId;
	}
	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}	
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BigDecimal getBoundary() {
		return boundary;
	}
	public void setBoundary(BigDecimal boundary) {
		this.boundary = boundary;
	}
	public Integer getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}	
}
