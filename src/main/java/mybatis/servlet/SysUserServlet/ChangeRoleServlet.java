package mybatis.servlet.SysUserServlet;

import mybatis.util.CookieUtil;
import mybatis.util.ResponseUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static mybatis.util.Constants.INDEX_PAGE;

public class ChangeRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        String roleStr=request.getParameter("role");

        Integer roleInt=Integer.parseInt(roleStr);
        HttpSession session=request.getSession();
        Integer preRole=(Integer) session.getAttribute("role");

        if(!roleInt.equals(preRole)){//切换的身份后和原本的不同
            CookieUtil.overrideCookie(request,response,"role",roleInt+"");
            session.setAttribute("role",new Integer(roleInt));//更新服务器端的role
            response.addHeader("REDIRECT", "REDIRECT");//告诉ajax这是重定向
            response.addHeader("CONTEXTPATH", INDEX_PAGE);//重定向地址，切换身份后到首页
            response.addHeader("Access-Control-Expose-Headers", "REDIRECT,CONTEXTPATH");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
