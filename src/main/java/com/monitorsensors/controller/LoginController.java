package com.monitorsensors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {
        String err= request.getParameter("err");
        if (err!=null)
            model.addAttribute("error","Неправильный логин или пароль");
        return "login";
    }
}
