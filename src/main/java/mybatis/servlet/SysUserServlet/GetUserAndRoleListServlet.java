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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetUserAndRoleListServlet extends HttpServlet {

    private SysUserService userService=new SysUserServiceImpl();
    private JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<SysUser> sysUserList=userService.selectUserList(null);
        List<ArrayList<Short> > roleList=new ArrayList<ArrayList<Short> >();
        for(SysUser userItem:sysUserList){
            List<SysRole> rolesOfUser=userService.selectRoleByUser(userItem);
            ArrayList<Short> rolesInt=new ArrayList<>();
            for(SysRole roleItem:rolesOfUser){
                rolesInt.add(roleItem.getId());
            }
            roleList.add(rolesInt);
        }
        jsonObject.put("total",sysUserList.size());
        jsonObject.put("users",sysUserList);
        jsonObject.put("roles",roleList);

        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
