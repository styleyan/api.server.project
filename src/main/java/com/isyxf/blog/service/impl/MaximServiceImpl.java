package com.isyxf.blog.service.impl;

import com.isyxf.blog.dao.MaximDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Maxim;
import com.isyxf.blog.service.MaximService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    public Result queryAll() {
        try {
            List<Maxim> list = maximDao.selectAll();

            if (list == null) {
                list = new ArrayList<>();
            }
            return Result.success(list);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "删除失败");
        }
    }
}
