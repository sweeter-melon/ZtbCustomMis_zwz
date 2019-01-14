package com.epoint.dlcp.dailiinfo.action;

import java.util.List;
import java.util.UUID;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.grammar.Record;
import com.epoint.core.utils.string.StringUtil;
import com.epoint.domain.DaiLiInfo;

import Epoint.ZtbMis.Bizlogic.BasePage4List;

/**
 * 招标代理信息对应的后台
 * 
 * @author SYSTEM
 * @version [版本号, 2015-02-05 14:10:44]
 */
@Name("zbdaiLiInfoUnitListAction")
@Scope(ScopeType.EVENT)
public class ZBDaiLiInfoUnitListAction extends BasePage4List
{
    private static final long serialVersionUID = -3837110443292373213L;

    /**
     * 一页表格modal
     */
    private DataGridModel<Record> dataGridModel;

    /**
     * 前台搜索条件-组织机构代码
     */
    private String zzjgdm = "";// 组织机构代码
    private String dwmc = "";// 单位名称
    private  String xuanQuGuid="";
    public void pageLoad() {
         xuanQuGuid = getRequestParameter("XuanQuGuid");
        addCallbackParam("xuanQuGuid", xuanQuGuid);
        InitHyGuid();
    }

    public DataGridModel<Record> getDataModel() {
        if (dataGridModel == null) {
            dataGridModel = new DataGridModel<Record>()
            {

                @Override
                public List<Record> fetchData(int first, int pageSize, String sortField, String sortOrder) {
                    String where = "";

                    where += " and t.auditstatus='3'";

                    if (!StringUtil.isBlank(dwmc)) {
                        where += " and danweiname like '%" + service.SQL_Encode(dwmc.trim()) + "%'";
                    }

                    if (!StringUtil.isBlank(zzjgdm)) {
                        where += " and unitorgnum like '%" + service.SQL_Encode(zzjgdm.trim()) + "%'";
                    }
                    String cntsql = "select count(*) from  H_DL_BasicInfo_Temp t ,HuiYuan_UnitComInfo_Temp b "
                            + "where t.danweiguid=b.danweiguid " + where;
                    String sql = "select unitorgnum,danweiname,areaname,statuscode,t.auditstatus,t.danweiguid,t.rowguid,zhuceziben from H_DL_BasicInfo_Temp t ,HuiYuan_UnitComInfo_Temp b "
                            + "where t.danweiguid=b.danweiguid " + where;

                    if ("true".equals(getRequestParameter("center"))) {
                        cntsql = "select count(*) from  H_DL_BasicInfo t ,HuiYuan_UnitComInfo b "
                                + "where t.danweiguid=b.danweiguid " + where;
                        sql = "select unitorgnum,danweiname,areaname,statuscode,auditstatus,t.danweiguid,t.rowguid from H_DL_BasicInfo t ,HuiYuan_UnitComInfo b "
                                + "where t.danweiguid=b.danweiguid " + where;
                    }
                    sql += getGridSort(sortField, sortOrder, "order by t.row_id desc");
                    int cnt = service.queryInt(cntsql);
                    List<Record> list = service.findList(sql, first, pageSize, Record.class);
                    this.setRowCount(cnt);
                    return list;
                }
            };
        }
        return dataGridModel;
    }

    /**
     * 选中的时候保存代理信息到库
     * 
     * @param XuanQuGuid
     *            与选取表关联
     */
    public String saveDaiLiInfo(String guid) {
        if(StringUtil.isNotBlank(guid))
        {
             saveDaiLiInfoByGuid(guid);
        }
        else
        {
        for (String rowguid : getDataModel().getSelectKeys()) {
             saveDaiLiInfoByGuid(rowguid);
            }
        }
        return "";
    }

        public String saveDaiLiInfoByGuid(String rowGuid)
        {
           String sql = "select unitorgnum,danweiname,areaname,statuscode,t.auditstatus,t.danweiguid,t.rowguid,zhuceziben from H_DL_BasicInfo_Temp t join HuiYuan_UnitComInfo_Temp b "
                    + "on t.danweiguid=b.danweiguid where t.rowguid = '" + rowGuid + "'";

            Record record = service.find(sql, Record.class);
            String str = "dailiguid='" + record.getStr("rowguid") + "' and xuanquguid='"+xuanQuGuid+"'";
            Boolean isexist = service.check_Item_Exist("CG_DaiLiInfo", str);
            if (record != null) 
            {
                String dailiguid = record.getStr("rowguid");
                String unitorrnum = record.get("unitorgnum");
                Double zhuceziben = record.getDouble("zhuceziben");
                String danweiname = record.get("danweiname");
                if(!isexist){
                DaiLiInfo daiLiInfo = new DaiLiInfo();
                daiLiInfo.setRowguid(UUID.randomUUID().toString());
                daiLiInfo.setUnitorgnum(unitorrnum);
                daiLiInfo.setZhucezijin(StringUtil.isNotBlank(zhuceziben) ? zhuceziben : 0d);
                daiLiInfo.setDailiguid(dailiguid);
                daiLiInfo.setDailiname(danweiname);
                daiLiInfo.setXuanquguid(xuanQuGuid);
                
                service.insert(daiLiInfo);
                }
            }
                return "保存成功!";
        }
        
    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getZzjgdm() {
        return zzjgdm;
    }

    public void setZzjgdm(String zzjgdm) {
        this.zzjgdm = zzjgdm;
    }
}
