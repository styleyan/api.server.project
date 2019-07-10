package com.isyxf.blog.controller;


import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Link;
import com.isyxf.blog.service.LinkService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author Y.jer
 *
 * 友情链接请求列表
 */
@RestController
@RequestMapping(value = "/api/link")
public class LinkController {

    @Resource
    private LinkService linkService;

    /**
     * 添加友链
     * @param link
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public Result add(@RequestBody Link link) {
        return linkService.add(link);
    }

    /**
     * 删除友链
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, consumes = "application/json")
    public Result delete(@PathVariable("id") int id) {
        return linkService.remove(id);
    }

    /**
     * 更新友链
     * @param link
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST, consumes = "application/json")
    public Result edit(@RequestBody Link link) {
        return linkService.edit(link);
    }

    /**
     * 查询所有友链
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result query() {
        return linkService.getAll();
    }
}
