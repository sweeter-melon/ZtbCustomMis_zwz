package com.epoint.dlcp.dailiinfo.action;

import java.util.Date;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import com.alibaba.dubbo.config.annotation.Service;
import com.epoint.domain.DaiLiInfo;

import Epoint.ZtbMis.Bizlogic.ContentPage;
import EpointBid_Constant.Enums.ClsEnum;

/**
 * 招标代理信息对应的后台
 * 
 * @author SYSTEM
 * @version [版本号, 2015-02-05 14:10:44]
 */
@Name("daiinfoworkflowaction")
@Scope(ScopeType.EVENT)
public class DaiLiInfoWorkflowAction extends ContentPage
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private DaiLiInfo daiLiInfo;

    @Override
    public void pageLoad() {
        super.pageLoad();
        String xuanQuGuid = getRequestParameter("XuanQuGuid");
        addCallbackParam("xuanQuGuid", xuanQuGuid);
        getDaiLiInfo();
    }

    public String saveInfo(String xuanQuGuid) {
        daiLiInfo.setXuanquguid(xuanQuGuid);
        daiLiInfo.setOperatedate(new Date());
        service.insert(daiLiInfo);
        // 记录日志
        Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog.Sys_OperationLog_Add_NoTran(daiLiInfo.getRowguid(),
                ClsEnum.SubSysName.其他, ClsEnum.OperName.增加, "保存新增的招标代理： ", "新增招标代理");
        return "保存成功!";
    }

    public DaiLiInfo getDaiLiInfo() {
        daiLiInfo=service.find(DaiLiInfo.class, getRequestParameter("rowguid"));
        if (daiLiInfo == null) {
            daiLiInfo = super.getMainDataBean(DaiLiInfo.class);
        }
        return daiLiInfo;
    }

    public void setDaiLiInfo(DaiLiInfo daiLiInfo) {
        this.daiLiInfo = daiLiInfo;
    }
}
