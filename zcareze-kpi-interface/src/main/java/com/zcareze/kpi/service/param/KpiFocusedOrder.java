/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.param;

import java.io.Serializable;

/**
 * 个人关注指标
 * 
 * @Filename KpiFocused.java
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
 *          <li>Date: 2017年5月9日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class KpiFocusedOrder implements Serializable {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 8277517704688794218L;

	private String id;
		
	/**
	 * 行号
	 */
	private Integer rowNum;
	/**
	 * 排列号
	 */
	private Integer seqNum;		

	public Integer getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}	

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
}
