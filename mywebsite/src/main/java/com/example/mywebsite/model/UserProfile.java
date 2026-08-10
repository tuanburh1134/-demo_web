package com.example.mywebsite.model;

import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private String username;
    private String fullName;
    private String email;
    private String phone;
    private String jobTitle;
    private String bio;
    private String location;
    private String company;
    private String joinedDate;
    private int projectsCount;
    private String visitsCount;
    private String rating;
    private String experienceYears;
    private List<String> skills = new ArrayList<>();
    private List<ActivityLog> activities = new ArrayList<>();

    public UserProfile() {
    }

    public UserProfile(String username, String fullName, String email, String phone, String jobTitle, String bio, String location, String company, String joinedDate) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.jobTitle = jobTitle;
        this.bio = bio;
        this.location = location;
        this.company = company;
        this.joinedDate = joinedDate;
    }

    // Activity Log inner class
    public static class ActivityLog {
        private String icon;
        private String title;
        private String description;

        public ActivityLog() {}

        public ActivityLog(String icon, String title, String description) {
            this.icon = icon;
            this.title = title;
            this.description = description;
        }

        public String getIcon() { return icon; }
        public void setIcon(String icon) { this.icon = icon; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getJoinedDate() { return joinedDate; }
    public void setJoinedDate(String joinedDate) { this.joinedDate = joinedDate; }

    public int getProjectsCount() { return projectsCount; }
    public void setProjectsCount(int projectsCount) { this.projectsCount = projectsCount; }

    public String getVisitsCount() { return visitsCount; }
    public void setVisitsCount(String visitsCount) { this.visitsCount = visitsCount; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    public String getExperienceYears() { return experienceYears; }
    public void setExperienceYears(String experienceYears) { this.experienceYears = experienceYears; }

    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }

    public List<ActivityLog> getActivities() { return activities; }
    public void setActivities(List<ActivityLog> activities) { this.activities = activities; }
}
