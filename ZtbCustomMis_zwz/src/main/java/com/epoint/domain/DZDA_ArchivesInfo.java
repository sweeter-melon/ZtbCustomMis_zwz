package com.epoint.domain;
import java.util.Date;
import com.epoint.core.annotation.Entity;
import Epoint.ZtbMis.Bizlogic.ZtbMisEnity;

/**
* 实体类  
* 
* @作者 
* @version [版本号, 2018-12-08 08:19:49]
*/
@Entity(table = "DZDA_ArchivesInfo", id = "rowguid")
public  class DZDA_ArchivesInfo extends ZtbMisEnity{

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
 	*GuiDangYear的set方法
 	*/
	public void  setGuidangyear(String  guidangyear ){
		 super.set("guidangyear",guidangyear);
	}
	/**
 	*GuiDangYear的get方法
 	*/
	public String  getGuidangyear(){
		return super.getStr("guidangyear");
	}
	/**
 	*SecrecyLvl的set方法
 	*/
	public void  setSecrecylvl(String  secrecylvl ){
		 super.set("secrecylvl",secrecylvl);
	}
	/**
 	*SecrecyLvl的get方法
 	*/
	public String  getSecrecylvl(){
		return super.getStr("secrecylvl");
	}
	/**
 	*KeepTime的set方法
 	*/
	public void  setKeeptime(String  keeptime ){
		 super.set("keeptime",keeptime);
	}
	/**
 	*KeepTime的get方法
 	*/
	public String  getKeeptime(){
		return super.getStr("keeptime");
	}
	/**
 	*ArchivesDanWei的set方法
 	*/
	public void  setArchivesdanwei(String  archivesdanwei ){
		 super.set("archivesdanwei",archivesdanwei);
	}
	/**
 	*ArchivesDanWei的get方法
 	*/
	public String  getArchivesdanwei(){
		return super.getStr("archivesdanwei");
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
 	*SBR_Date的set方法
 	*/
	public void  setSbrdate(String  sbr_date ){
		 super.set("sbr_date",sbr_date);
	}
	/**
 	*SBR_Date的get方法
 	*/
	public String  getSbrdate(){
		return super.getStr("sbr_date");
	}

}