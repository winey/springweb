package myboard.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 6. 20
 * Time: 오후 1:37
 * To change this template use File | Settings | File Templates.
 */
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        if (session == null) {
            response.sendRedirect("/login/loginform");
            return false;
        }

        String isLogin = (String) session.getAttribute("isLogin");
        if (StringUtils.isEmpty(isLogin)) {
            response.sendRedirect("/login/loginform");
            return false;
        }

        session.setAttribute("isLogin", "ok");
        return true;

    }
}
