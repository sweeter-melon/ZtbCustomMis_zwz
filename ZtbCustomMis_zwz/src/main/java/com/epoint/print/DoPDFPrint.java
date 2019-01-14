package com.epoint.print;

import java.util.UUID;

import com.epoint.HuiYuan.domain.HZBRBasicInfoTemp;
import com.epoint.HuiYuan.domain.HuiyuanUnitcominfoTemp;
import com.epoint.ZtbCommon.ZtbCommonDao;
import com.epoint.domain.LgsPwqJiaoyiweituo;
import com.epoint.domain.PwProjectinfo;

import Epoint.NetZtbMis.Bizlogic.PDF.PDFPrintEntity;
import Epoint.ZtbMis.Bizlogic.VelocityHelper;
import Epoint.ZtbMis.Bizlogic.Sys.DB_Frame_CodeItem;

public class DoPDFPrint
{
    ZtbCommonDao service = ZtbCommonDao.getInstance();

    /**
     * 导出项目申请表PDF
     * 
     * @return
     * @exception/throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public PDFPrintEntity PDFPrint_PWQ(String DicPath, String PrintDirection, String XiaQuCode,
            String ClientGuid, String ProjectGuid, String BiaoDuanGuid) {
        String pGuid = UUID.randomUUID().toString();
        String name = "排污权指标申请核定表.pdf";

        String templateName = "pages_zwz/pwq/template/pwqrecord.vm";
        VelocityHelper velocityHelper = new VelocityHelper(templateName);
        
        
        PwProjectinfo pwProjectinfo = service.find(PwProjectinfo.class, ClientGuid);
        velocityHelper.put("pwProjectinfo", pwProjectinfo);
        
        HuiyuanUnitcominfoTemp unitcominfo = service.find(HuiyuanUnitcominfoTemp.class, pwProjectinfo.getDanweiguid());
        HZBRBasicInfoTemp hzbrBasicInfo = service.find("select * from H_ZBR_BasicInfo_Temp where danweiguid=?", HZBRBasicInfoTemp.class,
                pwProjectinfo.getDanweiguid());
        velocityHelper.put("unitcominfo", unitcominfo);
        velocityHelper.put("hzbrBasicInfo", hzbrBasicInfo);
        //区域
        String Area=new DB_Frame_CodeItem().getCodeText("泰州市", pwProjectinfo.getArea());
        //排污授权项目交易方式
        String ProjectType=new DB_Frame_CodeItem().getCodeText("排污授权项目交易方式", pwProjectinfo.getProjecttype());
        
        velocityHelper.put("Area", Area);
        velocityHelper.put("ProjectType", ProjectType);

        String sResult = velocityHelper.Render();
        PDFPrintEntity pdfPrintEntity = new PDFPrintEntity();
        pdfPrintEntity.setHtmlContent(sResult);
        pdfPrintEntity.setNeedConvertPDF(true);
        pdfPrintEntity.setPdfName(name);
        pdfPrintEntity.setPdfPath(pGuid);
        return pdfPrintEntity;
    }

   
}
