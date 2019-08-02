package com.isyxf.blog.controller;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.service.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Y.jer
 *
 * C端相关查询
 */
@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Resource
    private ClientService clientService;

    /**
     * 查询归档分类
     * @return
     */
    @RequestMapping(value = "/archive", method = RequestMethod.GET)
    public Result archiveList() {
        return clientService.archiveList();
    }
}
