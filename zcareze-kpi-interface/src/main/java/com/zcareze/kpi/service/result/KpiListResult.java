/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.result;

import com.zcareze.commons.result.BaseResult;
import com.zcareze.kpi.service.vo.KpiListVO;

/**
 * 指标目录
 * 
 * @Filename KpiList.java
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
public class KpiListResult extends BaseResult<KpiListVO> {
	/**
	 * 记录总数
	 */
	private long recordCount;

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
}
