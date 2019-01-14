package com.epoint.damanage.daborrrow.action;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.utils.string.StringUtil;
import com.epoint.domain.DZDA_Borrow;

import Epoint.ZtbMis.Bizlogic.BasePage4List;
import EpointBid_Constant.Enums.ClsEnum;

@Name("daborrowlistaction")
@Scope(ScopeType.EVENT)
public class DaBorrowListAction extends BasePage4List
{

    private static final long serialVersionUID = 3374826936067249779L;
    private String archivesNo;// 档案编号
   
    private String archivesName;// 档案名称

    private DataGridModel<DZDA_Borrow> defaultModel;

    public String getFilter() {
        String where = "";
        if (!"0".equals(getSelAuditStatus())) {
            where += " and Auditstatus='" + service.SQL_Encode(getSelAuditStatus()) + "' ";
        }
        if (StringUtil.isNotBlank(archivesNo)) {
            where += "and archivesNo like '" + archivesNo + "'";
        }

        if (StringUtil.isNotBlank(archivesName)) {
            where += "and archivesName like '" + archivesName + "'";
        }
        return where;
    }

    public DataGridModel<DZDA_Borrow> getDataModel() {
        if (defaultModel == null) {
            defaultModel = new DataGridModel<DZDA_Borrow>()
            {
                @Override
                public List<DZDA_Borrow> fetchData(int first, int pageSize, String sortField, String sortOrder) {
                    String where = " 1=1 " + getFilter();
                    String sql = "select " + dealGridFields(this) + " from DZDA_Borrow where " + where;
                    String ctnSQL = "select count(*) from DZDA_Borrow where " + where;
                    sql += getGridSort(sortField, sortOrder, " order by row_id desc");

                    int ctn = service.queryInt(ctnSQL);
                    List<DZDA_Borrow> list = service.findList(sql, first, pageSize, DZDA_Borrow.class);

                    AddBtnColumn(list, "./DZDA_Borrow_Detail", "查看抽取详情");
                    this.setRowCount(ctn);
                    return list;
                }
            };
        }
        return defaultModel;
    }

    /**
     * 删除抽取记录
     * 
     * @return
     * @exception/throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public String deleteSelect() {
        for (String rowguid : getDataModel().getSelectKeys()) {
            DZDA_Borrow DZDA_Borrow = service.find(DZDA_Borrow.class, rowguid);
            service.delete(DZDA_Borrow);

            Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog.Sys_OperationLog_Add_NoTran(DZDA_Borrow.getRowguid(),
                    ClsEnum.SubSysName.其他, ClsEnum.OperName.增加, "删除招标代理抽取记录： ", "招标代理抽取");
        }
        return "删除成功!";
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
