package com.epoint.jywt.pwqjiaoyiweituo.action;

import java.util.List;

import org.jboss.seam.annotations.Name;

import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.utils.string.StringUtil;
import com.epoint.domain.LgsPwqJiaoyiweituo;

import Epoint.ZtbMis.Bizlogic.BasePage4List;
import Epoint.ZtbMis.Bizlogic.Sys.CustomWorkflow;
import Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog;
import EpointBid_Constant.Enums.ClsEnum;

/**
 * 排污权交易委托list页面对应的后台
 * 
 * @author 11016
 * @version [版本号, 2018-10-27 08:52:37]
 */
@Name("lgspwqjiaoyiweituolistaction")
public class LgsPwqJiaoyiweituoListAction extends BasePage4List
{
    /**
     * 
     */
    private static final long serialVersionUID = -4618607390462172224L;

    private int TableID = 8801;

    private DataGridModel<LgsPwqJiaoyiweituo> dataGridModel = null;
    // 默认为待审核状态
    private String selAuditStatus = "2";

    public DataGridModel<LgsPwqJiaoyiweituo> getDataModel() {
        if (dataGridModel == null) {
            dataGridModel = new DataGridModel<LgsPwqJiaoyiweituo>()
            {
                @Override
                public List<LgsPwqJiaoyiweituo> fetchData(int first, int pageSize, String sortField, String sortOrder) {

                    String where = "1=1 " + GetFilter();

                    String sql = "select * from PWQ_JiaoYiWeiTuo where " + where;
                    String cntsql = "select count(*) from PWQ_JiaoYiWeiTuo where " + where;

                    sql += getGridSort(sortField, sortOrder, "order by row_id desc");

                    int cnt = service.queryInt(cntsql);
                    List<LgsPwqJiaoyiweituo> lst = service.findList(sql, first, pageSize, LgsPwqJiaoyiweituo.class);
                    if (StringUtil.isNotBlank(lst)) {
                        AddBtnColumn(lst, "jywt/pages/pwqjiaoyiweituo/pwqjiaoyiweituo_Detail", "查看项目");
                    }
                    this.setRowCount(cnt);
                    return lst;
                }
            };
        }
        return dataGridModel;
    }

    protected String GetFilter() {
        String where = "";
        // 非招标办,招标人过滤
        if (ClsEnum.Sys_DanWeiType.招标人.getValue() != null) {
            where += " and  SBR_UnitGuid='" + getSession().getDanWeiGuid() + "'";
        }
        // 前台筛选条件
        if (StringUtil.isNotBlank(projectbh))
            where += " and projectbh like '%" + service.SQL_Encode(projectbh) + "%'";

        if (StringUtil.isNotBlank(projectname))
            where += " and projectname like '%" + service.SQL_Encode(projectname) + "%'";
        
        if (StringUtil.isNotBlank(selAuditStatus) && !"0".equals(selAuditStatus))
            where += " and AuditStatus = '" + selAuditStatus + "'";
        return where;
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
            CustomWorkflow.PVI_Delete(rowguid, TableID, "PWQ_JiaoYiWeiTuo");
            // 删除项目数据
            service.execute("delete PWQ_JiaoYiWeiTuo where RowGuid = ?", rowguid);
            // 删除关联的标信息
            service.execute("delete PWQ_BiaoDi where ProjectGuid=?", rowguid);
            // 记录日志
            String projectName = service.queryString("select ProjectName from PWQ_JiaoYiWeiTuo where RowGuid = ?",
                    rowguid);
            DB_OperationLog.Sys_OperationLog_Add_NoTran(rowguid, ClsEnum.SubSysName.建设工程, ClsEnum.OperName.删除,
                    "删除项目名称：" + projectName, "删除标");
        }
        return "成功删除！";
    }

    /**
     * 前台搜索条件
     */
    
    private String projectbh = "";

    private String projectname = "";

    public String getProjectbh() {
        return projectbh;
    }

    public void setProjectbh(String projectbh) {
        this.projectbh = projectbh;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getSelAuditStatus() {
        return selAuditStatus;
    }

    public void setSelAuditStatus(String selAuditStatus) {
        this.selAuditStatus = selAuditStatus;
    }
    
    
}
