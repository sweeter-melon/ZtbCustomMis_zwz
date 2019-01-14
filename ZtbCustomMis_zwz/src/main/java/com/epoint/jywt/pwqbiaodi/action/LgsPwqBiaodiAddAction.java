package com.epoint.jywt.pwqbiaodi.action;

import java.util.Date;

import org.jboss.seam.annotations.Name;

import com.epoint.domain.LgsPwqBiaodi;

import Epoint.ZtbMis.Bizlogic.ContentPage;

/**
 * 标的表新增页面对应的后台
 * 
 * @author 11016
 * @version [版本号, 2018-10-27 08:52:44]
 */
@Name("lgspwqbiaodiaddaction")
public class LgsPwqBiaodiAddAction extends ContentPage
{
    /**
     * 
     */
    private static final long serialVersionUID = 351055758759272271L;

    public LgsPwqBiaodiAddAction() {
        TableID = 8801;// 代理信息表
    }

    /**
     * 代理候选人明细表实体对象
     */
    private LgsPwqBiaodi dataBean = null;

    public void pageLoad() {
        getDataBean();
        if (IsAdd) {
            dataBean.setOperateusername(userSession.getDisplayName());
            dataBean.setProjectguid(getRequestParameter("projectguid"));
            dataBean.setProjectbh(getRequestParameter("projectbh"));
            dataBean.setBiaodiguid(dataBean.getRowguid());
        }
    }

    public LgsPwqBiaodi getDataBean() {
        if (dataBean == null) {
            dataBean = super.getMainDataBean(LgsPwqBiaodi.class);
        }
        return dataBean;
    }

    /**
     * 保存并关闭
     * 
     */
    public String save() {
        // 同一项目标的数量不能大于4个
        int i = service.queryInt("select count(*) from PWQ_BiaoDi where projectguid=? ", dataBean.getProjectguid());
        if (i > 3) {
            return "一个项目最多4个标！";
        }
        if (IsAdd) {
            dataBean.setOperatedate(new Date());
            service.insert(dataBean);
        }
        else {
            service.update(dataBean);
        }
        return "保存成功！";
    }


}
