package com.example.demo.springsecurity.jwt.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailService {
    public UserDetails loadUserByUseName(String userName);
}
