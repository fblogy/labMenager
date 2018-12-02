package mybatis.servlet.SysActivityServlet;

import mybatis.model.ActivityMembers;
import mybatis.model.SysActivity;
import mybatis.model.SysUser;
import mybatis.service.*;
import mybatis.util.Constants;
import mybatis.util.DateUtil;
import mybatis.util.ResponseUtil;
import mybatis.util.StringUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class AddActivityServlet extends HttpServlet implements Constants {

    private SysUserService sysUserService=new SysUserServiceImpl();


    private ActivityMembersService activityMembersService=new ActivityMembersServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String activityAccount=sysUser.getUserAccount();
        String activityUserName=sysUser.getUserName();

        String activityName=request.getParameter("activityName");
        String activityPosition=request.getParameter("activityPosition");
        String activityBeginTime=request.getParameter("activityBeginTime");
        String activityEndTime=request.getParameter("activityEndTime");
        String activityMoney=request.getParameter("activityMoney");
        String activityMin=request.getParameter("activityMin");
        String activityMax=request.getParameter("activityMax");
        String activityRemark=request.getParameter("activityRemark");

        SysActivity sysActivity=new SysActivity();

        sysActivity.setActivityName(activityName);
        sysActivity.setActivityPosition(activityPosition);
        sysActivity.setActivityAccount(activityAccount);
        sysActivity.setActivityBeginTime(DateUtil.formatString(activityBeginTime,DATE_FORMAT));
        sysActivity.setActivityEndTime(DateUtil.formatString(activityEndTime,DATE_FORMAT));
        sysActivity.setActivityMoney(Double.parseDouble(activityMoney));
        sysActivity.setActivityMin(Short.parseShort(activityMin));
        sysActivity.setActivityMax(Short.parseShort(activityMax));
        sysActivity.setActivityRemark(activityRemark);
        sysActivity.setActivityUserName(activityUserName);

        SysActivityService sysActivityService=new SysActivityServiceImpl();
        JSONObject jsonObject=new JSONObject();

        SysActivity sysActivity1=sysActivityService.addActivity(sysActivity);

        ActivityMembers activityMembers=new ActivityMembers();
        activityMembers.setActivityId(sysActivity1.getId());
        activityMembers.setAttendTime(new Date());
        activityMembers.setActivityAccount(sysActivity.getActivityAccount());

        Integer insertNum=activityMembersService.insert(activityMembers);

        if(sysActivity1!=null&&insertNum>0){
            jsonObject.put("msg","活动提交成功,等待管理员审核");
        }
        else if(sysActivity1!=null&&insertNum==ACTIVITY_LATE){
            jsonObject.put("msg","活动提交成功,但是负责人参加活动失败，请负责人到申请参加活动页面报名活动");
        }
        else{
            jsonObject.put("msg","活动提交失败,请检查信息完整性和正确性");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
