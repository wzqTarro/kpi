/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.enst;

/**
 *                       
 * @Filename OrgLayerEnum.java
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
 * <li>Date: 2017年9月5日</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 *
 */
public enum OrgLayerEnum {
    
	GLOBAL(0,"全域"),
	
	ORG(1,"机构"),
	
	DEPART(2,"科室"),
	
	TEAM(3,"医生团队");

	private Integer code;
	
	private String name;

	private OrgLayerEnum(Integer code,String name) {
		this.name = name;
		this.setCode(code);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static OrgLayerEnum parse(Integer code) {
		switch (code) {
			case 0 :
				return OrgLayerEnum.GLOBAL;
			case 1 :
				return OrgLayerEnum.ORG;
			case 2 :
				return OrgLayerEnum.DEPART;
			case 3:
				return OrgLayerEnum.TEAM;
			default :
				return null;
		}
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
