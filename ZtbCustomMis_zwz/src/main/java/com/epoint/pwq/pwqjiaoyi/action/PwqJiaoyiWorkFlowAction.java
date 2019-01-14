package com.epoint.pwq.pwqjiaoyi.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jboss.seam.annotations.Name;

import com.epoint.HuiYuan.Common.MemberSession;
import com.epoint.HuiYuan.domain.HZBRBasicInfoTemp;
import com.epoint.HuiYuan.domain.HuiyuanUnitcominfoTemp;
import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.utils.string.StringUtil;
import com.epoint.domain.DZDA_ArchivesInfo;
import com.epoint.domain.LgsPwqBiaodi;
import com.epoint.domain.LgsPwqJiaoyiweituo;
import com.epoint.domain.PwProjectinfo;

import Epoint.JSGCZtbMis.Bizlogic.WorkFlowPage_UsingMaster;
import Epoint.ZtbMis.Bizlogic.Sys.DB_AutoNumber;
import Epoint.ZtbMis.Bizlogic.Sys.DB_Frame_CodeItem;
import Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog;
import EpointBid_Constant.Enums.ClsEnum;

/**
 * 选取信息表工作流页面对应的后台
 * 
 * @author 11016
 * @version [版本号, 2018-10-20 10:43:49]
 */
@Name("pwqjiaoyiworkflowaction")
public class PwqJiaoyiWorkFlowAction extends WorkFlowPage_UsingMaster
{
    private static final long serialVersionUID = 6444671618788988631L;

    public PwqJiaoyiWorkFlowAction() {
        TableID = 20170737; //
        TaskCode = "PWQJiaoYi";
    }

    private PwProjectinfo dataBean = null;
    private HZBRBasicInfoTemp hzbrBasicInfo = new HZBRBasicInfoTemp();// 建设单位基本信息临时表（17015）

    private HuiyuanUnitcominfoTemp unitcominfo = null;// 单位基本信息表临时表实体（17044）

    public void pageLoad() {
        super.pageLoad();
        getDataBean();
       
        if (IsAdd) {
            unitcominfo = service.find(HuiyuanUnitcominfoTemp.class, getSession().getDanWeiGuid());
            hzbrBasicInfo = service.find("select * from H_ZBR_BasicInfo_Temp where danweiguid=?", HZBRBasicInfoTemp.class,
                    getSession().getDanWeiGuid());
            dataBean.setHuaxuexuyangliang(0.000);
            dataBean.setAndan(0.000);
            dataBean.setEryanghualiu(0.000);
            dataBean.setProjecttype("1");
        }
        else{
            unitcominfo = service.find(HuiyuanUnitcominfoTemp.class, dataBean.getDanweiguid());
            hzbrBasicInfo = service.find("select * from H_ZBR_BasicInfo_Temp where danweiguid=?", HZBRBasicInfoTemp.class,
                    dataBean.getDanweiguid());
        }
    }

    /**
     * 设置上下文值
     */
    protected Map<String, String> GetContextVal() {
        Map<String, String> hashmap = super.GetContextVal();
        hashmap.put("XiaQuCode", getDataBean().getXiaqucode());
        hashmap.put("ProjectJiaoYiType", "PWQ");
        hashmap.put("ProjectName", dataBean.getProjectname());// 代办名称
        return hashmap;
    }

    public PwProjectinfo getDataBean() {
        if (dataBean == null) {
            dataBean = super.getMainDataBean(PwProjectinfo.class);
            dataBean.setProjectguid(dataBean.getRowguid());
        }
        return dataBean;
    }

    public String SaveForm() {
        dataBean.setDanweiname(getSession().getDanweiname());
        if (StringUtil.isBlank(getDataBean().getAuditstatus()))
            dataBean.setAuditstatus(ClsEnum.AuditStatus.编辑中.getValue());
        if (IsAdd) {
            //存入申报人信息
            dataBean.setSbrcode(getSession().getUserGuid());
            dataBean.setDanweiguid(getSession().getDanWeiGuid());
            dataBean.setOperatedate(new Date());
            service.insert(dataBean);
        }
        else {
            service.update(dataBean);
        }
        // 记录日志
        DB_OperationLog.Sys_OperationLog_Add_NoTran(dataBean.getProjectguid(),
                EpointBid_Constant.Enums.ClsEnum.SubSysName.其他, ClsEnum.OperName.修改,
                "保存项目，项目名称为：" + dataBean.getProjectname(), "");

        return super.SaveForm();
    }

    /**
     * 工作流提交后事件
     */
    @Override
    protected String btnAfterSubmit_Click(String btn) {
        if ("btnEnd".equals(btn)) {
            // 审核通过设置编号
            dataBean.setProjectno(CreateProjectNO_new("PWQ"));
            service.update(dataBean);
        }
        return "";
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

    public void setDataBean(PwProjectinfo dataBean) {
        this.dataBean = dataBean;
    }

    public HZBRBasicInfoTemp getHzbrBasicInfo() {
        return hzbrBasicInfo;
    }

    public void setHzbrBasicInfo(HZBRBasicInfoTemp hzbrBasicInfo) {
        this.hzbrBasicInfo = hzbrBasicInfo;
    }

    public HuiyuanUnitcominfoTemp getUnitcominfo() {
        return unitcominfo;
    }

    public void setUnitcominfo(HuiyuanUnitcominfoTemp unitcominfo) {
        this.unitcominfo = unitcominfo;
    }

}
