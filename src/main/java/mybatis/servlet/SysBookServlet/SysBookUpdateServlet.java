package mybatis.servlet.SysBookServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import mybatis.service.SysBookServiceImpl;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

public class SysBookUpdateServlet extends HttpServlet {

	/**
	 * 参数：书籍id  学号   书需改变的状态值     -3->未申请   -2->失败     1 -》还在   0-》借出
	 * 根据id和status 来修改书籍状态
	 * 修改sys_book 的status
	 * 判断书状态，当为0（借出）时，向借书记录插入信息
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

		SysBookServiceImpl bookServiceImpl=new SysBookServiceImpl();

		int result = bookServiceImpl.update(id, account, st);

		if(result==1){
			jsonObject.put("success", "状态更新一条成功");

			try {
				ResponseUtil.write(resp, jsonObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}else{
			jsonObject.put("success", "状态更新多条成功");

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
