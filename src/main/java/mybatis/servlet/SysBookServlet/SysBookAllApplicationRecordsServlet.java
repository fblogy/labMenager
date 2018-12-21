package mybatis.servlet.SysBookServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import mybatis.model.SysBook;
import mybatis.service.SysBookServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

public class SysBookAllApplicationRecordsServlet extends HttpServlet  {
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
		req.setCharacterEncoding("utf-8");
		JSONObject jsonObject=new JSONObject();

		String p=req.getParameter("PageSize");
		String s=req.getParameter("start");
		if(p==null||s==null){
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
		System.out.println("oko");
		SysBookServiceImpl impl=new SysBookServiceImpl();
		List<SysBook> booklist=impl.selectAllAppRec(pageSize, start);

		if(booklist.size()==0||booklist==null){
			jsonObject.put("zero", "无图书申请记录");

			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}
		//页数
		int i=impl.countAllAppRec();
		System.out.println(i);
		if(i%pageSize!=0){
			i=i/pageSize+1;
		}else{
			i=i/pageSize;
		}
		jsonObject.put("count", i);
		jsonObject.put("allapplication", booklist);

		try {
			ResponseUtil.write(resp, jsonObject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}