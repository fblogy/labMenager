package mybatis.servlet.SysSignServlet;

import mybatis.model.SignUserAndCount;
import mybatis.service.SysSignService;
import mybatis.service.SysSignServiceImpl;
import mybatis.util.Constants;
import mybatis.util.DateUtil;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetTopSignCountByYearAndMonthServlet extends HttpServlet implements Constants {

    private SysSignService sysSignService=new SysSignServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        Date today=new Date();
        Integer year= DateUtil.getYear(today);
        Integer month=DateUtil.getMonth(today);

        String beginDateStr,endDateStr;
        /**
         * 获取上一月
         */
        if(month==1){
            month=12;
            --year;
            beginDateStr=year+"-"+month+"-"+"01";
            endDateStr=year+"-"+(month)+"-"+"31";
        } else {
            --month;
            beginDateStr=year+"-"+month+"-"+"01";
            endDateStr=year+"-"+(month+1)+"-"+"01";
            Date endDate= DateUtil.formatString(endDateStr,FORMAT);
            endDate=DateUtil.subDay(endDate);//倒退一天到上月末
            endDateStr=DateUtil.formatDate(endDate,FORMAT);
        }

        List<SignUserAndCount> signUserAndCountList=sysSignService.getTopSignCountByYearAndMonth(beginDateStr,endDateStr);

        JSONObject jsonObject =new JSONObject();
        jsonObject.put("total",signUserAndCountList.size());
        jsonObject.put("rows",signUserAndCountList);
        jsonObject.put("time",year+"年"+month+"月签到榜");

        ResponseUtil.write(response,jsonObject);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
