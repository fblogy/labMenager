package mybatis.servlet.SysTaskServlet;

import mybatis.model.TaskSubmitRecord;
import mybatis.service.TaskSubmitService;
import mybatis.service.TaskSubmitServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ResubmitTaskServlet extends HttpServlet {
    private TaskSubmitService taskSubmitService=new TaskSubmitServiceImpl();
    JSONObject jsonObject=new JSONObject();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String idStr=request.getParameter("id");
        String submitName=request.getParameter("submitName");
        Date date=new Date();

        TaskSubmitRecord taskSubmitRecord=new TaskSubmitRecord();
        taskSubmitRecord.setId(Integer.parseInt(idStr));
        taskSubmitRecord.setTaskSubmitName(submitName);
        taskSubmitRecord.setTaskSubmitTime(date);

        boolean insertResult=taskSubmitService.update(taskSubmitRecord);

        if(insertResult==true){
            jsonObject.put("msg","作业重新提交成功");
        }
        else {
            jsonObject.put("msg","作业重新提交失败");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
