package mybatis.servlet.SysProjectServlet;

import com.github.pagehelper.Constant;
import mybatis.model.ProjectMembers;
import mybatis.model.SysUser;
import mybatis.service.ProjectMemberService;
import mybatis.service.ProjectMembersServiceImpl;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
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

import static mybatis.util.Constants.FORMAT;

public class GetApplyerListServlet extends HttpServlet implements Constant {

    private ProjectMemberService projectMemberService=new ProjectMembersServiceImpl();
    private SysUserService sysUserService=new SysUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String projectAccount=sysUser.getUserAccount();

        List<ProjectMembers> projectMembersList=projectMemberService.getApplyerList(projectAccount);

        for(ProjectMembers item:projectMembersList){
            item.setPmTimeStr(DateUtil.formatDate(item.getPmTime(),FORMAT));
            item.setUserName(sysUserService.selectUserNameByAccount(item.getProjectAccount()));
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("total",projectMembersList.size());
        jsonObject.put("rows",projectMembersList);

        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
