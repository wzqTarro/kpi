/**
 * zcareze Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */
package com.zcareze.kpi.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.zcareze.data.dao.ZcarezeBaseDao;
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

/**
 * Kpi信息数据访问
 * 
 * @Filename ReportDao.java
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
 *          <li>Date: 2017年4月10日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
@Repository(value = "kpiDao")
public class KpiDao extends ZcarezeBaseDao {

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
	public void addKpiList(KpiList kpiList) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pid", kpiList.getId());
		mapObj.put("pcode", kpiList.getCode());
		mapObj.put("pname", kpiList.getName());
		mapObj.put("pcomment", kpiList.getComment());
		mapObj.put("punit", kpiList.getUnit());
		mapObj.put("pdataLen", kpiList.getDataLen());
		mapObj.put("pdataDec", kpiList.getDataDec());
		mapObj.put("pcycKind", kpiList.getCycKind());
		mapObj.put("porgLayer", kpiList.getOrgLayer());
		mapObj.put("psplitId", kpiList.getSplitId());
		mapObj.put("padAudit", kpiList.getAdAudit());
		mapObj.put("plpFlag", kpiList.getLpFlag());
		mapObj.put("pspFlag", kpiList.getSpFlag());
		mapObj.put("peditTime", kpiList.getEditTime());
		mapObj.put("peditorId", kpiList.getEditorId());
		mapObj.put("peditorName", kpiList.getEditorName());
		mapObj.put("pvalidMin", kpiList.getValidMin());
		mapObj.put("pvalidMax", kpiList.getValidMax());
		excuteStore("addKpiList", mapObj);
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
	public void editKpiList(KpiList kpiList) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pid", kpiList.getId());
		mapObj.put("pcode", kpiList.getCode());
		mapObj.put("pname", kpiList.getName());
		mapObj.put("pcomment", kpiList.getComment());
		mapObj.put("punit", kpiList.getUnit());
		mapObj.put("pdataLen", kpiList.getDataLen());
		mapObj.put("pdataDec", kpiList.getDataDec());
		mapObj.put("pcycKind", kpiList.getCycKind());
		mapObj.put("porgLayer", kpiList.getOrgLayer());
		mapObj.put("psplitId", kpiList.getSplitId());
		mapObj.put("padAudit", kpiList.getAdAudit());
		mapObj.put("plpFlag", kpiList.getLpFlag());
		mapObj.put("pspFlag", kpiList.getSpFlag());
		mapObj.put("peditTime", kpiList.getEditTime());
		mapObj.put("peditorId", kpiList.getEditorId());
		mapObj.put("peditorName", kpiList.getEditorName());
		mapObj.put("pvalidMin", kpiList.getValidMin());
		mapObj.put("pvalidMax", kpiList.getValidMax());
		excuteStore("editKpiList", mapObj);
	}

	/**
	 * 获取将指定指标作为细分指标的指标列表
	 * 
	 * @param kpiId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年8月28日 下午12:13:11
	 */
	public List<KpiList> findSplitKpiListById(String kpiId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		return excuteStoreListQuery(KpiList.class, "findSplitKpiListById", mapObj);
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
	public void deleteKpiList(String id) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pid", id);
		excuteStore("deleteKpiList", mapObj);
	}

	/**
	 * 更新指标聚合设置
	 * 
	 * @param kpiId
	 * @param ployId
	 * @param ployDim
	 *            <p>
	 *            说明：
	 *            </p>
	 * @author 虾米 by 2018年1月17日 下午5:22:03
	 */
	public void updateKpiListPloy(String kpiId, String ployId, String ployDim) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("ployId", ployId);
		mapObj.put("ployDim", ployDim);
		excuteStore("updateKpiListPloy", mapObj);
	}

	/**
	 * 获取将指定指标设置为了聚合指标的指标基本信息清单
	 * 
	 * @param kpiId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2018年1月17日 下午5:56:56
	 */
	public List<KpiPloyInfo> findKpiListPloy(String kpiId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		return excuteStoreListQuery(KpiPloyInfo.class, "findKpiListPloy", mapObj);
	}

	/**
	 * 获取指标列表清单
	 * 
	 * @param name
	 * @param pageStart
	 * @param pageSize
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年6月14日 下午6:16:21
	 */
	public List<KpiList> findKpiList(String name, Integer orgLayer, Integer pageStart, Integer pageSize) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pname", name);
		mapObj.put("porgLayer", orgLayer);
		mapObj.put("ppageStart", pageStart);
		mapObj.put("ppageSize", pageSize);
		return excuteStoreListQuery(KpiList.class, "findKpiList", mapObj);
	}

	public List<KpiList> findKpiListForPloyByKpiId(String kpiId, String name, Integer pageStart, Integer pageSize) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pname", name);
		mapObj.put("pkpiId", kpiId);
		mapObj.put("ppageStart", pageStart);
		mapObj.put("ppageSize", pageSize);
		return excuteStoreListQuery(KpiList.class, "findKpiListForPloyByKpiId", mapObj);
	}

	public KpiList findKpiListById(String id) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pid", id);
		return excuteStoreQuery(KpiList.class, "findKpiListById", mapObj);
	}

	public KpiList findKpiListByUnique(String name,String code){
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pname", name);
		mapObj.put("pcode", code);
		return excuteStoreQuery(KpiList.class, "findKpiListByUnique", mapObj);
	}
	
	public long countKpiList(String name, Integer orgLayer) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pname", name);
		mapObj.put("porgLayer", orgLayer);
		return excuteStoreCount("countKpiList", mapObj);
	}

	/**
	 * 保存指标适用的机构
	 * 
	 * @param kpiId
	 * @param orgIds
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月11日 下午5:31:28
	 */
	public void saveKpiOrg(String kpiId, String orgIds) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("porgIds", orgIds);
		excuteStore("saveKpiOrg", mapObj);
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
	public void addKpiRating(KpiRating kpiRank) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiRank.getKpiId());
		mapObj.put("pseqNo", kpiRank.getSeqNo());
		mapObj.put("pboundary", kpiRank.getBoundary());
		mapObj.put("pmeaning", kpiRank.getMeaning());
		mapObj.put("pcolor", kpiRank.getColor());
		excuteStore("addKpiRating", mapObj);
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
	public void editKpiRating(KpiRating kpiRank) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiRank.getKpiId());
		mapObj.put("pseqNo", kpiRank.getSeqNo());
		mapObj.put("pboundary", kpiRank.getBoundary());
		mapObj.put("pmeaning", kpiRank.getMeaning());
		mapObj.put("pcolor", kpiRank.getColor());
		excuteStore("editKpiRating", mapObj);
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
	public void deleteKpiRating(String kpiId, Integer seqNo) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("pseqNo", seqNo);
		excuteStore("deleteKpiRating", mapObj);
	}

	public List<KpiRating> findKpiRatingList(String kpiId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		return excuteStoreListQuery(KpiRating.class, "findKpiRatingList", mapObj);
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
	public void addKpiGrantTo(KpiGrantTo kpigrantTo) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpigrantTo.getKpiId());
		mapObj.put("porgId", kpigrantTo.getOrgId());
		mapObj.put("proles", kpigrantTo.getRoles());
		mapObj.put("pmanage", kpigrantTo.getManage());
		mapObj.put("pinput", kpigrantTo.getInput());
		mapObj.put("pgranter", kpigrantTo.getGranter());
		mapObj.put("pgrantTime", kpigrantTo.getGrantTime());
		excuteStore("addKpiGrantTo", mapObj);
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
	public void deleteKpiGrantTo(String kpiId, String orgId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("porgId", orgId);
		excuteStore("deleteKpiGrantTo", mapObj);
	}

	/**
	 * 
	 * @param kpiId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月18日 下午6:57:19
	 */
	public List<KpiGrantTo> findKpiGrantToByKpiId(String kpiId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		return excuteStoreListQuery(KpiGrantTo.class, "findKpiGrantToByKpiId", mapObj);
	}

	/**
	 * 
	 * @param kpiId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月18日 下午6:57:19
	 */
	public List<KpiGrantTo> findKpiGrantToByOrgList(String kpiId, String orgIds) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("porgIds", orgIds);
		return excuteStoreListQuery(KpiGrantTo.class, "findKpiGrantToByOrgList", mapObj);
	}

	public KpiGrantTo findKpiGrantToByStaff(String kpiId, String orgId, String staffId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("porgId", orgId);
		mapObj.put("pstaffId", staffId);
		return excuteStoreQuery(KpiGrantTo.class, "findKpiGrantToByStaff", mapObj);
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
	public void saveKpiRecord(KpiRecord kpiRecord) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pid", kpiRecord.getId());
		mapObj.put("porgId", kpiRecord.getOrgId());
		mapObj.put("pkpiId", kpiRecord.getKpiId());
		mapObj.put("pkpiName", kpiRecord.getKpiName());
		mapObj.put("pkpiUnit", kpiRecord.getKpiUnit());
		mapObj.put("pcycKind", kpiRecord.getCycKind());
		mapObj.put("pcycValue", kpiRecord.getCycValue());
		mapObj.put("pkpiValue", kpiRecord.getKpiValue());
		mapObj.put("peditTime", kpiRecord.getEditTime());
		mapObj.put("peditorId", kpiRecord.getEditorId());
		mapObj.put("peditorName", kpiRecord.getEditorName());
		mapObj.put("pauditTime", kpiRecord.getAuditTime());
		mapObj.put("pauditorName", kpiRecord.getAuditorName());
		mapObj.put("padAudit", kpiRecord.getAdAudit());
		excuteStore("saveKpiRecord", mapObj);
	}

	/**
	 * 稽核指标数据
	 * 
	 * @param kpiData
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月11日 下午5:32:37
	 */
	public void auditKpiRecord(String id, String auditorName, Date auditTime) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pid", id);
		mapObj.put("pauditTime", auditTime);
		mapObj.put("pauditorName", auditorName);
		excuteStore("auditKpiRecord", mapObj);
	}

	/**
	 * 取消稽核
	 * 
	 * @param kipDataId
	 *            <p>
	 *            说明：
	 *            </p>
	 * @author 虾米 by 2017年5月17日 下午3:55:52
	 */
	public void cancelAuditKpiData(String kipDataId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pid", kipDataId);
		excuteStore("cancelAuditKpiData", mapObj);
	}

	/**
	 * 增加关注指标
	 * 
	 * @param kpifocus
	 *            <p>
	 *            说明：
	 *            </p>
	 * @author 虾米 by 2017年5月23日 下午6:12:13
	 */
	public void addKpiFocused(KpiFocused kpifocus) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pid", kpifocus.getId());
		mapObj.put("pkpiId", kpifocus.getKpiId());
		if (StringUtils.isEmpty(kpifocus.getOrgId())) {
			kpifocus.setOrgId(null);
		}
		mapObj.put("porgId", kpifocus.getOrgId());
		mapObj.put("pkpiTitle", kpifocus.getKpiTitle());
		mapObj.put("pstaffId", kpifocus.getStaffId());
		mapObj.put("prowNum", kpifocus.getRowNum());
		mapObj.put("pseqNum", kpifocus.getSeqNum());
		mapObj.put("ppattern", kpifocus.getPattern());
		mapObj.put("pchart", kpifocus.getChart());
		mapObj.put("pployDim", kpifocus.getPloyDim());
		mapObj.put("pprevCycle", kpifocus.getPrevCycle());
		mapObj.put("pcycShow", kpifocus.getCycShow());
		mapObj.put("porgShow", kpifocus.getOrgShow());
		mapObj.put("punitShow", kpifocus.getUnitShow());
		excuteStore("addKpiFocused", mapObj);
	}

	/**
	 * 修改关注指标
	 * 
	 * @param kpifocus
	 *            <p>
	 *            说明：
	 *            </p>
	 * @author 虾米 by 2017年5月23日 下午6:12:13
	 */
	public void editKpiFocused(KpiFocused kpifocus) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pid", kpifocus.getId());
		mapObj.put("pkpiId", kpifocus.getKpiId());
		if (StringUtils.isEmpty(kpifocus.getOrgId())) {
			kpifocus.setOrgId(null);
		}
		mapObj.put("porgId", kpifocus.getOrgId());
		mapObj.put("pkpiTitle", kpifocus.getKpiTitle());
		mapObj.put("pstaffId", kpifocus.getStaffId());
		mapObj.put("prowNum", kpifocus.getRowNum());
		mapObj.put("pseqNum", kpifocus.getSeqNum());
		mapObj.put("ppattern", kpifocus.getPattern());
		mapObj.put("pchart", kpifocus.getChart());
		mapObj.put("pployDim", kpifocus.getPloyDim());
		mapObj.put("pprevCycle", kpifocus.getPrevCycle());
		mapObj.put("pcycShow", kpifocus.getCycShow());
		mapObj.put("porgShow", kpifocus.getOrgShow());
		mapObj.put("punitShow", kpifocus.getUnitShow());
		excuteStore("editKpiFocused", mapObj);
	}

	/**
	 * 调整关注指标顺序
	 * 
	 * @param kpiId
	 * @param orgId
	 * @param staffId
	 *            <p>
	 *            说明：
	 *            </p>
	 * @author 虾米 by 2017年5月23日 下午6:12:23
	 */
	public void updateKpiFocusedOrder(String id, Integer rowNum, Integer seqNum) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pid", id);
		mapObj.put("prowNum", rowNum);
		mapObj.put("pseqNum", seqNum);
		excuteStore("updateKpiFocusedOrder", mapObj);
	}

	/**
	 * 取消关注指标
	 * 
	 * @param kpiId
	 * @param orgId
	 * @param staffId
	 *            <p>
	 *            说明：
	 *            </p>
	 * @author 虾米 by 2017年5月23日 下午6:12:23
	 */
	public void cancelKpiFocused(String id) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pid", id);
		excuteStore("cancelKpiFocused", mapObj);
	}

	/**
	 * 阅读关注指标
	 * 
	 * @param kpiId
	 * @param orgId
	 * @param staffId
	 * @param readTime
	 *            <p>
	 *            说明：
	 *            </p>
	 * @author 虾米 by 2017年5月23日 下午6:12:30
	 */
	public void readKpiFocus(String kpiId, String orgId, String staffId, Date readTime) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("porgId", orgId);
		mapObj.put("pstaffId", staffId);
		mapObj.put("preadTime", readTime);
		excuteStore("readKpiFocused", mapObj);
	}

	/**
	 * 获取指定职员的关注报表
	 * 
	 * @param staffId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月20日 上午11:41:20
	 */
	public List<KpiFocused> findKpiFocusByStaffId(String staffId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pstaffId", staffId);
		return excuteStoreListQuery(KpiFocused.class, "findKpiFocusByStaffId", mapObj);
	}

	/**
	 * 获取指定职员的关注报表（包括报表值）
	 * 
	 * @param staffId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午3:56:04
	 */
	public List<KpiFocusedValue> findKpiFocusValueByStaffId(String staffId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pstaffId", staffId);
		return excuteStoreListQuery(KpiFocusedValue.class, "findKpiFocusValueByStaffId", mapObj);
	}

	/**
	 * 获取指定职员的关注报表(單個指標)
	 * 
	 * @param staffId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午3:56:04
	 */
	public KpiFocused findKpiFocused(String kpiId, String orgId, String staffId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("porgId", orgId);
		mapObj.put("pstaffId", staffId);
		return excuteStoreQuery(KpiFocused.class, "findKpiFocused", mapObj);
	}

	/**
	 * 获取指定组织机构有管理权限的指标列表
	 * 
	 * @param orgId
	 *            为空表示未授权指标
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年6月1日 下午4:46:59
	 */
	public List<KpiGrantToManageList> findKpiGrantToManageByOrgId(String orgId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("porgId", orgId);
		return excuteStoreListQuery(KpiGrantToManageList.class, "findKpiGrantToManageByOrgId", mapObj);
	}

	/**
	 * 获取特定指标数据
	 * 
	 * @param orgId
	 * @param kpiId
	 * @param cycValue
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午3:56:25
	 */
	public KpiRecord findKpiRecord(String orgId, String kpiId, String cycValue) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("porgId", orgId);
		mapObj.put("pkpiId", kpiId);
		mapObj.put("pcycValue", cycValue);
		return excuteStoreQuery(KpiRecord.class, "findKpiRecord", mapObj);
	}

	/**
	 * 获取指定周期的指标数据列表 主要用於獲取下級指標使用
	 * 
	 * @param kpiId
	 * @param cycValue
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午3:56:35
	 */
	public List<KpiRecord> findKpiRecordListByCycValue(String kpiId, String cycValue) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("pcycValue", cycValue);
		return excuteStoreListQuery(KpiRecord.class, "findKpiRecordListByCycValue", mapObj);
	}

	/**
	 * 获取指定指标的聚合数据
	 * 
	 * @param kpiId
	 * @param orgId
	 * @param cycValue
	 * @param ployDim
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2018年1月17日 下午7:13:49
	 */
	public List<KpiPloyValue> findKpiRecordListForPloy(String kpiId, String orgId, String cycValue, String ployDim) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("porgId", orgId);
		mapObj.put("pcycValue", cycValue);
		mapObj.put("pployDim", ployDim);
		return excuteStoreListQuery(KpiPloyValue.class, "findKpiRecordListForPloy", mapObj);
	}

	/**
	 * 获取指定组织机构的指标数据列表
	 * 
	 * @param kpiId
	 * @param orgId
	 * @param pageStart
	 * @param pageSize
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午3:56:53
	 */
	public List<KpiRecord> findKpiRecordListByOrg(String kpiId, String orgId, Integer pageStart, Integer pageSize) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("porgId", orgId);
		mapObj.put("ppageStart", pageStart);
		mapObj.put("ppageSize", pageSize);
		return excuteStoreListQuery(KpiRecord.class, "findKpiRecordListByOrg", mapObj);
	}

	/**
	 * 獲取特定周期區間的指標數據列表
	 * 
	 * @param kpiId
	 * @param orgId
	 * @param minCycValue
	 * @param maxCycValue
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午3:57:44
	 */
	public List<KpiRecord> findKpiRecordListByInterval(String kpiId, String orgId, String minCycValue,
			String maxCycValue) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("porgId", orgId);
		mapObj.put("pminCycValue", minCycValue);
		mapObj.put("pmaxCycValue", maxCycValue);
		return excuteStoreListQuery(KpiRecord.class, "findKpiRecordListByInterval", mapObj);
	}

	/**
	 * 获取特定组织成员有授权的指标列表 用于指标概述列表查询
	 * 
	 * @param orgId
	 * @param roles
	 * @param cycKind
	 * @param cycValue
	 * @param staffId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午3:58:09
	 */
	public List<GrantKpiValue> findGrantKpiValueList(String orgKind, String orgId, String roles, String cycKind,
			String cycValue) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("porgKind", orgKind);
		mapObj.put("porgId", orgId);
		mapObj.put("proles", roles);
		mapObj.put("pcycKind", cycKind);
		mapObj.put("pcycValue", cycValue);
		return excuteStoreListQuery(GrantKpiValue.class, "findGrantKpiValueList", mapObj);
	}

	/**
	 * 获取所有指标信息(云管人员专用)
	 * 
	 * @param orgId
	 * @param roles
	 * @param cycKind
	 * @param cycValue
	 * @param staffId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午3:58:09
	 */
	public List<GrantKpiValue> findGrantKpiValueListForManager(String cycKind, String cycValue) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pcycKind", cycKind);
		mapObj.put("pcycValue", cycValue);
		return excuteStoreListQuery(GrantKpiValue.class, "findGrantKpiValueListForManager", mapObj);
	}
	

	/**
	 * 获取特定组织成员有授权的指标列表 用于指标概述列表查询
	 * 
	 * @param orgId
	 * @param roles
	 * @param cycKind
	 * @param cycValue
	 * @param staffId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午3:58:09
	 */
	public List<GrantKpiValue> findGrantKpiValueList(Integer yearKind, Integer monthKind, Integer dayKind, String staffId,
			Integer pageNow,Integer pageSize) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pyearKind", yearKind);
		mapObj.put("pmonthKind", monthKind);
		mapObj.put("pdayKind", dayKind);
		mapObj.put("pstaffId", staffId);
		mapObj.put("ppageNow", pageNow);
		mapObj.put("ppageSize", pageSize);
		return excuteStoreListQuery(GrantKpiValue.class, "findGrantKpiValueList", mapObj);
	}

	/**
	 * 获取所有指标信息(云管人员专用)
	 * 
	 * @param orgId
	 * @param roles
	 * @param cycKind
	 * @param cycValue
	 * @param staffId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午3:58:09
	 */
	public List<GrantKpiValue> findGrantKpiValueListForManager(Integer yearKind, Integer monthKind, Integer dayKind, String staffId,
			Integer pageNow,Integer pageSize) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pyearKind", yearKind);
		mapObj.put("pmonthKind", monthKind);
		mapObj.put("pdayKind", dayKind);
		mapObj.put("pstaffId", staffId);
		mapObj.put("ppageNow", pageNow);
		mapObj.put("ppageSize", pageSize);
		return excuteStoreListQuery(GrantKpiValue.class, "findGrantKpiValueListForManager", mapObj);
	}

	/**
	 * 获取指定指标可查看的报表清单
	 * 
	 * @param kpiId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年5月17日 下午4:01:05
	 */
	public List<KpiReport> findKpiReportByKpiId(String kpiId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		return excuteStoreListQuery(KpiReport.class, "findKpiReportByKpiId", mapObj);
	}

	public void addKpiReport(KpiReport kpiReport) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiReport.getKpiId());
		mapObj.put("prptId", kpiReport.getReportId());
		mapObj.put("pseqNum", kpiReport.getSeqNum());
		excuteStore("addKpiReport", mapObj);
	}

	public void editKpiReport(KpiReport kpiReport) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiReport.getKpiId());
		mapObj.put("prptId", kpiReport.getReportId());
		mapObj.put("pseqNum", kpiReport.getSeqNum());
		excuteStore("editKpiReport", mapObj);
	}

	public void deleteKpiReport(String kpiId, String reportId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("prptId", reportId);
		excuteStore("deleteKpiReport", mapObj);
	}

	public void addKpiRptInputs(KpiRptInput kpiReport) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiReport.getKpiId());
		mapObj.put("prptId", kpiReport.getRptId());
		mapObj.put("pname", kpiReport.getName());
		mapObj.put("pvalLet", kpiReport.getValLet());
		excuteStore("addKpiRptInputs", mapObj);
	}

	public void editKpiRptInputs(KpiRptInput kpiReport) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiReport.getKpiId());
		mapObj.put("prptId", kpiReport.getRptId());
		mapObj.put("pname", kpiReport.getName());
		mapObj.put("pvalLet", kpiReport.getValLet());
		excuteStore("editKpiRptInputs", mapObj);
	}

	public void deleteKpiRptInputs(String kpiId, String rptId, String name) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("prptId", rptId);
		mapObj.put("pname", name);
		excuteStore("deleteKpiRptInputs", mapObj);
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
	 * @author 虾米 by 2017年5月24日 下午12:12:44
	 */
	public List<KpiRptInput> findKpiReportInputs(String kpiId, String reportId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("prptId", reportId);
		return excuteStoreListQuery(KpiRptInput.class, "findKpiReportInputs", mapObj);
	}

	/**
	 * 检查职员是否对指定指标有权限
	 * 
	 * @param kpiId
	 * @param staffId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2017年6月2日 下午2:42:14
	 */
	public Boolean checkKpiGrantToByStaffId(String kpiId, String staffId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pkpiId", kpiId);
		mapObj.put("pstaffId", staffId);
		return excuteStoreCount("checkKpiGrantToByStaffId", mapObj) > 0;
	}

	// #start 经典指标页面

	public void addKpipageList(KpipageList kpipage) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pId", kpipage.getId());
		mapObj.put("ptitle", kpipage.getTitle());
		mapObj.put("pcomment", kpipage.getComment());
		mapObj.put("peditorId", kpipage.getEditorId());
		mapObj.put("peditorName", kpipage.getEditorName());
		mapObj.put("peditTime", kpipage.getEditTime());
		excuteStore("addKpipageList", mapObj);
	}

	public void editKpipageList(KpipageList kpipage) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pId", kpipage.getId());
		mapObj.put("ptitle", kpipage.getTitle());
		mapObj.put("pcomment", kpipage.getComment());
		mapObj.put("peditorId", kpipage.getEditorId());
		mapObj.put("peditorName", kpipage.getEditorName());
		mapObj.put("peditTime", kpipage.getEditTime());
		excuteStore("editKpipageList", mapObj);
	}

	public void deleteKpipageList(String id) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pId", id);
		excuteStore("deleteKpipageList", mapObj);
	}

	public List<KpipageList> findKpipageLists(Integer pageStart, Integer pageSize) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("ppageStart", pageStart);
		mapObj.put("ppageSize", pageSize);
		return excuteStoreListQuery(KpipageList.class, "findKpipageLists", mapObj);
	}

	public KpipageList findKpipageListByTitle(String title) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("ptitle", title);
		return excuteStoreQuery(KpipageList.class, "findKpipageListByTitle", mapObj);
	}

	public void addKpipageSet(KpipageSet kpipageSet) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pId", kpipageSet.getId());
		mapObj.put("ppageId", kpipageSet.getPageId());
		mapObj.put("pkpiId", kpipageSet.getKpiId());
		if (StringUtils.isEmpty(kpipageSet.getOrgId())) {
			kpipageSet.setOrgId(null);
		}
		mapObj.put("porgId", kpipageSet.getOrgId());
		mapObj.put("pkpiTitle", kpipageSet.getKpiTitle());
		mapObj.put("prowNum", kpipageSet.getRowNum());
		mapObj.put("pseqNum", kpipageSet.getSeqNum());
		mapObj.put("ppattern", kpipageSet.getPattern());
		mapObj.put("pchart", kpipageSet.getChart());
		mapObj.put("pployDim", kpipageSet.getPloyDim());
		mapObj.put("pprevCycle", kpipageSet.getPrevCycle());
		mapObj.put("pcycShow", kpipageSet.getCycShow());
		mapObj.put("porgShow", kpipageSet.getOrgShow());
		mapObj.put("punitShow", kpipageSet.getUnitShow());
		excuteStore("addKpipageSet", mapObj);
	}

	public void editKpipageSet(KpipageSet kpipageSet) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pId", kpipageSet.getId());
		mapObj.put("pkpiId", kpipageSet.getKpiId());
		if (StringUtils.isEmpty(kpipageSet.getOrgId())) {
			kpipageSet.setOrgId(null);
		}
		mapObj.put("porgId", kpipageSet.getOrgId());
		mapObj.put("pkpiTitle", kpipageSet.getKpiTitle());
		mapObj.put("prowNum", kpipageSet.getRowNum());
		mapObj.put("pseqNum", kpipageSet.getSeqNum());
		mapObj.put("ppattern", kpipageSet.getPattern());
		mapObj.put("pchart", kpipageSet.getChart());
		mapObj.put("pployDim", kpipageSet.getPloyDim());
		mapObj.put("pprevCycle", kpipageSet.getPrevCycle());
		mapObj.put("pcycShow", kpipageSet.getCycShow());
		mapObj.put("porgShow", kpipageSet.getOrgShow());
		mapObj.put("punitShow", kpipageSet.getUnitShow());
		excuteStore("editKpipageSet", mapObj);
	}

	public void deleteKpipageSet(String id) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pId", id);
		excuteStore("deleteKpipageSet", mapObj);
	}

	public List<KpipageSet> findKpipageSetList(String pageId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("ppageId", pageId);
		return excuteStoreListQuery(KpipageSet.class, "findKpipageSetList", mapObj);
	}

	public void saveKpipageOpenTo(KpipageOpenTo kpipageOpenTo) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pId", kpipageOpenTo.getId());
		mapObj.put("ppageId", kpipageOpenTo.getPageId());
		mapObj.put("porgTreeLayer", kpipageOpenTo.getOrgTreeLayer());
		mapObj.put("porgTreeId", kpipageOpenTo.getOrgTreeId());
		mapObj.put("proles", kpipageOpenTo.getRoles());
		mapObj.put("pgranter", kpipageOpenTo.getGranter());
		mapObj.put("pgranttime", kpipageOpenTo.getGrantTime());
		excuteStore("saveKpipageOpenTo", mapObj);
	}

	public void deleteKpipageOpenTo(String id) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("pId", id);
		excuteStore("deleteKpipageOpenTo", mapObj);
	}

	public List<KpipageOpenTo> findKpipageOpenToList(String pageId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("ppageId", pageId);
		return excuteStoreListQuery(KpipageOpenTo.class, "findKpipageOpenToList", mapObj);
	}

	/**
	 * 获取经典指标页面的指标数据
	 * 
	 * @param pageId
	 * @param staffId
	 * @return
	 *         <p>
	 *         说明：
	 *         </p>
	 * @author 虾米 by 2018年5月15日 下午12:10:35
	 */
	public List<KpiFocusedValue> findKpiPageValue(String pageId, String staffId) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("ppageId", pageId);
		mapObj.put("pstaffId", staffId);
		return excuteStoreListQuery(KpiFocusedValue.class, "findKpiPageValue", mapObj);
	}

	// #end 经典指标页面
}