package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 6. 7
 * Time: 오전 10:02
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HelloController {

    @RequestMapping (value = "/hello")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        mav.addObject("greeting", getGreeting());

        return mav;
    }

    private String getGreeting() {
        return "안녕하세요.";
    }
}
