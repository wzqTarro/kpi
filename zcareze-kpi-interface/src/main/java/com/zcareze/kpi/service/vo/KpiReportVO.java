/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.vo;

import java.io.Serializable;

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
public class KpiReportVO implements Serializable{
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 445208807894600475L;
	/**
	 * 指标Id
	 */
	private String kpiId;
	/**
	 * 報表Id
	 */
	private String reportId;
	/**
	 * 报表名称
	 */
	private String reportName;
	/**
	 * 序号
	 */
	private Integer seqNum;
	/**
	 * 最后修改时间(时间戳)
	 */
	private Long updateTime;
	
	public String getKpiId() {
		return kpiId;
	}
	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}	
}
