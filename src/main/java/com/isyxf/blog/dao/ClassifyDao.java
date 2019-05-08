package com.isyxf.blog.dao;

import com.isyxf.blog.entity.Classify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("classifyDao")
public interface ClassifyDao {
    void insert(Classify classify);
    void delete(Integer id);
    void update(Classify classify);
    Classify selectById(Integer id);
    List<Classify> selectAll();
}
