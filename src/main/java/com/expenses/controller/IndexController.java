package com.expenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gnester on 2015-10-28.
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/home"})
    public String index() {
        return "index";
    }
}
