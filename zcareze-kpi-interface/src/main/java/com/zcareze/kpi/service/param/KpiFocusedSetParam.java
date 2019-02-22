/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.param;

import java.io.Serializable;
import java.util.List;

import com.zcareze.kpi.service.vo.KpiFocusedVO;

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
public class KpiFocusedSetParam implements Serializable {

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 4601560100110098927L;	
	
	/**
	 * 当前设置的关注指标信息
	 */
	private List<KpiFocusedVO> kpiFocused;
	
	/**
	 * 关注的指标顺序
	 */
	private List<KpiFocusedOrder> focusedOrders;
	
	/**
	 * 取消关注的指标列表
	 */
	private List<String> cancelFocused;

	public List<KpiFocusedVO> getKpiFocused() {
		return kpiFocused;
	}

	public void setKpiFocused(List<KpiFocusedVO> kpiFocused) {
		this.kpiFocused = kpiFocused;
	}

	public List<KpiFocusedOrder> getFocusedOrders() {
		return focusedOrders;
	}

	public void setFocusedOrders(List<KpiFocusedOrder> focusedOrders) {
		this.focusedOrders = focusedOrders;
	}

	public List<String> getCancelFocused() {
		return cancelFocused;
	}

	public void setCancelFocused(List<String> cancelFocused) {
		this.cancelFocused = cancelFocused;
	}
}