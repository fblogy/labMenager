package mybatis.servlet.SysProjectServlet;

import mybatis.model.SysProject;
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
import java.io.IOException;
import java.util.List;

public class GetOverProjectListServlet extends HttpServlet implements Constants {

    private SysProjectService sysProjectService=new SysProjectServiceImpl();
    private ProjectMemberService projectMemberService=new ProjectMembersServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<SysProject> sysProjectList=sysProjectService.getOverProjectList();

        for(SysProject item:sysProjectList){
            item.setProjectBeginTimeStr(DateUtil.formatDate(item.getProjectBeginTime(),FORMAT));
            item.setProjectEndTimeStr(DateUtil.formatDate(item.getProjectEndTime(),FORMAT));
            item.setProjectCur(projectMemberService.getAttendCountByProjectID(item.getId()));
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("total",sysProjectList.size());
        jsonObject.put("rows",sysProjectList);
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
