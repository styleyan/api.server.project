package com.isyxf.blog.controller;


import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Maxim;
import com.isyxf.blog.service.MaximService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author Y.jer
 *
 * 箴言请求列表
 */
@RestController
@RequestMapping(value = "/api/maxim")
public class MaximController {

    @Resource
    private MaximService maximService;

    /**
     * 添加箴言
     * @param maxim
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public Result add(@RequestBody Maxim maxim) {
        return maximService.add(maxim);
    }

    /**
     * 删除箴言
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, consumes = "application/json")
    public Result delete(@PathVariable("id") int id) {
        return maximService.remove(id);
    }

    /**
     * 添加箴言
     * @param maxim
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST, consumes = "application/json")
    public Result edit(@RequestBody Maxim maxim) {
        return maximService.edit(maxim);
    }

    /**
     * 所有箴言
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result query(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return maximService.queryList(pageNum, pageSize);
    }

    /**
     * 搜索箴言
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Result search(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam("search") String search) {
        return maximService.searchList(pageNum, pageSize, search, -1);
    }
}
