package com.isyxf.blog.service.impl;

import com.isyxf.blog.dao.ClassifyDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Classify;
import com.isyxf.blog.service.ClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Y.jer
 * 文章分类
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Resource
    private ClassifyDao classifyDao;

    /**
     * 添加分类
     * @param classify
     * @return
     */
    @Override
    public Result add(Classify classify) {
        try {
            classifyDao.insert(classify);
            return Result.success();
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "添加数据异常");
        }
    }

    /**
     * 更具 id 删除分类
     * @param id
     * @return
     */
    @Override
    public Result remove(Integer id) {
        try {
            classifyDao.delete(id);
            return Result.success();
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "删除数据异常");
        }
    }

    /**
     * 编辑分类信息
     * @param classify
     * @return
     */
    @Override
    public Result edit(Classify classify) {
        try {
            classifyDao.update(classify);
            return Result.success();
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "更新数据异常");
        }
    }

    /**
     * 更具id获取分类信息
     * @param id
     * @return
     */
    @Override
    public Result getById(Integer id) {
        try {
            Classify classify = classifyDao.selectById(id);
            return Result.success(classify);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "查询数据异常");
        }
    }

    /**
     * 获取全部文章分类
     * @return
     */
    @Override
    public Result getAll() {
        try {
            List<Classify> classifyList = classifyDao.selectAll();

            if (classifyList == null) {
                classifyList = new ArrayList<>();
            }
            return Result.success(classifyList);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "查询数据异常");
        }
    }
}
