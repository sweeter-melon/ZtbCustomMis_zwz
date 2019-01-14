package com.epoint.domain;
import java.util.Date;
import com.epoint.core.annotation.Entity;
import Epoint.ZtbMis.Bizlogic.ZtbMisEnity;

/**
* 实体类  
* 
* @作者 
* @version [版本号, 2018-12-08 08:20:12]
*/
@Entity(table = "DZDA_Borrow", id = "rowguid")
public  class DZDA_Borrow extends ZtbMisEnity{

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
 	*ArchivesGuid的set方法
 	*/
	public void  setArchivesguid(String  archivesguid ){
		 super.set("archivesguid",archivesguid);
	}
	/**
 	*ArchivesGuid的get方法
 	*/
	public String  getArchivesguid(){
		return super.getStr("archivesguid");
	}
	/**
 	*ArchivesNo的set方法
 	*/
	public void  setArchivesno(String  archivesno ){
		 super.set("archivesno",archivesno);
	}
	/**
 	*ArchivesNo的get方法
 	*/
	public String  getArchivesno(){
		return super.getStr("archivesno");
	}
	/**
 	*ArchivesName的set方法
 	*/
	public void  setArchivesname(String  archivesname ){
		 super.set("archivesname",archivesname);
	}
	/**
 	*ArchivesName的get方法
 	*/
	public String  getArchivesname(){
		return super.getStr("archivesname");
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
 	*BorrowStartTime的set方法
 	*/
	public void  setBorrowstarttime(Date  borrowstarttime ){
		 super.set("borrowstarttime",borrowstarttime);
	}
	/**
 	*BorrowStartTime的get方法
 	*/
	public Date  getBorrowstarttime(){
		return super.getDate("borrowstarttime");
	}
	/**
 	*BorrowEndTime的set方法
 	*/
	public void  setBorrowendtime(Date  borrowendtime ){
		 super.set("borrowendtime",borrowendtime);
	}
	/**
 	*BorrowEndTime的get方法
 	*/
	public Date  getBorrowendtime(){
		return super.getDate("borrowendtime");
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
 	*BackReason的set方法
 	*/
	public void  setBackreason(String  backreason ){
		 super.set("backreason",backreason);
	}
	/**
 	*BackReason的get方法
 	*/
	public String  getBackreason(){
		return super.getStr("backreason");
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

}