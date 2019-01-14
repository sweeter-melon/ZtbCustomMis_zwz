package com.epoint.pwq.pwqjiaoyi.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.bcel.generic.NEW;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.jboss.seam.annotations.Name;

import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.utils.string.StringUtil;
import com.epoint.domain.PwProjectinfo;
import com.epoint.ZtbCommon.Functions;


import Epoint.ZtbMis.Bizlogic.BasePage4List;
import Epoint.ZtbMis.Bizlogic.Sys.CustomWorkflow;
import Epoint.ZtbMis.Bizlogic.Sys.DB_Frame_CodeItem;
import Epoint.ZtbMis.Bizlogic.Sys.DB_OperationLog;
import EpointBid_Constant.Enums.ClsEnum;

/**
 * 排污权交易委托list页面对应的后台
 * 
 * @author 11016
 * @version [版本号, 2018-10-27 08:52:37]
 */
@Name("pwqjiaoyilistaction")
public class PwqJiaoyiListAction extends BasePage4List
{
    private static final long serialVersionUID = -7497413812138109344L;


    private int TableID = 20170737;

    private DataGridModel<PwProjectinfo> dataGridModel = null;


    public DataGridModel<PwProjectinfo> getDataModel() {
        if (dataGridModel == null) {
            dataGridModel = new DataGridModel<PwProjectinfo>()
            {
                @Override
                public List<PwProjectinfo> fetchData(int first, int pageSize, String sortField, String sortOrder) {

                    String where = "1=1 " + GetFilter();

                    String sql = "select * from PW_ProjectInfo where " + where;
                    String cntsql = "select count(*) from PW_ProjectInfo where " + where;

                    sql += getGridSort(sortField, sortOrder, "order by row_id desc");

                    int cnt = service.queryInt(cntsql);
                    List<PwProjectinfo> lst = service.findList(sql, first, pageSize, PwProjectinfo.class);
                    if (StringUtil.isNotBlank(lst)) {
                        AddBtnColumn(lst, "./pwqjiaoyi_Detail", "查看项目");
                    }
                    this.setRowCount(cnt);
                    return lst;
                }
            };
        }
        return dataGridModel;
    }

    protected String GetFilter() {
        String where = "";
        // 前台筛选条件
        if (StringUtil.isNotBlank(projectno))
            where += " and projectno like '%" + service.SQL_Encode(projectno) + "%'";

        if (StringUtil.isNotBlank(projectname))
            where += " and projectname like '%" + service.SQL_Encode(projectname) + "%'";
        
        if (StringUtil.isNotBlank(danweiname))
            where += " and danweiname like '%" + service.SQL_Encode(danweiname) + "%'";

        if (StringUtil.isNotBlank(ProjectType))
            where += " and ProjectType like '%" + service.SQL_Encode(ProjectType) + "%'";
        
        if (StringUtil.isNotBlank(selAuditStatus) && !"0".equals(selAuditStatus))
            where += " and AuditStatus = '" + selAuditStatus + "'";
        return where;
    }

    /**
     * 删除选定
     * 
     */
    public String deleteSelect() {
        if (getDataModel().getSelectKeys() == null || getDataModel().getSelectKeys().size() == 0)
            return "请选择要删除的项";

        for (String rowguid : getDataModel().getSelectKeys()) {

            // 删除工作流数据
            CustomWorkflow.PVI_Delete(rowguid, TableID, "PW_ProjectInfo");
            // 删除项目数据
            service.execute("delete PW_ProjectInfo where RowGuid = ?", rowguid);
            // 记录日志
            String projectName = service.queryString("select ProjectName from PW_ProjectInfo where RowGuid = ?",
                    rowguid);
            DB_OperationLog.Sys_OperationLog_Add_NoTran(rowguid, ClsEnum.SubSysName.建设工程, ClsEnum.OperName.删除,
                    "删除项目名称：" + projectName, "删除项目");
        }
        return "成功删除！";
    }

