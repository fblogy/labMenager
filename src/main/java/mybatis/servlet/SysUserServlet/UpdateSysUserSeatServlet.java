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
import java.util.ArrayList;
import java.util.List;

public class UpdateSysUserSeatServlet extends HttpServlet {

    SysUserService sysUserService=new SysUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        SysUser sysUser=new SysUser();
        sysUser.setUserAccount("221600416");
        sysUser.setUserSeat(Integer.parseInt("5"));

        SysUser sysUser2=new SysUser();
        sysUser2.setUserAccount("221600418");
        sysUser2.setUserSeat(Integer.parseInt("6"));

        List<SysUser> sysUserList=new ArrayList<>();
        sysUserList.add(sysUser);
        sysUserList.add(sysUser2);

        JSONObject jsonObject=new JSONObject();
        Integer updateNum=sysUserService.updateSysUserSeat(sysUserList);
        if(updateNum==sysUserList.size()){
            jsonObject.put("msg","修改工作位成功");
        }
        else if(updateNum<sysUserList.size()&&updateNum!=0){
            jsonObject.put("msg","修改部分失败,请检查信息是否正确");
        }
        else if(updateNum==0){
            jsonObject.put("msg","修改工作位失败");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
