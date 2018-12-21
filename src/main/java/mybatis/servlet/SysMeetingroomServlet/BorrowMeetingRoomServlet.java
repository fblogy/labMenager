package mybatis.servlet.SysMeetingroomServlet;

import mybatis.model.SysMeetingroom;
import mybatis.model.SysUser;
import mybatis.service.SysMeetingroomService;
import mybatis.service.SysMeetingroomServiceImpl;
import mybatis.util.Constants;
import mybatis.util.DateUtil;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowMeetingRoomServlet extends HttpServlet implements Constants {

    private SysMeetingroomService sysMeetingroomService=new SysMeetingroomServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String userAccount=sysUser.getUserAccount();

        String dateStr=request.getParameter("date");
        String frequencyStr=request.getParameter("frequency");
        String choiceStr=request.getParameter("choice");

        String[] choiceArray=choiceStr.split(",");
        Date date= DateUtil.formatString(dateStr,"yyyy-MM-dd");//前台传来的时间
        Integer orderInWeek=DateUtil.getDateIntOfWeek(date);
        List<SysMeetingroom> meetingroomList=new ArrayList<>();

        int cycleCount=1;
        if(frequencyStr.equals(FREQUENCY_CURRENT_WEEK)) {//频率为当周
            cycleCount=1;
        }
        else{
            cycleCount=WEEK_COUNT;
        }
        for(int i=1;i<=cycleCount;++i) {
            for (String choiceItem : choiceArray) {
                String orderInWeekItemStr = choiceItem.charAt(0) + "";
                String segItemStr = choiceItem.charAt(1) + "";
                int orderInWeekItem = Integer.parseInt(orderInWeekItemStr);//星期数
                int segItem = Integer.parseInt(segItemStr);//时间段数

                SysMeetingroom sysMeetingroom = new SysMeetingroom();
                sysMeetingroom.setRoomAccount(userAccount);
                sysMeetingroom.setRoomSeg(segItem);
                sysMeetingroom.setRoomDate(DateUtil.addDay(date, orderInWeekItem - orderInWeek));

                meetingroomList.add(sysMeetingroom);
            }
            date=DateUtil.addDay(date,7);//轮到下一周
        }

        int result=sysMeetingroomService.insertList(meetingroomList);

        JSONObject jsonObject=new JSONObject();
        if(result==-1){
            jsonObject.put("result","会议室预定有冲突,请重新选择");
        }
        else if(result==0){
            jsonObject.put("result","系统异常，稍后再试");
        }
        else{
            jsonObject.put("result","会议室预定成功");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
