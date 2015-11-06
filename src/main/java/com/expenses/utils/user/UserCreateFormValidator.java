package com.expenses.utils.user;


import com.expenses.dto.UserCreateForm;
import com.expenses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by gnester on 2015-10-30.
 */
@Component
public class UserCreateFormValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        validateEmail(errors, form);
        validatePasswords(errors, form);

    }

    private void validatePasswords(Errors errors, UserCreateForm form) {
        if (form.getPassword().length() < UserCreateForm.PASSWORD_LENGTH_MIN) {
            errors.rejectValue("password", "register.passwordRepeated.size", new Object[]{UserCreateForm.PASSWORD_LENGTH_MIN}, "Password must have at least " + UserCreateForm.PASSWORD_LENGTH_MIN + "charcters");
        }
        else if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.rejectValue("password", "register.passwordDontMatch", "Passwords don't matching");
            errors.rejectValue("passwordRepeated", "register.passwordDontMatch", "Passwords don't matching");
        }
    }
    private void validateEmail(Errors errors, UserCreateForm form) {
        if (form.getEmail().isEmpty()) {
            errors.rejectValue("email", "register.notEmpty", "This field doesn't empty");
            return;
        }
        EmailValidator emailValidator = new EmailValidator();
        boolean validEmail = emailValidator.validate(form.getEmail());
        if (!validEmail) {
            errors.rejectValue("email", "register.notValidEmail", "This field doesn't empty");
        }
        else if (userService.getUserByEmail(form.getEmail()).isPresent()) {
            errors.rejectValue("email", "register.userExist", "User with this email already exists");
        }
    }


}

