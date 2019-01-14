package com.epoint.damanage.daborrrow.action;

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
import Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog;
import EpointBid_Constant.Enums.ClsEnum;

/**
 * 
 * 招标代理抽取列表
 * 
 * @作者 zwz
 * @version [版本号, 2018年11月5日]
 */
@Name("dachakanaction")
@Scope(ScopeType.EVENT)
public class DachakanAction extends BasePage4List
{
    private static final long serialVersionUID = 8053096619751042939L;
    /**
     * 一页表格modal
     */

    /**
     * 前台搜索条件
     */
    private String archivesNo= "";// 档案编号
    private String archivesName = "";// 档案名称
    private String status="" ;//状态
   
    private DataGridModel<Record> dataGridModel = null;
    
    public DataGridModel<Record> getDataModel() {
        if (dataGridModel == null) {
            dataGridModel = new DataGridModel<Record>()
            {
                @Override
                public List<Record> fetchData(int first, int pageSize, String sortField, String sortOrder) {

                    String where = " 1=1  " ;

                    String sql = "select a.*,b.BorrowStartTime,b.BorrowEndTime,b.SBR_Name sbrn,b.SBR_Date sbrd"
                            + ",b.Remark,b.auditstatus from DZDA_ArchivesInfo a ,DZDA_Borrow b "
                            + "where a.rowguid=b.rowguid  and  auditstatus='3' and "  + where;
                    String cntsql = "select count(*) from DZDA_ArchivesInfo where " + where;
                    sql += getGridSort(sortField, sortOrder, "order by row_id desc");

                    int cnt = service.queryInt(cntsql);
                    List<Record> lst = service.findList(sql, first, pageSize, Record.class);
                   
                    this.setRowCount(cnt);
                    return lst;
                }
            };
        }
        return dataGridModel;
    }

     //更新状态
    public void updatestatus(String rowguid)
    {
        DZDA_ArchivesInfo archivesInfo=service.find(DZDA_ArchivesInfo.class, rowguid);
        archivesInfo.set("status", "1");
        service.update(archivesInfo);
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

    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
    
}
