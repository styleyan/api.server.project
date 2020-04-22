package com.isyxf.blog.controller.admin;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Classify;
import com.isyxf.blog.service.ClassifyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Y.jer
 *
 * 文章分类相关接口
 */
@RestController
@RequestMapping("/api/classify")
public class ClassifyController {

    @Resource
    private ClassifyService classifyService;

    /**
     * 添加文章分类
     * @param classify
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public Result add(@RequestBody Classify classify) {
        return classifyService.add(classify);
    }

    /**
     * 删除文章分类
     * @return
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, consumes = "application/json")
    public Result remove(@PathVariable("id") int id) {
        return classifyService.remove(id);
    }

    /**
     * 更新文章分类
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST, consumes = "application/json")
    public Result remove(@RequestBody Classify classify) {
        return classifyService.edit(classify);
    }

    /**
     * 查询分类详情
     * @return
     */
    @RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
    public Result detail(@PathVariable("id") int id) {
        return classifyService.getById(id);
    }

    /**
     * 查询分类列表
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result queryAll() {
        return classifyService.getAll();
    }
}
