/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.enst;

/**
 * 
 * @Filename KpiPatternType.java
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
public enum KpiPatternType {

	ONE_LABEL(1, "单值标签"),

	ONE_CHART(2, "单值图表"),

	CHART_TREND(3, "变化趋势图表"),

	CHART_ORG(4, "组织构成图表"),
	
	CHART_PLOY(5, "项目分解图表"),
	;

	private Integer code;

	private String name;

	private KpiPatternType(Integer code, String name) {
		this.name = name;
		this.code = code;;
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

	public static KpiPatternType parse(Integer code) {
		if(code==null)
			return KpiPatternType.ONE_LABEL;
		switch (code) {
			case 1 :
				return KpiPatternType.ONE_LABEL;
			case 2 :
				return KpiPatternType.ONE_CHART;
			case 3 :
				return KpiPatternType.CHART_TREND;
			case 4 :
				return KpiPatternType.CHART_ORG;
			case 5:
				return KpiPatternType.CHART_PLOY;
			default :
				return KpiPatternType.ONE_LABEL;
		}
	}
}
