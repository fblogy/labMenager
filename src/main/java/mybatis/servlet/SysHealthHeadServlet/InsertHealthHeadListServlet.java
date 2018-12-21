package mybatis.servlet.SysHealthHeadServlet;

import mybatis.model.SysHealthHead;
import mybatis.service.*;
import mybatis.util.ResponseUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertHealthHeadListServlet extends HttpServlet {

    SysHealthHeadService sysHealthHeadService=new SysHealthHeadServiceImpl();
    SysHealthHeadDateService sysHealthHeadDateService=new SysHealthHeadDateServiceImpl();
    SysUserService sysUserService=new SysUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String healthHeadArrayStr=request.getParameter("rows");

        List<SysHealthHead> sysHealthHeadList=new ArrayList<>();
        JSONArray jsonArray=new JSONArray(healthHeadArrayStr);

        /**
         * 通过账号查找姓名，防止姓名输错
         */
        for(int i=0;i<jsonArray.length();++i){
            SysHealthHead sysHealthHead=new SysHealthHead();
            sysHealthHead.setHealthAccount((String) jsonArray.getJSONObject(i).get("principal1"));
            sysHealthHead.setHealthName(sysUserService.selectUserNameByAccount(sysHealthHead.getHealthAccount()));
            sysHealthHead.setHealthAccount2((String) jsonArray.getJSONObject(i).get("principal2"));
            sysHealthHead.setHealthName2(sysUserService.selectUserNameByAccount(sysHealthHead.getHealthAccount2()));
            sysHealthHead.setHealthWeekOrder(Integer.parseInt((String) jsonArray.getJSONObject(i).get("weekNum")));

            sysHealthHeadList.add(sysHealthHead);
        }

        JSONObject jsonObject=new JSONObject();

        Integer deleteNum=sysHealthHeadService.deleteAll();//插入之前先删除所有
        Boolean loadDateResult=sysHealthHeadDateService.update(new Date());//更改上传日期

        if(deleteNum==-1){
            jsonObject.put("msg","导入之前要删除原本所有卫生负责人数据，删除数据异常，请重新导入");
        }
        else {
            if(loadDateResult==false){
                jsonObject.put("msg","上传日期更新失败,请重新上传");
            }
            else {
                Integer insertNum=sysHealthHeadService.insertList(sysHealthHeadList);

                if(sysHealthHeadList.size()==0){
                    jsonObject.put("msg","信息记录不能为空");
                }
                else if(insertNum==sysHealthHeadList.size()){
                    jsonObject.put("msg","卫生审核记录保存成功");
                }
                else{
                    jsonObject.put("msg","卫生审核记录保存失败，请检查信息完整性和正确性，并重新导入");
                }
            }
        }
        ResponseUtil.write(response,jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
