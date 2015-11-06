package com.expenses.controller;

import com.expenses.dto.UserCreateForm;
import com.expenses.service.UserService;
import com.expenses.utils.user.UserCreateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by gnester on 2015-10-29.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserCreateFormValidator userCreateFormValidator;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(@RequestParam Optional<String> error) {
        return "login";
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping("/user/{id}")
    public String showUserPage(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
        return "user";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("form", new UserCreateForm());
        return "register";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.create(form);
        return "redirect:/home";
    }
}
