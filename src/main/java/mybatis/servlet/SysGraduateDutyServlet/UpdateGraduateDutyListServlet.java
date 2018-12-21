package mybatis.servlet.SysGraduateDutyServlet;

import mybatis.model.SysGraduateDuty;
import mybatis.model.SysHealthHead;
import mybatis.service.SysGraduateDutyService;
import mybatis.service.SysGraduateDutyServiceImpl;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import mybatis.util.ResponseUtil;
import org.json.JSONObject;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdateGraduateDutyListServlet extends HttpServlet {

    private SysGraduateDutyService sysGraduateDutyService=new SysGraduateDutyServiceImpl();
    SysUserService sysUserService=new SysUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String graduateDutyStr=request.getParameter("rows");

        List<SysGraduateDuty> sysGraduateDutyList=new ArrayList<>();
        JSONArray jsonArray=new JSONArray(graduateDutyStr);

        System.out.println(jsonArray.toString());
        /**
         * 通过账号查找姓名，防止姓名输错
         */
        for(int i=0;i<jsonArray.length();++i){
            SysGraduateDuty sysGraduateDuty=new SysGraduateDuty();
            sysGraduateDuty.setGraduateDutyOrderonweek(Integer.parseInt((String)jsonArray.getJSONObject(i).get("dayWeek")));
            sysGraduateDuty.setId(sysGraduateDuty.getGraduateDutyOrderonweek());//星期数和id保持一致
            sysGraduateDuty.setGraduateDutyAccount((String)jsonArray.getJSONObject(i).get("yjsId"));
            sysGraduateDuty.setGraduateDutyName(sysUserService.selectUserNameByAccount(sysGraduateDuty.getGraduateDutyAccount()));
            sysGraduateDuty.setGraduateDutyPhone((String)jsonArray.getJSONObject(i).get("yjsPhone"));

            sysGraduateDutyList.add(sysGraduateDuty);
        }

        Boolean result=sysGraduateDutyService.updateGraduateDutyList(sysGraduateDutyList);
        JSONObject jsonObject=new JSONObject();
        if(result==true){
            jsonObject.put("msg","信息修改成功");
        }
        else {
            jsonObject.put("msg","部分信息修改失败，请检查信息完整性和正确性,并重新导入");
        }
        ResponseUtil.write(response,jsonObject);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
