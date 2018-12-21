package mybatis.servlet.SysProjectServlet;

import mybatis.model.ProjectMembers;
import mybatis.model.SysUser;
import mybatis.service.ProjectMemberService;
import mybatis.service.ProjectMembersServiceImpl;
import mybatis.util.Constants;
import mybatis.util.DateUtil;
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

public class ApplyToJoinProjectServlet extends HttpServlet implements Constants {

    ProjectMemberService projectMemberService=new ProjectMembersServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String projectAccount=sysUser.getUserAccount();

        String projectIDStr=request.getParameter("projectID");
        String pmReason=request.getParameter("pmReason");

        Integer projectIDInt=Integer.parseInt(projectIDStr);

        ProjectMembers projectMembers=new ProjectMembers();
        projectMembers.setProjectId(projectIDInt);
        projectMembers.setProjectAccount(projectAccount);
        if(StringUtil.isNotEmpty(pmReason)){
            projectMembers.setPmReason(pmReason);
        }

        projectMembers.setPmTime(new Date());

        Integer insertResult=projectMemberService.applyToJoinProject(projectMembers);
        JSONObject jsonObject=new JSONObject();
        if(insertResult==1){
            jsonObject.put("msg","申请提交成功,等待负责人审核");
        }
        else if(insertResult==0){
            jsonObject.put("msg","申请提交失败,请检查信息的准确性和完整性");
        }
        else if(insertResult==PROJECT_ATTENDED){
            jsonObject.put("msg","这个项目已经报过名啦");
        }
        else if(insertResult==PROJECT_LATE){
            jsonObject.put("msg","项目报名日期已经截至了,可以联系负责人修改截至日期哦");
        }
        else if(insertResult==PROJECT_FULL){
            jsonObject.put("msg","项目报名人数已满");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
