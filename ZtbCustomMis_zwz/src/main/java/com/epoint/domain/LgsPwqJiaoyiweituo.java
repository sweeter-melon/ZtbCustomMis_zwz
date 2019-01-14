package com.epoint.domain;

import java.util.Date;

import com.epoint.core.annotation.Entity;

import Epoint.ZtbMis.Bizlogic.ZtbMisEnity;

/**
 * 排污权交易委托实体
 * 
 * @作者 11016
 * @version [版本号, 2018-10-27 08:52:37]
 */
@Entity(table = "PWQ_JiaoYiWeiTuo", id = "rowguid")
public class LgsPwqJiaoyiweituo extends ZtbMisEnity
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
     * 项目名称
     */
    public String getProjectname() {
        return super.get("projectname");
    }

    public void setProjectname(String projectname) {
        super.set("projectname", projectname);
    }

    /**
     * 单位名称
     */
    public String getDanweiname() {
        return super.get("danweiname");
    }

    public void setDanweiname(String danweiname) {
        super.set("danweiname", danweiname);
    }

    /**
     * 委托类型
     */
    public String getWeituotype() {
        return super.get("weituotype");
    }

    public void setWeituotype(String weituotype) {
        super.set("weituotype", weituotype);
    }

    /**
     * 组织机构代码
     */
    public String getUnitorgnum() {
        return super.get("unitorgnum");
    }

    public void setUnitorgnum(String unitorgnum) {
        super.set("unitorgnum", unitorgnum);
    }

    /**
     * 单位地址
     */
    public String getDanweiaddress() {
        return super.get("danweiaddress");
    }

    public void setDanweiaddress(String danweiaddress) {
        super.set("danweiaddress", danweiaddress);
    }

    /**
     * 法定代表人
     */
    public String getFadingren() {
        return super.get("fadingren");
    }

    public void setFadingren(String fadingren) {
        super.set("fadingren", fadingren);
    }

    /**
     * 法定代表人身份证号码
     */
    public String getFadingrenidcard() {
        return super.get("fadingrenidcard");
    }

    public void setFadingrenidcard(String fadingrenidcard) {
        super.set("fadingrenidcard", fadingrenidcard);
    }

    /**
     * 委托代理人
     */
    public String getWeituoren() {
        return super.get("weituoren");
    }

    public void setWeituoren(String weituoren) {
        super.set("weituoren", weituoren);
    }

    /**
     * 委托代理人身份证号码
     */
    public String getWeituorenidcard() {
        return super.get("weituorenidcard");
    }

    public void setWeituorenidcard(String weituorenidcard) {
        super.set("weituorenidcard", weituorenidcard);
    }

    /**
     * 行业类别
     */
    public String getHangyetype() {
        return super.get("hangyetype");
    }

    public void setHangyetype(String hangyetype) {
        super.set("hangyetype", hangyetype);
    }

    /**
     * 联系电话
     */
    public String getLianxitel() {
        return super.get("lianxitel");
    }

    public void setLianxitel(String lianxitel) {
        super.set("lianxitel", lianxitel);
    }

    /**
     * 排污许可证编号
     */
    public String getPwlicensebh() {
        return super.get("pwlicensebh");
    }

    public void setPwlicensebh(String pwlicensebh) {
        super.set("pwlicensebh", pwlicensebh);
    }

    /**
     * 排污许可证有效期
     */
    public Date getPwlicenseyxq() {
        return super.getDate("pwlicenseyxq");
    }

    public void setPwlicenseyxq(Date pwlicenseyxq) {
        super.set("pwlicenseyxq", pwlicenseyxq);
    }

    /**
     * 审核文件编号
     */
    public String getShenhefilebh() {
        return super.get("shenhefilebh");
    }

    public void setShenhefilebh(String shenhefilebh) {
        super.set("shenhefilebh", shenhefilebh);
    }

    /**
     * 审核文件有效期
     */
    public Date getShenhefileyxq() {
        return super.getDate("shenhefileyxq");
    }

    public void setShenhefileyxq(Date shenhefileyxq) {
        super.set("shenhefileyxq", shenhefileyxq);
    }

    /**
     * 意向交易方式
     */
    public String getYxjiaoyifs() {
        return super.get("yxjiaoyifs");
    }

    public void setYxjiaoyifs(String yxjiaoyifs) {
        super.set("yxjiaoyifs", yxjiaoyifs);
    }

    /**
     * 意向受让方名称
     */
    public String getYxtransferee() {
        return super.get("yxtransferee");
    }

    public void setYxtransferee(String yxtransferee) {
        super.set("yxtransferee", yxtransferee);
    }

    /**
     * 意向受让方组织机构代码
     */
    public String getYxtransfereeunitorgnum() {
        return super.get("yxtransfereeunitorgnum");
    }

    public void setYxtransfereeunitorgnum(String yxtransfereeunitorgnum) {
        super.set("yxtransfereeunitorgnum", yxtransfereeunitorgnum);
    }

    /**
     * 审核有效期内是否同意自动连续委托
     */
    public String getIsautolianxuweituo() {
        return super.get("isautolianxuweituo");
    }

    public void setIsautolianxuweituo(String isautolianxuweituo) {
        super.set("isautolianxuweituo", isautolianxuweituo);
    }

    /**
     * AuditStatus
     */
    public String getAuditstatus() {
        return super.get("auditstatus");
    }

    public void setAuditstatus(String auditstatus) {
        super.set("auditstatus", auditstatus);
    }

    /**
     * SBR_UnitGuid
     */
    public String getSbr_unitguid() {
        return super.get("sbr_unitguid");
    }

    public void setSbr_unitguid(String sbr_unitguid) {
        super.set("sbr_unitguid", sbr_unitguid);
    }

    /**
     * SBR_Name
     */
    public String getSbr_name() {
        return super.get("sbr_name");
    }

    public void setSbr_name(String sbr_name) {
        super.set("sbr_name", sbr_name);
    }

    /**
     * SBR_Code
     */
    public String getSbr_code() {
        return super.get("sbr_code");
    }

    public void setSbr_code(String sbr_code) {
        super.set("sbr_code", sbr_code);
    }

    /**
     * SBR_UnitName
     */
    public String getSbr_unitname() {
        return super.get("sbr_unitname");
    }

    public void setSbr_unitname(String sbr_unitname) {
        super.set("sbr_unitname", sbr_unitname);
    }

    /**
     * SBR_Date
     */
    public Date getSbr_date() {
        return super.getDate("sbr_date");
    }

    public void setSbr_date(Date sbr_date) {
        super.set("sbr_date", sbr_date);
    }

    /**
     * SBR_Tel
     */
    public String getSbr_tel() {
        return super.get("sbr_tel");
    }

    public void setSbr_tel(String sbr_tel) {
        super.set("sbr_tel", sbr_tel);
    }

    /**
     * SBR_Moblie
     */
    public String getSbr_moblie() {
        return super.get("sbr_moblie");
    }

    public void setSbr_moblie(String sbr_moblie) {
        super.set("sbr_moblie", sbr_moblie);
    }

    /**
     * SHR_Code
     */
    public String getShr_code() {
        return super.get("shr_code");
    }

    public void setShr_code(String shr_code) {
        super.set("shr_code", shr_code);
    }

    /**
     * SHR_Name
     */
    public String getShr_name() {
        return super.get("shr_name");
    }

    public void setShr_name(String shr_name) {
        super.set("shr_name", shr_name);
    }

    /**
     * SHR_Date
     */
    public Date getShr_date() {
        return super.getDate("shr_date");
    }

    public void setShr_date(Date shr_date) {
        super.set("shr_date", shr_date);
    }

    /**
     * ProjectJiaoYiType
     */
    public String getProjectjiaoyitype() {
        return super.get("projectjiaoyitype");
    }

    public void setProjectjiaoyitype(String projectjiaoyitype) {
        super.set("projectjiaoyitype", projectjiaoyitype);
    }

    /**
     * XiaQuCode
     */
    public String getXiaqucode() {
        return super.get("xiaqucode");
    }

    public void setXiaqucode(String xiaqucode) {
        super.set("xiaqucode", xiaqucode);
    }

    /**
     * CurrentStepName
     */
    public String getCurrentstepname() {
        return super.get("currentstepname");
    }

    public void setCurrentstepname(String currentstepname) {
        super.set("currentstepname", currentstepname);
    }

    /**
     * PVI_Guid
     */
    public String getPvi_guid() {
        return super.get("pvi_guid");
    }

    public void setPvi_guid(String pvi_guid) {
        super.set("pvi_guid", pvi_guid);
    }

    /**
     * SBR_IDCard
     */
    public String getSbr_idcard() {
        return super.get("sbr_idcard");
    }

    public void setSbr_idcard(String sbr_idcard) {
        super.set("sbr_idcard", sbr_idcard);
    }

}
