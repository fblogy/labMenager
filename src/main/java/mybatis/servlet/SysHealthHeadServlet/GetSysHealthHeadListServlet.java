package mybatis.servlet.SysHealthHeadServlet;

import mybatis.model.SysHealthHead;
import mybatis.service.SysHealthHeadDateService;
import mybatis.service.SysHealthHeadDateServiceImpl;
import mybatis.service.SysHealthHeadService;
import mybatis.service.SysHealthHeadServiceImpl;
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

public class GetSysHealthHeadListServlet extends HttpServlet implements Constants {

    private SysHealthHeadService sysHealthHeadService=new SysHealthHeadServiceImpl();
    SysHealthHeadDateService sysHealthHeadDateService=new SysHealthHeadDateServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<SysHealthHead> sysHealthHeadListTotal=sysHealthHeadService.getHealthHeadList();
        JSONObject jsonObject=new JSONObject();
        if(sysHealthHeadListTotal.size()<=HEALTH_HEAD_MAX_SHOW){//少于最多显示条数则全部显示
            jsonObject.put("total",sysHealthHeadListTotal.size());
            jsonObject.put("rows", sysHealthHeadListTotal);
        }
        else{
            List<SysHealthHead> sysHealthHeadList=new ArrayList<>();
            Date update=sysHealthHeadDateService.getDate();
            Date today=new Date();
            int diff= DateUtil.dayDiff(today,update);
            System.out.println("diff:"+diff);

            /**
             * 获取最大周和最小周
             */
            int minWeek=10000;
            int maxWeek=0;
            for(int i=0;i<sysHealthHeadListTotal.size();++i){
                if(sysHealthHeadListTotal.get(i).getHealthWeekOrder()<minWeek){
                    minWeek=sysHealthHeadListTotal.get(i).getHealthWeekOrder();
                }
                if(sysHealthHeadListTotal.get(i).getHealthWeekOrder()>maxWeek){
                    maxWeek=sysHealthHeadListTotal.get(i).getHealthWeekOrder();
                }
            }
            System.out.println(minWeek+" "+maxWeek);

            int dateIntOfWeekOfUpdate=DateUtil.getDateIntOfWeek(update);//上传日期在周几
            int weekDiff=0;

            for(int i=dateIntOfWeekOfUpdate;i<7;++i){//加到周日,不能挂等号
                update=DateUtil.addDay(update);
            }
            if(today.compareTo(update)>0){
                ++weekDiff;
            }
            update=DateUtil.addDay(update,7);
            while(today.compareTo(update)>0){
                update=DateUtil.addDay(update,7);
                ++weekDiff;
            }
            int currentWeek=minWeek+weekDiff;
            System.out.println(weekDiff+" "+currentWeek);

            if(maxWeek-currentWeek<=(HEALTH_HEAD_MAX_SHOW-1)){//到了最后四周或者当前周大于最大周，四周全部显示
                if(sysHealthHeadListTotal.size()<=HEALTH_HEAD_MAX_SHOW){//少于四周，全部加入
                    for(int i=0;i<sysHealthHeadListTotal.size();++i){
                        sysHealthHeadList.add(sysHealthHeadListTotal.get(i));
                    }
                }
                else {
                    for(int i=sysHealthHeadListTotal.size()-HEALTH_HEAD_MAX_SHOW;i<sysHealthHeadListTotal.size();++i){
                        sysHealthHeadList.add(sysHealthHeadListTotal.get(i));
                    }
                }
            }
            else {
                for(int i=0;i<sysHealthHeadListTotal.size();++i){
                    int weekNum=sysHealthHeadListTotal.get(i).getHealthWeekOrder();
                    if(weekNum-currentWeek>=0&&weekNum-currentWeek<HEALTH_HEAD_MAX_SHOW){
                        sysHealthHeadList.add(sysHealthHeadListTotal.get(i));
                    }
                }
            }

            jsonObject.put("total",sysHealthHeadList.size());
            jsonObject.put("rows", sysHealthHeadList);
        }
        ResponseUtil.write(response,jsonObject);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
