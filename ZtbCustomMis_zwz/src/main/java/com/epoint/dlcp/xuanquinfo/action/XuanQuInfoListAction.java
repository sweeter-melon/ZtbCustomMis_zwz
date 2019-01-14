package com.epoint.dlcp.xuanquinfo.action;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.utils.string.StringUtil;
import com.epoint.domain.XuanQuInfo;

import Epoint.ZtbMis.Bizlogic.BasePage4List;
import EpointBid_Constant.Enums.ClsEnum;

/**
 * 
 * 招标代理抽取列表
 * 
 * @作者 dff
 * @version [版本号, 2018年11月5日]
 */
@Name("xuanquinfolistaction")
@Scope(ScopeType.EVENT)
public class XuanQuInfoListAction extends BasePage4List
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String xuanquno;// 选取编号
    private String xuanquname;// 选取名称
    private String shengqingdatefrom;// 申请开始时间
    private String shengqingdateto;// 申请结束时间

    private DataGridModel<XuanQuInfo> defaultModel;

    public String getFilter() {
        String where = "";
        if (!"0".equals(getSelAuditStatus())) {
            where += " and Auditstatus='" + service.SQL_Encode(getSelAuditStatus()) + "' ";
        }
        if (StringUtil.isNotBlank(xuanquno)) {
            where += "and xuanquno like '" + xuanquno + "'";
        }

        if (StringUtil.isNotBlank(xuanquname)) {
            where += "and xuanquname like '" + xuanquname + "'";
        }

        if (StringUtil.isNotBlank(shengqingdatefrom) && StringUtil.isNotBlank(shengqingdateto)) {
            where += "and shengqingdate > '" + shengqingdatefrom + "' and shengqingdate < '" + shengqingdateto + "'";
        }
        return where;
    }

    public DataGridModel<XuanQuInfo> getDataModel() {
        if (defaultModel == null) {
            defaultModel = new DataGridModel<XuanQuInfo>()
            {
                @Override
                public List<XuanQuInfo> fetchData(int first, int pageSize, String sortField, String sortOrder) {
                    String where = " 1=1 " + getFilter();
                    String sql = "select " + dealGridFields(this) + " from CG_XuanQuInfo where " + where;
                    String ctnSQL = "select count(*) from CG_XuanQuInfo where " + where;
                    sql += getGridSort(sortField, sortOrder, " order by row_id desc");

                    int ctn = service.queryInt(ctnSQL);
                    List<XuanQuInfo> list = service.findList(sql, first, pageSize, XuanQuInfo.class);

                    AddBtnColumn(list, "./XuanQuInfo_Detail", "查看抽取详情");
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
            XuanQuInfo xuanQuInfo = service.find(XuanQuInfo.class, rowguid);
            service.delete(xuanQuInfo);

            Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog.Sys_OperationLog_Add_NoTran(xuanQuInfo.getRowguid(),
                    ClsEnum.SubSysName.其他, ClsEnum.OperName.增加, "删除招标代理抽取记录： ", "招标代理抽取");
        }
        return "删除成功!";
    }

    public String getXuanquno() {
        return xuanquno;
    }

    public void setXuanquno(String xuanquno) {
        this.xuanquno = xuanquno;
    }

    public String getXuanquname() {
        return xuanquname;
    }

    public void setXuanquname(String xuanquname) {
        this.xuanquname = xuanquname;
    }

    public String getShengqingdatefrom() {
        return shengqingdatefrom;
    }

    public void setShengqingdatefrom(String shengqingdatefrom) {
        this.shengqingdatefrom = shengqingdatefrom;
    }

    public String getShengqingdateto() {
        return shengqingdateto;
    }

    public void setShengqingdateto(String shengqingdateto) {
        this.shengqingdateto = shengqingdateto;
    }

}
