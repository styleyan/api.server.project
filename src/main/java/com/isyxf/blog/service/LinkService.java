package com.isyxf.blog.service;

import com.isyxf.blog.entity.Link;

import java.util.List;

public interface LinkService {
    void add(Link link);
    void remove(Integer id);
    void edit(Link link);
    Link get(Integer id);
    List<Link> getAll();
}
