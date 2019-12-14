package com.isyxf.blog.controller;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.ConfigBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author xiaofei.yan
 * @Create 2019-10-10 11:48
 * @Descript 测试控制器
 */
@RestController
@RequestMapping("/api/myTest")
public class MyTestController {
    private static final Logger logger = LoggerFactory.getLogger(MyTestController.class);

    @Value("${com.isyxf.url}")
    private String url;
    @Autowired
    private ConfigBean configBean;

    @RequestMapping(value = "/url", method = RequestMethod.GET, consumes = "application/json")
    public Result url() {
        logger.info(configBean.toString());
        return Result.success(url);
    }

    /**
     * 上传文件
     * @param file
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(@RequestParam("file") MultipartFile file) throws ServletException, IOException {
        try{
            if (file.isEmpty()) {
                return Result.failure(2003, "上传文件问空");
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            logger.info("上传的文件名为:" + fileName);

            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            logger.info("文件的后缀名为:" + suffixName);

            // 设置文件存储路径
            String filePath = "I://fileTemp//";
            String path = filePath + fileName + suffixName;

            File dest = new File(path);

            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                // 新建目录
                dest.getParentFile().mkdirs();
            }

            // 文件写入
            file.transferTo(dest);

            return Result.success("上传成功");
        }catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Result.failure(2003, "上传失败");
    }

    /**
     * 下载文件
     */
    @RequestMapping("/download")
    public Result download(HttpServletRequest request, HttpServletResponse response) {
        // 设置下载文件名
        String fileName = "api_server_test.txt";
        // 设置下载文件存储路径
        String realPath= "I://fileTemp//";
        File file = new File(realPath, fileName);

        if (file.exists()) {
            // 强制设置下载不打开
            response.setContentType("application/force-download");
            // 设置文件名
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;

            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);

                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                System.out.println("success");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return null;
    }
}
