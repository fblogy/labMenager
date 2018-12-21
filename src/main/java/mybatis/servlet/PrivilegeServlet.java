package mybatis.servlet;

import mybatis.service.SysRoleService;
import mybatis.service.SysRoleServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PrivilegeServlet extends HttpServlet {
    SysRoleService sysRoleService=new SysRoleServiceImpl();
    JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String roleStr=request.getParameter("role");
        String option=request.getParameter("option");

        boolean isPrivilege=sysRoleService.selectRolePrivilege(Integer.parseInt(roleStr),option);
        if(isPrivilege==true){
            jsonObject.put("privilege",1);
        }
        else {
            jsonObject.put("privilege",0);
        }


        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
