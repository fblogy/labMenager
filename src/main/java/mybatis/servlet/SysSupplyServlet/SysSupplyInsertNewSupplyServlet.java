package mybatis.servlet.SysSupplyServlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import mybatis.model.SysSupply;
import mybatis.service.SysSupplyServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

public class SysSupplyInsertNewSupplyServlet extends HttpServlet {

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
		String name=req.getParameter("name");
		String number =req.getParameter("number");
		String cost=req.getParameter("cost");
		String mark=req.getParameter("mark");
		String buyer=req.getParameter("account");
		String st1=req.getParameter("status");


		if(number==null ||name==null||buyer==null||mark==null||st1==null||cost==null){

			jsonObject.put("error", "请求信息错误！");

			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;

		}
		Integer st=Integer.parseInt(st1);//-3
		byte status=st.byteValue();
		if(status!=-3){
			jsonObject.put("error", "请求信息错误！");

			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}
		Date time=new Date();
		SysSupply supply=new SysSupply();
		supply.setSupplyName(name);
		supply.setSupplyNumber(number);
		supply.setSupplyCost(cost);
		supply.setSupplyMark(mark);
		supply.setSupplyBuyer(buyer);
		supply.setSupplyBuyTime(time);
		supply.setSupplyStatus(status);

		SysSupplyServiceImpl impl=new SysSupplyServiceImpl();

		int result=impl.insertNewSupply(supply);

		if(result==1){
			jsonObject.put("success", "申请提交成功");

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
