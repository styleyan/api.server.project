package com.isyxf.blog.dao;

import com.isyxf.blog.entity.RemarkableWriting;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Y.jer
 * 个人奇文接口
 */
@Repository("remarkableWritingDao")
public interface RemarkableWritingDao {
    /**
     * 查询所有奇文
     * @return
     */
    List<RemarkableWriting> selectAll();

    /**
     * 添加奇文
     * @param remarkableWriting
     * @return
     */
    int insert(RemarkableWriting remarkableWriting);

    /**
     * 删除奇文
     * @param id
     * @return
     */
    boolean delete(@Param("id") int id);
}
