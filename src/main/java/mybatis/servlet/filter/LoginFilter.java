package mybatis.servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    String passUrl="";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;

        // 登陆页面无需验证
        String[] strArray = passUrl.split(";");
        for (String str : strArray) { //数组中的页面不用进行登录验证
            if (httpRequest.getRequestURL().indexOf(str) >= 0) {
                chain.doFilter(req, resp);
                return;
            }
        }
        //System.out.println("request:"+httpRequest.getRequestURL().toString());

        HttpSession session=httpRequest.getSession();
        if(session.getAttribute("loginUser")!=null){
            chain.doFilter(req, resp);
        }
        else {
            httpResponse.sendRedirect("login.html");
        }
    }

    public void init(FilterConfig config) throws ServletException{
        passUrl = config.getInitParameter("passUrl");
    }
}