/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.enst;

/**
 * 
 * @Filename CycKindType.java
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
public enum CycKindType {

	TYPE_YEAR("年"),

	TYPE_MONTH("月"),

	TYPE_DAY("日");

	private String name;

	private CycKindType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static CycKindType parse(String name) {
		switch (name) {
			case "年" :
				return CycKindType.TYPE_YEAR;
			case "月" :
				return CycKindType.TYPE_MONTH;
			case "日" :
				return CycKindType.TYPE_DAY;
			default :
				return null;
		}
	}
}