/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.vo;

import java.math.BigDecimal;

import com.zcareze.commons.IdStrEntity;

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
public class KpiRowValueVO extends IdStrEntity {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -2167263056517067488L;

	/**
	 * 周期值
	 */
	private String cycValue;
	/**
	 * 指标值(不存在则为空)
	 */
	private BigDecimal kpiValue;
	/**
	 * 稽核状态
	 * 0:没有数据;1:自动生成的;2:输入未审;3:已审
	 */
	private Integer auditState;
	/**
	 * 备注信息
	 * （包括稽核时间和稽核人）
    */
	private String comment;
	
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
