package mybatis.servlet.SysProjectServlet;

import mybatis.model.SysProject;
import mybatis.service.SysProjectService;
import mybatis.service.SysProjectServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProjectByIDServlet extends HttpServlet {

    private SysProjectService sysProjectService=new SysProjectServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String projectIDStr=request.getParameter("projectID");
        Integer projectIDInt=Integer.parseInt(projectIDStr);

        SysProject sysProject=new SysProject();
        sysProject.setId(projectIDInt);

        boolean deleteResult=sysProjectService.deleteProjectByID(sysProject);

        JSONObject jsonObject=new JSONObject();
        if(deleteResult==true){
            jsonObject.put("msg","删除编号为"+projectIDInt+"的项目成功");
        }
        else {
            jsonObject.put("msg","删除编号为"+projectIDInt+"的项目失败");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
