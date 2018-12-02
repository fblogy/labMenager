package mybatis.servlet.SysUserServlet;

import mybatis.model.SysUser;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ModifyPassServlet extends HttpServlet {
    private SysUserService sysUserService=new SysUserServiceImpl();
    JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser loginUser=(SysUser) session.getAttribute("loginUser");
        String userAccount=loginUser.getUserAccount();
        String pass=request.getParameter("newPass");

        SysUser sysUser=new SysUser();
        sysUser.setUserAccount(userAccount);
        sysUser.setUserPassword(pass);

        Boolean updateResult=sysUserService.modifyPass(sysUser);
        if(updateResult==true){
            jsonObject.put("msg","修改成功");
        }
        else {
            jsonObject.put("msg","修改失败");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
