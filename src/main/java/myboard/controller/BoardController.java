package myboard.controller;

import myboard.domain.Board;
import myboard.repository.BoardRepository;
import myboard.validator.BoardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping (value = "/myboard", method=RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("boards", boardRepository.getBoards());
        return "list";
    }

    @RequestMapping (value = "/myboard/list", method=RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("boards",boardRepository.getBoards());
        return "list";
    }

    @RequestMapping (value="/myboard/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Board board, BindingResult result) {
        new BoardValidator().validate(board, result);
        if (result.hasErrors()) {
            return "insertForm";
        }

        boardRepository.addBoard(board);
        return "redirect:/myboard";
    }

    @RequestMapping (value="/myboard/insertform")
    public String insertForm() {
        return "insertForm";
    }

    @RequestMapping (value="/myboard/updateform")
    public String updateForm(@RequestParam(value="id") int id, Model model) {

        model.addAttribute("board",boardRepository.getBoardById(id));
        return "updateForm";
    }

    @RequestMapping (value="/myboard/update", method = RequestMethod.POST)
    public String update(Board board) {


        boardRepository.updateBoard(board);
        return "redirect:/myboard";
    }

    @RequestMapping (value="/myboard/delete")
    public String delete(@RequestParam(value="id") int id) {

        boardRepository.deleteBoard(id);
        return "redirect:/myboard";
    }

    @RequestMapping (value="/myboard/detail")
    public String read(HttpServletRequest request, @RequestParam(value="id") int id, Model model) {

        model.addAttribute("board",boardRepository.getBoardById(id));
        return "detail";
    }
}