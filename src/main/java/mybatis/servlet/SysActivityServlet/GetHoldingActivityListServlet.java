package mybatis.servlet.SysActivityServlet;

import mybatis.model.SysActivity;
import mybatis.model.SysUser;
import mybatis.service.ActivityMembersService;
import mybatis.service.ActivityMembersServiceImpl;
import mybatis.service.SysActivityService;
import mybatis.service.SysActivityServiceImpl;
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
import java.util.List;

public class GetHoldingActivityListServlet extends HttpServlet implements Constants {

    private SysActivityService sysActivityService=new SysActivityServiceImpl();
    ActivityMembersService activityMembersService=new ActivityMembersServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String activityAccount=sysUser.getUserAccount();

        SysActivity sysActivity=new SysActivity();
        sysActivity.setActivityAccount(activityAccount);

        JSONObject jsonObject=new JSONObject();
        List<SysActivity> sysActivityList=sysActivityService.getHoldingActivityList();

        /**
         * 用json传送时间数据时增加字符串格式的数据
         */
        for(SysActivity item:sysActivityList){
            item.setBeginTimeStr(DateUtil.formatDate(item.getActivityBeginTime(),DATE_FORMAT));
            item.setEndTimeStr(DateUtil.formatDate(item.getActivityEndTime(),DATE_FORMAT));
            item.setActivityCur(activityMembersService.getAttendCountByActivityID(item.getId()));

        }

        jsonObject.put("total",sysActivityList.size());
        jsonObject.put("rows",sysActivityList);

        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
