package com.isyxf.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isyxf.blog.dao.MaximDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Maxim;
import com.isyxf.blog.service.MaximService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Y.jer
 * 箴言
 */
@Service
public class MaximServiceImpl implements MaximService {

    @Resource
    private MaximDao maximDao;

    /**
     * 添加箴言
     * @param maxim
     * @return
     */
    @Override
    public Result add(Maxim maxim) {
        try {
            maximDao.insert(maxim);
            return Result.success();
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "添加失败");
        }
    }

    /**
     * 编辑检验
     */
    @Override
    public Result edit(Maxim maxim) {
        try {
            maximDao.edit(maxim);
            return Result.success();
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "添加失败");
        }
    }

    /**
     * 删除箴言
     * @param id
     * @return
     */
    @Override
    public Result remove(Integer id) {
        try {
            maximDao.delete(id);
            return Result.success();
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "删除失败");
        }
    }

    /**
     * 获取所有箴言
     * @return
     */
    @Override
    public Result queryList(int pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            PageInfo<Maxim> listInfo = new PageInfo<>(maximDao.selectPage());

            return Result.success(listInfo);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "失败");
        }
    }

    @Override
    public Result searchList(int pageNum, int pageSize, String search) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            PageInfo<Maxim> listInfo = new PageInfo<>(maximDao.searchPage(search));

            return Result.success(listInfo);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "失败");
        }
    }
}
