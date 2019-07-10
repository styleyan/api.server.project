package com.isyxf.blog.service;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Classify;

public interface ClassifyService {
    Result add(Classify classify);
    Result remove(Integer id);
    Result edit(Classify classify);
    Result getById(Integer id);
    Result getAll();
}
