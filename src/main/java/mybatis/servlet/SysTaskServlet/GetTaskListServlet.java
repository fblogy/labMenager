package mybatis.servlet.SysTaskServlet;

import mybatis.model.SysTask;
import mybatis.service.*;
import mybatis.util.Constants;
import mybatis.util.DateUtil;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetTaskListServlet extends HttpServlet implements Constants {

    SysTaskService sysTaskService=new SysTaskServiceImpl();
    JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<SysTask> sysTaskList=sysTaskService.getTaskList();

        for(SysTask item:sysTaskList){
            item.setTaskEndTimeStr(DateUtil.formatDate(item.getTaskEndTime(),DATE_FORMAT));
            item.setTaskPubTimeStr(DateUtil.formatDate(item.getTaskPubTime(),DATE_FORMAT));
        }

        jsonObject.put("total",sysTaskList.size());
        jsonObject.put("rows",sysTaskList);

        ResponseUtil.write(response,jsonObject);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
