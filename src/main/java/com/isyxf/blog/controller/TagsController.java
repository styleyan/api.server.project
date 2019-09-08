package com.isyxf.blog.controller;


import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Tag;
import com.isyxf.blog.service.TagsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author Y.jer
 *
 * 书单请求列表
 */
@RestController
@RequestMapping(value = "/api/tags")
public class TagsController {

    @Resource
    private TagsService tagsService;

    /**
     * 添加书单
     * @param tag
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public Result add(@RequestBody Tag tag) {
        return tagsService.add(tag);
    }

    /**
     * 更新书单
     * @param tag
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    public Result update(@RequestBody Tag tag) {
        return tagsService.update(tag);
    }

    /**
     * 删除书单
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, consumes = "application/json")
    public Result delete(@PathVariable("id") int id) {
        return tagsService.remove(id);
    }

    /**
     * 查询书单
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result query() {
        return tagsService.queryList();
    }
}
