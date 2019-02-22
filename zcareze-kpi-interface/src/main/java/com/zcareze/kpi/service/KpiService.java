/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service;

import java.util.List;

import com.zcareze.commons.method.annotation.ParamentValidate;
import com.zcareze.commons.method.annotation.ValidateRules;
import com.zcareze.commons.result.BaseResult;
import com.zcareze.commons.result.Result;
import com.zcareze.kpi.domain.KpiPloyInfo;
import com.zcareze.kpi.domain.KpiPloyValue;
import com.zcareze.kpi.domain.KpipageList;
import com.zcareze.kpi.domain.KpipageOpenTo;
import com.zcareze.kpi.domain.KpipageSet;
import com.zcareze.kpi.service.param.KpiFocusedParam;
import com.zcareze.kpi.service.param.KpiFocusedSetParam;
import com.zcareze.kpi.service.param.KpiPloyValueParam;
import com.zcareze.kpi.service.param.KpiRowValueParam;
import com.zcareze.kpi.service.param.KpiSplitValueParam;
import com.zcareze.kpi.service.result.FocusKpiResult;
import com.zcareze.kpi.service.result.GrantKpiResult;
import com.zcareze.kpi.service.result.KpiCopyResult;
import com.zcareze.kpi.service.result.KpiDetailValueResult;
import com.zcareze.kpi.service.result.KpiGrantToResult;
import com.zcareze.kpi.service.result.KpiListResult;
import com.zcareze.kpi.service.result.KpiManageResult;
import com.zcareze.kpi.service.result.KpiRatingResult;
import com.zcareze.kpi.service.result.KpiReportResult;
import com.zcareze.kpi.service.result.KpiRowValueResult;
import com.zcareze.kpi.service.result.KpiRptInputResult;
import com.zcareze.kpi.service.result.KpiSplitValueResult;
import com.zcareze.kpi.service.vo.FocusKpiValueVO;
import com.zcareze.kpi.service.vo.KpiFocusPatternVO;
import com.zcareze.kpi.service.vo.KpiFocusedVO;
import com.zcareze.kpi.service.vo.KpiGrantToVO;
import com.zcareze.kpi.service.vo.KpiListVO;
import com.zcareze.kpi.service.vo.KpiRatingVO;
import com.zcareze.kpi.service.vo.KpiRecordVO;
import com.zcareze.kpi.service.vo.KpiReportVO;
import com.zcareze.kpi.service.vo.KpiRptInputVO;

