package mybatis.servlet.SysSignServlet;

import mybatis.model.SysSign;
import mybatis.service.SysSignService;
import mybatis.service.SysSignServiceImpl;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import mybatis.util.Constants;
import mybatis.util.DateUtil;
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

public class InsertSignRecordServlet extends HttpServlet implements Constants {

    SysSignService sysSignService=new SysSignServiceImpl();
    SysUserService sysUserService=new SysUserServiceImpl();
    JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String signArrayStr=request.getParameter("rows");
        JSONArray jsonArray=new JSONArray(signArrayStr);

        List<SysSign> sysSignList=new ArrayList<SysSign>();

        /**
         * 通过账号查找姓名，防止姓名输错
         */
        for(int i=0;i<jsonArray.length();++i){
            SysSign sysSign=new SysSign();
            sysSign.setSignAccount((String) jsonArray.getJSONObject(i).get("signId"));
            sysSign.setSignName(sysUserService.selectUserNameByAccount(sysSign.getSignAccount()));
            sysSign.setSignTime(DateUtil.formatString(((String)jsonArray.getJSONObject(i).get("signTime")),DATE_FORMAT));
            sysSignList.add(sysSign);
        }

        Integer insertNum=sysSignService.insertList(sysSignList);
        if(insertNum==sysSignList.size()){
            jsonObject.put("msg","导入签到记录成功");
        }
        else{
            jsonObject.put("msg","签到记录导入异常,请检查信息完整性和正确性,并重新导入");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
