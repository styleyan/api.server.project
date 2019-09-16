package com.isyxf.blog.controller;


import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Books;
import com.isyxf.blog.service.BooksService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author Y.jer
 *
 * 书单请求列表
 */
@RestController
@RequestMapping(value = "/api/books")
public class BooksController {

    @Resource
    private BooksService booksService;

    /**
     * 添加书单
     * @param books
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public Result add(@RequestBody Books books) {
        return booksService.add(books);
    }

    /**
     * 更新书单
     * @param books
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    public Result update(@RequestBody Books books) {
        return booksService.update(books);
    }

    /**
     * 删除书单
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, consumes = "application/json")
    public Result delete(@PathVariable("id") int id) {
        return booksService.remove(id);
    }

    /**
     * 查询书单
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result query(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return booksService.queryList(pageNum, pageSize);
    }
}
