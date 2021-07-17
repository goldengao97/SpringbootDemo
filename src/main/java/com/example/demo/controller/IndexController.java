package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: TODO
 * @author: Golden
 * @date: 2021/7/13 16:43
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String toFirstHtml(){
        return "index";
    }
}
