/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.zcareze.commons.ZcarezeConstant;
import com.zcareze.commons.cache.ApplicationCacheUtils;
import com.zcareze.commons.json.JsonUtils;
import com.zcareze.commons.method.annotation.ParamentValidate;
import com.zcareze.commons.method.annotation.ValidateRules;
import com.zcareze.commons.result.BaseResult;
import com.zcareze.commons.result.Result;
import com.zcareze.commons.result.ResultEnum;
import com.zcareze.commons.thread.ThreadUtils;
import com.zcareze.commons.utils.DateUtil;
import com.zcareze.commons.utils.StringUtils;
import com.zcareze.commons.utils.ValidatorUtil;
import com.zcareze.data.annotation.CustomTransactional;
import com.zcareze.data.exception.DataSourceException;
import com.zcareze.data.transaction.TransactionManager;
import com.zcareze.domain.regional.OrgList;
import com.zcareze.domain.regional.OrgMembers;
import com.zcareze.kpi.dao.KpiDao;
import com.zcareze.kpi.domain.GrantKpiValue;
import com.zcareze.kpi.domain.KpiFocused;
import com.zcareze.kpi.domain.KpiFocusedValue;
import com.zcareze.kpi.domain.KpiGrantTo;
import com.zcareze.kpi.domain.KpiGrantToManageList;
import com.zcareze.kpi.domain.KpiList;
import com.zcareze.kpi.domain.KpiPloyInfo;
import com.zcareze.kpi.domain.KpiPloyValue;
import com.zcareze.kpi.domain.KpiRating;
import com.zcareze.kpi.domain.KpiRecord;
import com.zcareze.kpi.domain.KpiReport;
import com.zcareze.kpi.domain.KpiRptInput;
import com.zcareze.kpi.domain.KpipageList;
import com.zcareze.kpi.domain.KpipageOpenTo;
import com.zcareze.kpi.domain.KpipageSet;
import com.zcareze.kpi.service.KpiService;
import com.zcareze.kpi.service.enst.CycKindType;
import com.zcareze.kpi.service.enst.KpiChartType;
import com.zcareze.kpi.service.enst.KpiConstants;
import com.zcareze.kpi.service.enst.KpiPatternType;
import com.zcareze.kpi.service.enst.KpiResultMessage;
import com.zcareze.kpi.service.enst.OrgLayerEnum;
import com.zcareze.kpi.service.param.KpiFocusedOrder;
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
import com.zcareze.kpi.service.vo.GrantKpiValueVO;
import com.zcareze.kpi.service.vo.KpiDetailValueVO;
import com.zcareze.kpi.service.vo.KpiFocusPatternVO;
import com.zcareze.kpi.service.vo.KpiFocusedVO;
import com.zcareze.kpi.service.vo.KpiGrantToVO;
import com.zcareze.kpi.service.vo.KpiListVO;
import com.zcareze.kpi.service.vo.KpiManageVO;
import com.zcareze.kpi.service.vo.KpiRatingVO;
import com.zcareze.kpi.service.vo.KpiRecordVO;
import com.zcareze.kpi.service.vo.KpiReportVO;
import com.zcareze.kpi.service.vo.KpiRowValueVO;
import com.zcareze.kpi.service.vo.KpiRptInputVO;
import com.zcareze.kpi.service.vo.KpiSplitValueVO;
import com.zcareze.regional.service.OrgService;
import com.zcareze.regional.service.enst.OrgListEnum;
import com.zcareze.regional.service.result.OrgListResult;
import com.zcareze.token.service.TokenService;
import com.zcareze.token.service.data.CurrentLoginInfo;

