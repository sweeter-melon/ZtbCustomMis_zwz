package com.epoint.damanage.daborrrow.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.utils.string.StringUtil;
import com.epoint.domain.DZDA_ArchivesInfo;
import com.epoint.domain.DZDA_Borrow;

import Epoint.JSGCZtbMis.Bizlogic.WorkFlowPage_UsingMaster;
import Epoint.ZtbMis.Bizlogic.Common.ContextHelper;
import EpointBid_Constant.Enums.ClsEnum;

/**
 * 招标代理抽取工作流
 * 
 * @author zwz
 * @version [版本号, 2018-11-5 15:04:05]
 */
@Name("daborrowworkflowaction")
@Scope(ScopeType.EVENT)
public class DaBorrowWorkflowAction extends WorkFlowPage_UsingMaster
{
    private static final long serialVersionUID = 1848254973986873584L;

    private DZDA_ArchivesInfo archivesInfo;

    private DZDA_Borrow dataBean;

    private DataGridModel<DZDA_Borrow> defaultModel;

    private String guidangdate = ""; // 避免id重复

    public DaBorrowWorkflowAction() {
        TableID = 20170736;
        TaskCode = "DZBorrow";
    }

    @Override
    protected Map<String, String> GetContextVal() {
        Map<String, String> hashmap = super.GetContextVal();
        return hashmap;
    }

    @Override
    public void pageLoad() {
        super.pageLoad();
        getDataBean();
        if (IsAdd) {
            dataBean.setSbrcode(getSession().getUserGuid());
            dataBean.setSbrdate(new Date());
            dataBean.setSbrname(ContextHelper.getDisplayName());
            initData();
        }
        else {
            archivesInfo = service.find(DZDA_ArchivesInfo.class, dataBean.getRowguid());
        }
        guidangdate = archivesInfo.getSbrdate();
    }

    public void initData() {
        archivesInfo = service.find(DZDA_ArchivesInfo.class, getRequestParameter("rowguid"));
    }

    @Override
    protected String btnAfterSubmit_Click(String btn) {

        return super.btnAfterSubmit_Click(btn);
    }

    @Override
    protected String SaveForm() {
        dataBean.setOperatedate(new Date());
        if (StringUtil.isBlank(getDataBean().getAuditstatus())) {
            dataBean.setAuditstatus(ClsEnum.AuditStatus.编辑中.getValue());
        }

        if (IsAdd) {
            dataBean.setRowguid(archivesInfo.getRowguid());
            dataBean.setArchivesno(archivesInfo.getArchivesno());
            dataBean.setArchivesname(archivesInfo.getArchivesname());
            dataBean.setSbrcode(getSession().getUserGuid());
            dataBean.setSbrdate(new Date());
            dataBean.setSbrname(ContextHelper.getDisplayName());

            service.insert(dataBean);
            // 更新借阅状态
            archivesInfo.set("isborrow", "1");
            service.update(archivesInfo);
        }
        else {
            service.update(dataBean);
        }

        // 记录日志
        Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog.Sys_OperationLog_Add_NoTran(dataBean.getRowguid(),
                ClsEnum.SubSysName.其他, ClsEnum.OperName.增加, "", "");
        return super.SaveForm();
    }

    public DZDA_ArchivesInfo getArchivesInfo() {
        return archivesInfo;
    }

    public void setArchivesInfo(DZDA_ArchivesInfo archivesInfo) {
        this.archivesInfo = archivesInfo;
    }

    public DZDA_Borrow getDataBean() {
        if (dataBean == null) {
            dataBean = super.getMainDataBean(DZDA_Borrow.class);
        }
        return dataBean;
    }

    public void setDataBean(DZDA_Borrow dataBean) {
        this.dataBean = dataBean;
    }

    public String getGuidangdate() {
        return guidangdate;
    }

    public void setGuidangdate(String guidangdate) {
        this.guidangdate = guidangdate;
    }

}
