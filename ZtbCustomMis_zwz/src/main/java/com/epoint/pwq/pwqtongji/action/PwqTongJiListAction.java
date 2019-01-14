package com.epoint.pwq.pwqtongji.action;

import java.util.Date;
import java.util.List;

import org.apache.bcel.generic.NEW;
import org.jboss.seam.annotations.Name;

import com.epoint.core.dto.model.DataGridModel;
import com.epoint.core.utils.string.StringUtil;
import com.epoint.domain.PwProjectinfo;

import Epoint.ZtbMis.Bizlogic.BasePage4List;

/**
 * 排污权交易委托list页面对应的后台
 * 
 * @author 11016
 * @version [版本号, 2018-10-27 08:52:37]
 */
@Name("pwqtongjilistaction")
public class PwqTongJiListAction extends BasePage4List
{
    private static final long serialVersionUID = -2130618338030144380L;

    private int TableID = 20170737;

    private DataGridModel<PwProjectinfo> dataGridModel1 = null;

    private String StartTime;
    private String EndTime;

    public DataGridModel<PwProjectinfo> getDataModel1() {
        if (dataGridModel1 == null) {
            dataGridModel1 = new DataGridModel<PwProjectinfo>()
            {
                @Override
                public List<PwProjectinfo> fetchData(int first, int pageSize, String sortField, String sortOrder) {

                    String where = "1=1 " + GetFilter();

                    String sql = "select Area,sum(HuaXueXuYangLiang) HuaXueXuYangLiang,sum(AnDan) AnDan, sum(ErYangHuaLiu) ErYangHuaLiu, "
                            + "sum(TotalPrice) TotalPrice from PW_ProjectInfo where " + where;
                    String cntsql = "select count(*) from PW_ProjectInfo where " + where;

                    int cnt = service.queryInt(cntsql);
                    List<PwProjectinfo> lst = service.findList(sql, PwProjectinfo.class);
                    Double sumHuaXueXuYangLiang = 0.000;
                    Double sumAnDan = 0.000;
                    Double sumErYangHuaLiu = 0.000;
                    Double sumTotalPrice = 0.000;
                    for (PwProjectinfo r : lst) {
                        sumHuaXueXuYangLiang += r.getHuaxuexuyangliang();
                        sumAnDan += r.getAndan();
                        sumErYangHuaLiu += r.getEryanghualiu();
                        sumTotalPrice += r.getTotalprice();
                        r.setShowtotalprice(r.getTotalprice().toString());
                        if (r.getTotalprice() < 2000) {
                            r.setShowtotalprice("免收");
                        }
                    }
                    PwProjectinfo sum = new PwProjectinfo();
                    sum.setArea("总计");
                    sum.setHuaxuexuyangliang(sumHuaXueXuYangLiang);
                    sum.setAndan(sumAnDan);
                    sum.setEryanghualiu(sumErYangHuaLiu);
                    sum.setShowtotalprice(sumTotalPrice.toString());
                    if (sumTotalPrice < 2000) {
                        sum.setShowtotalprice("免收");
                    }
                    lst.add(sum);
                    this.setRowCount(cnt);
                    return lst;
                }
            };
        }
        return dataGridModel1;
    }

    protected String GetFilter() {
        String where = "";
        // 前台筛选条件
        if (StringUtil.isNotBlank(StartTime))
            where += " and SHR_Date >convert(datetime,'" + StartTime + "',120)";

        if (StringUtil.isNotBlank(EndTime))
            where += " and SHR_Date <convert(datetime,'" + EndTime + "',120)";

        where += " group by Area";
       
        return where;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

}
