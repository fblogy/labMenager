package mybatis.servlet.SysSupplyServlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import mybatis.model.SysUser;
import mybatis.service.SysSupplyServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

public class SysSupplySelectMyBorrowByWordsServlet extends HttpServlet  {
	/**
	 * 我借的图书的模糊搜索
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		JSONObject jsonObject=new JSONObject();

		HttpSession session=req.getSession();
		SysUser sysUser=(SysUser) session.getAttribute("loginUser");
		String account=sysUser.getUserAccount();
		//String account=req.getParameter("account");
		String name=req.getParameter("word");
		String p=req.getParameter("PageSize");
		String s=req.getParameter("start");
		if(p==null||s==null||name==null||account==null){
			jsonObject.put("error", "信息错误！");

			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}
		Integer pageSize=Integer.parseInt(p);
		Integer start=Integer.parseInt(s);


		if(pageSize==0||start==0){
			jsonObject.put("error", "信息错误！");

			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;

		}
		start=(start-1)*pageSize;

		SysSupplyServiceImpl impl=new SysSupplyServiceImpl();
		List<Map<String, Object>> supplylist=impl.selectMyBorrowByWords(account, pageSize, start, name);
		if(supplylist==null||supplylist.size()==0){
			jsonObject.put("error", "信息错误！");

			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}
		if(supplylist.size()==1){
			jsonObject.put("zero", "无借用物资");

			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}else{
			supplylist.remove(0);
		}
		int i=impl.countMyBorrowPart(account, "%"+name+"%");
		System.out.println(i);
		if(i%pageSize!=0){
			i=i/pageSize+1;
		}else{
			i=i/pageSize;
		}
		jsonObject.put("count", i);
		jsonObject.put("supply",supplylist);
		try {
			ResponseUtil.write(resp, jsonObject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
