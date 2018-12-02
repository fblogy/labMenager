package mybatis.servlet.SysTaskServlet;

import com.github.pagehelper.Constant;
import mybatis.model.SysUser;
import mybatis.model.TaskSubmitRecord;
import mybatis.service.TaskSubmitService;
import mybatis.service.TaskSubmitServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

import static mybatis.util.Constants.TASK_SUBMIT_LATE;

public class SubmitTaskServlet extends HttpServlet implements Constant {

    private TaskSubmitService taskSubmitService=new TaskSubmitServiceImpl();
    JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String submitAccount=sysUser.getUserAccount();

        String taskId=request.getParameter("taskId");
        String submitName=request.getParameter("submitName");
        Date date=new Date();

        TaskSubmitRecord taskSubmitRecord=new TaskSubmitRecord();
        taskSubmitRecord.setTaskId(Integer.parseInt(taskId));
        taskSubmitRecord.setTaskSubmitAccount(submitAccount);
        taskSubmitRecord.setTaskSubmitName(submitName);
        taskSubmitRecord.setTaskSubmitTime(date);

        Integer insertResult=taskSubmitService.insert(taskSubmitRecord);

        if(insertResult==TASK_SUBMIT_LATE){
            jsonObject.put("msg","作业提交的截至日期已过，可以联系组长修改截至日期");
        }
        else if(insertResult==0){
            jsonObject.put("msg","作业提交失败");
        }
        else {
            jsonObject.put("msg","作业提交成功");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
