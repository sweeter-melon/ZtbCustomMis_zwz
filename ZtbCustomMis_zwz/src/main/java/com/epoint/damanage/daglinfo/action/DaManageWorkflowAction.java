package com.epoint.damanage.daglinfo.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import com.epoint.domain.DZDA_ArchivesInfo;

import CustomFrame4Bid.Bizlogic.YWScanModal;
import Epoint.ZtbMis.Bizlogic.ContentPage;
import Epoint.ZtbMis.Bizlogic.Common.ContextHelper;
import Epoint.ZtbMis.Bizlogic.Sys.DB_AutoNumber;
import EpointBid_Constant.Enums.ClsEnum;

/**
 * 
 * 
 * @author SYSTEM
 * @version [版本号, 2015-02-05 14:10:44]
 */
@Name("damanageworkflowaction")
@Scope(ScopeType.EVENT)
public class DaManageWorkflowAction extends ContentPage
{

    /**
     * 
     */
    private static final long serialVersionUID = -508615779972969991L;
    private DZDA_ArchivesInfo dataBean;

    @Override
    public void pageLoad() {
        super.pageLoad();
        getDataBean();
        dataBean.setArchivesno(CreateProjectNO_new(""));
        dataBean.setSbrdate(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()).toString());
    }

    private YWScanModal ywscanmodule = null;

    /**
     * 
     *  [一句话功能简述] 重写电子件方法
     *  [功能详细描述]
     *  @return    
     * @exception/throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
      public Object getYwscanfileValue() {
            if (ywscanmodule == null) {
                ywscanmodule = new YWScanModal(dataBean.getRowguid(), "JSGC_DAManage", false, "", "", "", "", "");
            }
            return ywscanmodule.Render();
        }
    
    // 自动生成编号
    public static String CreateProjectNO_new(String areaPrefix) {
        Calendar a = Calendar.getInstance();
        String month = (a.get(Calendar.MONTH) + 1) + "";
        if (month.length() == 1) {
            month = "0" + month;
        }
        // LYG+2008+11+003+01 地区+年份+月份+月份流水号+标段编号
        String strNumberPrefix = areaPrefix + a.get(Calendar.YEAR) + month;
        String num = DB_AutoNumber.autoNumber("档案编号", strNumberPrefix, 3);
        return num;
    }

    public String saveInfo() {
        dataBean.set("caozuo", "2");
        dataBean.setSbrcode(getSession().getUserGuid());
        dataBean.setSbrname(ContextHelper.getDisplayName());
        service.insert(dataBean);
        // 记录日志
        Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog.Sys_OperationLog_Add_NoTran(dataBean.getRowguid(),
                ClsEnum.SubSysName.其他, ClsEnum.OperName.增加, "保存新增的档案： ", "新增招档案");
        return "保存成功!";
    }

    public DZDA_ArchivesInfo getDataBean() {
        if (dataBean == null) {
            dataBean = super.getMainDataBean(DZDA_ArchivesInfo.class);
        }
        return dataBean;
    }

    public void setDataBean(DZDA_ArchivesInfo dataBean) {
        this.dataBean = dataBean;
    }
}
