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
import java.util.List;

public class GetMySubmitTaskListServlet extends HttpServlet {

    private TaskSubmitService taskSubmitService=new TaskSubmitServiceImpl();
    private JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String account=request.getParameter("submitAccount");
        List<TaskSubmitRecord> taskSubmitRecordList=taskSubmitService.getMySubmitList(account);
        jsonObject.put("total",taskSubmitRecordList.size());
        jsonObject.put("rows",taskSubmitRecordList);
        ResponseUtil.write(response,jsonObject);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
