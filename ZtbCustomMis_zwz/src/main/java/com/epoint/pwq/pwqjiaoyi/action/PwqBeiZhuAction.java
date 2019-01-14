package com.epoint.pwq.pwqjiaoyi.action;


import org.jboss.seam.annotations.Name;

import com.epoint.domain.PwProjectinfo;

import Epoint.ZtbMis.Bizlogic.BasePage4List;
import Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog;
import EpointBid_Constant.Enums.ClsEnum;

/**
 * 排污权交易委托list页面对应的后台
 * 
 * @author 11016
 * @version [版本号, 2018-10-27 08:52:37]
 */
@Name("pwqbeizhuaction")
public class PwqBeiZhuAction extends BasePage4List
{
    private static final long serialVersionUID = 2704534474476230861L;

    private int TableID = 20170737;

    PwProjectinfo dataBean=null;

    String rowguid=" ";
    public void pageLoad() {
        rowguid=getRequestParameter("rowguid");
        dataBean=service.find(PwProjectinfo.class, rowguid);
    }
    
    public void saveinfo()
    {
        
        dataBean.setRemarktime(new java.util.Date());
        dataBean.setRemarkperson(getSession().getDisplayName());
     // 记录日志
        String remark = service.queryString("select Remark from PW_ProjectInfo where RowGuid = ?",
                rowguid);
        DB_OperationLog.Sys_OperationLog_Add_NoTran(rowguid, ClsEnum.SubSysName.建设工程, ClsEnum.OperName.修改,
                "修改备注：" + remark, "备注");
        System.out.println("Git success");
        service.update(dataBean);
    }
  
    
    public PwProjectinfo getDataBean() {
        return dataBean;
    }
    public void setDataBean(PwProjectinfo dataBean) {
        this.dataBean = dataBean;
    }
}
