package myboard.validator;

import myboard.domain.Board;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 6. 12
 * Time: 오후 5:11
 * To change this template use File | Settings | File Templates.
 */
@Component
public class BoardValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Board.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Board board = (Board) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required", null, "<- title 필수입력");
//        if (board.getTitle() == null || board.getTitle().trim().isEmpty()) {
//            errors.rejectValue("title", "required");
//        }
    }
}
