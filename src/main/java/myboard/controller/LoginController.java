package myboard.controller;

import myboard.domain.LoginRequest;
import myboard.validator.LoginRequestValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 6. 12
 * Time: 오후 5:36
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login/loginform")
    public String loginForm() {
        return "/login/loginForm";
    }

    @RequestMapping (value = "/login/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, @ModelAttribute("command") LoginRequest loginRequest, BindingResult result) {
        new LoginRequestValidator().validate(loginRequest, result);
        if (result.hasErrors()) {
            return "redirect:/login/loginform";
        }
        HttpSession session = request.getSession();
        session.setAttribute("isLogin", "ok");
        return "redirect:/myboard/";
    }

    @RequestMapping (value = "/login/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            return "redirect:/login/loginform";
        }
        session.invalidate();
        return "redirect:/myboard/";
    }
}
