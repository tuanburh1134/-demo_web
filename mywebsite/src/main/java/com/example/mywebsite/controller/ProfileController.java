package com.example.mywebsite.controller;

import com.example.mywebsite.model.UserProfile;
import com.example.mywebsite.service.UserProfileService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public ProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpSession session, @RequestParam(value = "success", required = false) String success) {
        String username = (String) session.getAttribute("user");
        if (username == null) {
            username = "admin"; // Default fallback demo
        }

        UserProfile userProfile = userProfileService.getUserProfile(username);
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("username", username);

        if ("true".equals(success)) {
            model.addAttribute("successMessage", "Cập nhật thông tin cá nhân thành công vào Backend!");
        }

        return "profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute UserProfile userProfile,
                                HttpSession session,
                                RedirectAttributes redirectAttributes) {
        String username = (String) session.getAttribute("user");
        if (username == null) {
            username = "admin";
        }

        userProfileService.updateUserProfile(username, userProfile);
        redirectAttributes.addAttribute("success", "true");

        return "redirect:/profile";
    }
}