    public String excelPort() {
        String biaotou1;
        String columnnames1;
        // biaotou1=
        // "序号,计划编号,中心编号,计划名称,采购人,受理日期,预算资金（元）,审核日期,公告发布时间,报名开始时间,报名结束时间,采购方式,审核状态,经办人";
        // columnnames1 =
        // "indexcolumn,projectno,projectbianhao,shouliname,yezhudanwei,weituodate,yusuanprice,shr_date,ggsenderdate,gonggaorealfrom,gonggaorealto,caigoufs,auditstatus,xiangmufzr";
        int[] widths = {5000, 5000, 12000, 5000, 5000, 5000,5000,5000,5000,10000 };
        biaotou1 = "项目编号,受让单位,项目名称,所在区域,化学需氧量(审核量/吨/年),氨氮(审核量/吨/年),二氧化硫（吨/年）,总价,备注,审核时间";
        columnnames1 = "ProjectNo,DanWeiName,ProjectName,Area,HuaXueXuYangLiang,AnDan,ErYangHuaLiu,TotalPrice,Remark,SHR_Date";
        String[] biaotou = biaotou1.split(",");
        String[] columnnames = columnnames1.split(",");
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("排污权统计");
        for (int i = 0; i < widths.length; i++) {
            sheet.setColumnWidth(i, widths[i]);
        }

        // 第三步，创建单元格，并设置值表头 设置表头居中
        // 设置字体 统一12号
        HSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 12);
        // 样式2 只设置了字体
        HSSFCellStyle style2 = wb.createCellStyle();
        style2.setFont(font);
        // 样式 折行，可编辑，字体
        HSSFCellStyle lock = wb.createCellStyle();
        lock.setLocked(false);
        lock.setWrapText(true);
        lock.setFont(font);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 设置居中
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
        style2.setLeftBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色.
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
        style2.setRightBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
        style2.setTopBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 设置单元格的边框为粗体
        style2.setBottomBorderColor(HSSFColor.BLACK.index); // 设置单元格的边框颜色．
        style2.setFillForegroundColor(HSSFColor.WHITE.index);// 设置单元格的背景颜色．

        // 第一行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell;
        for (int i = 0; i < biaotou.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(biaotou[i]);
            cell.setCellStyle(style2);
        }
        String sql = "select * from PW_ProjectInfo";
        List<PwProjectinfo> list = service.findList(sql, PwProjectinfo.class);
        int i = 1;
        for (PwProjectinfo item : list) {
            row = sheet.createRow(i);
            for (int j = 0; j < columnnames.length; j++) {
                cell = row.createCell(j);
                if(j==3)
                {
                    item.set(columnnames[j], new DB_Frame_CodeItem().getCodeText("泰州市", item.getStr(columnnames[j])));
                }
                if(j==7)
                {
                    if(Double.parseDouble(item.getStr(columnnames[j]))<2000)
                    {
                        item.set(columnnames[j],"免收"); 
                    }
                    
                }
                cell.setCellValue(item.getStr(columnnames[j]));
                cell.setCellStyle(style2);

            }
            i++;
        }
        String fileguid = UUID.randomUUID().toString();
        try {
            String path = Functions.MapPath("~\\EpointMisTempFile\\TJ\\" + fileguid);
            File f = new File(path);
            // 创建文件夹
            if (!f.exists()) {
                f.mkdirs();
            }
            FileOutputStream fout = new FileOutputStream(path + File.separator + "排污权导出.xls");
            wb.write(fout);
            fout.close();
            wb.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return fileguid;
    }
    /**
     * 前台搜索条件
     */
    
    private String projectno = "";

    private String projectname = "";
    
    private String danweiname = "";

    private String ProjectType = "";
    
    public String getDanweiname() {
        return danweiname;
    }

    public void setDanweiname(String danweiname) {
        this.danweiname = danweiname;
    }

    public String getProjectType() {
        return ProjectType;
    }

    public void setProjectType(String projectType) {
        ProjectType = projectType;
    }
    
    public String getProjectno() {
        return projectno;
    }

    public void setProjectno(String projectnno) {
        this.projectno=projectnno;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getSelAuditStatus() {
        return selAuditStatus;
    }

    public void setSelAuditStatus(String selAuditStatus) {
        this.selAuditStatus = selAuditStatus;
    }
    
    
}
