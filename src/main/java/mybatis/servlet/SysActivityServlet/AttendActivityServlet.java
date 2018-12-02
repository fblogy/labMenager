package mybatis.servlet.SysActivityServlet;

import mybatis.model.ActivityMembers;
import mybatis.model.SysActivity;
import mybatis.model.SysUser;
import mybatis.service.ActivityMembersService;
import mybatis.service.ActivityMembersServiceImpl;
import mybatis.service.SysActivityService;
import mybatis.service.SysActivityServiceImpl;
import mybatis.util.Constants;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class AttendActivityServlet extends HttpServlet implements Constants {

    private ActivityMembersService activityMembersService=new ActivityMembersServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String activityAccount=sysUser.getUserAccount();

        String activityIDStr=request.getParameter("activityID");
        Integer activityIDInt=Integer.parseInt(activityIDStr);
        ActivityMembers activityMembers=new ActivityMembers();
        activityMembers.setActivityId(activityIDInt);
        activityMembers.setActivityAccount(activityAccount);
        activityMembers.setAttendTime(new Date());

        int insertResult=activityMembersService.insert(activityMembers);

        JSONObject jsonObject=new JSONObject();

        if(insertResult==1){
            jsonObject.put("msg","活动报名成功");
        }
        else if(insertResult==0){
            jsonObject.put("msg","活动报名失败");
        }
        else if(insertResult==ACTIVITY_ATTENDED){
            jsonObject.put("msg","该活动已经报过名啦");
        }
        else if(insertResult==ACTIVITY_FULL){
            jsonObject.put("msg","人数已经满啦,不能报名");
        }
        else if(insertResult==ACTIVITY_LATE){
            jsonObject.put("msg","活动已经开始啦,不能报名");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
