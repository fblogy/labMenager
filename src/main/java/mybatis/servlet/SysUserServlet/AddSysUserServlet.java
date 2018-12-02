package mybatis.servlet.SysUserServlet;

import mybatis.model.SysUser;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import mybatis.util.ResponseUtil;
import mybatis.util.StringUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddSysUserServlet extends HttpServlet {

    private SysUserService sysUserService=new SysUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String sysUserAccount=request.getParameter("userAccount");
        String sysUserPassword=request.getParameter("userPassword");
        String sysUserName=request.getParameter("userName");
        String sysUserSex=request.getParameter("userSex");
        String sysUserPhone=request.getParameter("userPhone");
        String sysUserSeat=request.getParameter("userSeat");

        SysUser sysUser=new SysUser();
        sysUser.setUserAccount(sysUserAccount);
        sysUser.setUserPassword(sysUserPassword);
        sysUser.setUserName(sysUserName);
        sysUser.setUserSex(sysUserSex);
        if(StringUtil.isNotEmpty(sysUserPhone)){
            sysUser.setUserPhone(sysUserPhone);
        }
        if(StringUtil.isNotEmpty(sysUserSeat)){
            sysUser.setUserSeat(Integer.parseInt(sysUserSeat.trim()));
        }

        Integer addUserNum=sysUserService.addSysUser(sysUser);
        JSONObject jsonObject=new JSONObject();
        if(addUserNum<0){
            jsonObject.put("result","用户"+sysUserAccount+"已存在");
        } else if (addUserNum == 0) {
            jsonObject.put("result","用户保存失败");
        }else {
            jsonObject.put("result","用户"+sysUserAccount+":"+sysUserName+"保存成功");
        }

        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
