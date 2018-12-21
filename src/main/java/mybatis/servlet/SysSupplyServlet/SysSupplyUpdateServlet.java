package mybatis.servlet.SysSupplyServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mybatis.service.SysSupplyServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

public class SysSupplyUpdateServlet extends HttpServlet {

	/**
	 *
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

		String i1=req.getParameter("id");
		String i2=req.getParameter("status");

		String account=req.getParameter("account");   //借还人的学号

		if(i1==null||i2==null||account==null){
			jsonObject.put("error", "信息错误！");

			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}


		Integer id=Integer.parseInt(i1);

		Integer status=Integer.parseInt(i2);
		byte st=status.byteValue();

		SysSupplyServiceImpl impl=new SysSupplyServiceImpl();

		int result = impl.update(id, account, st);

		if(result==1){
			jsonObject.put("success", "状态更新一条成功");

			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}
		if(result==0){
			jsonObject.put("except", "不存在该记录");

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