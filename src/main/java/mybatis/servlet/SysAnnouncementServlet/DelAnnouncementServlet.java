package mybatis.servlet.SysAnnouncementServlet;

import mybatis.service.SysAnnouncementService;
import mybatis.service.SysAnnouncementServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelAnnouncementServlet extends HttpServlet {
    private SysAnnouncementService sysAnnouncementService=new SysAnnouncementServiceImpl();
    private JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String idStr=request.getParameter("id");
        Boolean delNum=sysAnnouncementService.delAnnouncement(Integer.parseInt(idStr));
        if(delNum==true){
            jsonObject.put("msg","删除通知成功");
        }
        else {
            jsonObject.put("msg","删除通知失败");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
