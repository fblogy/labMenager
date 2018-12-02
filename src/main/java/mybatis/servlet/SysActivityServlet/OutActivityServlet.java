package mybatis.servlet.SysActivityServlet;

import mybatis.model.ActivityMembers;
import mybatis.model.SysUser;
import mybatis.service.ActivityMembersService;
import mybatis.service.ActivityMembersServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class OutActivityServlet extends HttpServlet {
    ActivityMembersService activityMembersService=new ActivityMembersServiceImpl();
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

        int deleteResult=activityMembersService.outActivity(activityMembers);

        JSONObject jsonObject=new JSONObject();
        if(deleteResult>0){
            jsonObject.put("msg","退出活动成功");
        }
        else {
            jsonObject.put("msg","退出活动失败，请重新操作");
        }


        ResponseUtil.write(response,jsonObject);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
