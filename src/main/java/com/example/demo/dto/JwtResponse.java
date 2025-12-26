package com.example.demo.dto;

public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private long userId;
    private String email;
    private String role;

    public JwtResponse(String token, long userId, String email, String role) {
        this.token = token;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    public String getToken() { return token; }
    public String getType() { return type; }
    public long getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
}
