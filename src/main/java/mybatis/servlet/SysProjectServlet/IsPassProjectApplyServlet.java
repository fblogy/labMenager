package mybatis.servlet.SysProjectServlet;

import mybatis.model.ProjectMembers;
import mybatis.model.SysUser;
import mybatis.service.ProjectMemberService;
import mybatis.service.ProjectMembersServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IsPassProjectApplyServlet extends HttpServlet {

    ProjectMemberService projectMemberService=new ProjectMembersServiceImpl();
    JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String projectAccount=sysUser.getUserAccount();

        String projectIDStr=request.getParameter("projectID");
        String projectStatusStr=request.getParameter("projectStatus");

        Integer projectStatusInt=Integer.parseInt(projectStatusStr);
        Integer projectIDInt=Integer.parseInt(projectIDStr);

        ProjectMembers projectMembers=new ProjectMembers();
        projectMembers.setProjectId(projectIDInt);
        projectMembers.setProjectAccount(projectAccount);
        projectMembers.setPmStatus(projectStatusInt);

        Integer updateResult=projectMemberService.isPassProjectApply(projectMembers);

        if(updateResult>0){
            jsonObject.put("msg","操作成功");
        }
        else {
            jsonObject.put("msg","操作失败");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
