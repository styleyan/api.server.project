package com.isyxf.blog.controller.admin;


import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Movies;
import com.isyxf.blog.service.MoviesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author Y.jer
 *
 * 影视请求列表
 */
@RestController
@RequestMapping(value = "/api/movies")
public class MoviesController {

    @Resource
    private MoviesService moviesService;

    /**
     * 添加影视
     * @param movies
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public Result add(@RequestBody Movies movies) {
        return moviesService.add(movies);
    }

    /**
     * 更新影视
     * @param movies
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    public Result update(@RequestBody Movies movies) {
        return moviesService.update(movies);
    }

    /**
     * 删除影视
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, consumes = "application/json")
    public Result delete(@PathVariable("id") int id) {
        return moviesService.remove(id);
    }

    /**
     * 影视列表
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result query(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam("search") String search) {
        return moviesService.searchList(pageNum, pageSize, search, -1);
    }
}
