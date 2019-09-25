package com.isyxf.blog.controller;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.service.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Y.jer
 *
 * C端相关查询
 */
@RestController
@RequestMapping("/client")
public class ClientController {
    @Resource
    private ArticleService articleService;
    @Resource
    private ClientService clientService;
    @Resource
    private MaximService maximService;
    @Resource
    private BooksService booksService;
    @Resource
    private LinkService linkService;
    @Resource
    private ClassifyService classifyService;

    /**
     * 文章列表
     * @return
     */
    @RequestMapping(value = "/article/list", method = RequestMethod.GET)
    public Result articleList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return articleService.search(pageNum,pageSize, "");
    }

    /**
     * 文章详情
     * @return
     */
    @RequestMapping(value = "/article/{url}/detail", method = RequestMethod.GET)
    public Result articleDetail(@PathVariable("url") String url) {
        return clientService.articleDetail(url);
    }


    /**
     * 文章归档
     */
    @RequestMapping(value = "/archive/list", method = RequestMethod.GET)
    public Result archiveList() {
        return clientService.archiveList();
    }

    /**
     * 箴言列表
     */
    @RequestMapping(value = "/maxim/list", method = RequestMethod.GET)
    public Result maximList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return maximService.searchList(pageNum, pageSize, "");
    }

    /**
     * 书单
     */
    @RequestMapping(value = "/books/list", method = RequestMethod.GET)
    public Result clientList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return booksService.searchList(pageNum, pageSize, "");
    }

    /**
     * 友链
     */
    @RequestMapping(value = "/link/list", method = RequestMethod.GET)
    public Result linkList() {
        return linkService.getAll();
    }

    /**
     * 分类
     */
    @RequestMapping(value = "/classify/list", method = RequestMethod.GET)
    public Result classifyList() {
        return classifyService.getAll();
    }
}
