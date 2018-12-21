package mybatis.servlet.SysTaskServlet;

import com.github.pagehelper.Constant;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import mybatis.model.SysUser;
import mybatis.model.TaskSubmitRecord;
import mybatis.service.TaskSubmitService;
import mybatis.service.TaskSubmitServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static mybatis.util.Constants.GROUPER;

public class GetSubmitTaskListServlet extends HttpServlet implements Constant {

    private TaskSubmitService taskSubmitService=new TaskSubmitServiceImpl();
    private JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session=request.getSession();
        SysUser sysUser=(SysUser) session.getAttribute("loginUser");
        String account=sysUser.getUserAccount();
        Integer role=Integer.parseInt((String)session.getAttribute("role"));
        List<TaskSubmitRecord> taskSubmitRecordList=new ArrayList<>();

        if(role.equals(GROUPER)){//是组长

        }
        else {//不是组长
            taskSubmitRecordList=taskSubmitService.getMySubmitList(account);
        }


        jsonObject.put("total",taskSubmitRecordList.size());
        jsonObject.put("rows",taskSubmitRecordList);
        ResponseUtil.write(response,jsonObject);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
