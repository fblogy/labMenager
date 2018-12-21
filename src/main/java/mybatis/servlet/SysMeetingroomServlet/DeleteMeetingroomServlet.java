package mybatis.servlet.SysMeetingroomServlet;

import mybatis.model.SysMeetingroom;
import mybatis.model.SysUser;
import mybatis.service.SysMeetingroomService;
import mybatis.service.SysMeetingroomServiceImpl;
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

public class DeleteMeetingroomServlet extends HttpServlet {

    private SysMeetingroomService sysMeetingroomService=new SysMeetingroomServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String userAccount=sysUser.getUserAccount();

        String dateStr=request.getParameter("date");
        String choiceStr=request.getParameter("choice");

        String[] choiceArray=choiceStr.split(",");
        Date date= DateUtil.formatString(dateStr,"yyyy-MM-dd");//前台传来的时间
        Integer orderInWeek=DateUtil.getDateIntOfWeek(date);
        List<SysMeetingroom> meetingroomList=new ArrayList<>();

        for(String item:choiceArray){
            SysMeetingroom sysMeetingroom=new SysMeetingroom();
            sysMeetingroom.setRoomAccount(userAccount);
            String orderOnWeekStr=item.charAt(0)+"";
            Integer orderOnWeekIntCur=Integer.parseInt(orderOnWeekStr);
            String seg=item.charAt(1)+"";
            sysMeetingroom.setRoomSeg(Integer.parseInt(seg));
            Date dateCur=DateUtil.addDay(date,orderOnWeekIntCur-orderInWeek);
            sysMeetingroom.setRoomDate(dateCur);
            meetingroomList.add(sysMeetingroom);
        }
        Integer deleteNum=sysMeetingroomService.deleteSysMeetingroomByList(meetingroomList);
        JSONObject jsonObject=new JSONObject();
        if(deleteNum!=0){
            jsonObject.put("msg","删除"+deleteNum+"条记录成功");
        }
        else{
            jsonObject.put("msg","删除失败");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
