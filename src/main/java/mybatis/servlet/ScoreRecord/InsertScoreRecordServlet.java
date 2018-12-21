package mybatis.servlet.ScoreRecord;

import mybatis.model.ScoreRecord;
import mybatis.model.SysUser;
import mybatis.service.ScoreRecordService;
import mybatis.service.ScoreRecordServiceImpl;
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

public class InsertScoreRecordServlet extends HttpServlet {

    private ScoreRecordService scoreRecordService=new ScoreRecordServiceImpl();
    private SysUserService sysUserService=new SysUserServiceImpl();
    private JSONObject jsonObject=new JSONObject();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String addedAccount=request.getParameter("addedAccount");
        if(!sysUserService.isExist(addedAccount.trim())){//账号不存在
            jsonObject.put("result",0);
            jsonObject.put("msg","该用户不存在");
        }
        else {
            String addedName=sysUserService.selectUserNameByAccount(addedAccount);
            String scoreStr=request.getParameter("score");
            Integer score=Integer.parseInt(scoreStr);
            String remark=request.getParameter("remark");

            HttpSession session=request.getSession();
            SysUser sysUser=(SysUser) session.getAttribute("loginUser");
            String userAccount=sysUser.getUserAccount();
            String userName=sysUser.getUserName();

            ScoreRecord scoreRecord=new ScoreRecord();
            scoreRecord.setSrScore(score);
            scoreRecord.setSrAccount(addedAccount);
            scoreRecord.setSrAccount(addedName);
            scoreRecord.setSrManagerAccount(userAccount);
            scoreRecord.setSrManagerAccount(userName);
            scoreRecord.setSrGroup(sysUserService.selectGroupByAccount(userAccount));
            scoreRecord.setSrRemark(remark);
            scoreRecord.setSrTime(new Date());

            Integer insertNum=scoreRecordService.insert(scoreRecord);
            if(insertNum>0){
                jsonObject.put("result",1);
                jsonObject.put("msg","积分操作成功");
            }
            else {
                jsonObject.put("result",0);
                jsonObject.put("msg","积分操作失败,请检查信息的准确性和完整性");
            }
        }

        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