/**
 * 
 * @Filename KpiService.java
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
 *          <li>Date: 2017年5月11日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public interface KpiService {

	/**
	 * 增加指标
	 * 
	 * @param kpiList
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月11日 下午5:30:53
	 */
	public Result addKpiList(KpiListVO kpiList);

	/**
	 * 修改指定指标
	 * 
	 * @param kpiList
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月11日 下午5:31:09
	 */
	public Result editKpiList(KpiListVO kpiList);

	/**
	 * 删除指定指标
	 * 
	 * @param id
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月11日 下午5:31:17
	 */
	public Result deleteKpiList(String id);

	/**
	 * 获取指标列表清单
	 * 
	 * @param name
	 * @param pageNow
	 * @param pageSize
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年6月14日 下午6:03:14
	 */
	public KpiListResult getKpiList(String name, Integer orgLayer, Integer pageNow, Integer pageSize);

	/**
	 * 获取可用作聚合指标查询的指标列表清单
	 * 
	 * @param kpiId
	 *            指标Id
	 * @param name
	 *            过滤条件 通过指标名称过滤
	 * @param pageNow
	 * @param pageSize
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2018年1月17日 下午3:59:57
	 */
	@ParamentValidate(name = "指标", rules = {ValidateRules.NOT_NULL})
	public KpiListResult getKpiListForPloy(String kpiId, String name, Integer pageNow, Integer pageSize);

	/**
	 * 增加指定指标的聚合指标
	 * 
	 * @param kpiId
	 *            指标Id
	 * @param ployDim
	 *            聚合维度
	 * @param ployKpiIds
	 *            下级聚合指标列表
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2018年1月17日 下午5:05:49
	 */
	@ParamentValidate(name = "指标", rules = {ValidateRules.NOT_NULL})
	@ParamentValidate(index = 1, name = "维度", rules = {ValidateRules.NOT_NULL})
	public Result addKpiListForPloy(String kpiId, String ployDim, List<String> ployKpiIds);

	/**
	 * 删除指定指标的聚合指标
	 * 
	 * @param kpiId
	 *            指标Id
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2018年1月17日 下午5:05:49
	 */
	@ParamentValidate(name = "指标", rules = {ValidateRules.NOT_NULL})
	public Result deleteKpiListForPloy(String kpiId);

	/**
	 * 获取将指定指标设置为了聚合指标的指标基本信息清单
	 * 
	 * @param kpiId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2018年1月17日 下午6:30:24
	 */
	@ParamentValidate(name = "指标", rules = {ValidateRules.NOT_NULL})
	public BaseResult<KpiPloyInfo> getKpiPloyList(String kpiId);

	/**
	 * 根据Id获取指定的kpi信息
	 * 
	 * @param id
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年6月15日 下午3:00:02
	 */
	public KpiListResult getKpiListById(String id);

	/**
	 * 保存指标适用的机构
	 * 
	 * @param reportId
	 * @param orgIds
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月11日 下午5:31:28
	 */
	public Result saveKpiOrg(String kpiId, List<String> orgIds);

	/**
	 * 新增指标定级规则
	 * 
	 * @param kpiRanks
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月11日 下午5:31:49
	 */
	public Result addKpiRating(KpiRatingVO kpiRatings);

	/**
	 * 修改指标定级规则
	 * 
	 * @param kpiRanks
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月11日 下午5:31:49
	 */
	public Result editKpiRating(KpiRatingVO kpiRatings);

	/**
	 * 删除指标定级规则
	 * 
	 * @param kpiRanks
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月11日 下午5:31:49
	 */
	public Result deleteKpiRating(String kpiId, Integer seqNo);

	/**
	 * 获取制定制定的定级规则
	 * 
	 * @param kpiId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年6月14日 下午6:06:45
	 */
	public KpiRatingResult getKpiRatingList(String kpiId);

	/**
	 * 增加指标授权
	 * 
	 * @param kpigrantTo
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月11日 下午5:32:12
	 */
	public Result addKpiGrantTo(KpiGrantToVO kpigrantTo);

	/**
	 * 删除指标授权
	 * 
	 * @param kpigrantTo
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月11日 下午5:32:22
	 */
	public Result deleteKpiGrantTo(String kpiId, String orgId);

	/**
	 * 获取指定的指标授权列表
	 * 
	 * @param kpiId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年6月14日 下午6:07:38
	 */
	public KpiGrantToResult getKpiGrantToByKpiId(String kpiId);

	/**
	 * 新增指标报表
	 * 
	 * @param kpiReport
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年6月15日 下午7:07:30
	 */
	public Result addKpiReport(KpiReportVO kpiReport);

	/**
	 * 修改指标报表参数
	 * 
	 * @param kpiReport
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年6月15日 下午7:07:07
	 */
	public Result editKpiReport(KpiReportVO kpiReport);

	/**
	 * 删除指标报表
	 * 
	 * @param kpiId
	 * @param reportId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年6月15日 下午7:06:44
	 */
	public Result deleteKpiReport(String kpiId, String reportId);

	/**
	 * 获取指标报表列表
	 * 
	 * @param kpiId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年6月16日 上午9:55:57
	 */
	public KpiReportResult getKpiReportList(String kpiId);

	/**
	 * 新增指标报表参数
	 * 
	 * @param kpiReport
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年6月15日 下午7:06:22
	 */
	public Result addKpiRptInputs(KpiRptInputVO KpiRptInput);

	/**
	 * 修改指标报表参数
	 * 
	 * @param kpiReport
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年6月15日 下午7:05:57
	 */
	public Result editKpiRptInputs(KpiRptInputVO KpiRptInput);

	/**
	 * 删除指标报表参数
	 * 
	 * @param kpiId
	 * @param rptId
	 * @param name
	 *            <p>
	 *            说明：
	 *            </p>
	 * @author 虾米 by 2017年6月15日 下午7:05:24
	 */
	public Result deleteKpiRptInputs(String kpiId, String rptId, String name);

	/**
	 * 保存指标数据
	 * 
	 * @param kpiData
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月11日 下午5:32:28
	 */
	public Result saveKpiRecord(KpiRecordVO kpiRecord);

	/**
	 * 稽核指标数据
	 * 
	 * @param kipDataId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月11日 下午5:32:37
	 */
	public Result auditKpiRecord(String kpiRecordId);

	/**
	 * 取消稽核指标数据
	 * 
	 * @param kipDataId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月12日 上午10:05:51
	 */
	public Result cancelAuditKpiData(String kpiRecordId);

	/**
	 * 获取设置指标关注时可选择的指标模式
	 * 
	 * @param kpiId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2018年1月18日 上午10:15:40
	 */
	@ParamentValidate(name = "指标", rules = {ValidateRules.NOT_NULL})
	public BaseResult<KpiFocusPatternVO> getKpiPatternForFocus(String kpiId);

	/**
	 * 保存常用指标设置 包含指标顺序,取消关注的指标,设置的指标和新关注的指标
	 * 
	 * @param kpiFocused
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2018年1月18日 上午10:56:30
	 */
	@ParamentValidate(name = "指标设置", rules = {ValidateRules.NOT_NULL})
	public BaseResult<KpiFocusedVO> saveMyFocusKpi(KpiFocusedSetParam kpiFocused);

	/**
	 * 增加我的常用指标
	 * 
	 * @param reportId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月15日 下午12:10:50
	 */
	public Result addMyFocusKpi(KpiFocusedParam kpiFocused);

	/**
	 * 取消我的常用指标
	 * 
	 * @param reportId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月15日 下午12:11:00
	 */
	public Result cancelMyFocusKpi(String kpiId, String orgId);

	/**
	 * 阅览我的常用指标
	 * 
	 * @param reportId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月15日 下午12:12:42
	 */
	public Result readMyMyFocusKpi(String kpiId, String orgId);

	/**
	 * 我关注的指标(分析主页使用)
	 * 
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月12日 下午3:20:52
	 */
	public FocusKpiResult getMyFocusKpis();

	/**
	 * 获取我的单个获取指标
	 * 
	 * @param kpiId
	 * @param orgId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月23日 下午6:35:40
	 */
	public FocusKpiResult getMyFocusKpiValue(String kpiId, String orgId);

	/**
	 * 我有权限的指标列表
	 * 
	 * @param cycKinds
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月15日 下午8:12:24
	 */
	public GrantKpiResult getMyGrantKpis(List<String> cycKinds, Integer pageNow, Integer pageSize);

	/**
	 * 我有管理权限的指标列表
	 * 
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午4:56:08
	 */
	public KpiManageResult getMyManageKpis(String orgId, Integer pageNow, Integer pageSize);

	/**
	 * 获取指标数据详情
	 * 
	 * @param kpiId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月16日 下午5:24:52
	 */
	public KpiDetailValueResult getKpiDetailValue(String kpiId, String orgId, Integer rowNum);

	/**
	 * 获取指标数据 (用于历史数据查询)
	 * 
	 * @param rowValueParam
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午3:17:52
	 */
	public KpiRowValueResult getKpiRowValues(KpiRowValueParam rowValueParam);

	/**
	 * 获取指标的下级指标数据 用于构成图显示
	 * 
	 * @param splitParam
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午4:24:42
	 */
	public KpiSplitValueResult getKpiSplitValue(KpiSplitValueParam splitParam);

	/**
	 * 获取指标的项目分解数据
	 * 
	 * @param ployParam
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2018年1月19日 下午5:21:12
	 */
	public BaseResult<KpiPloyValue> getKpiPloyValue(KpiPloyValueParam ployParam);

	/**
	 * 获取指标对应报表的参数列表
	 * 
	 * @param kpiId
	 * @param reportId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月24日 下午12:15:47
	 */
	public KpiRptInputResult getKpiRptInputs(String kpiId, String reportId);

	/**
	 * 指标同步到其他区域
	 * 
	 * @param reportId
	 * @param cloudIds
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年8月22日 下午4:08:03
	 */
	@ParamentValidate(name = "指标", rules = {ValidateRules.NOT_NULL})
	public KpiCopyResult copyKpiList(String kpiId, List<String> cloudIds);

	// #start 经典指标页面

	@ParamentValidate(name = "指标页面标题", rules = {ValidateRules.NOT_NULL})
	public Result saveMyFocusToPage(String title,String comment);
	
	@ParamentValidate(name = "指标页面Id", rules = {ValidateRules.NOT_NULL})
	public BaseResult<FocusKpiValueVO> getKpiPageValue(String pageId);		
		
	@ParamentValidate(name = "指标页面", rules = {ValidateRules.NOT_NULL})
	public Result addKpipageList(KpipageList kpipage);

	@ParamentValidate(name = "指标页面", rules = {ValidateRules.NOT_NULL})
	public Result editKpipageList(KpipageList kpipage);

	@ParamentValidate(name = "指标页面Id", rules = {ValidateRules.NOT_NULL})
	public Result deleteKpipageList(String id);

	public BaseResult<KpipageList> getKpipageLists(Integer pageStart, Integer pageSize);

	@ParamentValidate(name = "指标页面设置", rules = {ValidateRules.NOT_NULL})
	public Result addKpipageSet(KpipageSet kpipageSet);

	@ParamentValidate(name = "指标页面设置", rules = {ValidateRules.NOT_NULL})
	public Result editKpipageSet(KpipageSet kpipageSet);

	@ParamentValidate(name = "指标页面设置Id", rules = {ValidateRules.NOT_NULL})
	public Result deleteKpipageSet(String id);

	@ParamentValidate(name = "指标页面Id", rules = {ValidateRules.NOT_NULL})
	public BaseResult<KpipageSet> getKpipageSetList(String pageId);

	@ParamentValidate(name = "指标页面授权", rules = {ValidateRules.NOT_NULL})
	public Result saveKpipageOpenTo(KpipageOpenTo kpipageOpenTo);	

	@ParamentValidate(name = "授权Id", rules = {ValidateRules.NOT_NULL})
	public Result deleteKpipageOpenTo(String id);

	@ParamentValidate(name = "指标页面Id", rules = {ValidateRules.NOT_NULL})
	public BaseResult<KpipageOpenTo> getKpipageOpenToList(String pageId);

	// #end 经典指标页面

}
