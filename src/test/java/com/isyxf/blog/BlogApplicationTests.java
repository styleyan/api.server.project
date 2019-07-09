package com.isyxf.blog;

import com.isyxf.blog.dto.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Test
    public void contextLoads() {
        Map map = new HashMap();

        Result result1 = Result.success();
        Result result21 = Result.success(2001, map);
        Result result2 = Result.success(map);
        Result result3 = Result.failure(2003, "输入错误");

        System.out.println("测试结束");
    }

}
