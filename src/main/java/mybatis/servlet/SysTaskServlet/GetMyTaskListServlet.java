package mybatis.servlet.SysTaskServlet;

import mybatis.model.SysTask;
import mybatis.model.SysUser;
import mybatis.model.TaskSubmitRecord;
import mybatis.service.*;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetMyTaskListServlet extends HttpServlet {

    private SysTaskService taskService=new SysTaskServiceImpl();
    private SysUserService sysUserService=new SysUserServiceImpl();
    private TaskSubmitService taskSubmitService=new TaskSubmitServiceImpl();
    private JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String submitAccount=sysUser.getUserAccount();

        List<SysTask> taskList=taskService.getMyTaskList(sysUserService.selectGroupByAccount(sysUser.getUserAccount()));
        List<Integer> isSubmitList=taskSubmitService.getIsSubmitList(taskList,submitAccount);

        jsonObject.put("total",taskList.size());
        jsonObject.put("rows",taskList);
        jsonObject.put("isSubmitList",isSubmitList);

        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
