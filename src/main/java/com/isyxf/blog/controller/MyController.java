package com.isyxf.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class MyController {
    @RequestMapping("/out")
    public String out() {
        return "success";
    }
}
