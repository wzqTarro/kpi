/**
 * Zcareze Inc.
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.zcareze.kpi.domain;

import java.util.Date;

import com.zcareze.commons.IdStrEntity;

/**
 * 
 * @Filename KpipageOpenTo.java
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
 *          <li>Date: 2018年5月14日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class KpipageOpenTo extends IdStrEntity {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -1891247257563347486L;

	/**
	 * 页面ID
	 */
	private String pageId;

	/**
	 * 组织树ID
	 */
	private String orgTreeId;

	/**
	 * 组织树层
	 */
	private Integer orgTreeLayer;

	/**
	 * 角色
	 */
	private String roles;

	/**
	 * 授权者
	 */
	private String granter;

	/**
	 * 授权时间
	 */
	private Date grantTime;

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getOrgTreeId() {
		return orgTreeId;
	}

	public void setOrgTreeId(String orgTreeId) {
		this.orgTreeId = orgTreeId;
	}

	public Integer getOrgTreeLayer() {
		return orgTreeLayer;
	}

	public void setOrgTreeLayer(Integer orgTreeLayer) {
		this.orgTreeLayer = orgTreeLayer;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getGranter() {
		return granter;
	}

	public void setGranter(String granter) {
		this.granter = granter;
	}

	public Date getGrantTime() {
		return grantTime;
	}

	public void setGrantTime(Date grantTime) {
		this.grantTime = grantTime;
	}
}
