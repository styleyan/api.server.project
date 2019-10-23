package com.isyxf.blog.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author xiaofei.yan
 * @Create 2019-10-23 20:37
 * @Descript 图片上传接口
 */
public interface UploadService {
    String uploadFile(MultipartFile multipartFile);
}
