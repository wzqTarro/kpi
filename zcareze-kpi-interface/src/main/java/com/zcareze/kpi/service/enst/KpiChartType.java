/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.enst;

import com.zcareze.commons.utils.StringUtils;

/**
 * 
 * @Filename KpiChartType.java
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
 *          <li>Date: 2017年5月15日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public enum KpiChartType {

	CHART_NONE(0, "", 1),

	CHART_GRADE(1, "定级条", 2),

	CHART_ODOM(2, "里程表", 2),

	CHART_LINR(3, "折线图", 3),

	CHART_BAR(4, "柱状图", 3),

	CHART_PIE(5, "圆饼图", 4),

	CHART_ORG_BAR(6, "柱状图", 4),
	
	CHART_EXP_PIE(7, "圆饼图", 5),
	
	CHART_EXP_BAR(8, "柱状图", 5),
	
	CHART_EXP_RADAR(9, "雷达图",5);

	private Integer code;

	private String name;

	private Integer patternCode;

	private KpiChartType(Integer code, String name, Integer patternCode) {
		this.name = name;
		this.code = code;
		this.patternCode = patternCode;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPatternCode() {
		return patternCode;
	}

	public void setPatternCode(Integer patternCode) {
		this.patternCode = patternCode;
	}

	public static KpiChartType parse(Integer code) {
		if (code == null) {
			return KpiChartType.CHART_NONE;
		}
		switch (code) {
			case 1 :
				return KpiChartType.CHART_GRADE;
			case 2 :
				return KpiChartType.CHART_ODOM;
			case 3 :
				return KpiChartType.CHART_LINR;
			case 4 :
				return KpiChartType.CHART_BAR;
			case 5 :
				return KpiChartType.CHART_PIE;
			case 6 :
				return KpiChartType.CHART_ORG_BAR;
			case 7:
				return KpiChartType.CHART_EXP_PIE;
			case 8:
				return KpiChartType.CHART_EXP_BAR;
			case 9:
				return KpiChartType.CHART_EXP_RADAR;
			default :
				return KpiChartType.CHART_NONE;
		}
	}

	public static KpiChartType parse(String name, Integer patternCode) {
		if (StringUtils.isEmpty(name) || patternCode == null || patternCode == null) {
			return KpiChartType.CHART_NONE;
		}
		for (KpiChartType chartType : KpiChartType.values()) {
			if (chartType.getName().equals(name) && chartType.getPatternCode().equals(patternCode)) {
				return chartType;
			}
		}
		return KpiChartType.CHART_NONE;
	}
}
