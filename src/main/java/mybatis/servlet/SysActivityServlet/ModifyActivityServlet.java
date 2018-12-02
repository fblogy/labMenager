package mybatis.servlet.SysActivityServlet;

import mybatis.model.SysActivity;
import mybatis.model.SysUser;
import mybatis.service.*;
import mybatis.util.DateUtil;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static mybatis.util.Constants.DATE_FORMAT;

public class ModifyActivityServlet extends HttpServlet {

    private SysActivityService sysActivityService=new SysActivityServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String activityAccount=sysUser.getUserAccount();
        String activityUserName=sysUser.getUserName();

        String activityIDStr=request.getParameter("activityID");
        String activityName=request.getParameter("activityName");
        String activityPosition=request.getParameter("activityPosition");

        String activityBeginTime=request.getParameter("activityBeginTime");
        String activityEndTime=request.getParameter("activityEndTime");
        String activityMoney=request.getParameter("activityMoney");
        String activityMin=request.getParameter("activityMin");
        String activityMax=request.getParameter("activityMax");
        String activityRemark=request.getParameter("activityRemark");
        Integer activityID=Integer.parseInt(activityIDStr);

        SysActivity sysActivity=new SysActivity();

        sysActivity.setId(activityID);
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

        JSONObject jsonObject=new JSONObject();

        Integer updateResult=sysActivityService.modifyActivity(sysActivity);
        if(updateResult>0){
            jsonObject.put("msg","修改成功");
        }
        else {
            jsonObject.put("msg","修改失败");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
