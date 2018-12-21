package mybatis.servlet.SysActivityServlet;


import mybatis.service.SysActivityService;
import mybatis.service.SysActivityServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class IsPassActivityServlet extends HttpServlet {

    private SysActivityService sysActivityService=new SysActivityServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String inspectResultStr=request.getParameter("inspectResult");
        String activityIDStr=request.getParameter("activityID");
        Integer activityIDInt=Integer.parseInt(activityIDStr);
        Short inspectResultInt=Short.parseShort(inspectResultStr);

        boolean updateResult=sysActivityService.isPassActivity(inspectResultInt,activityIDInt);

        JSONObject jsonObject=new JSONObject();

        if(updateResult==true){
            jsonObject.put("msg","操作成功");
        }
        else {
            jsonObject.put("msg","操作失败");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
