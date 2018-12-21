package mybatis.servlet.SysUserServlet;

import mybatis.model.SysRole;
import mybatis.model.SysUser;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectRoleByUserServlet extends HttpServlet {

    SysUserService sysUserService=new SysUserServiceImpl();
    JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");

        List<SysRole> roleList=sysUserService.selectRoleByUser(sysUser);

        List<Short> rolesInt=new ArrayList<>();
        for(SysRole item:roleList){
            rolesInt.add(item.getId());
        }

        jsonObject.put("total",rolesInt.size());
        jsonObject.put("rows",rolesInt);

        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
