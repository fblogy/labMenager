package mybatis.servlet.ScoreRecord;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mybatis.model.ScoreRecord;
import mybatis.model.SysAnnouncement;
import mybatis.model.SysUser;
import mybatis.service.ScoreRecordService;
import mybatis.service.ScoreRecordServiceImpl;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetScoreRcordListServlet extends HttpServlet {

    private ScoreRecordService scoreRecordService=new ScoreRecordServiceImpl();
    private JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String pageNumStr=request.getParameter("pageNum");
        String pageSizeStr=request.getParameter("pageSize");

        Integer pageNum=Integer.parseInt(pageNumStr);
        Integer pageSize=Integer.parseInt(pageSizeStr);
        PageHelper.startPage(pageNum, pageSize);

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String userAccount=sysUser.getUserAccount();

        Integer role=(Integer) session.getAttribute("role");


        List<ScoreRecord> scoreRecordList=scoreRecordService.getMyScoreRecordList(userAccount,role);

        PageInfo<ScoreRecord> pageInfo=new PageInfo<ScoreRecord>(scoreRecordList);

        jsonObject.put("pages",pageInfo.getPages());
        jsonObject.put("realRowNum",scoreRecordList.size());
        jsonObject.put("rows",scoreRecordList);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
