package com.zcareze.kpi.service.enst;

/**
 * 
 * 
 * @Filename HdocResultMessage.java
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
 *          <li>Date: 2017年3月20日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public class KpiResultMessage {	
		
	public static final String BASEREPORTPARAMEMPTY="参数为空";	
	public static final String BASEREPORTDATAEMPTY="数据为空";	
	public static final String INPUTISNOTEXIST="参数不存在";
	public static final String BASEREPORTDATAERROR="参数错误";
	
	public static final String EXISTSPLITKPI="作为其他指标的细分指标,无法删除";
	public static final String EXISTPLOYKPI="作为其他指标的聚合指标,无法删除";
	
	public static final String NOORGFIND="未找到所属组织";
	public static final String KPIEXIST="指标已存在";
	public static final String KPINOTEXIST="指标不存在";
	public static final String KPINOTLOYER="不是同级指标,不能聚合";
	
	public static final String INPUTERROR="动态查询参数sql为空";
	public static final String INPUTSQLERROR="动态查询参数sql错误";
	public static final String INPUTISYSTEM="系统内置参数名称";	
	public static final String REPORTOPERATESQLERROR="执行数据库操作失败";	
	
	public static final String COPYCLOUDEMPTY = "未选中要同步的区域";
}
