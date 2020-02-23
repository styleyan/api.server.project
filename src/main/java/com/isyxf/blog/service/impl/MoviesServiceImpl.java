package com.isyxf.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isyxf.blog.dao.MoviesDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Movies;
import com.isyxf.blog.service.MoviesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Y.jer
 * 影视
 */
@Service
public class MoviesServiceImpl implements MoviesService {
    @Resource
    private MoviesDao moviesDao;

    /**
     * 添加影视
     * @param books
     * @return
     */
    @Override
    public Result add(Movies books) {
        try{
            moviesDao.insert(books);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "添加异常");
        }
    }

    /**
     * 更新影视
     * @param movies
     * @return
     */
    @Override
    public Result update(Movies movies) {
        try{
            moviesDao.update(movies);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "更新异常");
        }
    }

    /**
     * 删除影视
     * @param id
     * @return
     */
    @Override
    public Result remove(Integer id) {
        try {
            moviesDao.delete(id);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "删除异常");
        }
    }

    /**
     * 搜索影视
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @Override
    public Result searchList(int pageNum, int pageSize, String name, Integer state) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            PageInfo<Movies> listInfo = new PageInfo<>(moviesDao.search(name, state));

            return Result.success(listInfo);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "查询失败");
        }
    }
}
