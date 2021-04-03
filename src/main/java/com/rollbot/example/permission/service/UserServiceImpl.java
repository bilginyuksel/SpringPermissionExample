package com.rollbot.example.permission.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public String getUsername() {
        return computeUsername();
    }

    private String computeUsername() {
        return "bilginyuksel";
    }
}
