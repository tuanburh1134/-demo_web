package com.example.mywebsite.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        // Nếu người dùng đã đăng nhập, chuyển hướng về trang chủ
        if (session.getAttribute("user") != null) {
            return "redirect:/";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        // Xác thực cơ bản với thông tin đăng nhập mặc định
        if ("admin".equals(username) && "admin123".equals(password)) {
            session.setAttribute("user", username);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác!");
            model.addAttribute("username", username);
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Hủy session khi đăng xuất
        session.invalidate();
        return "redirect:/";
    }
}
