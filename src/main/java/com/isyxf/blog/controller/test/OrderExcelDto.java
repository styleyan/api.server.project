package com.isyxf.blog.controller.test;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author xiaofei.yan
 * @Create 2021-03-05 16:00
 * @Descript
 */
@Data
public class OrderExcelDto {
    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    @Excel(name = "姓名", orderNum = "0", width = 15)
    private String name;

    /**
     * 登录用户名
     */
    @Excel(name = "用户名", orderNum = "1", width = 17)
    private String username;

    /**
     * 手机号
     */
    @Excel(name = "手机号", orderNum = "2", width = 20)
    private String phoneNumber;
}
