package com.epoint.domain;
import java.util.Date;
import com.epoint.core.annotation.Entity;
import Epoint.ZtbMis.Bizlogic.ZtbMisEnity;

/**
* 实体类  
* 
* @作者 
* @version [版本号, 2018-12-15 08:15:25]
*/
@Entity(table = "PW_ProjectInfo", id = "rowguid")
public  class PwProjectinfo extends ZtbMisEnity{

	/**
 	*OperateUserName的set方法
 	*/
	public void  setOperateusername(String  operateusername ){
		 super.set("operateusername",operateusername);
	}
	/**
 	*OperateUserName的get方法
 	*/
	public String  getOperateusername(){
		return super.getStr("operateusername");
	}
	/**
 	*OperateDate的set方法
 	*/
	public void  setOperatedate(Date  operatedate ){
		 super.set("operatedate",operatedate);
	}
	/**
 	*OperateDate的get方法
 	*/
	public Date  getOperatedate(){
		return super.getDate("operatedate");
	}
	/**
 	*Row_ID的set方法
 	*/
	public void  setRowid(Integer  row_id ){
		 super.set("row_id",row_id);
	}
	/**
 	*Row_ID的get方法
 	*/
	public Integer  getRowid(){
		return super.getInt("row_id");
	}
	/**
 	*YearFlag的set方法
 	*/
	public void  setYearflag(String  yearflag ){
		 super.set("yearflag",yearflag);
	}
	/**
 	*YearFlag的get方法
 	*/
	public String  getYearflag(){
		return super.getStr("yearflag");
	}
	/**
 	*RowGuid的set方法
 	*/
	public void  setRowguid(String  rowguid ){
		 super.set("rowguid",rowguid);
	}
	/**
 	*RowGuid的get方法
 	*/
	public String  getRowguid(){
		return super.getStr("rowguid");
	}
	/**
 	*ProjectGuid的set方法
 	*/
	public void  setProjectguid(String  projectguid ){
		 super.set("projectguid",projectguid);
	}
	/**
 	*ProjectGuid的get方法
 	*/
	public String  getProjectguid(){
		return super.getStr("projectguid");
	}
	/**
 	*ProjectNo的set方法
 	*/
	public void  setProjectno(String  projectno ){
		 super.set("projectno",projectno);
	}
	/**
 	*ProjectNo的get方法
 	*/
	public String  getProjectno(){
		return super.getStr("projectno");
	}
	/**
 	*DanWeiGuid的set方法
 	*/
	public void  setDanweiguid(String  danweiguid ){
		 super.set("danweiguid",danweiguid);
	}
	/**
 	*DanWeiGuid的get方法
 	*/
	public String  getDanweiguid(){
		return super.getStr("danweiguid");
	}
	/**
 	*DanWeiName的set方法
 	*/
	public void  setDanweiname(String  danweiname ){
		 super.set("danweiname",danweiname);
	}
	/**
 	*DanWeiName的get方法
 	*/
	public String  getDanweiname(){
		return super.getStr("danweiname");
	}
	/**
 	*ProjectName的set方法
 	*/
	public void  setProjectname(String  projectname ){
		 super.set("projectname",projectname);
	}
	/**
 	*ProjectName的get方法
 	*/
	public String  getProjectname(){
		return super.getStr("projectname");
	}
	/**
 	*Area的set方法
 	*/
	public void  setArea(String  area ){
		 super.set("area",area);
	}
	/**
 	*Area的get方法
 	*/
	public String  getArea(){
		return super.getStr("area");
	}
	/**
 	*ProjectType的set方法
 	*/
	public void  setProjecttype(String  projecttype ){
		 super.set("projecttype",projecttype);
	}
	/**
 	*ProjectType的get方法
 	*/
	public String  getProjecttype(){
		return super.getStr("projecttype");
	}
	/**
 	*ProjectTouZi的set方法
 	*/
	public void  setProjecttouzi(Double  projecttouzi ){
		 super.set("projecttouzi",projecttouzi);
	}
	/**
 	*ProjectTouZi的get方法
 	*/
	public Double  getProjecttouzi(){
		return super.getDouble("projecttouzi");
	}
	/**
 	*JianSheGuiMo的set方法
 	*/
	public void  setJiansheguimo(String  jiansheguimo ){
		 super.set("jiansheguimo",jiansheguimo);
	}
	/**
 	*JianSheGuiMo的get方法
 	*/
	public String  getJiansheguimo(){
		return super.getStr("jiansheguimo");
	}
	/**
 	*JianSheAdress的set方法
 	*/
	public void  setJiansheadress(String  jiansheadress ){
		 super.set("jiansheadress",jiansheadress);
	}
	/**
 	*JianSheAdress的get方法
 	*/
	public String  getJiansheadress(){
		return super.getStr("jiansheadress");
	}
	/**
 	*ErYangHuaLiu的set方法
 	*/
	public void  setEryanghualiu(Double  eryanghualiu ){
		 super.set("eryanghualiu",eryanghualiu);
	}
	/**
 	*ErYangHuaLiu的get方法
 	*/
	public Double  getEryanghualiu(){
		return super.getDouble("eryanghualiu");
	}
	/**
 	*AnDan的set方法
 	*/
	public void  setAndan(Double  andan ){
		 super.set("andan",andan);
	}
	/**
 	*AnDan的get方法
 	*/
	public Double  getAndan(){
		return super.getDouble("andan");
	}
	/**
 	*HuaXueXuYangLiang的set方法
 	*/
	public void  setHuaxuexuyangliang(Double  huaxuexuyangliang ){
		 super.set("huaxuexuyangliang",huaxuexuyangliang);
	}
	/**
 	*HuaXueXuYangLiang的get方法
 	*/
	public Double  getHuaxuexuyangliang(){
		return super.getDouble("huaxuexuyangliang");
	}
	/**
 	*ShowTotalPrice的set方法
 	*/
	public void  setShowtotalprice(String  showtotalprice ){
		 super.set("showtotalprice",showtotalprice);
	}
	/**
 	*ShowTotalPrice的get方法
 	*/
	public String  getShowtotalprice(){
		return super.getStr("showtotalprice");
	}
	/**
 	*TotalPrice的set方法
 	*/
	public void  setTotalprice(Double  totalprice ){
		 super.set("totalprice",totalprice);
	}
	/**
 	*TotalPrice的get方法
 	*/
	public Double  getTotalprice(){
		return super.getDouble("totalprice");
	}
	/**
 	*Remark的set方法
 	*/
	public void  setRemark(String  remark ){
		 super.set("remark",remark);
	}
	/**
 	*Remark的get方法
 	*/
	public String  getRemark(){
		return super.getStr("remark");
	}
	/**
 	*RemarkTime的set方法
 	*/
	public void  setRemarktime(Date  remarktime ){
		 super.set("remarktime",remarktime);
	}
	/**
 	*RemarkTime的get方法
 	*/
	public Date  getRemarktime(){
		return super.getDate("remarktime");
	}
	/**
 	*RemarkPerson的set方法
 	*/
	public void  setRemarkperson(String  remarkperson ){
		 super.set("remarkperson",remarkperson);
	}
	/**
 	*RemarkPerson的get方法
 	*/
	public String  getRemarkperson(){
		return super.getStr("remarkperson");
	}
	/**
 	*ProjectJiaoYiType的set方法
 	*/
	public void  setProjectjiaoyitype(String  projectjiaoyitype ){
		 super.set("projectjiaoyitype",projectjiaoyitype);
	}
	/**
 	*ProjectJiaoYiType的get方法
 	*/
	public String  getProjectjiaoyitype(){
		return super.getStr("projectjiaoyitype");
	}
	/**
 	*XiaQuCode的set方法
 	*/
	public void  setXiaqucode(String  xiaqucode ){
		 super.set("xiaqucode",xiaqucode);
	}
	/**
 	*XiaQuCode的get方法
 	*/
	public String  getXiaqucode(){
		return super.getStr("xiaqucode");
	}
	/**
 	*SBR_UnitGuid的set方法
 	*/
	public void  setSbrunitguid(String  sbr_unitguid ){
		 super.set("sbr_unitguid",sbr_unitguid);
	}
	/**
 	*SBR_UnitGuid的get方法
 	*/
	public String  getSbrunitguid(){
		return super.getStr("sbr_unitguid");
	}
	/**
 	*SBR_UnitName的set方法
 	*/
	public void  setSbrunitname(String  sbr_unitname ){
		 super.set("sbr_unitname",sbr_unitname);
	}
	/**
 	*SBR_UnitName的get方法
 	*/
	public String  getSbrunitname(){
		return super.getStr("sbr_unitname");
	}
	/**
 	*SBR_Code的set方法
 	*/
	public void  setSbrcode(String  sbr_code ){
		 super.set("sbr_code",sbr_code);
	}
	/**
 	*SBR_Code的get方法
 	*/
	public String  getSbrcode(){
		return super.getStr("sbr_code");
	}
	/**
 	*SBR_Name的set方法
 	*/
	public void  setSbrname(String  sbr_name ){
		 super.set("sbr_name",sbr_name);
	}
	/**
 	*SBR_Name的get方法
 	*/
	public String  getSbrname(){
		return super.getStr("sbr_name");
	}
	/**
 	*SBR_Date的set方法
 	*/
	public void  setSbrdate(Date  sbr_date ){
		 super.set("sbr_date",sbr_date);
	}
	/**
 	*SBR_Date的get方法
 	*/
	public Date  getSbrdate(){
		return super.getDate("sbr_date");
	}
	/**
 	*SHR_Code的set方法
 	*/
	public void  setShrcode(String  shr_code ){
		 super.set("shr_code",shr_code);
	}
	/**
 	*SHR_Code的get方法
 	*/
	public String  getShrcode(){
		return super.getStr("shr_code");
	}
	/**
 	*SHR_Name的set方法
 	*/
	public void  setShrname(String  shr_name ){
		 super.set("shr_name",shr_name);
	}
	/**
 	*SHR_Name的get方法
 	*/
	public String  getShrname(){
		return super.getStr("shr_name");
	}
	/**
 	*SHR_Date的set方法
 	*/
	public void  setShrdate(Date  shr_date ){
		 super.set("shr_date",shr_date);
	}
	/**
 	*SHR_Date的get方法
 	*/
	public Date  getShrdate(){
		return super.getDate("shr_date");
	}
	/**
 	*AuditStatus的set方法
 	*/
	public void  setAuditstatus(String  auditstatus ){
		 super.set("auditstatus",auditstatus);
	}
	/**
 	*AuditStatus的get方法
 	*/
	public String  getAuditstatus(){
		return super.getStr("auditstatus");
	}
	/**
 	*CurrentStepName的set方法
 	*/
	public void  setCurrentstepname(String  currentstepname ){
		 super.set("currentstepname",currentstepname);
	}
	/**
 	*CurrentStepName的get方法
 	*/
	public String  getCurrentstepname(){
		return super.getStr("currentstepname");
	}
	/**
 	*PVI_Guid的set方法
 	*/
	public void  setPviguid(String  pvi_guid ){
		 super.set("pvi_guid",pvi_guid);
	}
	/**
 	*PVI_Guid的get方法
 	*/
	public String  getPviguid(){
		return super.getStr("pvi_guid");
	}

}