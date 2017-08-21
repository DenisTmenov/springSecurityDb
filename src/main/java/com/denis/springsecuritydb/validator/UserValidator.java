package com.denis.springsecuritydb.validator;

import com.denis.springsecuritydb.model.User;
import com.denis.springsecuritydb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Autowired
    private UserService userService;


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (user.getUsername().length() < 8 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "UserForm.username.size");
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "UserForm.username.dublicate");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "UserForm.password.size");
        }
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("password", "UserForm.password.different");
        }
    }
}
