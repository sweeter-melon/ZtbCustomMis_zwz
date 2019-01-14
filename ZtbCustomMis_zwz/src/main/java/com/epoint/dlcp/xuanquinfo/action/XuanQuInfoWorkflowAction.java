package com.epoint.dlcp.xuanquinfo.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.utils.string.StringUtil;
import com.epoint.domain.DaiLiInfo;
import com.epoint.domain.XuanQuInfo;

import Epoint.JSGCZtbMis.Bizlogic.WorkFlowPage_UsingMaster;
import Epoint.ZtbMis.Bizlogic.Common.ContextHelper;
import Epoint.ZtbMis.Bizlogic.Sys.DB_AutoNumber;
import EpointBid_Constant.Enums.ClsEnum;

/**
 * 招标代理抽取工作流
 * 
 * @author dff
 * @version [版本号, 2018-11-5 15:04:05]
 */
@Name("xuanquinfoworkflowaction")
@Scope(ScopeType.EVENT)
public class XuanQuInfoWorkflowAction extends WorkFlowPage_UsingMaster
{

    /**
     * 
     */
    private static final long serialVersionUID = -5705348773790624477L;

    private XuanQuInfo dataBean;

    private DataGridModel<DaiLiInfo> defaultModel;

    public XuanQuInfoWorkflowAction() {
        TableID = 30800;
        TaskCode = "DaiLiChouQu";
    }

    @Override
    protected Map<String, String> GetContextVal() {
        Map<String, String> hashmap = super.GetContextVal();
        hashmap.put("RowGuid", getDataBean().getRowguid());
        return hashmap;
    }

    @Override
    public void pageLoad() {
        super.pageLoad();
        
        getDataBean();
        dataBean.setXuanquno(CreateProjectNO_new(""));
        initData();
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
            DaiLiInfo daiLiInfo = service.find(DaiLiInfo.class, rowguid);
            service.delete(daiLiInfo);

            Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog.Sys_OperationLog_Add_NoTran(daiLiInfo.getRowguid(),
                    ClsEnum.SubSysName.其他, ClsEnum.OperName.增加, "删除新增的代理： ", "新增的代理");
        }
        return "删除成功!";
    }
    
    public void initData() {
        if (IsAdd) {
            String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
            int i = (int) (Math.random() * 900 + 100);
            String myStr = Integer.toString(i);
            //dataBean.setXuanquno(date + myStr);
            dataBean.setShengqingdate(new Date());
            dataBean.setDanweiname(ContextHelper.getdanweiname());
            dataBean.setXuanquguid(dataBean.getRowguid());
            
        }
            
    }
 // / </summary>
    // / <param name="AreaPrefix">区域前缀</param>
    // / <returns>项目编号</returns>
    public static String CreateProjectNO_new(String areaPrefix) {
        Calendar a = Calendar.getInstance();
        String month = (a.get(Calendar.MONTH) + 1) + "";
        if (month.length() == 1) {
            month = "0" + month;
        }
        // LYG+2008+11+003+01 地区+年份+月份+月份流水号+标段编号
        String strNumberPrefix = areaPrefix + a.get(Calendar.YEAR) + month;
        String num = DB_AutoNumber.autoNumber("项目编号", strNumberPrefix, 3);
        return num;
    }
    @Override
    protected String btnAfterSubmit_Click(String btn) {
        if (btn.equals("btnEnd")) {
            // 随机从添加的代理中抽取一个作为中选代理
            Random random = new Random();
            int n = random.nextInt(getDataModel().getWrappedData().size());
            
            DaiLiInfo daiLiInfo = getDataModel().getWrappedData().get(n);

            daiLiInfo.setIszhongxuan("1");// 设置该代理已经中选
            service.update(daiLiInfo);
            String daiLiName = daiLiInfo.getDailiname();
            XuanQuInfo xuanQuInfo = service.find(XuanQuInfo.class, daiLiInfo.getXuanquguid());
            xuanQuInfo.setDailiname(daiLiName);
            service.update(xuanQuInfo);

            return "抽取成功!";
        }

        return super.btnAfterSubmit_Click(btn);
    }

    @Override
    protected String SaveForm() {
        dataBean.setOperatedate(new Date());
        if (StringUtil.isBlank(getDataBean().getAuditstatus())) {
            dataBean.setAuditstatus(ClsEnum.AuditStatus.编辑中.getValue());
        }
        // 若选取代理家数少于3家，则不允许提交，并提示。
        int dailiCount = getDataModel().getWrappedData().size();
        if (dailiCount < 3) {
            return "选取代理家数不能少于3家!";
        }
        if (IsAdd) {
            if (StringUtil.isNotBlank(ContextHelper.getdanweiguid())) {
                dataBean.setSbrunitguid(ContextHelper.getdanweiguid());
            }
            if (StringUtil.isNotBlank(ContextHelper.getdanweiname())) {
                dataBean.setSbrunitname(ContextHelper.getdanweiname());
            }
            dataBean.setSbrcode(getSession().getUserGuid());
            dataBean.setSbrdate(new Date());
            dataBean.setSbrname(ContextHelper.getDisplayName());

            service.insert(dataBean);
        }
        else {
            service.update(dataBean);
        }

        // 记录日志
        Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog.Sys_OperationLog_Add_NoTran(dataBean.getRowguid(),
                ClsEnum.SubSysName.其他, ClsEnum.OperName.增加, "保存招标代理抽取记录： ", "新增招标代理抽取");
        return super.SaveForm();
    }

    public DataGridModel<DaiLiInfo> getDataModel() {
        if (defaultModel == null) {
            defaultModel = new DataGridModel<DaiLiInfo>()
            {
                @Override
                public List<DaiLiInfo> fetchData(int first, int pageSize, String sortField, String sortOrder) {
                    String where = " 1=1 and XuanQuGuid = '" + getRowGuid() + "'";
                    String sql = "select * from CG_DaiLiInfo where " + where;
                    String ctnSQL = "select count(*) from CG_DaiLiInfo where " + where;
                    sql += getGridSort(sortField, sortOrder, " order by row_id desc");

                    int ctn = service.queryInt(ctnSQL);
                    List<DaiLiInfo> list = service.findList(sql, first, pageSize, DaiLiInfo.class);
                    this.setRowCount(ctn);
                    return list;
                }
            };
        }
        return defaultModel;
    }


    public XuanQuInfo getDataBean() {
        if (dataBean == null) {
            dataBean = super.getMainDataBean(XuanQuInfo.class);
        }
        return dataBean;
    }

    public void setDataBean(XuanQuInfo dataBean) {
        this.dataBean = dataBean;
    }

}
