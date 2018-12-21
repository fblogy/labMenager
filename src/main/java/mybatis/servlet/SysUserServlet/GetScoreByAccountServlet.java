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
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetScoreByAccountServlet extends HttpServlet {

    private SysUserService sysUserService=new SysUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");

        Integer score=sysUserService.getScoreByAccount(sysUser);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("score",score);

        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
