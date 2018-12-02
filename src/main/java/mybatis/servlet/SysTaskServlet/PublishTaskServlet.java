package mybatis.servlet.SysTaskServlet;

import mybatis.model.SysTask;
import mybatis.model.SysUser;
import mybatis.service.SysTaskService;
import mybatis.service.SysTaskServiceImpl;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
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
import java.util.Date;

public class PublishTaskServlet extends HttpServlet implements Constants {

    SysTaskService sysTaskService=new SysTaskServiceImpl();
    JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String taskAccount=sysUser.getUserAccount();
        String taskUserName=sysUser.getUserName();

        String taskName=request.getParameter("taskName");
        String taskGroup=request.getParameter("taskGroup");
        String taskRemark=request.getParameter("taskRemark");
        String taskEndTime=request.getParameter("taskEndTime");

        SysTask sysTask=new SysTask();
        sysTask.setTaskAccount(taskAccount);
        sysTask.setTaskUserName(taskUserName);
        sysTask.setTaskName(taskName);
        sysTask.setTaskGroup(taskGroup);
        sysTask.setTaskRemark(taskRemark);
        sysTask.setTaskEndTime(DateUtil.formatString(taskEndTime,DATE_FORMAT));
        sysTask.setTaskPubTime(new Date());

        boolean insertResult=sysTaskService.publishTask(sysTask);
        if(insertResult==true){
            jsonObject.put("msg","发布作业成功");
        }
        else {
            jsonObject.put("msg","发布作业失败");
        }
        ResponseUtil.write(response,jsonObject);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
