package mybatis.servlet.SysUserServlet;

import com.github.pagehelper.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static mybatis.util.Constants.LOGIN_PAGE;

public class OutServlet extends HttpServlet implements Constant {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        HttpSession session = request.getSession(false);
        if(session==null){
            return;
        }
        session.removeAttribute("loginUser");//注销账号，session还在，下次登录请求的JSESSIONID不变
        session.removeAttribute("role");     //注销身份
        //session.invalidate();//session不在，下次登录请求的JSESSIONID变化

        response.addHeader("REDIRECT", "REDIRECT");//告诉ajax这是重定向
        response.addHeader("CONTEXTPATH", LOGIN_PAGE);//重定向地址
        response.addHeader("Access-Control-Expose-Headers", "REDIRECT,CONTEXTPATH");
        /*
        XMLHttpRequest.getResponseHeader(“XXX”)，通过CORS方式解决的ajax跨域,是获取不到请求头的。getResponseHeader的值一直为空。
        要通过Access-Control-Expose-Headers来设置响应头的白名单。
        httpResponse.addHeader(“Access-Control-Expose-Headers”, “REDIRECT,CONTEXTPATH”);将想要传递的字段设置一下。才能获取到值。
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
