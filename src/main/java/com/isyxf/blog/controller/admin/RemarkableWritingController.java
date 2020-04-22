package com.isyxf.blog.controller.admin;


import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.RemarkableWriting;
import com.isyxf.blog.service.RemarkableWritingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author Y.jer
 *
 * 箴言请求列表
 */
@RestController
@RequestMapping(value = "/api/remarkableWriting")
public class RemarkableWritingController {

    @Resource
    private RemarkableWritingService remarkableWritingService;

    /**
     * 添加箴言
     * @param remarkableWriting
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public Result add(@RequestBody RemarkableWriting remarkableWriting) {
        return remarkableWritingService.add(remarkableWriting);
    }

    /**
     * 删除箴言
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, consumes = "application/json")
    public Result delete(@PathVariable("id") int id) {
        return remarkableWritingService.remove(id);
    }

    /**
     * 查询所有箴言
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result query() {
        return remarkableWritingService.queryAll();
    }
}
