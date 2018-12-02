package mybatis.servlet.SysUserServlet;

import mybatis.model.SysUser;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteSysUserServlet extends HttpServlet {

    private SysUserService sysUserService=new SysUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String sysUserAccount=request.getParameter("userAccount");
        SysUser sysUser=new SysUser();
        sysUser.setUserAccount(sysUserAccount);
        boolean deleteResult=sysUserService.deleteUserByAccount(sysUser);
        JSONObject jsonObject=new JSONObject();
        if(deleteResult==true){
            jsonObject.put("msg","删除用户"+sysUserAccount+"成功");
        }
        else {
            jsonObject.put("msg","删除用户"+sysUserAccount+"失败");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
