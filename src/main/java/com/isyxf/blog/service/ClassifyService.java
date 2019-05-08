package com.isyxf.blog.service;

import com.isyxf.blog.entity.Classify;

import java.util.List;

public interface ClassifyService {
    void add(Classify classify);
    void remove(Integer id);
    void edit(Classify classify);
    Classify get(Integer id);
    List<Classify> getAll();
}
