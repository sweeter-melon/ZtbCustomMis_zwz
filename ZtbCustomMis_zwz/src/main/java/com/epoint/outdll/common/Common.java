package com.epoint.outdll.common;


import java.util.UUID;

import com.epoint.domain.PwProjectinfo;
import com.epoint.pbzjmis.domain.SmsMessagtmp;

import Epoint.ZtbMis.Bizlogic.ContentPage;

public class Common extends ContentPage
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    /**
     * 工作流
     * 外部方法判断总价
     * 根据规模 选择走哪条流程
     * 
     * 
     * @param rowguid
     */
    public boolean isqueryTotalPrice(String rowguid) {
        PwProjectinfo pwProjectinfo = service.find(PwProjectinfo.class, rowguid);
        Double total = pwProjectinfo.getTotalprice();
        if (total >= 2000) {
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * 工作流
     * 外部方法判断项目预算规模
     * 根据规模 选择走哪条流程
     * 
     * 
     * @param rowguid
     */
    public boolean isnotqueryTotalPrice(String rowguid) {
        return !isqueryTotalPrice(rowguid);
    }
    

   

    /**
     * 短信通知联系人
     * 返回对应的userguid即可
     * @see [类、类#方法、类#成员]
     */
    public void getMessage(String rowguid) {
    
        String userguid = service.queryString("select sbr_code from PW_ProjectInfo where rowguid=?",rowguid);
        //往短信表插入数据
        String sql="insert into smsmessage(RECEIVEUSERID) values('"+userguid+"')";
        service.execute(sql);
    }
    
    
}
