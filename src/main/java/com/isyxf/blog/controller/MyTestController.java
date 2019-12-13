package com.isyxf.blog.controller;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.ConfigBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author xiaofei.yan
 * @Create 2019-10-10 11:48
 * @Descript 测试控制器
 */
@RestController
@RequestMapping("/api/myTest")
public class MyTestController {
    private static final Logger logger = LoggerFactory.getLogger(MyTestController.class);

    @Value("${com.isyxf.url}")
    private String url;
    @Autowired
    private ConfigBean configBean;

    @RequestMapping(value = "/url", method = RequestMethod.GET, consumes = "application/json")
    public Result url() {
        logger.info(configBean.toString());
        return Result.success(url);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(@RequestParam("file") MultipartFile file) throws ServletException, IOException {
        try{
            if (file.getSize() > 0) {
                System.out.println("2333, 文件大小不为0");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Result.success("233");
    }
}
