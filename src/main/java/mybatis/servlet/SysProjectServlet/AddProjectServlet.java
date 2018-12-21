package mybatis.servlet.SysProjectServlet;

import mybatis.model.SysProject;
import mybatis.model.SysUser;
import mybatis.service.SysProjectService;
import mybatis.service.SysProjectServiceImpl;
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

public class AddProjectServlet extends HttpServlet implements Constants {

    private SysUserService sysUserService=new SysUserServiceImpl();
    private SysProjectService sysProjectService=new SysProjectServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String projectAccount=sysUser.getUserAccount();
        String projectUserName=sysUser.getUserName();

        String projectName=request.getParameter("projectName");
        String projectRequired=request.getParameter("projectRequired");
        String projectRemark=request.getParameter("projectRemark");
        String projectBeginTime=request.getParameter("projectBeginTime");
        String projectEndTime=request.getParameter("projectEndTime");

        SysProject sysProject=new SysProject();
        sysProject.setProjectName(projectName);
        sysProject.setProjectAccount(projectAccount);
        sysProject.setProjectUserName(projectUserName);
        sysProject.setProjectRequired(Integer.parseInt(projectRequired));
        sysProject.setProjectRemark(projectRemark);
        sysProject.setProjectBeginTime(DateUtil.formatString(projectBeginTime,FORMAT));
        sysProject.setProjectEndTime(DateUtil.formatString(projectEndTime,FORMAT));

        boolean insertResult=sysProjectService.addProject(sysProject);

        JSONObject jsonObject=new JSONObject();
        if(insertResult==true){
            jsonObject.put("msg","发布项目成功");
        }
        else {
            jsonObject.put("msg","发布项目失败");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
