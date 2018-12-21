package mybatis.servlet.SysTaskServlet;

import mybatis.service.SysTaskService;
import mybatis.service.SysTaskServiceImpl;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTaskByIdServlet extends HttpServlet {

    SysTaskService sysTaskService=new SysTaskServiceImpl();
    JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String idStr=request.getParameter("taskId");
        boolean deleteResult=sysTaskService.deleteTaskById(Integer.parseInt(idStr));
        if(deleteResult==true){
            jsonObject.put("msg","删除作业成功");
        }
        else {
            jsonObject.put("msg","删除作业失败");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
