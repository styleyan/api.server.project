package com.isyxf.blog.controller.test;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.service.HdfsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author xiaofei.yan
 * @Create 2021-03-22 17:51
 * @Descript hdfs文件
 */
@RestController
@RequestMapping("/hadoop/hdfs")
public class HdfsController {

    /**
     * 查看文件是否已存在
     */
    @GetMapping("/existFile")
    public Result existFile(@RequestParam("path") String path) throws Exception {
        Boolean isExist = HdfsService.existFile(path);

        return Result.success("file isExist: " + isExist);
    }

    /**
     * 复制文件
     * @param map
     * @return
     * @throws Exception
     */
    @PostMapping("/copy")
    public Result copyFile(@RequestBody Map map) throws Exception {
        String sourcePath = (String) map.get("sourcePath");
        String result = HdfsService.copyTable(sourcePath);

        return Result.success(result);
    }

    /**
     * 删除文件
     */
    @PostMapping("/deleteFile")
    public Result deleteFile(@RequestParam("path") String path) throws Exception {
        Boolean result = HdfsService.deleteFile(path);

        return Result.success(result);
    }

    /**
     * 获取文件列表
     * @param path
     * @return
     * @throws Exception
     */
    @PostMapping("/listFile")
    public Result listFile(@RequestParam("path") String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return Result.failure(2003, "请求参数不能为空");
        }
        List<Map<String, String>> resultList = HdfsService.listFile(path);

        return Result.success(resultList);
    }
}
