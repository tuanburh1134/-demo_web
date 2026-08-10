package com.example.mywebsite.service;

import com.example.mywebsite.model.UserProfile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserProfileService {

    private final Map<String, UserProfile> userProfileRepository = new ConcurrentHashMap<>();

    public UserProfileService() {

        UserProfile adminProfile = new UserProfile(
                "admin",
                "Nguyễn Văn Admin",
                "admin@example.com",
                "0987 654 321",
                "Senior Java Spring Boot Web Developer",
                "Đam mê xây dựng các ứng dụng web hiện đại, tối ưu hiệu năng và trải nghiệm người dùng ấn tượng.",
                "Hà Nội, Việt Nam",
                "Công ty Công nghệ ABC",
                "Tháng 08/2026"
        );
        adminProfile.setProjectsCount(15);
        adminProfile.setVisitsCount("1.8k");
        adminProfile.setRating("4.9 ★");
        adminProfile.setExperienceYears("3+ Năm");
        adminProfile.setSkills(Arrays.asList(
                "☕ Java 17+",
                "🌱 Spring Boot 3",
                "🍃 Thymeleaf Template",
                "🎨 HTML5 / CSS3 / Glassmorphic",
                "⚡ JavaScript (ES6+)",
                "🐬 MySQL / PostgreSQL",
                "🔀 Git & GitHub",
                "🐳 Docker Basics",
                "🔒 Spring Security",
                "🚀 RESTful API"
        ));

        adminProfile.getActivities().add(new UserProfile.ActivityLog(
                "✨",
                "Tạo thành công giao diện Trang Cá Nhân",
                "Vừa cập nhật giao diện Glassmorphism hiện đại cho hệ thống"
        ));
        adminProfile.getActivities().add(new UserProfile.ActivityLog(
                "🔑",
                "Đăng nhập thành công vào Bảng điều khiển",
                "Phiên làm việc được tạo thành công với quyền Admin"
        ));
        adminProfile.getActivities().add(new UserProfile.ActivityLog(
                "💻",
                "Khởi chạy ứng dụng Spring Boot",
                "Hệ thống đã sẵn sàng phục vụ tại cổng 8082"
        ));

        userProfileRepository.put("admin", adminProfile);
    }

    public UserProfile getUserProfile(String username) {
        if (username == null || username.trim().isEmpty()) {
            username = "admin";
        }
        return userProfileRepository.computeIfAbsent(username, key -> {
            UserProfile defaultProfile = new UserProfile(
                    key,
                    "Người dùng " + key,
                    key + "@example.com",
                    "0123 456 789",
                    "Lập trình viên Web",
                    "Chào mừng bạn đến với trang cá nhân của tôi!",
                    "Việt Nam",
                    "Công ty Công nghệ",
                    "Tháng 08/2026"
            );
            defaultProfile.setProjectsCount(5);
            defaultProfile.setVisitsCount("500");
            defaultProfile.setRating("5.0 ★");
            defaultProfile.setExperienceYears("1 Năm");
            defaultProfile.setSkills(Arrays.asList("☕ Java", "🌱 Spring Boot", "🎨 HTML/CSS"));
            return defaultProfile;
        });
    }

    public void updateUserProfile(String username, UserProfile updatedData) {
        UserProfile existing = getUserProfile(username);
        if (updatedData.getFullName() != null) existing.setFullName(updatedData.getFullName());
        if (updatedData.getEmail() != null) existing.setEmail(updatedData.getEmail());
        if (updatedData.getPhone() != null) existing.setPhone(updatedData.getPhone());
        if (updatedData.getJobTitle() != null) existing.setJobTitle(updatedData.getJobTitle());
        if (updatedData.getBio() != null) existing.setBio(updatedData.getBio());
        if (updatedData.getLocation() != null) existing.setLocation(updatedData.getLocation());
        if (updatedData.getCompany() != null) existing.setCompany(updatedData.getCompany());

        // Thêm nhật ký hoạt động mới
        String timeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm - dd/MM/yyyy"));
        existing.getActivities().add(0, new UserProfile.ActivityLog(
                "📝",
                "Đã cập nhật thông tin cá nhân",
                "Cập nhật hồ sơ thành công vào lúc " + timeNow
        ));
    }
}
