package mybatis.servlet.SysBookServlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import mybatis.model.SysBook;
import mybatis.service.SysBookServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

public class SysBookInsertNewBookServlet extends HttpServlet {

	/**
	 * 插入新书
	 * 参数：全部 (id 不要   status 默认-3)
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

		System.out.println("inter");
		String isbn =req.getParameter("isbn");
		String name=req.getParameter("name");
		String writer=req.getParameter("writer");
		String pub=req.getParameter("pub");
		String mark=req.getParameter("mark");
		String buyer=req.getParameter("buyer");
		Date time=new Date();
		Integer st=Integer.parseInt(req.getParameter("status"));//-3
		byte status=st.byteValue();

		if(isbn==null ||name==null||writer==null||pub==null||mark==null||buyer==null||status!=-3){
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("error", "请求信息错误！");

			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;

		}

		SysBook book=new SysBook();
		book.setBookIsbn(isbn);
		book.setBookName(name);
		book.setBookWriter(writer);
		book.setBookMark(mark);
		book.setBookPub(pub);
		book.setBookBuyer(buyer);
		book.setBookBorrowTime(time);
		book.setBookStatus(status);

		System.out.println(book);

		SysBookServiceImpl bookServiceImpl=new SysBookServiceImpl();
		int result=bookServiceImpl.insertNewBook(book);

		if(result==1){
			JSONObject jsonObject=new JSONObject();
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
