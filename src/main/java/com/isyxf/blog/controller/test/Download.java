package com.isyxf.blog.controller.test;

import com.isyxf.blog.utils.ExcelUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaofei.yan
 * @Create 2021-03-05 15:55
 * @Descript 下载Excel 文件;
 * @Url 参考文档: https://www.jianshu.com/p/6e1d962ff444、https://segmentfault.com/a/1190000016370444
 * @Url 遇到的问题: https://blog.csdn.net/zhaowen1233/article/details/90513265
 */
@RestController
@RequestMapping("/myTest/download")
public class Download {

    @GetMapping("/orderExport")
    public void order(HttpServletResponse response) throws Exception {
        List<OrderExcelDto> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            OrderExcelDto orderExcelDto = new OrderExcelDto();
            orderExcelDto.setName("zer" + i);
            orderExcelDto.setPhoneNumber("1881021813" + i);
            orderExcelDto.setUsername("xiaofei.yan_" + i);

            list.add(orderExcelDto);
        }

        ExcelUtils.exportExcel(list, "员工信息表", "员工信息", OrderExcelDto.class,"员工信息", response);
    }
}
