package mybatis.servlet.SysActivityServlet;

import mybatis.model.SysActivity;
import mybatis.service.SysActivityService;
import mybatis.service.SysActivityServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteActivityServlet extends HttpServlet {

    private SysActivityService sysActivityService=new SysActivityServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String activityIDStr=request.getParameter("activityID");
        Integer activityIDInt=Integer.parseInt(activityIDStr);
        SysActivity sysActivity=new SysActivity();
        sysActivity.setId(activityIDInt);

        JSONObject jsonObject=new JSONObject();
        boolean DeleteResult=sysActivityService.deleteActivityByID(sysActivity);
        if(DeleteResult==true){
            jsonObject.put("msg","编号为"+activityIDInt+"的活动删除成功");
        }
        else{
            jsonObject.put("msg","编号为"+activityIDInt+"的活动删除失败");
        }
        ResponseUtil.write(response,jsonObject);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
