package mybatis.servlet.SysAnnouncementServlet;

import mybatis.model.SysAnnouncement;
import mybatis.model.SysUser;
import mybatis.service.SysAnnouncementService;
import mybatis.service.SysAnnouncementServiceImpl;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class AddAnnouncementServlet extends HttpServlet {

    private SysAnnouncementService sysAnnouncementService=new SysAnnouncementServiceImpl();
    private JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String account=sysUser.getUserAccount();
        String name=sysUser.getUserName();

        String text=request.getParameter("text");
        Date date=new Date();

        SysAnnouncement sysAnnouncement=new SysAnnouncement();
        sysAnnouncement.setAnAccount(account);
        sysAnnouncement.setAnText(text);
        sysAnnouncement.setAnDate(date);
        sysAnnouncement.setAnName(name);

        boolean insertResult=sysAnnouncementService.addAnnouncement(sysAnnouncement);
        if(insertResult==true){
            jsonObject.put("msg","发布公告成功");
        }
        else {
            jsonObject.put("msg","系统异常,发布公告失败,请稍后再试");
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
