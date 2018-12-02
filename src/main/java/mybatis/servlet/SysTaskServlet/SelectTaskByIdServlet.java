package mybatis.servlet.SysTaskServlet;

import com.github.pagehelper.Constant;
import mybatis.model.SysTask;
import mybatis.service.SysTaskService;
import mybatis.service.SysTaskServiceImpl;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import mybatis.util.DateUtil;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static mybatis.util.Constants.DATE_FORMAT;

public class SelectTaskByIdServlet extends HttpServlet implements Constant {

    SysTaskService sysTaskService=new SysTaskServiceImpl();
    JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String idStr=request.getParameter("taskId");
        SysTask sysTask =sysTaskService.selectTaskById(Integer.parseInt(idStr));

        if(sysTask!=null){
            sysTask.setTaskPubTimeStr(DateUtil.formatDate(sysTask.getTaskPubTime(),DATE_FORMAT));
            sysTask.setTaskEndTimeStr(DateUtil.formatDate(sysTask.getTaskEndTime(),DATE_FORMAT));
            jsonObject.put("result",1);
            jsonObject.put("task",sysTask);
        }
        else {
            jsonObject.put("result",0);
        }

        ResponseUtil.write(response,jsonObject);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
