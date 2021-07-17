package com.example.demo.service;

import com.example.demo.bean.TestUser;

import java.util.List;

public interface TestUserService {
    String findUser(String id);
    String registUser(List<TestUser> testUsers);
}
