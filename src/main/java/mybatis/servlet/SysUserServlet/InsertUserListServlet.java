package mybatis.servlet.SysUserServlet;

import mybatis.model.SysUser;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import mybatis.util.ResponseUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InsertUserListServlet extends HttpServlet {

    private SysUserService sysUserService=new SysUserServiceImpl();
    private JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String userArrayStr=request.getParameter("rows");

        List<SysUser> sysUserList=new ArrayList<>();
        JSONArray jsonArray=new JSONArray(userArrayStr);

        for(int i=0;i<jsonArray.length();++i){
            SysUser sysUser=new SysUser();
            sysUser.setUserAccount((String)jsonArray.getJSONObject(i).get("userAccount"));
            sysUser.setUserName((String)jsonArray.getJSONObject(i).get("userName"));
            sysUser.setUserSex((String)jsonArray.getJSONObject(i).get("userSex"));
            sysUser.setUserPhone((String)jsonArray.getJSONObject(i).get("userPhone"));
            sysUser.setUserSeat(Integer.parseInt ((String)jsonArray.getJSONObject(i).get("userSeat")));
            sysUser.setUserGroup((String)jsonArray.getJSONObject(i).get("userGroup"));

            sysUserList.add(sysUser);
        }
        String addNum=sysUserService.addSysUserList(sysUserList);
        if(addNum.charAt(0)=='-'){
            jsonObject.put("msg","账号"+addNum.substring(1)+"已存在,不能重复导入");
        }
        else {
            if(Integer.parseInt(addNum)==jsonArray.length()){
                jsonObject.put("msg","导入"+addNum+"条记录成功");
            }
            else{
                jsonObject.put("msg","导入"+jsonArray.length()+"条记录失败,可能导入重复的数据或者信息格式不正确");
            }
        }

        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
