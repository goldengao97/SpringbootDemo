package com.example.demo.controller;

import com.example.demo.bean.TestUser;
import com.example.demo.service.impl.TestUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LegionGolden
 */
@RestController
public class TestController {
    @Autowired
    TestUserServiceImpl testUserService;

    @RequestMapping("/hello")
    public String sayHello(){
        return "HelloWorld!";
    }

    @RequestMapping("/findUser")
    public String findUser(@RequestParam String id){
        String result = testUserService.findUser(id);
        return result;
    }

    @RequestMapping("/registUser")
    public String registUser(@RequestBody List<TestUser> testUsers){
        String msg = testUserService.registUser(testUsers);
        return msg;
    }

}
