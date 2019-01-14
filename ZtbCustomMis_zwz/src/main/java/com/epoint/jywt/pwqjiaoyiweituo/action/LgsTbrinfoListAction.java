package com.epoint.jywt.pwqjiaoyiweituo.action;
import java.util.List;

import org.jboss.seam.annotations.Name;

import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.grammar.Record;
import com.epoint.core.utils.string.StringUtil;

import Epoint.ZtbMis.Bizlogic.BasePage4List;


/**
 * 代理候选人明细表list页面对应的后台
 * 
 * @author 11016
 * @version [版本号, 2018-10-20 10:43:38]
 */
@Name("lgstbrinfolistaction")
public class LgsTbrinfoListAction  extends BasePage4List
{

    
    /**
     * 
     */
    private static final long serialVersionUID = 2560732303713842483L;
    private DataGridModel<Record> dataGridModel = null;
    public DataGridModel<Record> getDataModel() {
        if (dataGridModel == null) {
            dataGridModel = new DataGridModel<Record>()
            {
                @Override
                public List<Record> fetchData(int first, int pageSize, String sortField, String sortOrder) {

                    String where = "1=1 " + GetFilter();

                    String sql = "select DanWeiName,UnitOrgNum,FaRen,FaRenIDCard from HuiYuan_UnitComInfo where " + where;
                    String cntsql = "select count(*) from HuiYuan_UnitComInfo where " + where;

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

    protected String GetFilter() {
        String where = "";
        // 前台筛选条件
        if (StringUtil.isNotBlank(danweiname))
            where += " and danweiname like '%" + service.SQL_Encode(danweiname) + "%'";
        if (StringUtil.isNotBlank(unitorgnum))
            where += " and unitorgnum like '%" + service.SQL_Encode(unitorgnum) + "%'";
        //招标代理
        where += " and danweitype like '%13%'";
        return where;
    }
    
    private String danweiname;
    private String unitorgnum;
    public String getDanweiname() {
        return danweiname;
    }

    public void setDanweiname(String danweiname) {
        this.danweiname = danweiname;
    }

    public String getUnitorgnum() {
        return unitorgnum;
    }

    public void setUnitorgnum(String unitorgnum) {
        this.unitorgnum = unitorgnum;
    }
    
    
}
