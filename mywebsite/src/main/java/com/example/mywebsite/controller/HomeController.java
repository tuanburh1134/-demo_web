package com.example.mywebsite.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        String user = (String) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("loggedIn", true);
            model.addAttribute("username", user);
            model.addAttribute("message", "Chào mừng quay trở lại, " + user + "! Bạn đã đăng nhập thành công vào hệ thống.");
        } else {
            model.addAttribute("loggedIn", false);
            model.addAttribute("message", "Chúc mừng! Bạn đã chạy thành công trang web Java Spring Boot đầu tiên.");
        }
        return "index";
    }
}
