package mybatis.servlet.filter;

import mybatis.service.SysRoleService;
import mybatis.service.SysRoleServiceImpl;
import mybatis.util.CookieUtil;
import mybatis.util.ResponseUtil;
import mybatis.util.StringUtil;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PriRoleFilter implements Filter {
    String passUrl="";
    SysRoleService sysRoleService=new SysRoleServiceImpl();
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 登陆页面无需验证
        String[] strArray = passUrl.split(";");
        for (String str : strArray) { //数组中的页面不用进行登录验证
            if (request.getRequestURL().indexOf(str) >= 0) {
                chain.doFilter(req, resp);
                return;
            }
        }
        HttpSession session=request.getSession();
        String option=request.getParameter("option");
        Integer role= (Integer) session.getAttribute("role");

        boolean isPrivilege=true;
        if(role!=null&& StringUtil.isNotEmpty(option)){
            isPrivilege=sysRoleService.selectRolePrivilege(role,option);
            //覆盖之前的cookie ,pri在loginServlet中初始化
            if(isPrivilege==true){
                CookieUtil.overrideCookie(request,response,"pri",1+"");//有权限
            }
            else{
                CookieUtil.overrideCookie(request,response,"pri",0+"");//无权限
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("priMSG","您当前的身份没有权限进行此项操作");
                ResponseUtil.write(response,jsonObject);
                return;
            }
        }
        if(isPrivilege==true){
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        passUrl = config.getInitParameter("passUrl");
    }
}