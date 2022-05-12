package com.example.repo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPass = "testing";
        String encodedPassword = encoder.encode(rawPass);
        System.out.println(encodedPassword);
    }
}
