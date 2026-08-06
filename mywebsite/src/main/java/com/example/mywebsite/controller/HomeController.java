package com.example.mywebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Chúc mừng! Bạn đã chạy thành công trang web Java Spring Boot đầu tiên.");
        return "index";
    }
}
