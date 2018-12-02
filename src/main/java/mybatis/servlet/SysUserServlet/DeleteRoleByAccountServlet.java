package mybatis.servlet.SysUserServlet;

import mybatis.model.UserRole;
import mybatis.service.UserRoleService;
import mybatis.service.UserRoleServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class DeleteRoleByAccountServlet extends HttpServlet {

    UserRoleService userRoleService=new UserRoleServiceImpl();
    JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String account=request.getParameter("account");
        String roleArray=request.getParameter("roleArray");


        String[] rolesString = roleArray.split(",");
        int   [] rolesInt=new int[rolesString.length];

        for(int i=0;i<rolesString.length;i++){
            rolesInt[i]=Integer.parseInt(rolesString[i].trim());//获得id数组
        }
        ArrayList<UserRole> userRoleArrayList=new ArrayList<>();
        for(int j=0;j<rolesString.length;++j){
            UserRole userRole=new UserRole();
            userRole.setUserAccount(account);
            userRole.setRoleId(rolesInt[j]);
            userRoleArrayList.add(userRole);
        }

        int deleteNum=userRoleService.deleteList(userRoleArrayList);
        if(deleteNum==0){
            jsonObject.put("msg","系统异常,请稍后再试");
        }
        else if(deleteNum<rolesString.length){
            jsonObject.put("msg","系统异常,部分信息删除失败,请重新删除失败的记录");
        }
        else {
            jsonObject.put("msg","删除"+rolesString.length+"条记录成功");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
