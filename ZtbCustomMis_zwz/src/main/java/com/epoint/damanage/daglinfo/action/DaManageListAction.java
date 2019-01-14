package com.epoint.damanage.daglinfo.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.grammar.Record;
import com.epoint.core.utils.string.StringUtil;
import com.epoint.domain.DZDA_ArchivesInfo;

import Epoint.ZtbMis.Bizlogic.BasePage4List;
import Epoint.ZtbMis.Bizlogic.Sys.CustomWorkflow;
import Epoint.ZtbMis.Bizlogic.Sys.DB_AllowTo;
import Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog;
import EpointBid_Constant.Enums.ClsEnum;

/**
 * 招标代理信息对应的后台
 * 
 * @author SYSTEM
 * @version [版本号, 2015-02-05 14:10:44]
 */
@Name("damanagelistaction")
@Scope(ScopeType.EVENT)
public class DaManageListAction extends BasePage4List
{

    private static final long serialVersionUID = 1L;
  
    /**
     * 一页表格modal
     */

    /**
     * 前台搜索条件
     */
    private String archivesNo= "";// 档案编号
    private String archivesName = "";// 档案名称
    private DataGridModel<DZDA_ArchivesInfo> dataGridModel = null;
    private int TableID = 20170735;
    private String isadmin="0";
    
    public void pageLoad() {
        
        if(!DB_AllowTo.IsCurrentUserInRole("档案管理员")){
            AddExtValue("isadmin", isadmin);
        }
        super.pageLoad();
    }
    
    public DataGridModel<DZDA_ArchivesInfo> getDataModel() {
        if (dataGridModel == null) {
            dataGridModel = new DataGridModel<DZDA_ArchivesInfo>()
            {
                @Override
                public List<DZDA_ArchivesInfo> fetchData(int first, int pageSize, String sortField, String sortOrder) {

                    String where = "1=1 " + GetFilter();

                    String sql = "select * from DZDA_ArchivesInfo where " + where;
                    String cntsql = "select count(*) from DZDA_ArchivesInfo where " + where;

                    sql += getGridSort(sortField, sortOrder, "order by row_id desc");

                    int cnt = service.queryInt(cntsql);
                    List<DZDA_ArchivesInfo> lst = service.findList(sql, first, pageSize, DZDA_ArchivesInfo.class);
                       for(DZDA_ArchivesInfo r:lst){
                        if("2".equals(r.getStr("caozuo")))
                        r.set("caozuo",
                                "<a class='action-icon icon-search' onclick=\"javascript:epoint.openTopDialog('查看档案','./DaManage_Detail?rowguid="
                                        + r.getRowguid()  +"', function(){epoint.refresh();})\"></a>");
                    }
                
                    this.setRowCount(cnt);
                    return lst;
                }
            };
        }
        return dataGridModel;
    }

    /**
     * 删除选定
     * 
     */
    public String deleteSelect() {
        if (getDataModel().getSelectKeys() == null || getDataModel().getSelectKeys().size() == 0)
            return "请选择要删除的项";

        for (String rowguid : getDataModel().getSelectKeys()) {

            // 删除工作流数据
            CustomWorkflow.PVI_Delete(rowguid, TableID, "DZDA_ArchivesInfo");
            // 删除项目数据
            service.execute("delete DZDA_ArchivesInfo where RowGuid = ?", rowguid);
            // 记录日志
            String archivesNo = service.queryString("select archivesNo from DZDA_ArchivesInfo where RowGuid = ?",
                    rowguid);
            DB_OperationLog.Sys_OperationLog_Add_NoTran(rowguid, ClsEnum.SubSysName.建设工程, ClsEnum.OperName.删除,
                    "删除项目名称：" + archivesNo, "删除档案");
        }
        return "成功删除！";
    }
    
    protected String GetFilter() {
        String where = "";
        // 前台筛选条件
        if (StringUtil.isNotBlank(archivesNo))
            where += " and archivesNo like '%" + service.SQL_Encode(archivesNo) + "%'";
        if (StringUtil.isNotBlank(archivesName))
            where += " and archivesName like '%" + service.SQL_Encode(archivesName) + "%'";
        return where;
    }
    
    public String getArchivesNo() {
        return archivesNo;
    }

    public void setArchivesNo(String archivesNo) {
        this.archivesNo = archivesNo;
    }

    public String getArchivesName() {
        return archivesName;
    }

    public void setArchivesName(String archivesName) {
        this.archivesName = archivesName;
    }

    
    
}