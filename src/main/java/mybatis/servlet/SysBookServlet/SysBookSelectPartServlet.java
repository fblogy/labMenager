package mybatis.servlet.SysBookServlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import mybatis.service.SysBookServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

public class SysBookSelectPartServlet extends HttpServlet {

	/**
	 * 书籍模糊查询
	 * 参数：书名  bookname
	 * 返回:count list
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

		String name=req.getParameter("word");
		String p=req.getParameter("PageSize");
		String s=req.getParameter("start");
		if(p==null||s==null||name==null){
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

		SysBookServiceImpl bookServiceImpl=new SysBookServiceImpl();
		List<Map<String, Object>> booklist=bookServiceImpl.selectByPartBook(name,pageSize,start);
		int i=bookServiceImpl.countPart("%"+name+"%");
		if(i%pageSize!=0){
			i=i/pageSize+1;
		}else{
			i=i/pageSize;
		}
		jsonObject.put("count", i);
		jsonObject.put("Book",booklist);
		try {
			ResponseUtil.write(resp, jsonObject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
