/**
 * Zcareze Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.zcareze.kpi.service.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.zcareze.commons.IdStrEntity;

/**
 * 指标目录
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
public class KpiListVO extends IdStrEntity {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -6455761244929136226L;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 
	*/
	private String comment;
	/**
	 * 计算单位
	 */
	private String unit;
	/**
	 * 数据长度
	 */
	private Integer dataLen;
	/**
	 * 小数位数
	 */
	private Integer dataDec;
	/**
	 * 周期种类
	 */
	private String cycKind;
	/**
	 * 组织层次
	 */
	private Integer orgLayer;	
	/**
	 * 有效低值
	 */
	private BigDecimal validMin;
	/**
	 * 有效高值
	 */
	private BigDecimal validMax;
	/**
	 * 细分指标ID
	 */
	private String splitId;
	/**
	 * 细分指标名称
	 */
	private String splitName;
	/**
	 * 聚合指标ID
	 */
	private String	ployId;
	/**
	 * 聚合指标名称
	 */
	private String	ployName;
	/**
	 * 	聚合维度
	 */
	private String ployDim;
	/**
	 * 发布稽核
	 */
	private Integer adAudit;
	/**
	 * 环比标识
	 */
	private Integer lpFlag;
	/**
	 * 同比标识
	 */
	private Integer spFlag;
	/**
	 * 最后修改时间
	 */
	private Date editTime;
	/**
	 * 最后修改人
	 */
	private String editorId;
	/**
	 * 最后修改人名称
	 */
	private String editorName;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getDataLen() {
		return dataLen;
	}

	public void setDataLen(Integer dataLen) {
		this.dataLen = dataLen;
	}

	public Integer getDataDec() {
		return dataDec;
	}

	public void setDataDec(Integer dataDec) {
		this.dataDec = dataDec;
	}

	public String getCycKind() {
		return cycKind;
	}

	public void setCycKind(String cycKind) {
		this.cycKind = cycKind;
	}

	public Integer getOrgLayer() {
		return orgLayer;
	}

	public void setOrgLayer(Integer orgLayer) {
		this.orgLayer = orgLayer;
	}	

	public String getSplitId() {
		return splitId;
	}

	public void setSplitId(String splitId) {
		this.splitId = splitId;
	}

	public Integer getAdAudit() {
		return adAudit;
	}

	public void setAdAudit(Integer adAudit) {
		this.adAudit = adAudit;
	}

	public Integer getLpFlag() {
		return lpFlag;
	}

	public void setLpFlag(Integer lpFlag) {
		this.lpFlag = lpFlag;
	}

	public Integer getSpFlag() {
		return spFlag;
	}

	public void setSpFlag(Integer spFlag) {
		this.spFlag = spFlag;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getEditorId() {
		return editorId;
	}

	public void setEditorId(String editorId) {
		this.editorId = editorId;
	}

	public String getEditorName() {
		return editorName;
	}

	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BigDecimal getValidMin() {
		return validMin;
	}

	public void setValidMin(BigDecimal validMin) {
		this.validMin = validMin;
	}

	public BigDecimal getValidMax() {
		return validMax;
	}

	public void setValidMax(BigDecimal validMax) {
		this.validMax = validMax;
	}

	public String getPloyId() {
		return ployId;
	}

	public void setPloyId(String ployId) {
		this.ployId = ployId;
	}

	public String getPloyDim() {
		return ployDim;
	}

	public void setPloyDim(String ployDim) {
		this.ployDim = ployDim;
	}

	public String getSplitName() {
		return splitName;
	}

	public void setSplitName(String splitName) {
		this.splitName = splitName;
	}

	public String getPloyName() {
		return ployName;
	}

	public void setPloyName(String ployName) {
		this.ployName = ployName;
	}
}
