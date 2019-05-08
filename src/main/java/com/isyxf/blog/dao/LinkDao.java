package com.isyxf.blog.dao;

import com.isyxf.blog.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("linkDao")
public interface LinkDao {
    void insert(Link link);
    void delete(Integer id);
    void update(Link link);
    Link selectById(Integer id);
    List<Link> selectAll();
}
