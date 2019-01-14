package com.epoint.jywt.pwqjiaoyiweituo.action;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
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
import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.utils.string.StringUtil;
import com.epoint.domain.LgsPwqBiaodi;
import com.epoint.domain.LgsPwqJiaoyiweituo;

import Epoint.JSGCZtbMis.Bizlogic.WorkFlowPage_UsingMaster;
import Epoint.ZtbMis.Bizlogic.Sys.DB_Frame_CodeItem;
import Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog;
import EpointBid_Constant.Enums.ClsEnum;

/**
 * 选取信息表工作流页面对应的后台
 * 
 * @author 11016
 * @version [版本号, 2018-10-20 10:43:49]
 */
@Name("lgspwqjiaoyiweituoworkflowaction")
public class LgsPwqJiaoyiweituoWorkFlowAction extends WorkFlowPage_UsingMaster
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 6444671618788988631L;

    public LgsPwqJiaoyiweituoWorkFlowAction() {
        TableID = 8801; //
        TaskCode = "JiaoYiWeiTuo";
    }

    private LgsPwqJiaoyiweituo dataBean = null;
    private DataGridModel<LgsPwqBiaodi> dataGridModel1 = null;

    public void pageLoad() {
        super.pageLoad();
        getDataBean();
        if (IsAdd) {
            if (!Epoint.ZtbMis.Bizlogic.Sys.DB_AllowTo.IsZBB()) {
                // 如果不是招标办，初始化经办人信息
                dataBean.setSbr_code(MemberSession.getInstance().getUserGuid());
                dataBean.setSbr_name(MemberSession.getInstance().getDisplayName());
                dataBean.setSbr_date(new Date());
                dataBean.setSbr_unitguid(MemberSession.getInstance().getDanWeiGuid());
                dataBean.setSbr_unitname(MemberSession.getInstance().getDanweiname());
            }
        }
    }

    // 自动生成公告编号
    protected void getXQBiaoHao() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        String sql = "select * from PWQ_JiaoYiWeiTuo order by row_id desc";
        List<LgsPwqJiaoyiweituo> info = service.findList(sql, LgsPwqJiaoyiweituo.class);
        if (StringUtil.isNotBlank(info) && info.size() == 0) {
            dataBean.setProjectbh(date + "001");
        }
        else {
            int i = Integer.parseInt(info.get(0).getProjectbh().substring(8, 11)) + 1;
            dataBean.setProjectbh(date + String.format("%03d", i));
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

    public LgsPwqJiaoyiweituo getDataBean() {
        if (dataBean == null) {
            dataBean = super.getMainDataBean(LgsPwqJiaoyiweituo.class);
            dataBean.setProjectguid(dataBean.getRowguid());
        }
        return dataBean;
    }

    public DataGridModel<LgsPwqBiaodi> getDataModel1() {
        if (dataGridModel1 == null) {
            dataGridModel1 = new DataGridModel<LgsPwqBiaodi>()
            {
                @Override
                public List<LgsPwqBiaodi> fetchData(int first, int pageSize, String sortField, String SortOrder) {
                    String where = "1=1";

                    where += " and projectguid ='" + dataBean.getProjectguid() + "'";
                    String sql = "select * from PWQ_BiaoDi where " + where;
                    String cntsql = "select count(*) from PWQ_BiaoDi where " + where;
                    String sort = " order by row_id asc";
                    if (StringUtil.isNotBlank(sortField))
                        sort = " order by " + sortField + " " + SortOrder;
                    sql += sort;
                    int cnt = service.queryInt(cntsql);
                    List<LgsPwqBiaodi> lst = service.findList(sql, LgsPwqBiaodi.class);
                    this.setRowCount(cnt);
                    return lst;
                }
            };
        }
        return dataGridModel1;
    }

    public String SaveForm() {
        //委托类型是转让，文件编号和有效日期不能是空
        if(StringUtil.isNotBlank(dataBean.getWeituotype())&&"2".equals(dataBean.getWeituotype())){
            if(StringUtil.isBlank(dataBean.getShenhefilebh())||StringUtil.isBlank(dataBean.getShenhefileyxq())){
                return "审核文件编号(有效日期)不能为空！";
            }
        }
        if (StringUtil.isBlank(getDataBean().getAuditstatus()))
            dataBean.setAuditstatus(ClsEnum.AuditStatus.编辑中.getValue());
        if (IsAdd) {
            // 保存时生成编号
            getXQBiaoHao();
            
            dataBean.setOperatedate(new Date());
            service.insert(dataBean);
        }else{
            service.update(dataBean);
        }
        // 记录日志
        DB_OperationLog.Sys_OperationLog_Add_NoTran(dataBean.getProjectguid(),
                EpointBid_Constant.Enums.ClsEnum.SubSysName.其他, ClsEnum.OperName.修改,
                "保存项目，项目名称为：" + dataBean.getProjectname(), "");

        return super.SaveForm();
    }
    /**
     * [删除标信息]
     */
    public String delSelectBd() {
        for (String rowguid : getDataModel1().getSelectKeys()) {
            LgsPwqBiaodi bean = service.find("select * from Pwq_Biaodi where rowguid=? ",
                    LgsPwqBiaodi.class, rowguid);
            service.delete(bean);
            // 记录日志
            Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog.Sys_OperationLog_Add_NoTran(dataBean.getRowguid(),
                    EpointBid_Constant.Enums.ClsEnum.SubSysName.其他, EpointBid_Constant.Enums.ClsEnum.OperName.删除,
                    "删除标:"+bean.getPwzhibiaoname(), "删除标");
            
        }
        return "删除成功！";
    }
    /**
     * 工作流提交之前，判断代理数是否够
     * 
     */
    @Override
    protected String beforeSubmit_Click() {

        int count = service.queryInt("select count(*) from Pwq_Biaodi where projectguid=?", dataBean.getProjectguid());
        if (count == 0) {
            return "您并未添加标，请先添加！";
        }
        return "";
    }

    /**
     * 工作流提交后事件
     */
    @Override
    protected String btnAfterSubmit_Click(String btn) {
        if ("btnEnd".equals(btn)) {
            //标的编号，因为项目编号保存后才会生成，故在提交后对标进行编号
            List<LgsPwqBiaodi> list = service.findList("select * from PWQ_BiaoDi where ProjectGuid=? order by row_id asc", LgsPwqBiaodi.class, dataBean.getProjectguid());
            for(int i=0; i<list.size(); i++){
                String biaodiBH = dataBean.getProjectbh()+String.format("%02d", i+1);
                service.execute("UPDATE PWQ_BiaoDi set BiaoDiBH=?,ProjectBH=? where RowGuid=?", biaodiBH,dataBean.getProjectbh(),list.get(i).getRowguid());
            }
        }
        return "";
    }
    
    // 导出Excel
    public void exportExcel() {
        List<LgsPwqBiaodi> list = service.findList("select * from PWQ_BiaoDi where ProjectGuid=? order by row_id asc", LgsPwqBiaodi.class, getRequestParameter("projectguid"));
        ex(list);
    }
    private void ex(List<LgsPwqBiaodi> list) {
        XSSFWorkbook wb = new XSSFWorkbook();// 创建一个Excel文件
        XSSFSheet sheet = wb.createSheet("标的统计");// 创建一个工作簿
        // 样式1
        XSSFCellStyle style = wb.createCellStyle(); // 样式对象
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平
        // 设置标题字体格式
        XSSFFont font = wb.createFont();
        // 设置字体样式
        font.setFontHeightInPoints((short) 20); // --->设置字体大小
        font.setFontName("黑体"); // ---》设置字体，是什么类型例如：宋体
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
        style.setFont(font); // --->将字体格式加入到style中

        // 表格第一行
        XSSFRow row1 = sheet.createRow((short) 0); // --->创建一行
        row1.setHeight((short) 1000);
        XSSFCell cell1 = row1.createCell((short) 0); // --->创建一个单元格
        cell1.setCellStyle(style);
        cell1.setCellValue("标的信息");
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        // 样式2
        XSSFCellStyle style2 = wb.createCellStyle();
        XSSFFont font2 = wb.createFont();
        font2.setFontHeightInPoints((short) 18);
        font2.setFontName("黑体");
        style2.setFont(font2);
        style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直
        style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平
        // 样式3
        XSSFCellStyle style3 = wb.createCellStyle();
        XSSFFont font3 = wb.createFont();
        font3.setFontHeightInPoints((short) 18);
        font3.setFontName("宋体");
        style3.setFont(font3);
        style3.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直
        style3.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平
        // 表格第二行
        XSSFRow row2 = sheet.createRow((short) 1);
        row2.setHeight((short) 700);
        XSSFCell cell2 = null;
        for (int i = 0; i < 6; i++) {
            cell2 = row2.createCell((short) i);
            cell2.setCellValue("");
            cell2.setCellStyle(style2);
        }
        XSSFCell cell2_1 = row2.createCell((short) 0);
        cell2_1.setCellValue("序号");
        cell2_1.setCellStyle(style2);
        XSSFCell cell2_2 = row2.createCell((short) 1);
        cell2_2.setCellValue("标的编号");
        cell2_2.setCellStyle(style2);
        XSSFCell cell2_3 = row2.createCell((short) 2);
        cell2_3.setCellValue("排污指标名称");
        cell2_3.setCellStyle(style2);
        XSSFCell cell2_4 = row2.createCell((short) 3);
        cell2_4.setCellValue("排污指标所在区域");
        cell2_4.setCellStyle(style2);
        XSSFCell cell2_5 = row2.createCell((short) 4);
        cell2_5.setCellValue("交易指标数量（吨）");
        cell2_5.setCellStyle(style2);
        XSSFCell cell2_6 = row2.createCell((short) 5);
        cell2_6.setCellValue("起始价格（元/吨）");
        cell2_6.setCellStyle(style2);
        // 表格第三行
        short i = 2;
        int j = 1;
        for (LgsPwqBiaodi biaodi : list) {

            XSSFRow rowN = sheet.createRow(i++);
            XSSFCell cellN1 = rowN.createCell((short) 0);
            cellN1.setCellValue(j++);
            cellN1.setCellStyle(style3);
            XSSFCell cellN2 = rowN.createCell((short) 1);
            cellN2.setCellValue(biaodi.getBiaodibh());
            cellN2.setCellStyle(style3);
            XSSFCell cellN3 = rowN.createCell((short) 2);
            cellN3.setCellValue(biaodi.getPwzhibiaoname());
            cellN3.setCellStyle(style3);
            XSSFCell cellN4 = rowN.createCell((short) 3);
            cellN4.setCellValue(new DB_Frame_CodeItem().getCodeText("交易地区", biaodi.getPwzhibiaoquyu()));
            cellN4.setCellStyle(style3);
            XSSFCell cellN5 = rowN.createCell((short) 4);
            cellN5.setCellValue(biaodi.getJiaoyizhibiaocount());
            cellN5.setCellStyle(style3);
            XSSFCell cellN6 = rowN.createCell((short) 5);
            cellN6.setCellValue(biaodi.getQishiprice());
            cellN6.setCellStyle(style3);
        }

        sheet.setColumnWidth(0, 2000);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 10000);
        sheet.setColumnWidth(3, 7000);
        sheet.setColumnWidth(4, 8000);
        sheet.setColumnWidth(5, 8000);
        sheet.setDefaultRowHeight((short) 500);// 默认行高
        OutputStream output = null;
        try {

            HttpServletResponse response = getRequestContext().getRes();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            // 设置头时如果有中文需要用UrlEncode编码一下
            response.setHeader("Content-disposition",
                    "attachment;filename=" + StringUtil.getFileNameFromPath("BiaoDi.xlsx"));
            output = response.getOutputStream();
            wb.write(output);
            output.flush();
            requestContext.setRequestComplete(true);

        }
        catch (Exception e) {
            e.printStackTrace();
            AlertAjaxMessage(e.getMessage());
        }
        finally {
            if (output != null) {
                try {
                    wb.close();
                    output.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
