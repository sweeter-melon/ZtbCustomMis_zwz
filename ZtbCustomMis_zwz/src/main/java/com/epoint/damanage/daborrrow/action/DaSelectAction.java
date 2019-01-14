package com.epoint.damanage.daborrrow.action;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.utils.string.StringUtil;
import com.epoint.domain.DZDA_ArchivesInfo;
import com.epoint.domain.XuanQuInfo;

import Epoint.ZtbMis.Bizlogic.BasePage4List;
import Epoint.ZtbMis.Bizlogic.Sys.CustomWorkflow;
import Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog;
import EpointBid_Constant.Enums.ClsEnum;

/**
 * 
 * 招标代理抽取列表
 * 
 * @作者 zwz
 * @version [版本号, 2018年11月5日]
 */
@Name("daselectaction")
@Scope(ScopeType.EVENT)
public class DaSelectAction extends BasePage4List
{
    private static final long serialVersionUID = -6394948397195053687L;
    private String archivesNo= "";// 档案编号
    private String archivesName = "";// 档案名称
    private DataGridModel<DZDA_ArchivesInfo> dataGridModel = null;
    
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
                    this.setRowCount(cnt);
                    return lst;
                }
            };
        }
        return dataGridModel;
    }

  
    
    protected String GetFilter() {
        String where = "and isborrow is null ";
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
