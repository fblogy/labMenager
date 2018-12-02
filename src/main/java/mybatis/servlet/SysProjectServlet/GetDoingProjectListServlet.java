package mybatis.servlet.SysProjectServlet;

import mybatis.model.SysProject;
import mybatis.model.SysUser;
import mybatis.service.ProjectMemberService;
import mybatis.service.ProjectMembersServiceImpl;
import mybatis.service.SysProjectService;
import mybatis.service.SysProjectServiceImpl;
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
import java.util.List;

public class GetDoingProjectListServlet extends HttpServlet implements Constants {

    private SysProjectService sysProjectService=new SysProjectServiceImpl();
    private ProjectMemberService projectMemberService=new ProjectMembersServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String projectAccount=sysUser.getUserAccount();

        List<SysProject> sysProjectList=sysProjectService.getDoingProjectList();

        for(SysProject item:sysProjectList){
            item.setProjectBeginTimeStr(DateUtil.formatDate(item.getProjectBeginTime(),FORMAT));
            item.setProjectEndTimeStr(DateUtil.formatDate(item.getProjectEndTime(),FORMAT));
            item.setProjectCur(projectMemberService.getAttendCountByProjectID(item.getId()));
            if(item.getProjectAccount().equals(projectAccount)){
                item.setMyStatus(2);//项目是本人发起的
            }
            else {
                if(projectMemberService.isAttendProject(projectAccount,item.getId())){
                    item.setMyStatus(1);//已报名
                }
                else{
                    item.setMyStatus(0);//未报名
                }
            }
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("total",sysProjectList.size());
        jsonObject.put("rows",sysProjectList);
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
