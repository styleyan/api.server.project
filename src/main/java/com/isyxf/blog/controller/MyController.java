package com.isyxf.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
@Slf4j
public class MyController {
    @RequestMapping("/out")
    public String out() {
        log.info("===================我执行了");
        return "success";
    }
}
