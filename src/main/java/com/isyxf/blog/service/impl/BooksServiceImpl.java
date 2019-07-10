package com.isyxf.blog.service.impl;

import com.isyxf.blog.dao.BooksDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Books;
import com.isyxf.blog.service.BooksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Result queryAll() {
        try {
            List<Books> list = booksDao.selectAll();
            if (list == null) {
                list = new ArrayList<>();
            }
            return Result.success(list);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "查询失败");
        }
    }
}
