package com.epoint.domain;

import java.util.Date;

import com.epoint.core.annotation.Entity;

import Epoint.ZtbMis.Bizlogic.ZtbMisEnity;

/**
 * 代理候选人实体类
 * 
 * @作者 dff
 * @version [版本号, 2018/11/5 14:46:56]
 */
@Entity(table = "CG_DaiLiInfo", id = "rowguid")
public class DaiLiInfo extends ZtbMisEnity
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * OperateUserName的set方法
     */
    public void setOperateusername(String operateusername) {
        super.set("operateusername", operateusername);
    }

    /**
     * OperateUserName的get方法
     */
    public String getOperateusername() {
        return super.getStr("operateusername");
    }

    /**
     * OperateDate的set方法
     */
    public void setOperatedate(Date operatedate) {
        super.set("operatedate", operatedate);
    }

    /**
     * OperateDate的get方法
     */
    public Date getOperatedate() {
        return super.getDate("operatedate");
    }

    /**
     * Row_ID的set方法
     */
    public void setRowid(Integer row_id) {
        super.set("row_id", row_id);
    }

    /**
     * Row_ID的get方法
     */
    public Integer getRowid() {
        return super.getInt("row_id");
    }

    /**
     * YearFlag的set方法
     */
    public void setYearflag(String yearflag) {
        super.set("yearflag", yearflag);
    }

    /**
     * YearFlag的get方法
     */
    public String getYearflag() {
        return super.getStr("yearflag");
    }

    /**
     * RowGuid的set方法
     */
    public void setRowguid(String rowguid) {
        super.set("rowguid", rowguid);
    }

    /**
     * RowGuid的get方法
     */
    public String getRowguid() {
        return super.getStr("rowguid");
    }

    /**
     * XuanQuGuid的set方法
     */
    public void setXuanquguid(String xuanquguid) {
        super.set("xuanquguid", xuanquguid);
    }

    /**
     * XuanQuGuid的get方法
     */
    public String getXuanquguid() {
        return super.getStr("xuanquguid");
    }

    /**
     * DaiLiGuid的set方法
     */
    public void setDailiguid(String dailiguid) {
        super.set("dailiguid", dailiguid);
    }

    /**
     * DaiLiGuid的get方法
     */
    public String getDailiguid() {
        return super.getStr("dailiguid");
    }

    /**
     * DaiLiName的set方法
     */
    public void setDailiname(String dailiname) {
        super.set("dailiname", dailiname);
    }

    /**
     * DaiLiName的get方法
     */
    public String getDailiname() {
        return super.getStr("dailiname");
    }

    /**
     * IsZhongXuan的set方法
     */
    public void setIszhongxuan(String iszhongxuan) {
        super.set("iszhongxuan", iszhongxuan);
    }

    /**
     * IsZhongXuan的get方法
     */
    public String getIszhongxuan() {
        return super.getStr("iszhongxuan");
    }

    /**
     * UnitOrgNum的set方法
     */
    public void setUnitorgnum(String unitorgnum) {
        super.set("unitorgnum", unitorgnum);
    }

    /**
     * UnitOrgNum的get方法
     */
    public String getUnitorgnum() {
        return super.getStr("unitorgnum");
    }

    /**
     * ZhuCeZiJin的set方法
     */
    public void setZhucezijin(Double zhucezijin) {
        super.set("zhucezijin", zhucezijin);
    }

    /**
     * ZhuCeZiJin的get方法
     */
    public Double getZhucezijin() {
        return super.getDouble("zhucezijin");
    }

    /**
     * ReMark的set方法
     */
    public void setRemark(String remark) {
        super.set("remark", remark);
    }

    /**
     * ReMark的get方法
     */
    public String getRemark() {
        return super.getStr("remark");
    }
    
    /**
     * extractNum的set方法
     */
    public void setExtractNum(String extractnum) {
        super.set("extractnum", extractnum);
    }

    /**
     * extractNum的get方法
     */
    public String getExtractNum() {
        return super.getStr("extractnum");
    }
}
