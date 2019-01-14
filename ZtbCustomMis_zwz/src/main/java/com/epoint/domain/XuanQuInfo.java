package com.epoint.domain;

import java.util.Date;

import com.epoint.core.annotation.Entity;

import Epoint.ZtbMis.Bizlogic.ZtbMisEnity;

/**
 * 招标代理抽取表
 * 
 * @作者 dff
 * @version [版本号, 2018/11/5 14:43:23]
 */
@Entity(table = "CG_XuanQuInfo", id = "rowguid")
public class XuanQuInfo extends ZtbMisEnity
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
     * XuanQuNo的set方法
     */
    public void setXuanquno(String xuanquno) {
        super.set("xuanquno", xuanquno);
    }

    /**
     * XuanQuNo的get方法
     */
    public String getXuanquno() {
        return super.getStr("xuanquno");
    }

    /**
     * XuanQuName的set方法
     */
    public void setXuanquname(String xuanquname) {
        super.set("xuanquname", xuanquname);
    }

    /**
     * XuanQuName的get方法
     */
    public String getXuanquname() {
        return super.getStr("xuanquname");
    }

    /**
     * DanWeiName的set方法
     */
    public void setDanweiname(String danweiname) {
        super.set("danweiname", danweiname);
    }

    /**
     * DanWeiName的get方法
     */
    public String getDanweiname() {
        return super.getStr("danweiname");
    }

    /**
     * DanWeiGuid的set方法
     */
    public void setDanweiguid(String danweiguid) {
        super.set("danweiguid", danweiguid);
    }

    /**
     * DanWeiGuid的get方法
     */
    public String getDanweiguid() {
        return super.getStr("danweiguid");
    }

    /**
     * ShengQingDate的set方法
     */
    public void setShengqingdate(Date shengqingdate) {
        super.set("shengqingdate", shengqingdate);
    }

    /**
     * ShengQingDate的get方法
     */
    public Date getShengqingdate() {
        return super.getDate("shengqingdate");
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
     * XuanQuType的set方法
     */
    public void setXuanqutype(String xuanqutype) {
        super.set("xuanqutype", xuanqutype);
    }

    /**
     * XuanQuType的get方法
     */
    public String getXuanqutype() {
        return super.getStr("xuanqutype");
    }

    /**
     * YuSuanPrice的set方法
     */
    public void setYusuanprice(Double yusuanprice) {
        super.set("yusuanprice", yusuanprice);
    }

    /**
     * YuSuanPrice的get方法
     */
    public Double getYusuanprice() {
        return super.getDouble("yusuanprice");
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
     * LianXiTel的set方法
     */
    public void setLianxitel(String lianxitel) {
        super.set("lianxitel", lianxitel);
    }

    /**
     * LianXiTel的get方法
     */
    public String getLianxitel() {
        return super.getStr("lianxitel");
    }

    /**
     * IsXuanQu的set方法
     */
    public void setIsxuanqu(String isxuanqu) {
        super.set("isxuanqu", isxuanqu);
    }

    /**
     * IsXuanQu的get方法
     */
    public String getIsxuanqu() {
        return super.getStr("isxuanqu");
    }

    /**
     * AuditStatus的set方法
     */
    public void setAuditstatus(String auditstatus) {
        super.set("auditstatus", auditstatus);
    }

    /**
     * AuditStatus的get方法
     */
    public String getAuditstatus() {
        return super.getStr("auditstatus");
    }

    /**
     * SBR_UnitGuid的set方法
     */
    public void setSbrunitguid(String sbr_unitguid) {
        super.set("sbr_unitguid", sbr_unitguid);
    }

    /**
     * SBR_UnitGuid的get方法
     */
    public String getSbrunitguid() {
        return super.getStr("sbr_unitguid");
    }

    /**
     * SBR_Name的set方法
     */
    public void setSbrname(String sbr_name) {
        super.set("sbr_name", sbr_name);
    }

    /**
     * SBR_Name的get方法
     */
    public String getSbrname() {
        return super.getStr("sbr_name");
    }

    /**
     * SBR_Code的set方法
     */
    public void setSbrcode(String sbr_code) {
        super.set("sbr_code", sbr_code);
    }

    /**
     * SBR_Code的get方法
     */
    public String getSbrcode() {
        return super.getStr("sbr_code");
    }

    /**
     * SBR_UnitName的set方法
     */
    public void setSbrunitname(String sbr_unitname) {
        super.set("sbr_unitname", sbr_unitname);
    }

    /**
     * SBR_UnitName的get方法
     */
    public String getSbrunitname() {
        return super.getStr("sbr_unitname");
    }

    /**
     * SBR_Date的set方法
     */
    public void setSbrdate(Date sbr_date) {
        super.set("sbr_date", sbr_date);
    }

    /**
     * SBR_Date的get方法
     */
    public Date getSbrdate() {
        return super.getDate("sbr_date");
    }

    /**
     * SBR_Tel的set方法
     */
    public void setSbrtel(String sbr_tel) {
        super.set("sbr_tel", sbr_tel);
    }

    /**
     * SBR_Tel的get方法
     */
    public String getSbrtel() {
        return super.getStr("sbr_tel");
    }

    /**
     * SBR_Moblie的set方法
     */
    public void setSbrmoblie(String sbr_moblie) {
        super.set("sbr_moblie", sbr_moblie);
    }

    /**
     * SBR_Moblie的get方法
     */
    public String getSbrmoblie() {
        return super.getStr("sbr_moblie");
    }

    /**
     * SHR_Code的set方法
     */
    public void setShrcode(String shr_code) {
        super.set("shr_code", shr_code);
    }

    /**
     * SHR_Code的get方法
     */
    public String getShrcode() {
        return super.getStr("shr_code");
    }

    /**
     * SHR_Name的set方法
     */
    public void setShrname(String shr_name) {
        super.set("shr_name", shr_name);
    }

    /**
     * SHR_Name的get方法
     */
    public String getShrname() {
        return super.getStr("shr_name");
    }

    /**
     * SHR_Date的set方法
     */
    public void setShrdate(Date shr_date) {
        super.set("shr_date", shr_date);
    }

    /**
     * SHR_Date的get方法
     */
    public Date getShrdate() {
        return super.getDate("shr_date");
    }

    /**
     * ProjectJiaoYiType的set方法
     */
    public void setProjectjiaoyitype(String projectjiaoyitype) {
        super.set("projectjiaoyitype", projectjiaoyitype);
    }

    /**
     * ProjectJiaoYiType的get方法
     */
    public String getProjectjiaoyitype() {
        return super.getStr("projectjiaoyitype");
    }

    /**
     * XiaQuCode的set方法
     */
    public void setXiaqucode(String xiaqucode) {
        super.set("xiaqucode", xiaqucode);
    }

    /**
     * XiaQuCode的get方法
     */
    public String getXiaqucode() {
        return super.getStr("xiaqucode");
    }

    /**
     * CurrentStepName的set方法
     */
    public void setCurrentstepname(String currentstepname) {
        super.set("currentstepname", currentstepname);
    }

    /**
     * CurrentStepName的get方法
     */
    public String getCurrentstepname() {
        return super.getStr("currentstepname");
    }

    /**
     * PVI_Guid的set方法
     */
    public void setPviguid(String pvi_guid) {
        super.set("pvi_guid", pvi_guid);
    }

    /**
     * PVI_Guid的get方法
     */
    public String getPviguid() {
        return super.getStr("pvi_guid");
    }

    /**
     * SBR_IDCard的set方法
     */
    public void setSbridcard(String sbr_idcard) {
        super.set("sbr_idcard", sbr_idcard);
    }

    /**
     * SBR_IDCard的get方法
     */
    public String getSbridcard() {
        return super.getStr("sbr_idcard");
    }

}
