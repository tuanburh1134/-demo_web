package com.example.mywebsite.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile(Model model, HttpSession session) {
        String user = (String) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("username", user);
        } else {
            model.addAttribute("username", "Nguyễn Văn Admin");
        }
        return "profile";
    }
}
