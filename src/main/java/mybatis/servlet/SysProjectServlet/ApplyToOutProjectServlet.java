package mybatis.servlet.SysProjectServlet;

import mybatis.model.ProjectMembers;
import mybatis.model.SysUser;
import mybatis.service.ProjectMemberService;
import mybatis.service.ProjectMembersServiceImpl;
import mybatis.util.ResponseUtil;
import mybatis.util.StringUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class ApplyToOutProjectServlet extends HttpServlet {

    ProjectMemberService projectMemberService=new ProjectMembersServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String projectAccount=sysUser.getUserAccount();

        String projectIDStr=request.getParameter("projectID");

        Integer projectIDInt=Integer.parseInt(projectIDStr);

        ProjectMembers projectMembers=new ProjectMembers();
        projectMembers.setProjectId(projectIDInt);
        projectMembers.setProjectAccount(projectAccount);

        Integer deleteResult=projectMemberService.applyToOutProject(projectMembers);
        JSONObject jsonObject=new JSONObject();
        if(deleteResult>0){
            jsonObject.put("msg","退出项目成功");
        }
        else {
            jsonObject.put("msg","退出项目失败，请稍后再试");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
