package com.isyxf.blog.controller.admin;

import com.google.gson.Gson;
import com.isyxf.blog.dto.Result;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author xiaofei.yan
 * @Create 2020-04-22 13:35
 * @Descript 图片存储相关控制器
 */
@RestController
@RequestMapping("/client/images")
public class ImageController {
    @Value("${qiniu.access.key}")
    private String qiNiuAccessKey;

    @Value("${qiniu.secret.key}")
    private String qiNiuSecretKey;

    @Value("${qiniu.bucket.name}")
    private String qiNiuBucketName;

    @Value("${qiniu.bucket.host.name}")
    private String qiNiuBucketHostName;

    /**
     * 图片上传到七牛云
     * 文档地址: https://developer.qiniu.com/kodo/sdk/1239/java#upload-file
     * 华南: Region.region2(), Region.huanan()
     * 华东	Region.region0(), Region.huadong()
     * @return
     */
    @PostMapping("qiniuyun")
    public Result qiniuyun(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileNewName = simpleDateFormat.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
        byte[] uploadBytes = file.getBytes();

        // 构造一个带指定Region对象的配置类
        Configuration cfg = new Configuration(Region.huanan());

        // 创建上传对象
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(qiNiuAccessKey, qiNiuSecretKey);
        String upToken = auth.uploadToken(qiNiuBucketName);

        try {
            Response response = uploadManager.put(uploadBytes, fileNewName, upToken);
            // 解析上传后的返回值
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

            return Result.success(qiNiuBucketHostName + "/" + putRet.key);
        } catch (QiniuException e) {
            Response r = e.response;
            System.err.println(r.toString());

            try {
                System.out.println(r.bodyString());
            } catch (Exception e1) {

            }

            return Result.failure(2001, "上传图片异常");
        }
    }
}
