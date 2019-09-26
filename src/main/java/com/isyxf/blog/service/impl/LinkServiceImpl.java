package com.isyxf.blog.service.impl;

import com.isyxf.blog.dao.LinkDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Link;
import com.isyxf.blog.service.LinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Y.jer
 * 友链
 */
@Service
public class LinkServiceImpl implements LinkService {
    @Resource
    private LinkDao linkDao;

    /**
     * 添加友链
     * @param link
     * @return
     */
    @Override
    public Result add(Link link) {
        try {
            linkDao.insert(link);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "添加异常");
        }
    }

    /**
     * 删除友链
     * @param id
     * @return
     */
    @Override
    public Result remove(Integer id) {
        try {
            linkDao.delete(id);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "删除异常");
        }
    }

    /**
     * 编辑友链
     * @param link
     * @return
     */
    @Override
    public Result edit(Link link) {
        try {
            linkDao.update(link);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "更新异常");
        }
    }

    /**
     * 获取所有友链
     * @return
     */
    @Override
    public Result getAll(Integer state) {
        try {
            List<Link> links = linkDao.selectAll(state);
            return Result.success(links);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "获取异常");
        }
    }
}
