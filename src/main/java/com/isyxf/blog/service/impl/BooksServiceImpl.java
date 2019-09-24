package com.isyxf.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isyxf.blog.dao.BooksDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Books;
import com.isyxf.blog.service.BooksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Y.jer
 * 箴言
 */
@Service
public class BooksServiceImpl implements BooksService {
    @Resource
    private BooksDao booksDao;

    /**
     * 添加书单
     * @param books
     * @return
     */
    @Override
    public Result add(Books books) {
        try{
            booksDao.insert(books);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "添加异常");
        }
    }

    /**
     * 更新书单
     * @param books
     * @return
     */
    @Override
    public Result update(Books books) {
        try{
            booksDao.update(books);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "更新异常");
        }
    }

    /**
     * 删除书单
     * @param id
     * @return
     */
    @Override
    public Result remove(Integer id) {
        try {
            booksDao.delete(id);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "删除异常");
        }
    }

    /**
     * 书单列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Result queryList(int pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            PageInfo<Books> listInfo = new PageInfo<>(booksDao.selectPage());

            return Result.success(listInfo);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "查询失败");
        }
    }

    /**
     * 搜索书单
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @Override
    public Result searchList(int pageNum, int pageSize, String name) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            PageInfo<Books> listInfo = new PageInfo<>(booksDao.search(name));

            return Result.success(listInfo);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "查询失败");
        }
    }
}
