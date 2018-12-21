package mybatis.servlet.SysUserServlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import mybatis.model.SysAnnouncement;
import mybatis.model.SysUser;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUserListServlet extends HttpServlet {

    private SysUserService userService=new SysUserServiceImpl();
    private JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String search=request.getParameter("search");
        String pageNumStr=request.getParameter("pageNum");
        String pageSizeStr=request.getParameter("pageSize");

        Integer pageNum=Integer.parseInt(pageNumStr);
        Integer pageSize=Integer.parseInt(pageSizeStr);
        PageHelper.startPage(pageNum, pageSize);

        List<SysUser> sysUserList=userService.selectUserList(search);
        PageInfo<SysUser> pageInfo=new PageInfo<SysUser>(sysUserList);

        jsonObject.put("pages",pageInfo.getPages());
        jsonObject.put("realRowNum",sysUserList.size());
        jsonObject.put("rows",sysUserList);

        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
