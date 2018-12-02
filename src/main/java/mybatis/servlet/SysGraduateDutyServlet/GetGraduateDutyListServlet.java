package mybatis.servlet.SysGraduateDutyServlet;

import mybatis.model.SysGraduateDuty;
import mybatis.service.SysGraduateDutyService;
import mybatis.service.SysGraduateDutyServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetGraduateDutyListServlet extends HttpServlet {

    private SysGraduateDutyService sysGraduateDutyService=new SysGraduateDutyServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        List<SysGraduateDuty> graduateDutyList=sysGraduateDutyService.getGraduateDutyList();

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("total",graduateDutyList.size());
        jsonObject.put("rows",graduateDutyList);

        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
