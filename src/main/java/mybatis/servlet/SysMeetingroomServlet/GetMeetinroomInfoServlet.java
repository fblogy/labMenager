package mybatis.servlet.SysMeetingroomServlet;

import mybatis.model.SysMeetingroom;
import mybatis.model.SysUser;
import mybatis.service.SysMeetingroomService;
import mybatis.service.SysMeetingroomServiceImpl;
import mybatis.service.SysUserService;
import mybatis.service.SysUserServiceImpl;
import mybatis.util.DateUtil;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetMeetinroomInfoServlet extends HttpServlet {

    private SysMeetingroomService sysMeetingroomService=new SysMeetingroomServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String dateStr=request.getParameter("date");
        Date date= DateUtil.formatString(dateStr,"yyyy-MM-dd");
        SysMeetingroom sysMeetingroom=new SysMeetingroom();
        sysMeetingroom.setRoomDate(date);

        try{
            JSONObject jsonObject=new JSONObject();
            List<SysMeetingroom> sysMeetingroomList=sysMeetingroomService.selectSysMeetingroomByRoomdate(sysMeetingroom);
            List<String> choiceList=new ArrayList<>();
            List<String> borrowerAccountList=new ArrayList<>();
            List<String> borrowerNameList=new ArrayList<>();

            for(SysMeetingroom item:sysMeetingroomList){
                borrowerAccountList.add(item.getRoomAccount());
                String seg=item.getRoomSeg()+"";
                String orderInWeek=DateUtil.getDateIntOfWeek(item.getRoomDate())+"";
                choiceList.add(orderInWeek+seg);
            }
            SysUserService sysUserService=new SysUserServiceImpl();
            List<SysUser> sysUserList=sysUserService.selectUserNameByAccount(borrowerAccountList);
            for(SysUser item:sysUserList){
                borrowerNameList.add(item.getUserName());
            }
            jsonObject.put("total",sysMeetingroomList.size());
            jsonObject.put("choice",choiceList);
            jsonObject.put("borrowerAccount",borrowerAccountList);
            jsonObject.put("borrowerName",borrowerNameList);

            ResponseUtil.write(response, jsonObject);

        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }
    }

}