/**
 * 
 * @Filename KpiServiceImpl.java
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
public class KpiServiceImpl implements KpiService {
	public static final Logger LOGGER = LoggerFactory.getLogger(KpiServiceImpl.class);
	@Autowired
	private KpiDao kpiDao;
	@Autowired
	private OrgService orgService;
	@Autowired
	private TokenService tokenService;

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
	@Override
	public Result addKpiList(KpiListVO kpiList) {
		if (ValidatorUtil.isEmpty(kpiList.getCode(), kpiList.getName(), kpiList.getName(), kpiList.getUnit(),
				kpiList.getCycKind())) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		if (StringUtils.isEmpty(kpiList.getId())) {
			kpiList.setId(StringUtils.getUUID());
		}
		KpiList existKpi = kpiDao.findKpiListByUnique(kpiList.getName(), kpiList.getCode());
		if (existKpi != null) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.KPIEXIST);
		}
		KpiList rlist = new KpiList();
		BeanUtils.copyProperties(kpiList, rlist);
		kpiDao.addKpiList(rlist);
		return Result.success();
	}

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
	@Override
	public Result editKpiList(KpiListVO kpiList) {
		if (ValidatorUtil.isEmpty(kpiList.getCode(), kpiList.getName(), kpiList.getName(), kpiList.getUnit(),
				kpiList.getCycKind())) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		KpiList existKpi = kpiDao.findKpiListByUnique(kpiList.getName(), kpiList.getCode());
		if (existKpi != null && !existKpi.getId().equals(kpiList.getId())) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.KPIEXIST);
		}
		KpiList rlist = new KpiList();
		BeanUtils.copyProperties(kpiList, rlist);
		kpiDao.editKpiList(rlist);
		return Result.success();
	}

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
	@Override
	public Result deleteKpiList(String id) {
		if (ValidatorUtil.isEmpty(id)) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		List<KpiList> splitKpis = kpiDao.findSplitKpiListById(id);
		if (splitKpis != null && splitKpis.size() > 0) {
			return Result.serviceError(KpiResultMessage.EXISTSPLITKPI);
		}
		List<KpiPloyInfo> ployInfos = kpiDao.findKpiListPloy(id);
		if (ployInfos != null && ployInfos.size() > 0) {
			return Result.serviceError(KpiResultMessage.EXISTPLOYKPI);
		}
		kpiDao.deleteKpiList(id);
		return Result.success();
	}

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
	@Override
	public KpiListResult getKpiList(String name, Integer orgLayer, Integer pageNow, Integer pageSize) {
		KpiListResult result = new KpiListResult();
		Integer pageStart = pageNow * pageSize;
		if (pageStart <= 0) {
			pageStart = 0;
		}
		if (orgLayer == null) {
			orgLayer = -1;
		}
		List<KpiListVO> kpiLists = new ArrayList<KpiListVO>();
		List<KpiList> kpLists = kpiDao.findKpiList(name, orgLayer, pageStart, pageSize);
		for (KpiList kp : kpLists) {
			KpiListVO vo = new KpiListVO();
			BeanUtils.copyProperties(kp, vo);
			kpiLists.add(vo);
		}
		result.setRecordCount(kpiDao.countKpiList(name, orgLayer));
		result.success(kpiLists);
		return result;
	}

	/**
	 * 获取可用作聚合指标查询的指标列表清单
	 * 
	 * @param name
	 * @param orgLayer
	 * @param pageNow
	 * @param pageSize
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2018年1月17日 下午3:59:57
	 */
	@Override
	public KpiListResult getKpiListForPloy(String kpiId, String name, Integer pageNow, Integer pageSize) {
		KpiListResult result = new KpiListResult();
		Integer pageStart = pageNow * pageSize;
		if (pageStart <= 0) {
			pageStart = 0;
		}
		List<KpiListVO> kpiLists = new ArrayList<KpiListVO>();
		List<KpiList> kpLists = kpiDao.findKpiListForPloyByKpiId(kpiId, name, pageStart, pageSize);
		for (KpiList kp : kpLists) {
			if (kp.getId().equals(kpiId)) {
				continue;
			}
			KpiListVO vo = new KpiListVO();
			BeanUtils.copyProperties(kp, vo);
			kpiLists.add(vo);
		}
		result.success(kpiLists);
		return result;
	}

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
	public Result addKpiListForPloy(String kpiId, String ployDim, List<String> ployKpiIds) {
		if (ployKpiIds == null || ployKpiIds.size() == 0) {
			return Result.success();
		}
		KpiList ployKpi = kpiDao.findKpiListById(kpiId);
		if (ployKpi == null) {
			return Result.paramError(KpiResultMessage.INPUTISNOTEXIST);
		}
		for (String string : ployKpiIds) {
			KpiList kpiList = kpiDao.findKpiListById(string);
			if (kpiList == null) {
				return Result.paramError(KpiResultMessage.INPUTISNOTEXIST);
			}
			if (!kpiList.getOrgLayer().equals(ployKpi.getOrgLayer())) {
				return Result.paramError(KpiResultMessage.KPINOTLOYER);
			}
			kpiDao.updateKpiListPloy(string, kpiId, ployDim);
		}
		return Result.success();
	}

	/**
	 * 删除指定指标的聚合指标
	 * 
	 * @param kpiId
	 *            指标Id
	 * @param ployId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2018年1月17日 下午5:05:49
	 */
	@ParamentValidate(name = "指标", rules = {ValidateRules.NOT_NULL})
	public Result deleteKpiListForPloy(String ployId) {
		kpiDao.updateKpiListPloy(ployId, null, null);
		return Result.success();
	}

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
	public BaseResult<KpiPloyInfo> getKpiPloyList(String kpiId) {
		BaseResult<KpiPloyInfo> result = new BaseResult<>();
		List<KpiPloyInfo> pluyInfos = kpiDao.findKpiListPloy(kpiId);
		result.success(pluyInfos);
		return result;
	}

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
	public KpiListResult getKpiListById(String id) {
		KpiListResult result = new KpiListResult();
		KpiList kpList = kpiDao.findKpiListById(id);
		KpiListVO vo = new KpiListVO();
		BeanUtils.copyProperties(kpList, vo);
		if (StringUtils.isNotEmpty(kpList.getSplitId())) {
			KpiList splitKpi = kpiDao.findKpiListById(kpList.getSplitId());
			if (splitKpi != null) {
				vo.setSplitName(splitKpi.getName());
			}
		}
		if (StringUtils.isNotEmpty(kpList.getPloyId())) {
			KpiList ployKpi = kpiDao.findKpiListById(kpList.getPloyId());
			if (ployKpi != null) {
				vo.setPloyName(ployKpi.getName());
			}
		}
		result.success(vo);
		return result;
	}

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
	@Override
	public Result saveKpiOrg(String kpiId, List<String> orgIds) {
		if (ValidatorUtil.isEmpty(kpiId)) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		String orgStrIds = "";
		for (String string : orgIds) {
			orgStrIds = orgStrIds + string + ",";
		}
		kpiDao.saveKpiOrg(kpiId, orgStrIds);
		return Result.success();
	}

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
	public Result addKpiRating(KpiRatingVO kpiRatings) {
		if (ValidatorUtil.isEmpty(kpiRatings.getKpiId())) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		KpiRating rlist = new KpiRating();
		BeanUtils.copyProperties(kpiRatings, rlist);
		kpiDao.addKpiRating(rlist);
		return Result.success();
	}

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
	public Result editKpiRating(KpiRatingVO kpiRatings) {
		if (ValidatorUtil.isEmpty(kpiRatings.getKpiId())) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		KpiRating rlist = new KpiRating();
		BeanUtils.copyProperties(kpiRatings, rlist);
		kpiDao.editKpiRating(rlist);
		return Result.success();
	}

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
	public Result deleteKpiRating(String kpiId, Integer seqNo) {
		if (ValidatorUtil.isEmpty(kpiId)) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		kpiDao.deleteKpiRating(kpiId, seqNo);
		return Result.success();
	}

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
	@Override
	public KpiRatingResult getKpiRatingList(String kpiId) {
		KpiRatingResult result = new KpiRatingResult();
		List<KpiRatingVO> kpiRantVos = new ArrayList<KpiRatingVO>();
		List<KpiRating> kpiRantings = kpiDao.findKpiRatingList(kpiId);
		for (KpiRating kp : kpiRantings) {
			KpiRatingVO vo = new KpiRatingVO();
			BeanUtils.copyProperties(kp, vo);
			kpiRantVos.add(vo);
		}
		result.success(kpiRantVos);
		return result;
	}

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
	@Override
	@CustomTransactional
	public Result addKpiGrantTo(KpiGrantToVO kpigrantTo) {
		if (ValidatorUtil.isEmpty(kpigrantTo.getKpiId(), kpigrantTo.getOrgId(), kpigrantTo.getRoles())) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		String kpiId = kpigrantTo.getKpiId();
		String[] ids = kpiId.split(";");
		if (ids != null && ids.length > 0) {
			for (String string : ids) {
				if (StringUtils.isEmpty(string)) {
					continue;
				}
				KpiGrantTo rlist = new KpiGrantTo();
				BeanUtils.copyProperties(kpigrantTo, rlist);
				rlist.setKpiId(string);
				rlist.setGranter(ApplicationCacheUtils.getAccountName());
				rlist.setGrantTime(new Date());
				if (rlist.getManage() == null) {
					rlist.setManage(0);
				}
				if (rlist.getInput() == null) {
					rlist.setInput(0);
				}
				kpiDao.addKpiGrantTo(rlist);
			}
		}
		return Result.success();
	}

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
	@Override
	public Result deleteKpiGrantTo(String kpiId, String orgId) {
		if (ValidatorUtil.isEmpty(kpiId, orgId)) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		kpiDao.deleteKpiGrantTo(kpiId, orgId);
		return Result.success();
	}

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
	@Override
	public KpiGrantToResult getKpiGrantToByKpiId(String kpiId) {
		KpiGrantToResult result = new KpiGrantToResult();
		List<KpiGrantToVO> kpiGranttoVos = new ArrayList<KpiGrantToVO>();
		List<KpiGrantTo> kpiGrantTos = kpiDao.findKpiGrantToByKpiId(kpiId);
		for (KpiGrantTo kp : kpiGrantTos) {
			KpiGrantToVO vo = new KpiGrantToVO();
			BeanUtils.copyProperties(kp, vo);
			if (!StringUtils.isEmpty(vo.getOrgId())) {
				String orgName = getOrgName(vo.getOrgId(), 4, true, false);
				vo.setOrgName(orgName);
			}
			kpiGranttoVos.add(vo);
		}
		result.success(kpiGranttoVos);
		return result;
	}

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
	public Result addKpiReport(KpiReportVO kpiReport) {
		if (ValidatorUtil.isEmpty(kpiReport.getKpiId(), kpiReport.getReportId())) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		KpiReport kpiRpt = new KpiReport();
		BeanUtils.copyProperties(kpiReport, kpiRpt);
		kpiDao.addKpiReport(kpiRpt);
		return Result.success();
	}

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
	public Result editKpiReport(KpiReportVO kpiReport) {
		if (ValidatorUtil.isEmpty(kpiReport.getKpiId(), kpiReport.getReportId())) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		KpiReport kpiRpt = new KpiReport();
		BeanUtils.copyProperties(kpiReport, kpiRpt);
		kpiDao.editKpiReport(kpiRpt);
		return Result.success();
	}

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
	public Result deleteKpiReport(String kpiId, String reportId) {
		if (ValidatorUtil.isEmpty(kpiId, reportId)) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		kpiDao.deleteKpiReport(kpiId, reportId);
		return Result.success();
	}

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
	public KpiReportResult getKpiReportList(String kpiId) {
		KpiReportResult result = new KpiReportResult();
		if (ValidatorUtil.isEmpty(kpiId)) {
			result.failure(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
			return result;
		}
		List<KpiReport> kpirpts = kpiDao.findKpiReportByKpiId(kpiId);
		List<KpiReportVO> kpVos = new ArrayList<KpiReportVO>();
		for (KpiReport kpirpt : kpirpts) {
			KpiReportVO vo = new KpiReportVO();
			BeanUtils.copyProperties(kpirpt, vo);
			kpVos.add(vo);
		}
		result.success(kpVos);
		return result;
	}

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
	public Result addKpiRptInputs(KpiRptInputVO KpiRptInput) {
		if (ValidatorUtil.isEmpty(KpiRptInput.getKpiId(), KpiRptInput.getRptId(), KpiRptInput.getName())) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		KpiRptInput kpiRpt = new KpiRptInput();
		BeanUtils.copyProperties(KpiRptInput, kpiRpt);
		kpiDao.addKpiRptInputs(kpiRpt);
		return Result.success();
	}

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
	public Result editKpiRptInputs(KpiRptInputVO KpiRptInput) {
		if (ValidatorUtil.isEmpty(KpiRptInput.getKpiId(), KpiRptInput.getRptId(), KpiRptInput.getName())) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		KpiRptInput kpiRpt = new KpiRptInput();
		BeanUtils.copyProperties(KpiRptInput, kpiRpt);
		kpiDao.editKpiRptInputs(kpiRpt);
		return Result.success();
	}

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
	public Result deleteKpiRptInputs(String kpiId, String rptId, String name) {
		if (ValidatorUtil.isEmpty(kpiId, rptId, name)) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		kpiDao.deleteKpiRptInputs(kpiId, rptId, name);
		return Result.success();
	}

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
	@Override
	public Result saveKpiRecord(KpiRecordVO kpiRecord) {
		if (ValidatorUtil.isEmpty(kpiRecord.getKpiId(), kpiRecord.getCycValue())) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		KpiRecord rlist = new KpiRecord();
		KpiList kpiList = kpiDao.findKpiListById(kpiRecord.getKpiId());
		rlist.setCycKind(kpiList.getCycKind());
		rlist.setCycValue(kpiRecord.getCycValue());
		rlist.setEditorId(ApplicationCacheUtils.getStaffId());
		rlist.setEditTime(new Date());
		rlist.setEditorName(ApplicationCacheUtils.getAccountName());
		rlist.setId(kpiRecord.getId());
		if (StringUtils.isEmpty(rlist.getId())) {
			rlist.setId(StringUtils.getUUID());
		}
		rlist.setKpiId(kpiList.getId());
		rlist.setKpiName(kpiList.getName());
		rlist.setKpiUnit(kpiList.getUnit());
		// 必须处理组织机构Id,前端传入的组织机构Id可能有问题
		String orgId = kpiRecord.getOrgId();
		OrgLayerEnum orgLayer = OrgLayerEnum.parse(kpiList.getOrgLayer());
		switch (orgLayer) {
			case GLOBAL :
				orgId = null;
				break;
			case ORG :
				OrgList horgList = orgService.getHisOrgByOrgId(orgId);
				if (horgList == null) {
					return Result.paramError("组织机构不正确,无法完成数据输入");
				}
				orgId = horgList.getId();
				break;
			case DEPART :
				OrgList orgList = orgService.seOrgById(orgId);
				if (orgList == null || orgList.getKind().equals(OrgListEnum.KIND_H.getCode())) {
					return Result.paramError("组织机构不正确,无法完成数据输入");
				}
				if (orgList.getKind().equals(OrgListEnum.KIND_D.getCode())) {
					orgId = orgList.getId();
				} else if (orgList.getKind().equals(OrgListEnum.KIND_T.getCode())) {
					OrgList pOrgList = orgService.seOrgById(orgList.getParentId());
					if (pOrgList.getKind().equals(OrgListEnum.KIND_D.getCode())) {
						orgId = pOrgList.getId();
					}
				}
				if (StringUtils.isEmpty(orgId)) {
					return Result.paramError("组织机构不正确,无法完成数据输入");
				}
				break;
			case TEAM :
				OrgList tmorgList = orgService.seOrgById(orgId);
				if (tmorgList == null || !tmorgList.getKind().equals(OrgListEnum.KIND_T.getCode())) {
					return Result.paramError("组织机构不正确,无法完成数据输入");
				}
				orgId = tmorgList.getId();
				break;
		}
		rlist.setOrgId(orgId);
		// 判断是否需要审核
		if (kpiList.getAdAudit() != null && kpiList.getAdAudit().equals(ZcarezeConstant.YES)) {
			rlist.setAdAudit(ZcarezeConstant.YES);
		} else {
			rlist.setAdAudit(ZcarezeConstant.NO);
		}
		if (kpiRecord.getAudit() == null || kpiRecord.getAudit().equals(ZcarezeConstant.NO)) {
			rlist.setAuditTime(null);
			rlist.setAuditorName(null);
		} else {
			rlist.setAuditTime(new Date());
			rlist.setAuditorName(ApplicationCacheUtils.getAccountName());
		}
		rlist.setKpiValue(kpiRecord.getKpiValue());
		kpiDao.saveKpiRecord(rlist);
		return Result.success();
	}

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
	@Override
	public Result auditKpiRecord(String kpiRecordId) {
		if (ValidatorUtil.isEmpty(kpiRecordId)) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		kpiDao.auditKpiRecord(kpiRecordId, ApplicationCacheUtils.getAccountName(), new Date());
		return Result.success();
	}

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
	@Override
	public Result cancelAuditKpiData(String kpiRecordId) {
		if (ValidatorUtil.isEmpty(kpiRecordId)) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		kpiDao.cancelAuditKpiData(kpiRecordId);
		return Result.success();
	}

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
	public BaseResult<KpiFocusPatternVO> getKpiPatternForFocus(String kpiId) {
		BaseResult<KpiFocusPatternVO> result = new BaseResult<>();
		KpiFocusPatternVO patternVo = new KpiFocusPatternVO();
		patternVo.setKpiId(kpiId);
		KpiList kpiList = kpiDao.findKpiListById(kpiId);
		if (kpiList == null) {
			result.paramFailure(KpiResultMessage.KPINOTEXIST);
			return result;
		}
		if (StringUtils.isNotEmpty(kpiList.getSplitId())) {
			patternVo.setOrgChart(ZcarezeConstant.YES);
		} else {
			patternVo.setOrgChart(ZcarezeConstant.NO);
		}
		List<KpiPloyInfo> ployKpiList = kpiDao.findKpiListPloy(kpiId);
		if (ployKpiList != null && ployKpiList.size() > 0) {
			patternVo.setPloyChart(ZcarezeConstant.YES);
			List<String> ployDim = new ArrayList<>();
			for (KpiPloyInfo ployInfo : ployKpiList) {
				if (StringUtils.isEmpty(ployInfo.getPloyDim())) {
					continue;
				}
				if (!ployDim.contains(ployInfo.getPloyDim())) {
					ployDim.add(ployInfo.getPloyDim());
				}
			}
			patternVo.setPloyDims(ployDim);
		} else {
			patternVo.setPloyChart(ZcarezeConstant.NO);
		}
		List<KpiRating> kpiRatings = kpiDao.findKpiRatingList(kpiId);
		if (kpiRatings != null && kpiRatings.size() > 0) {
			patternVo.setGradeChart(ZcarezeConstant.YES);
		} else {
			patternVo.setGradeChart(ZcarezeConstant.NO);
		}
		result.success(patternVo);
		return result;
	}

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
	@CustomTransactional
	public BaseResult<KpiFocusedVO> saveMyFocusKpi(KpiFocusedSetParam kpiFocused) {
		BaseResult<KpiFocusedVO> result = new BaseResult<>();
		String staffId = ApplicationCacheUtils.getStaffId();
		if (kpiFocused.getFocusedOrders() != null && kpiFocused.getFocusedOrders().size() > 0) {
			for (KpiFocusedOrder kpiFocusedOrder : kpiFocused.getFocusedOrders()) {
				kpiDao.updateKpiFocusedOrder(kpiFocusedOrder.getId(), kpiFocusedOrder.getRowNum(),
						kpiFocusedOrder.getSeqNum());
			}
		}
		if (kpiFocused.getKpiFocused() != null && kpiFocused.getKpiFocused().size() > 0) {
			for (KpiFocusedVO kpiFocusedVO : kpiFocused.getKpiFocused()) {
				if (StringUtils.isEmpty(kpiFocusedVO.getStaffId())) {
					kpiFocusedVO.setStaffId(staffId);
				}
				Integer chart = 0;
				if (StringUtils.isNotEmpty(kpiFocusedVO.getChart())) {
					chart = Integer.parseInt(kpiFocusedVO.getChart());
				}
				KpiList kpi = kpiDao.findKpiListById(kpiFocusedVO.getKpiId());
				if (kpi == null) {
					continue;
				}
				OrgLayerEnum orgLayer = OrgLayerEnum.parse(kpi.getOrgLayer());
				if (orgLayer == null) {
					continue;
				}
				String orgId = kpiFocusedVO.getOrgId();
				switch (orgLayer) {
					case GLOBAL :
						orgId = null;
						break;
					case ORG :
						OrgList horgList = orgService.getHisOrgByOrgId(orgId);
						if (horgList == null) {
							orgId = ApplicationCacheUtils.getDefaultOrg();
						} else {
							orgId = horgList.getId();
						}
						break;
					case DEPART :
						OrgList orgList = orgService.seOrgById(orgId);
						if (orgList != null) {
							if (orgList.getKind().equals(OrgListEnum.KIND_D.getCode())) {
								orgId = orgList.getId();
							} else if (orgList.getKind().equals(OrgListEnum.KIND_T.getCode())) {
								OrgList pOrgList = orgService.seOrgById(orgList.getParentId());
								if (pOrgList.getKind().equals(OrgListEnum.KIND_D.getCode())) {
									orgId = pOrgList.getId();
								}
							}
						}
						if (StringUtils.isEmpty(orgId)) {
							orgId = ApplicationCacheUtils.getDefaultDepart();
						}
						break;
					case TEAM :
						OrgList tmorgList = orgService.seOrgById(orgId);
						orgId = tmorgList.getId();
						if (StringUtils.isEmpty(orgId)) {
							orgId = ApplicationCacheUtils.getDefaultTeam();
						}
						break;
				}
				kpiFocusedVO.setOrgId(orgId);
				KpiChartType chartType = KpiChartType.parse(chart);
				kpiFocusedVO.setChart(chartType.getName());
				if (StringUtils.isEmpty(kpiFocusedVO.getId())) {
					kpiFocusedVO.setId(StringUtils.getUUID());
					KpiFocused newKpiFocus = new KpiFocused();
					BeanUtils.copyProperties(kpiFocusedVO, newKpiFocus);
					kpiDao.addKpiFocused(newKpiFocus);
				} else {
					KpiFocused oldKpiFocus = new KpiFocused();
					BeanUtils.copyProperties(kpiFocusedVO, oldKpiFocus);
					kpiDao.editKpiFocused(oldKpiFocus);
				}
			}
		}
		if (kpiFocused.getCancelFocused() != null && kpiFocused.getCancelFocused().size() > 0) {
			for (String kpiId : kpiFocused.getCancelFocused()) {
				kpiDao.cancelKpiFocused(kpiId);
			}
		}
		result.success(kpiFocused.getKpiFocused());
		return result;
	}

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
	@Override
	public Result addMyFocusKpi(KpiFocusedParam kpiFocused) {
		if (ValidatorUtil.isEmpty(kpiFocused.getKpiId())) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		String staffId = ApplicationCacheUtils.getStaffId();
		KpiFocused kpifocus = new KpiFocused();
		BeanUtils.copyProperties(kpiFocused, kpifocus);
		KpiList kpi = kpiDao.findKpiListById(kpiFocused.getKpiId());
		kpifocus.setKpiTitle(kpi.getName());
		if (StringUtils.isEmpty(kpifocus.getOrgId())) {
			kpifocus.setOrgId(null);
		}
		KpiChartType chartType = KpiChartType.parse(kpiFocused.getChart());
		kpifocus.setChart(chartType.getName());
		kpifocus.setStaffId(staffId);
		kpiDao.addKpiFocused(kpifocus);
		return Result.success();
	}

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
	@Override
	public Result cancelMyFocusKpi(String kpiId, String orgId) {
		if (ValidatorUtil.isEmpty(kpiId)) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		// String staffId = ApplicationCacheUtils.getStaffId();
		// kpiDao.cancelKpiFocused(kpiId, orgId, staffId);
		return Result.success();
	}

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
	@Override
	public Result readMyMyFocusKpi(String kpiId, String orgId) {
		if (ValidatorUtil.isEmpty(kpiId)) {
			return Result.error(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
		}
		String staffId = ApplicationCacheUtils.getStaffId();
		Date now = new Date();
		kpiDao.readKpiFocus(kpiId, orgId, staffId, now);
		return Result.success();
	}

	/**
	 * 我关注的指标(分析主页使用)
	 * 
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月12日 下午3:20:52
	 */
	@Override
	public FocusKpiResult getMyFocusKpis() {
		FocusKpiResult result = new FocusKpiResult();
		List<FocusKpiValueVO> kpiValues = new LinkedList<FocusKpiValueVO>();
		String staffId = ApplicationCacheUtils.getStaffId();
		// 云管管理人员
		boolean isAdmin = ApplicationCacheUtils.getLoginManager();
		List<KpiFocusedValue> kpiFocus = kpiDao.findKpiFocusValueByStaffId(staffId);
		for (int i = 0; i < kpiFocus.size(); i++) {
			KpiFocusedValue kpis = kpiFocus.get(i);
			if (!isAdmin) {
				// 判断是否有权限
				Boolean hasGrantto = kpiDao.checkKpiGrantToByStaffId(kpis.getKpiId(), staffId);
				if (!hasGrantto) {
					continue;
				}
			}
			FocusKpiValueVO kpiValue = getkpiFocusValue(kpis);
			kpiValues.add(kpiValue);
		}
		result.success(kpiValues);
		return result;
	}

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
	public FocusKpiResult getMyFocusKpiValue(String kpiId, String orgId) {
		FocusKpiResult result = new FocusKpiResult();
		if (ValidatorUtil.isEmpty(kpiId, orgId)) {
			result.failure(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
			return result;
		}
		String staffId = ApplicationCacheUtils.getStaffId();
		KpiList kpiList = kpiDao.findKpiListById(kpiId);
		KpiFocused kpiFocused = kpiDao.findKpiFocused(kpiId, orgId, staffId);
		if (kpiFocused == null || kpiList == null) {
			result.failure(ResultEnum.DATA_ERROR, KpiResultMessage.BASEREPORTDATAEMPTY);
			return result;
		}
		KpiFocusedValue kpis = new KpiFocusedValue();
		kpis.setChart(kpiFocused.getChart());
		kpis.setCycKind(kpiList.getCycKind());
		kpis.setCycShow(kpiFocused.getCycShow());
		kpis.setKpiId(kpiId);
		kpis.setKpiTitle(kpiList.getName());
		kpis.setOrgId(orgId);
		kpis.setOrgLayer(kpiList.getOrgLayer());
		kpis.setOrgShow(kpiFocused.getOrgShow());
		kpis.setPattern(kpiFocused.getPattern());
		kpis.setPrevCycle(kpiFocused.getPrevCycle());
		kpis.setReadTime(kpiFocused.getReadTime());
		kpis.setRowNum(kpiFocused.getRowNum());
		kpis.setSeqNum(kpiFocused.getSeqNum());
		kpis.setSplitId(kpiList.getSplitId());
		kpis.setUnit(kpiList.getUnit());
		kpis.setUnitShow(kpiFocused.getUnitShow());
		kpis.setValidMax(kpiList.getValidMax());
		kpis.setValidMin(kpiList.getValidMin());
		Boolean isLast = kpis.getPrevCycle() == 1;
		Calendar cal = Calendar.getInstance();
		CycKindType cyckindType = CycKindType.parse(kpis.getCycKind());
		String cycValue = "";
		switch (cyckindType) {
			case TYPE_YEAR :
				if (isLast) {
					cal.add(Calendar.YEAR, -1);
				}
				break;
			case TYPE_MONTH :
				if (isLast) {
					cal.add(Calendar.MONTH, -1);
				}
				break;
			case TYPE_DAY :
				if (isLast) {
					cal.add(Calendar.DAY_OF_MONTH, -1);
				}
				break;
		}
		cycValue = getCycValue(cyckindType, cal.getTime());
		kpis.setCycValue(cycValue);
		KpiRecord kpiRecord = kpiDao.findKpiRecord(orgId, kpiId, cycValue);
		if (kpiRecord != null) {
			kpis.setKpiValue(kpiRecord.getKpiValue());
		}
		FocusKpiValueVO kpiValue = getkpiFocusValue(kpis);
		result.success(kpiValue);
		return result;
	}

	private FocusKpiValueVO getkpiFocusValue(KpiFocusedValue kpis) {
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		Date readTime = kpis.getReadTime();
		FocusKpiValueVO kpiValue = new FocusKpiValueVO();
		BeanUtils.copyProperties(kpis, kpiValue);
		kpiValue.setOrgName(""); // 组织名称
		kpiValue.setTotleValue(new BigDecimal(0));
		if (kpis.getOrgShow().equals(ZcarezeConstant.YES)) {
			String orgName = kpis.getOrgName();
			if (StringUtils.isEmpty(orgName)) {
				orgName = KpiConstants.ORG_GLOBAL;
			}
			kpiValue.setOrgName(orgName);
		}
		if (kpis.getUnitShow().equals(ZcarezeConstant.YES)) {
			kpiValue.setUnit(kpis.getUnit());
		}
		Boolean isLast = kpis.getPrevCycle() == 1;
		String cycValue = kpis.getCycValue();
		String cycValueShow = "";
		Date cycDate = now;
		Integer count = 5;
		CycKindType cyckindType = CycKindType.parse(kpis.getCycKind());
		switch (cyckindType) {
			case TYPE_YEAR :
				cycDate = DateUtil.convertStringToDate(cycValue);
				cycValueShow = isLast ? "去年" : "今年";
				count = 5;
				break;
			case TYPE_MONTH :
				cycDate = DateUtil.convertStringToDate(cycValue);
				cycValueShow = isLast ? "上月" : "本月";
				count = 10;
				break;
			case TYPE_DAY :
				cycDate = DateUtil.convertStringToDate(cycValue);
				cycValueShow = isLast ? "昨天" : "今天";
				count = 10;
				break;
		}
		if (readTime == null || readTime.before(cycDate)) {
			kpiValue.setNoRead(true);
		} else {
			kpiValue.setNoRead(false);
		}
		if (kpis.getCycShow() == ZcarezeConstant.YES) {
			kpiValue.setCycValue(cycValueShow);
		}
		KpiPatternType patternType = KpiPatternType.parse(kpis.getPattern());
		kpiValue.setPattern(patternType.getCode());
		KpiChartType chartType = KpiChartType.parse(kpis.getChart(), kpis.getPattern());
		kpiValue.setChart(chartType.getCode());
		Map<String, BigDecimal> values = new HashMap<String, BigDecimal>();
		// 柱状图,饼图,折线图数据处理
		switch (patternType) {
			case CHART_ORG :
				String childKpiId = kpis.getSplitId();
				List<KpiRecord> kpiRecords = kpiDao.findKpiRecordListByCycValue(childKpiId, cycValue);
				for (KpiRecord kpiRecord : kpiRecords) {
					String orgName = kpiRecord.getOrgName();
					if (!StringUtils.isEmpty(orgName)) {
						values.put(orgName, kpiRecord.getKpiValue());
					}
				}
				kpiValue.setTotleValue(kpis.getKpiValue());
				break;
			case CHART_TREND :
				List<KpiRecord> kpiRecords2 = kpiDao.findKpiRecordListByOrg(kpis.getKpiId(), kpis.getOrgId(), 0, count);
				for (int i = kpiRecords2.size() - 1; i >= 0; i--) {
					KpiRecord kpiRecord = kpiRecords2.get(i);
					// 未审核的数据不显示
					if (kpiRecord.getAdAudit() != null && kpiRecord.getAdAudit().equals(ZcarezeConstant.YES)
							&& kpiRecord.getAuditTime() == null) {
						continue;
					}
					values.put(kpiRecord.getCycValue(), kpiRecord.getKpiValue());
				}
				kpiValue.setTotleValue(kpis.getKpiValue());
				break;
			case ONE_CHART :
				List<KpiRating> kpiRatings = kpiDao.findKpiRatingList(kpis.getKpiId());
				List<KpiRatingVO> kpiratingVOs = new LinkedList<KpiRatingVO>();
				BigDecimal validMax = kpis.getValidMax();
				for (KpiRating kpiRating : kpiRatings) {
					KpiRatingVO vo = new KpiRatingVO();
					BeanUtils.copyProperties(kpiRating, vo);
					if (vo.getBoundary() == null) {
						vo.setBoundary(kpis.getValidMax());
					} else {
						if (validMax == null || validMax.compareTo(vo.getBoundary()) < 0) {
							validMax = vo.getBoundary();
						}
					}
					kpiratingVOs.add(vo);
				}
				kpiValue.setValidMax(validMax);
				kpiValue.setKpiRatings(kpiratingVOs);
			case ONE_LABEL :
				kpiValue.setKpiValue(kpis.getKpiValue());
				break;
			case CHART_PLOY :
				List<KpiPloyValue> kpiRecord3 = kpiDao.findKpiRecordListForPloy(kpis.getKpiId(), kpis.getOrgId(),
						cycValue, kpis.getPloyDim());
				if (chartType == KpiChartType.CHART_EXP_RADAR) {
					String jsonString = JsonUtils.toJSONString(kpiRecord3);
					kpiValue.setKpiJsonValue(jsonString);
				} else {
					for (KpiPloyValue kpiRecord : kpiRecord3) {
						String kpiName = kpiRecord.getKpiName();
						if (!StringUtils.isEmpty(kpiName)) {
							values.put(kpiName, kpiRecord.getKpiValue());
						}
					}
				}
				kpiValue.setTotleValue(kpis.getKpiValue());
				break;
		}
		if (!values.isEmpty()) {
			String jsonValue = "";
			jsonValue = JsonUtils.toJSONString(values);
			kpiValue.setKpiJsonValue(jsonValue);
		}
		return kpiValue;
	}

	/**
	 * 我有权限的指标列表
	 * 
	 * @param pageNow
	 * @param pageSize
	 * @param cycKinds
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月15日 下午8:12:24
	 */
	@Override
	public GrantKpiResult getMyGrantKpis(List<String> cycKinds, Integer pageNow, Integer pageSize) {
		GrantKpiResult result = new GrantKpiResult();
		List<GrantKpiValueVO> kpiValues = new LinkedList<GrantKpiValueVO>();
		// 云管管理人员
		boolean isAdmin = ApplicationCacheUtils.getLoginManager();
		String staffId = ApplicationCacheUtils.getStaffId();
		Date now = new Date();
		long startTime = System.currentTimeMillis();// 记录开始时间
		List<KpiFocused> kpiFocusList = kpiDao.findKpiFocusByStaffId(staffId);
		HashMap<String, String> orgNameCache = new HashMap<>();
		HashMap<String, String> cycValueMap = new HashMap<>();
		Integer yearCycKind = ZcarezeConstant.NO;
		Integer monthCycKind = ZcarezeConstant.NO;
		Integer dayCycKind = ZcarezeConstant.NO;
		for (String cycKind : cycKinds) {
			CycKindType kindType = CycKindType.parse(cycKind);
			String cycValue = getCycValue(kindType, now);
			if (!cycValueMap.containsKey(cycKind)) {
				cycValueMap.put(cycKind, cycValue);
			}
			switch (kindType) {
				case TYPE_DAY :
					dayCycKind = ZcarezeConstant.YES;
					break;
				case TYPE_MONTH :
					monthCycKind = ZcarezeConstant.YES;
					break;
				case TYPE_YEAR :
					yearCycKind = ZcarezeConstant.YES;
					break;
			}
		}

		List<GrantKpiValue> grantKpiValues = new LinkedList<GrantKpiValue>();
		if (isAdmin) {
			grantKpiValues = kpiDao.findGrantKpiValueListForManager(yearCycKind, monthCycKind, dayCycKind, staffId,
					pageNow, pageSize);
		} else {
			grantKpiValues = kpiDao.findGrantKpiValueList(yearCycKind, monthCycKind, dayCycKind, staffId, pageNow,
					pageSize);
		}
		grantKpiValues.sort(new Comparator<GrantKpiValue>() {
			public int compare(GrantKpiValue arg0, GrantKpiValue arg1) {
				return arg0.getOrgLayer().compareTo(arg1.getOrgLayer());
			}
		});
		long endTime = System.currentTimeMillis();// 记录结束时间
		float excTime = (float) (endTime - startTime);
		LOGGER.info("取数据时间：" + excTime + "ms");
		for (GrantKpiValue grantKpiValue : grantKpiValues) {
			GrantKpiValueVO grantKpiValueVO = new GrantKpiValueVO();
			BeanUtils.copyProperties(grantKpiValue, grantKpiValueVO);
			grantKpiValueVO.setUsually(false);
			if (StringUtils.isEmpty(grantKpiValueVO.getCycValue())) {
				String cycKind = grantKpiValueVO.getCycKind();
				if (cycValueMap.containsKey(cycKind)) {
					grantKpiValueVO.setCycValue(cycValueMap.get(cycKind));
				}
			}
			String orgKey = grantKpiValue.getOrgId() + "-" + grantKpiValue.getOrgLayer();
			if (!orgNameCache.containsKey(orgKey)) {
				// 处理组织名称
				String orgName = getOrgName(grantKpiValue.getOrgId(), grantKpiValue.getOrgLayer(), true, false);
				orgNameCache.put(orgKey, orgName);
			}
			// 处理组织名称
			// String orgName = getOrgName(grantKpiValue.getOrgId(),
			// grantKpiValue.getOrgLayer(), true, false);
			grantKpiValueVO.setOrgName(orgNameCache.get(orgKey));
			// 处理个人收藏情况
			for (KpiFocused kpiFocused : kpiFocusList) {
				if (grantKpiValue.getKpiId().equals(kpiFocused.getKpiId())) {
					// 全域指标或者组织Id存在则被收藏了
					if (grantKpiValue.getOrgLayer().equals(OrgLayerEnum.GLOBAL.getCode())
							|| (grantKpiValue.getOrgId() != null && kpiFocused.getOrgId() != null
									&& grantKpiValue.getOrgId().equals(kpiFocused.getOrgId()))) {
						grantKpiValueVO.setUsually(true);
						break;
					}
				}
			}
			kpiValues.add(grantKpiValueVO);
		}

		endTime = System.currentTimeMillis();// 记录结束时间
		excTime = (float) (endTime - startTime);
		LOGGER.info("处理组织机构名称耗时：" + excTime + "ms");

		endTime = System.currentTimeMillis();// 记录结束时间
		excTime = (float) (endTime - startTime);
		LOGGER.info("共耗时：" + excTime + "ms");
		result.success(kpiValues);
		return result;
	}

	/**
	 * 我有管理权限的指标列表
	 * 
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午4:56:08
	 */
	public KpiManageResult getMyManageKpis(String orgId, Integer pageNow, Integer pageSize) {
		KpiManageResult result = new KpiManageResult();
		Integer pageStart = pageNow * pageSize;
		if (pageStart <= 0) {
			pageStart = 0;
		}
		List<KpiManageVO> kpiManages = new ArrayList<KpiManageVO>();
		List<KpiGrantToManageList> allKpiGrants = kpiDao.findKpiGrantToManageByOrgId(orgId);
		kpiManages = dealKpiGrantTo(allKpiGrants);
		// kpiManages.sort(new Comparator<KpiManageVO>() {
		// public int compare(KpiManageVO arg0, KpiManageVO arg1) {
		// return arg0.getOrgLayer().compareTo(arg1.getOrgLayer());
		// }
		// });
		result.success(kpiManages);
		return result;
	}

	private List<KpiManageVO> dealKpiGrantTo(List<KpiGrantToManageList> allKpiGrants) {
		List<String> existKeys = new ArrayList<String>();
		List<KpiManageVO> kpiManages = new ArrayList<KpiManageVO>();
		for (KpiGrantToManageList kpiGrantToManageList : allKpiGrants) {
			String orgId = kpiGrantToManageList.getOrgId();
			if (StringUtils.isEmpty(orgId)) // 为空表示还未授权
			{
				KpiManageVO noGrantKpi = new KpiManageVO();
				noGrantKpi.setKpiId(kpiGrantToManageList.getKpiId());
				noGrantKpi.setName(kpiGrantToManageList.getKpiTitle());
				List<KpiGrantToVO> kpiGrantToVOs = new ArrayList<KpiGrantToVO>();
				noGrantKpi.setKpiGrantTos(kpiGrantToVOs);
				noGrantKpi.setOrgId(orgId);
				noGrantKpi.setOrgLayer(kpiGrantToManageList.getOrgLayer());
				noGrantKpi.setOrgName(KpiConstants.ORG_NOGRANT);
				kpiManages.add(noGrantKpi);
				existKeys.add(kpiGrantToManageList.getKpiId());
				continue;
			}
			String kpiId = kpiGrantToManageList.getKpiId();
			if (existKeys.contains(kpiId)) {
				continue;
			}
			KpiManageVO rootGrantKpi = new KpiManageVO();
			rootGrantKpi.setKpiId(kpiId);
			rootGrantKpi.setName(kpiGrantToManageList.getKpiTitle());
			rootGrantKpi.setOrgId("");
			rootGrantKpi.setOrgLayer(kpiGrantToManageList.getOrgLayer());
			rootGrantKpi.setOrgName("");
			List<KpiGrantToVO> kpiGrantToVOs = new ArrayList<KpiGrantToVO>();
			for (KpiGrantToManageList kpiGrantTo : allKpiGrants) {
				String kpiId2 = kpiGrantTo.getKpiId();
				if (!kpiId2.equals(kpiId)) {
					continue;
				}
				KpiGrantToVO kpiGrantToVO = new KpiGrantToVO();
				String OrgName = getOrgName(kpiGrantTo.getOrgId(), 4, true, true);
				kpiGrantToVO.setOrgName(OrgName);
				kpiGrantToVO.setInput(kpiGrantTo.getInput());
				kpiGrantToVO.setKpiId(kpiId2);
				kpiGrantToVO.setManage(kpiGrantTo.getManage());
				kpiGrantToVO.setOrgId(kpiGrantTo.getOrgId());
				kpiGrantToVO.setRoles(kpiGrantTo.getRoles());
				kpiGrantToVOs.add(kpiGrantToVO);
			}
			rootGrantKpi.setKpiGrantTos(kpiGrantToVOs);
			kpiManages.add(rootGrantKpi);
			existKeys.add(kpiId);
		}
		return kpiManages;
	}

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
	@Override
	public KpiDetailValueResult getKpiDetailValue(String kpiId, String orgId, Integer rowNum) {
		KpiDetailValueResult result = new KpiDetailValueResult();
		KpiDetailValueVO kpiDetailValue = new KpiDetailValueVO();
		String staffId = ApplicationCacheUtils.getStaffId();
		Boolean isOrgAdmin = false;
		KpiList kpiInfo = kpiDao.findKpiListById(kpiId);
		// 云管管理人员
		boolean isAdmin = ApplicationCacheUtils.getLoginManager();
		Integer input = ZcarezeConstant.NO;
		if (isAdmin) {
			isOrgAdmin = true;
			input = ZcarezeConstant.YES;
		} else {
			String temOrgId = orgId;
			// orgId为空,则判断是否为机构管理员，机构管理员可以审核
			if (StringUtils.isEmpty(orgId) && kpiInfo.getOrgLayer().equals(OrgLayerEnum.GLOBAL.getCode())) {
				temOrgId = ApplicationCacheUtils.getDefaultOrg();
			}
			BaseResult<OrgMembers> orgMemBerresult = orgService.checkStaffManagerJobByStaffIdAndOrgId(staffId,
					temOrgId);
			if (orgMemBerresult != null && orgMemBerresult.getOne() != null) {
				isOrgAdmin = true;
			}
			KpiGrantTo kpiGrantTo = kpiDao.findKpiGrantToByStaff(kpiId, orgId, staffId);
			if (kpiGrantTo != null) {
				input = kpiGrantTo.getInput();
			}
		}
		Boolean lpFlag = kpiInfo.getLpFlag() == null ? false : kpiInfo.getLpFlag().equals(ZcarezeConstant.YES);
		Boolean spFlag = kpiInfo.getSpFlag() == null ? false : kpiInfo.getSpFlag().equals(ZcarezeConstant.YES);
		CycKindType kindType = CycKindType.parse(kpiInfo.getCycKind());
		Integer fetchRowNum = rowNum;
		// 月周期,为计算环比和同比,最少需要得到12个数据
		if (kindType == CycKindType.TYPE_MONTH && fetchRowNum < 12) {
			fetchRowNum = 12;
		}
		// 明细数据處理
		KpiRowValueVO lastRecord = null;
		List<KpiRowValueVO> rowValues = null;
		if (input.equals(ZcarezeConstant.YES)) {
			rowValues = getKpiRowValuesForInput(kpiId, orgId, input, isOrgAdmin, kindType, 0, fetchRowNum);
		} else {
			rowValues = getKpiRowValuesForView(kpiId, orgId, isOrgAdmin, 0, fetchRowNum);
		}
		if (rowValues != null) {
			for (KpiRowValueVO kpiRowValueVO : rowValues) {
				if (kpiRowValueVO.getAuditState().equals(0)) {
					continue;
				}
				if (lastRecord == null || lastRecord.getCycValue().compareTo(kpiRowValueVO.getCycValue()) < 0) {
					lastRecord = kpiRowValueVO;
				}
			}
		}
		if (lastRecord != null) {
			String cycValue = lastRecord.getCycValue();
			kpiDetailValue.setCycValue(cycValue);
			kpiDetailValue.setKpiValue(lastRecord.getKpiValue());
			kpiDetailValue.setAuditState(lastRecord.getAuditState());
			// 同比环比比较
			if (lpFlag) {
				String lpCycValue = getLpCycValue(kindType, cycValue);
				kpiDetailValue.setLpValue(getKpiValueForlpsp(lpCycValue, rowValues));
			}
			if (spFlag) {
				String spCycValue = getSpCycValue(kindType, cycValue);
				kpiDetailValue.setSpValue(getKpiValueForlpsp(spCycValue, rowValues));
			}
		} else {
			kpiDetailValue.setCycValue(getCycValue(kindType, new Date()));
		}
		List<KpiReport> reports = kpiDao.findKpiReportByKpiId(kpiId);
		if (reports != null && reports.size() > 0) {
			List<KpiReportVO> reportVOs = new ArrayList<KpiReportVO>();
			for (KpiReport kpiReport : reports) {
				KpiReportVO kpiReportVO = new KpiReportVO();
				BeanUtils.copyProperties(kpiReport, kpiReportVO);
				long timeLong = kpiReport.getEditTime().getTime();
				kpiReportVO.setUpdateTime(timeLong);
				reportVOs.add(kpiReportVO);
			}
			kpiDetailValue.setReports(reportVOs);
		}
		kpiDetailValue.setOrgId(orgId);
		String orgName = getOrgName(orgId, kpiInfo.getOrgLayer(), true, false);
		kpiDetailValue.setOrgName(orgName);
		kpiDetailValue.setCycKind(kindType.getName());
		kpiDetailValue.setInput(input);
		kpiDetailValue.setKpiId(kpiId);
		if (isOrgAdmin) {
			kpiDetailValue.setAudit(ZcarezeConstant.YES);
		} else {
			kpiDetailValue.setAudit(ZcarezeConstant.NO);
		}
		kpiDetailValue.setSplitId(kpiInfo.getSplitId());
		kpiDetailValue.setKpiTitle(kpiInfo.getName());
		kpiDetailValue.setUnit(kpiInfo.getUnit());
		// 倒序排列
		List<KpiRowValueVO> fetchRows = new LinkedList<KpiRowValueVO>();
		Integer fetchRowCount = rowNum;
		if (fetchRowCount > rowValues.size()) {
			fetchRowCount = rowValues.size();
		}
		for (int i = fetchRowCount - 1; i >= 0; i--) {
			fetchRows.add(rowValues.get(i));
		}
		kpiDetailValue.setRowValues(fetchRows);

		List<KpiPloyInfo> ployKpiList = kpiDao.findKpiListPloy(kpiId);
		if (ployKpiList != null && ployKpiList.size() > 0) {
			List<String> ployDim = new ArrayList<>();
			for (KpiPloyInfo ployInfo : ployKpiList) {
				if (StringUtils.isEmpty(ployInfo.getPloyDim())) {
					continue;
				}
				if (!ployDim.contains(ployInfo.getPloyDim())) {
					ployDim.add(ployInfo.getPloyDim());
				}
			}
			kpiDetailValue.setPloyDims(ployDim);
		}
		result.success(kpiDetailValue);
		return result;
	}

	/**
	 * 获取指标数据 (用于历史数据查询)
	 * 
	 * @param kpiId
	 * @param orgId
	 * @param pageNow
	 * @param pageSize
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午3:17:52
	 */
	@Override
	public KpiRowValueResult getKpiRowValues(KpiRowValueParam rowValueParam) {
		KpiRowValueResult result = new KpiRowValueResult();
		if (rowValueParam == null) {
			result.failure(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
			return result;
		}
		if (ValidatorUtil.isEmpty(rowValueParam.getKpiId(), rowValueParam.getKpiId())) {
			result.failure(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
			return result;
		}
		String kpiId = rowValueParam.getKpiId();
		String orgId = rowValueParam.getOrgId();
		Integer pageNow = rowValueParam.getPageNow();
		Integer pageSize = rowValueParam.getPageSize();
		Integer input = rowValueParam.getInput();
		if (input == null) {
			input = ZcarezeConstant.NO;
		}
		String cycKind = rowValueParam.getCycKind();
		if (ValidatorUtil.isEmpty(kpiId, cycKind)) {
			result.failure(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
			return result;
		}
		CycKindType kindType = CycKindType.parse(cycKind);
		String staffId = ApplicationCacheUtils.getStaffId();
		List<KpiRowValueVO> rowValues = null;
		Boolean isOrgAdmin = false;
		// 云管管理人员
		boolean isAdmin = ApplicationCacheUtils.getLoginManager();
		if (isAdmin) {
			isOrgAdmin = true;
			input = ZcarezeConstant.YES;
		} else {
			BaseResult<OrgMembers> orgMemBerresult = orgService.checkStaffManagerJobByStaffIdAndOrgId(staffId, orgId);
			if (orgMemBerresult != null && orgMemBerresult.getOne() != null) {
				isOrgAdmin = true;
			}
		}
		if (input.equals(ZcarezeConstant.YES)) {
			rowValues = getKpiRowValuesForInput(kpiId, orgId, input, isOrgAdmin, kindType, pageNow, pageSize);
		} else {
			rowValues = getKpiRowValuesForView(kpiId, orgId, isOrgAdmin, pageNow, pageSize);
		}
		// 倒序排列
		List<KpiRowValueVO> fetchRows = new LinkedList<KpiRowValueVO>();
		Integer fetchRowCount = pageSize;
		if (fetchRowCount > rowValues.size()) {
			fetchRowCount = rowValues.size();
		}
		for (int i = 0; i < fetchRowCount; i++) {
			fetchRows.add(rowValues.get(i));
		}
		result.success(fetchRows);
		return result;
	}

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
	public KpiSplitValueResult getKpiSplitValue(KpiSplitValueParam splitParam) {
		KpiSplitValueResult result = new KpiSplitValueResult();
		List<KpiSplitValueVO> splitValues = new LinkedList<KpiSplitValueVO>();
		if (splitParam == null) {
			result.failure(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
			return result;
		}
		String kpiId = splitParam.getSplitKpiId();
		String cycValue = splitParam.getCycValue();
		if (ValidatorUtil.isEmpty(kpiId, cycValue)) {
			result.failure(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
			return result;
		}
		List<KpiRecord> kpiRecords = kpiDao.findKpiRecordListByCycValue(kpiId, cycValue);
		for (KpiRecord kpiRecord : kpiRecords) {
			String cOrgId = kpiRecord.getOrgId();
			String cOrgName = kpiRecord.getOrgName(); // 得到组织机构名称
			splitValues.add(new KpiSplitValueVO(cOrgId, cOrgName, kpiRecord.getKpiValue()));
		}
		result.success(splitValues);
		return result;
	}

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
	public BaseResult<KpiPloyValue> getKpiPloyValue(KpiPloyValueParam ployParam) {
		BaseResult<KpiPloyValue> result = new BaseResult<>();
		List<KpiPloyValue> kpiRecord3 = kpiDao.findKpiRecordListForPloy(ployParam.getKpiId(), ployParam.getOrgId(),
				ployParam.getCycValue(), ployParam.getPloyDim());
		result.success(kpiRecord3);
		return result;
	}

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
	public KpiRptInputResult getKpiRptInputs(String kpiId, String reportId) {
		KpiRptInputResult result = new KpiRptInputResult();
		if (ValidatorUtil.isEmpty(kpiId, reportId)) {
			result.failure(ResultEnum.PARAM_ERROR, KpiResultMessage.BASEREPORTPARAMEMPTY);
			return result;
		}
		List<KpiRptInputVO> inputVOs = new ArrayList<KpiRptInputVO>();
		List<KpiRptInput> inputs = kpiDao.findKpiReportInputs(kpiId, reportId);
		for (KpiRptInput kpiRptInput : inputs) {
			KpiRptInputVO vo = new KpiRptInputVO();
			BeanUtils.copyProperties(kpiRptInput, vo);
			inputVOs.add(vo);
		}
		result.success(inputVOs);
		return result;
	}

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
	public KpiCopyResult copyKpiList(String kpiId, List<String> cloudIds) {
		KpiCopyResult result = new KpiCopyResult();
		if (cloudIds == null || cloudIds.size() <= 0) {
			result.setCode(ResultEnum.PARAM_ERROR.getCode());
			result.setErrorCode(KpiResultMessage.COPYCLOUDEMPTY);
			return result;
		}
		KpiList kpiList = kpiDao.findKpiListById(kpiId);
		List<KpiRating> kpiRatings = kpiDao.findKpiRatingList(kpiId);
		List<String> errorCloudIds = new ArrayList<String>();
		for (String cloudId : cloudIds) {
			ThreadUtils.setCloudId(cloudId);
			try {
				// 指标是否已经存在
				KpiList existKpi = kpiDao.findKpiListById(kpiId);
				TransactionManager.beginTransaction();
				kpiList.setEditTime(new Date());
				if (existKpi == null) {
					kpiDao.addKpiList(kpiList);
				} else {
					kpiDao.editKpiList(existKpi);
				}
				List<KpiRating> existRatings = kpiDao.findKpiRatingList(kpiId);
				for (KpiRating kpiRating : existRatings) {
					kpiDao.deleteKpiRating(kpiRating.getKpiId(), kpiRating.getSeqNo());
				}
				for (KpiRating kpiRating : kpiRatings) {
					kpiDao.addKpiRating(kpiRating);
				}
				TransactionManager.commit();
			} catch (DataSourceException ex) {
				LOGGER.error("同步指标出错:" + ex.getMessage(), ex);
				TransactionManager.rollBack();
				errorCloudIds.add(cloudId);
			}
		}
		if (errorCloudIds != null && errorCloudIds.size() > 0) {
			result.setErrorCloudIds(errorCloudIds);
		}
		return result;
	}

	/**
	 * 得到組織名稱
	 * 
	 * @param orgId
	 * @param orgLayer
	 *            0-全域;1-机构;2-科室;3-医生团队
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月19日 上午10:05:25
	 */
	private String getOrgName(String orgId, Integer orgLayer, Boolean isFullName, boolean isAdmin) {
		// 全域
		if (orgLayer.equals(OrgLayerEnum.GLOBAL.getCode())) {
			return KpiConstants.ORG_GLOBAL;
		}
		// 不是全域指标同时组织Id为空(只有云管账号登录才可能出现这个情况)
		// （或者数据错误）
		if (!orgLayer.equals(OrgLayerEnum.GLOBAL.getCode()) && StringUtils.isEmpty(orgId)) {
			if (isAdmin) {
				return KpiConstants.ORG_NOGRANT;
			} else {
				return "";
			}
		}
		if (!StringUtils.isEmpty(orgId)) {
			if (isFullName) {
				BaseResult<OrgList> parOrgList = orgService.getParentOrgTreeByOrgId(orgId);
				String orgName = "";
				if (parOrgList.getLists().size() > 0) {
					orgName = parOrgList.getLists().get(0).getName();
					for (int i = 1; i < parOrgList.getLists().size(); i++) {
						OrgList orgList = parOrgList.getLists().get(i);
						orgName = orgName + KpiConstants.ORG_JOIN + orgList.getName();
					}
				}
				return orgName;
			} else {
				OrgListResult orglistResult = orgService.getOrgListById(orgId);
				if (orglistResult != null && orglistResult.getOne() != null) {
					OrgList orglist = orglistResult.getOne();
					return orglist.getName();
				}
			}
		}
		return "";
	}

	private List<KpiRowValueVO> getKpiRowValuesForView(String kpiId, String orgId, Boolean isOrgAdmin, Integer pageNow,
			Integer pageSize) {
		Integer pageStart = pageNow * pageSize;
		if (pageStart <= 0) {
			pageStart = 0;
		}
		List<KpiRecord> kpiRecords = kpiDao.findKpiRecordListByOrg(kpiId, orgId, pageStart, pageSize);
		List<KpiRowValueVO> rowValues = convertRowValue(false, isOrgAdmin, kpiRecords);
		return rowValues;
	}

	private List<KpiRowValueVO> getKpiRowValuesForInput(String kpiId, String orgId, Integer input, Boolean isOrgAdmin,
			CycKindType kindType, Integer pageStart, Integer pageSize) {
		Integer preDateNum = pageStart * pageSize;
		List<String> cycValueList = new LinkedList<String>();
		String beginInputCycValue = "";
		switch (kindType) {
			case TYPE_DAY :
				for (int i = 0; i < pageSize; i++) {
					Calendar dayCal = Calendar.getInstance();
					dayCal.add(Calendar.DAY_OF_MONTH, -(preDateNum + i));
					String tday = getCycValue(kindType, dayCal.getTime());
					cycValueList.add(tday);
				}
				Calendar currDayCal = Calendar.getInstance();
				currDayCal.add(Calendar.DAY_OF_MONTH, -2);
				beginInputCycValue = getCycValue(kindType, currDayCal.getTime());
				break;
			case TYPE_MONTH :
				for (int i = 0; i < pageSize; i++) {
					Calendar dayCal = Calendar.getInstance();
					dayCal.add(Calendar.MONTH, -(preDateNum + i));
					String tmonth = getCycValue(kindType, dayCal.getTime());
					cycValueList.add(tmonth);
				}
				Calendar currMonthCal = Calendar.getInstance();
				currMonthCal.add(Calendar.MONTH, -2);
				beginInputCycValue = getCycValue(kindType, currMonthCal.getTime());
				break;
			case TYPE_YEAR :
				for (int i = 0; i < pageSize; i++) {
					Calendar dayCal = Calendar.getInstance();
					dayCal.add(Calendar.YEAR, -(preDateNum + i));
					String tyear = getCycValue(kindType, dayCal.getTime());
					cycValueList.add(tyear);
				}
				Calendar currYearCal = Calendar.getInstance();
				currYearCal.add(Calendar.YEAR, -2);
				beginInputCycValue = getCycValue(kindType, currYearCal.getTime());
				break;
		}
		String maxValue = cycValueList.get(0);
		String minValue = cycValueList.get(cycValueList.size() - 1);
		List<KpiRecord> kpiRecords = kpiDao.findKpiRecordListByInterval(kpiId, orgId, minValue, maxValue);
		List<KpiRowValueVO> rowValues = convertRowValue(true, isOrgAdmin, kpiRecords);
		List<KpiRowValueVO> inputRowValues = new LinkedList<KpiRowValueVO>();
		for (String cycValue : cycValueList) {
			KpiRowValueVO rowValue = null;
			for (KpiRowValueVO kpiRowValueVO : rowValues) {
				if (kpiRowValueVO.getCycValue().equals(cycValue)) {
					{
						rowValue = kpiRowValueVO;
						break;
					}
				}
			}
			if (rowValue == null) {
				// 转换成数字进行比较
				if (Integer.parseInt(cycValue) < Integer.parseInt(beginInputCycValue)) {
					continue;
				}
				rowValue = new KpiRowValueVO();
				rowValue.setCycValue(cycValue);
				rowValue.setId(StringUtils.getUUID());
				rowValue.setAuditState(0);
			}
			inputRowValues.add(rowValue);
		}
		return inputRowValues;
	}

	private List<KpiRowValueVO> convertRowValue(Boolean isInput, Boolean isOrgAdmin, List<KpiRecord> kpiRecords) {
		List<KpiRowValueVO> rowValues = new LinkedList<KpiRowValueVO>();
		for (KpiRecord kpiRecord : kpiRecords) {
			KpiRowValueVO kpiRowValue = new KpiRowValueVO();
			String comment = "";
			Integer auditState = 0;
			// 采集程序得到的数据
			if (StringUtils.isEmpty(kpiRecord.getEditorId())) {
				auditState = 1;
				comment = "(系统自动统计)";
			} else {
				Integer dataAdAudit = kpiRecord.getAdAudit();
				Date auditTime = kpiRecord.getAuditTime();
				// 数据还未审核
				if (auditTime == null) {
					// 沒有輸入權限和審核權限則不顯示
					if (dataAdAudit.equals(ZcarezeConstant.YES) && !isInput && !isOrgAdmin) {
						continue;
					}
					// 判断是否需要审核
					if (dataAdAudit.equals(ZcarezeConstant.NO)) {
						auditState = 3;
					} else {
						auditState = 2;
					}
					comment = "输入：" + kpiRecord.getEditorName() + ","
							+ DateUtil.convertDateToString("MM-dd", kpiRecord.getEditTime());
				} else {
					auditState = 3;
					comment = "审核：" + kpiRecord.getAuditorName() + ","
							+ DateUtil.convertDateToString("MM-dd", kpiRecord.getAuditTime());
				}
			}
			kpiRowValue.setId(kpiRecord.getId());
			kpiRowValue.setAuditState(auditState);
			kpiRowValue.setKpiValue(kpiRecord.getKpiValue());
			kpiRowValue.setComment(comment);
			kpiRowValue.setCycValue(kpiRecord.getCycValue());
			rowValues.add(kpiRowValue);
		}
		return rowValues;
	}

	private String getLpCycValue(CycKindType kindType, String cycValue) {
		String lpCycValue = "";

		Calendar cal = Calendar.getInstance();
		Date CycDate = null;
		switch (kindType) {
			case TYPE_YEAR :
				CycDate = DateUtil.convertStringToDate(cycValue);
				cal.setTime(CycDate);
				cal.add(Calendar.YEAR, -1);
				lpCycValue = getCycValue(kindType, cal.getTime());
				break;
			case TYPE_MONTH :
				CycDate = DateUtil.convertStringToDate(cycValue);
				cal.setTime(CycDate);
				cal.add(Calendar.MONTH, -1);
				lpCycValue = getCycValue(kindType, cal.getTime());
				break;
			default :
				CycDate = DateUtil.convertStringToDate(cycValue);
				cal.setTime(CycDate);
				cal.add(Calendar.DAY_OF_MONTH, -1);
				lpCycValue = getCycValue(kindType, cal.getTime());
				break;
		}
		return lpCycValue;
	}

	private String getSpCycValue(CycKindType kindType, String cycValue) {
		String spCycValue = "";
		Calendar cal = Calendar.getInstance();
		switch (kindType) {
			case TYPE_YEAR :
				break;
			case TYPE_MONTH :
				cal.set(Calendar.DAY_OF_MONTH, 1);
				cal.add(Calendar.YEAR, -1);
				spCycValue = getCycValue(kindType, cal.getTime());
				break;
			default :
				break;
		}
		return spCycValue;
	}

	private String getCycValue(CycKindType cyckindType, Date cycTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(cycTime);
		Integer year = cal.get(Calendar.YEAR);
		Integer month = cal.get(Calendar.MONTH) + 1;
		Integer day = cal.get(Calendar.DAY_OF_MONTH);
		switch (cyckindType) {
			case TYPE_YEAR :
				return String.format("%04d", year);
			case TYPE_MONTH :
				return String.format("%04d", year) + String.format("%02d", month);
			case TYPE_DAY :
				return String.format("%04d", year) + String.format("%02d", month) + String.format("%02d", day);
		}
		return "";
	}

	private boolean rolesIntersect(String roles1, String roles2) {
		String intersect = StringUtils.intersectStr(roles1, roles2, ";");
		return !StringUtils.isEmpty(intersect);
	}

	private BigDecimal getKpiValueForlpsp(String cycValue, List<KpiRowValueVO> rowValues) {
		if (StringUtils.isEmpty(cycValue) || rowValues == null || rowValues.size() == 0) {
			return null;
		}
		for (KpiRowValueVO kpiRowValueVO : rowValues) {
			if (kpiRowValueVO.getAuditState().equals(0)) {
				continue;
			}
			if (kpiRowValueVO.getCycValue().equals(cycValue)) {
				return kpiRowValueVO.getKpiValue();
			}
		}
		return null;
	}

	// #start 经典指标页面

	@CustomTransactional
	public Result saveMyFocusToPage(String title, String comment) {
		KpipageList existPage = kpiDao.findKpipageListByTitle(title);
		if (existPage != null) {
			return Result.paramError(title + "的指标页面已存在");
		}
		String staffId = "";
		KpipageList kpipage = new KpipageList();
		CurrentLoginInfo loginInfo = tokenService.getCurrentLoginInfo();
		if (loginInfo != null) {
			staffId = loginInfo.getStaffId();
			kpipage.setEditorId(staffId);
			kpipage.setEditorName(loginInfo.getStaffName());
		}
		if (StringUtils.isEmpty(staffId)) {
			return Result.paramError("登录职员Id为空");
		}
		List<KpiFocused> kpiFocusedList = kpiDao.findKpiFocusByStaffId(staffId);
		if (kpiFocusedList == null || kpiFocusedList.size() <= 0) {
			return Result.paramError("指标个人主页未设置");
		}

		kpipage.setEditTime(new Date());
		kpipage.setId(StringUtils.getUUID());
		kpipage.setTitle(title);
		kpipage.setComment(comment);
		kpiDao.addKpipageList(kpipage);
		for (KpiFocused kpiFocused : kpiFocusedList) {
			KpiList kpiList = kpiDao.findKpiListById(kpiFocused.getKpiId());
			if (kpiList == null) {
				continue;
			}
			KpipageSet kpipageSet = new KpipageSet();
			BeanUtils.copyProperties(kpiFocused, kpipageSet);
			kpipageSet.setId(StringUtils.getUUID());
			kpipageSet.setPageId(kpipage.getId());
			kpipageSet.setKpiTitle(kpiList.getName());
			kpipageSet.setOrgLayer(kpiList.getOrgLayer());
			kpiDao.addKpipageSet(kpipageSet);
		}
		return Result.success();
	}

	public BaseResult<FocusKpiValueVO> getKpiPageValue(String pageId) {
		BaseResult<FocusKpiValueVO> result = new BaseResult<>();
		List<FocusKpiValueVO> kpiValues = new LinkedList<FocusKpiValueVO>();
		String staffId = "";
		CurrentLoginInfo loginInfo = tokenService.getCurrentLoginInfo();
		if (loginInfo != null) {
			staffId = loginInfo.getStaffId();
		}
		List<KpiFocusedValue> kpiFocus = kpiDao.findKpiPageValue(pageId, staffId);
		for (int i = 0; i < kpiFocus.size(); i++) {
			KpiFocusedValue kpis = kpiFocus.get(i);
			FocusKpiValueVO kpiValue = getkpiFocusValue(kpis);
			kpiValues.add(kpiValue);
		}
		result.success(kpiValues);
		return result;
	}

	public Result addKpipageList(KpipageList kpipage) {
		CurrentLoginInfo loginInfo = tokenService.getCurrentLoginInfo();
		if (loginInfo != null) {
			kpipage.setEditorId(loginInfo.getStaffId());
			kpipage.setEditorName(loginInfo.getStaffName());
		}
		kpipage.setEditTime(new Date());
		kpiDao.addKpipageList(kpipage);
		return Result.success();
	}

	public Result editKpipageList(KpipageList kpipage) {
		CurrentLoginInfo loginInfo = tokenService.getCurrentLoginInfo();
		if (loginInfo != null) {
			kpipage.setEditorId(loginInfo.getStaffId());
			kpipage.setEditorName(loginInfo.getStaffName());
		}
		kpipage.setEditTime(new Date());
		kpiDao.editKpipageList(kpipage);
		return Result.success();
	}

	public Result deleteKpipageList(String id) {
		kpiDao.deleteKpipageList(id);
		return Result.success();
	}

	public BaseResult<KpipageList> getKpipageLists(Integer pageStart, Integer pageSize) {
		BaseResult<KpipageList> result = new BaseResult<>();
		result.success(kpiDao.findKpipageLists(pageStart, pageSize));
		return result;
	}

	public Result addKpipageSet(KpipageSet kpipageSet) {
		kpiDao.addKpipageSet(kpipageSet);
		return Result.success();
	}

	public Result editKpipageSet(KpipageSet kpipageSet) {
		kpiDao.editKpipageSet(kpipageSet);
		return Result.success();
	}

	public Result deleteKpipageSet(String id) {
		kpiDao.deleteKpipageSet(id);
		return Result.success();
	}

	public BaseResult<KpipageSet> getKpipageSetList(String pageId) {
		BaseResult<KpipageSet> result = new BaseResult<>();
		result.success(kpiDao.findKpipageSetList(pageId));
		return result;
	}

	public Result saveKpipageOpenTo(KpipageOpenTo kpipageOpenTo) {
		if (StringUtils.isEmpty(kpipageOpenTo.getId())) {
			kpipageOpenTo.setId(StringUtils.getUUID());
		}
		if (StringUtils.isEmpty(kpipageOpenTo.getOrgTreeId())) {
			kpipageOpenTo.setOrgTreeId(null);
		}
		CurrentLoginInfo loginInfo = tokenService.getCurrentLoginInfo();
		if (loginInfo != null) {
			kpipageOpenTo.setGranter(loginInfo.getStaffName());
		}
		kpipageOpenTo.setGrantTime(new Date());
		kpiDao.saveKpipageOpenTo(kpipageOpenTo);
		return Result.success();
	}

	public Result deleteKpipageOpenTo(String id) {
		kpiDao.deleteKpipageOpenTo(id);
		return Result.success();
	}

	public BaseResult<KpipageOpenTo> getKpipageOpenToList(String pageId) {
		BaseResult<KpipageOpenTo> result = new BaseResult<>();
		result.success(kpiDao.findKpipageOpenToList(pageId));
		return result;
	}

	// #end 经典指标页面
}