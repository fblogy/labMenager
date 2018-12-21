package mybatis.servlet.SysUserServlet;

import mybatis.model.SysRole;
import mybatis.model.SysUser;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import mybatis.util.CookieUtil;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {

    private SysUserService userService=new SysUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        //创建session对象
        HttpSession session = request.getSession();

        String userAccount=request.getParameter("userAccount");
        String userPassword=request.getParameter("userPassword");

        SysUser sysUser=new SysUser();
        sysUser.setUserAccount(userAccount);
        sysUser.setUserPassword(userPassword);

        int loginNum=userService.login(sysUser);

        JSONObject jsonObject=new JSONObject();
        if(loginNum<0){
            jsonObject.put("result",0);
            jsonObject.put("msg","该账号不存在");
            sysUser=null;
        }
        else if(loginNum==0){
            jsonObject.put("result",0);
            jsonObject.put("msg","密码错误");
            sysUser=null;
        }
        else{
            jsonObject.put("result",1);
            jsonObject.put("msg","登陆成功");
            List<SysRole> roleList=userService.selectRoleByUser(sysUser);
            StringBuffer roleListStr=new StringBuffer();
            if(roleList.size()>0){
                session.setAttribute("role",new Integer(roleList.get(0).getId()));//保存身份,身份默认为获取的身份数组的第一个
                CookieUtil.addCookie(response,"role",roleList.get(0).getId()+"");
            }

            for(SysRole role:roleList){
                roleListStr.append(role.getId()+"_");
            }
            String userName=userService.selectUserNameByAccount(userAccount);

            sysUser.setUserName(userName);
            CookieUtil.addCookie(response,"userAccount",userAccount);
            CookieUtil.addCookie(response,"userName",userName);
            CookieUtil.addCookie(response,"roleList",roleListStr.toString().substring(0,roleListStr.length()-1));
        }

        session.setAttribute("loginUser",sysUser);//保存账号
        session.setMaxInactiveInterval(60*60*5);//三小时过时
        ResponseUtil.write(response,jsonObject);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
