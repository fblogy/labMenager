package mybatis.servlet.SysAnnouncementServlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mybatis.model.SysAnnouncement;
import mybatis.service.SysAnnouncementService;
import mybatis.service.SysAnnouncementServiceImpl;
import mybatis.util.DateUtil;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static mybatis.util.Constants.FORMAT;

public class GetAnnouncementListServlet extends HttpServlet {

    private SysAnnouncementService sysAnnouncementService=new SysAnnouncementServiceImpl();
    private JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String pageNumStr=request.getParameter("pageNum");
        String pageSizeStr=request.getParameter("pageSize");

        Integer pageNum=Integer.parseInt(pageNumStr);
        Integer pageSize=Integer.parseInt(pageSizeStr);
        PageHelper.startPage(pageNum, pageSize);

        List<SysAnnouncement> sysAnnouncementList=sysAnnouncementService.getAnnouncementList();
        for (SysAnnouncement item:sysAnnouncementList){
            item.setAnDateStr(DateUtil.formatDate(item.getAnDate(),FORMAT));
        }
        PageInfo<SysAnnouncement> pageInfo=new PageInfo<SysAnnouncement>(sysAnnouncementList);

        jsonObject.put("pages",pageInfo.getPages());
        jsonObject.put("realRowNum",sysAnnouncementList.size());
        jsonObject.put("rows",sysAnnouncementList);

        ResponseUtil.write(response,jsonObject);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
