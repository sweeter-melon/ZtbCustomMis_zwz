package com.epoint.domain;

import java.util.Date;

import com.epoint.core.annotation.Entity;

import Epoint.ZtbMis.Bizlogic.ZtbMisEnity;

/**
 * 标的表实体
 * 
 * @作者 11016
 * @version [版本号, 2018-10-27 08:52:44]
 */
@Entity(table = "PWQ_BiaoDi", id = "rowguid")
public class LgsPwqBiaodi extends ZtbMisEnity
{
    private static final long serialVersionUID = 1L;

    /**
     * 所属辖区号
     */
    public String getBelongxiaqucode() {
        return super.get("belongxiaqucode");
    }

    public void setBelongxiaqucode(String belongxiaqucode) {
        super.set("belongxiaqucode", belongxiaqucode);
    }

    /**
     * 操作者名字
     */
    public String getOperateusername() {
        return super.get("operateusername");
    }

    public void setOperateusername(String operateusername) {
        super.set("operateusername", operateusername);
    }

    /**
     * 操作日期
     */
    public Date getOperatedate() {
        return super.getDate("operatedate");
    }

    public void setOperatedate(Date operatedate) {
        super.set("operatedate", operatedate);
    }

    /**
     * 序号
     */
    public Integer getRow_id() {
        return super.getInt("row_id");
    }

    public void setRow_id(Integer row_id) {
        super.set("row_id", row_id);
    }

    /**
     * 年份标识
     */
    public String getYearflag() {
        return super.get("yearflag");
    }

    public void setYearflag(String yearflag) {
        super.set("yearflag", yearflag);
    }

    /**
     * 默认主键字段
     */
    public String getRowguid() {
        return super.get("rowguid");
    }

    public void setRowguid(String rowguid) {
        super.set("rowguid", rowguid);
    }

    /**
     * 标的唯一标识
     */
    public String getBiaodiguid() {
        return super.get("biaodiguid");
    }

    public void setBiaodiguid(String biaodiguid) {
        super.set("biaodiguid", biaodiguid);
    }

    /**
     * 项目唯一标识
     */
    public String getProjectguid() {
        return super.get("projectguid");
    }

    public void setProjectguid(String projectguid) {
        super.set("projectguid", projectguid);
    }

    /**
     * 项目编号
     */
    public String getProjectbh() {
        return super.get("projectbh");
    }

    public void setProjectbh(String projectbh) {
        super.set("projectbh", projectbh);
    }

    /**
     * 标的编号
     */
    public String getBiaodibh() {
        return super.get("biaodibh");
    }

    public void setBiaodibh(String biaodibh) {
        super.set("biaodibh", biaodibh);
    }

    /**
     * 排污指标名称
     */
    public String getPwzhibiaoname() {
        return super.get("pwzhibiaoname");
    }

    public void setPwzhibiaoname(String pwzhibiaoname) {
        super.set("pwzhibiaoname", pwzhibiaoname);
    }

    /**
     * 排污指标所在区域
     */
    public String getPwzhibiaoquyu() {
        return super.get("pwzhibiaoquyu");
    }

    public void setPwzhibiaoquyu(String pwzhibiaoquyu) {
        super.set("pwzhibiaoquyu", pwzhibiaoquyu);
    }

    /**
     * 交易指标数量（吨）
     */
    public Double getJiaoyizhibiaocount() {
        return super.getDouble("jiaoyizhibiaocount");
    }

    public void setJiaoyizhibiaocount(Double jiaoyizhibiaocount) {
        super.set("jiaoyizhibiaocount", jiaoyizhibiaocount);
    }

    /**
     * 起始价格（元/吨）
     */
    public Double getQishiprice() {
        return super.getDouble("qishiprice");
    }

    public void setQishiprice(Double qishiprice) {
        super.set("qishiprice", qishiprice);
    }

}
