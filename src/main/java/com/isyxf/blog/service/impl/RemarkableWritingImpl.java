package com.isyxf.blog.service.impl;

import com.isyxf.blog.dao.RemarkableWritingDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.RemarkableWriting;
import com.isyxf.blog.service.RemarkableWritingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Y.jer
 * 箴言
 */
@Service
public class RemarkableWritingImpl implements RemarkableWritingService {

    @Resource
    private RemarkableWritingDao remarkableWritingDao;

    /**
     * 添加奇文
     * @param remarkableWriting
     * @return
     */
    @Override
    public Result add(RemarkableWriting remarkableWriting) {
        try {
            remarkableWritingDao.insert(remarkableWriting);
            return Result.success();
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "添加失败");
        }
    }

    /**
     * 删除奇文
     * @param id
     * @return
     */
    @Override
    public Result remove(Integer id) {
        try {
            remarkableWritingDao.delete(id);
            return Result.success();
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "删除失败");
        }
    }

    /**
     * 查询所有奇文
     * @return
     */
    @Override
    public Result queryAll() {
        try {
            List<RemarkableWriting> list = remarkableWritingDao.selectAll();

            if (list == null) {
                list = new ArrayList<>();
            }
            return Result.success(list);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "查询所有奇文失败");
        }
    }
}
