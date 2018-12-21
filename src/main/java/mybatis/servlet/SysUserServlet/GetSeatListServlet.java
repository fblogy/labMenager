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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetSeatListServlet extends HttpServlet {

    private SysUserService sysUserService=new SysUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<SysUser> sysUserList=sysUserService.getSeatList();

        for(SysUser item:sysUserList){
            item.setId(0);
            item.setUserPhone("");
            item.setUserSex("");
            item.setUserPassword("");
            item.setUserScore(0);
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("total",sysUserList.size());
        jsonObject.put("rows",sysUserList);

        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
