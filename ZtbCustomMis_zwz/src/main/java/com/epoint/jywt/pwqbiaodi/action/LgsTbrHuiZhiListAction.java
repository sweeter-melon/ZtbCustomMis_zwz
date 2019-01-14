package com.epoint.jywt.pwqbiaodi.action;

import java.util.List;

import org.jboss.seam.annotations.Name;

import com.epoint.HuiYuan.Common.MemberSession;
import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.utils.string.StringUtil;
import com.epoint.domain.LgsPwqJiaoyiweituo;

import Epoint.ZtbMis.Bizlogic.BasePage4List;

/**
 * 排污权交易委托list页面对应的后台
 * 
 * @author 11016
 * @version [版本号, 2018-10-27 08:52:37]
 */
@Name("lgstbrhuizhilistaction")
public class LgsTbrHuiZhiListAction extends BasePage4List
{
    /**
     * 
     */
    private static final long serialVersionUID = -7110564012956804095L;

    private DataGridModel<LgsPwqJiaoyiweituo> dataGridModel = null;

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
                    this.setRowCount(cnt);
                    return lst;
                }
            };
        }
        return dataGridModel;
    }

    protected String GetFilter() {
        String where = "";
        // 受委托的项目过滤
        where += " and unitorgnum='" + MemberSession.getInstance().getUnitOrgNum() + "'";
        // 前台筛选条件
        if (StringUtil.isNotBlank(projectbh))
            where += " and projectbh like '%" + service.SQL_Encode(projectbh) + "%'";

        if (StringUtil.isNotBlank(projectname))
            where += " and projectname like '%" + service.SQL_Encode(projectname) + "%'";
        return where;
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
