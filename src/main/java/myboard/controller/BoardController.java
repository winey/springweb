package myboard.controller;

import myboard.entity.Board;
import myboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 6. 7
 * Time: 오후 1:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @RequestMapping (value = "/myboard/loginform")
    public String loginForm() {
        return "/myboard/loginForm";
    }

    @RequestMapping (value = "/myboard/login")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("isLogin", true);
        return "redirect:/myboard";
    }

    @RequestMapping (value = "/myboard/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            return "redirect:/myboard/loginform";
        }

        session.invalidate();
        return "redirect:/myboard";
    }

    @RequestMapping (value = "/myboard", method=RequestMethod.GET)
    public ModelAndView hello(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            mav.setViewName("loginForm");
            return mav;
        }
        mav.addObject("boards",boardRepository.getBoards());
        mav.setViewName("list");
        return mav;
    }

    @RequestMapping (value="/myboard", method = RequestMethod.POST)
    public String save(HttpServletRequest request, Board board) {
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            return "redirect:/myboard/loginform";
        }

        boardRepository.addBoard(board);
        return "redirect:/myboard";
    }

    @RequestMapping (value="/myboard/insertform")
    public String insertForm(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            return "redirect:/myboard/loginform";
        }
        return "insertForm";
    }

    @RequestMapping (value="/myboard/updateform")
    public ModelAndView updateForm(HttpServletRequest request, @RequestParam(value="id") int id) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            mav.setViewName("redirect:/myboard/loginform");
            return mav;
        }

        mav.addObject("board",boardRepository.getBoardById(id));
        mav.setViewName("updateForm");
        return mav;
    }

    @RequestMapping (value="/myboard/update", method = RequestMethod.POST)
    public String update(HttpServletRequest request, Board board) {
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            return "redirect:/myboard/loginform";
        }

        boardRepository.updateBoard(board);
        return "redirect:/myboard";
    }

    @RequestMapping (value="/myboard/delete")
    public String delete(HttpServletRequest request, @RequestParam(value="id") int id) {
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            return "redirect:/myboard/loginform";
        }

        boardRepository.deleteBoard(id);
        return "redirect:/myboard";
    }

    @RequestMapping (value="/myboard/detail")
    public ModelAndView read(HttpServletRequest request, @RequestParam(value="id") int id) {
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            mav.setViewName("redirect:/myboard/loginform");
            return mav;
        }

        mav.addObject("board",boardRepository.getBoardById(id));
        mav.setViewName("detail");
        return mav;
    }
}