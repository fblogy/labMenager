package mybatis.servlet.SysBookServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import mybatis.service.SysBookServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

public class SysBookDeleteServlet  extends HttpServlet{
	/**
	 * 删除图书
	 * 参数：   书籍id
	 * 返回值：无
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		JSONObject jsonObject=new JSONObject();

		String i=req.getParameter("id");
		if(i==null){
			jsonObject.put("error", "信息错误！");

			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}
		Integer id =Integer.parseInt(req.getParameter("id"));
		System.out.println("servlet is ok");
		SysBookServiceImpl bookServiceImpl=new SysBookServiceImpl();
		int result=bookServiceImpl.delete(id);
		if(result==1){
			jsonObject.put("success", "成功删除");
			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}
		if(result==0){
			jsonObject.put("expect", "无该记录，是否参数有误？");

			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}
	}
}
