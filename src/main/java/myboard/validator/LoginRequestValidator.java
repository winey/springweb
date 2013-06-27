package myboard.validator;

import myboard.domain.LoginRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: winey
 * Date: 13. 6. 12
 * Time: 오후 5:42
 * To change this template use File | Settings | File Templates.
 */
@Component
public class LoginRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return LoginRequestValidator.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginRequest loginRequest = (LoginRequest) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required", null, "<- 아이디 필수입력");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "required", null, "<- 비밀번 필수입력");
//        if (loginRequest.getId() == null || loginRequest.getId().trim().isEmpty()) {
//            errors.rejectValue("id","required");
//        }
//
//        if (loginRequest.getPw() == null || loginRequest.getPw().trim().isEmpty()) {
//            errors.rejectValue("pw","required");
//        }
    }
}
