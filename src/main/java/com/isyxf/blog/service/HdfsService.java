package com.isyxf.blog.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.hdfs.server.namenode.EditLogInputException;
import org.apache.hadoop.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.*;

/**
 * @author xiaofei.yan
 * @Create 2021-03-22 17:30
 * @Descript Hdfs服务
 */
@Component
public class HdfsService {

    @Value("${hdfs.path}")
    private String path;
    @Value("${hdfs.username}")
    private String username;

    private static String hdfsPath;
    private static String hdfsName;
    private static final int bufferSize = 1024 * 1024 * 64;

    /**
     * 获取HDFS配置信息
     */
    private static Configuration getConiguration() {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", hdfsPath);

        return configuration;
    }

    /**
     * 获取HDFS文件系统对象
     */
    public static FileSystem getFileSystem() throws Exception {
        /**
         * 客户端去操作 hdfs 时是有一个用户身份的，默认情况下hdfs客户端 api 会从 jvm 中获取一个参数作为自己的用户身份
         * DHADOOP_USER_NAME=hadoop
         * 可以在构造客户端fs对象时，通过次数传递进去
         */
        FileSystem fileSystem = FileSystem.get(new URI(hdfsPath), getConiguration(), hdfsName);

        return fileSystem;
    }

    /**
     * 复制表
     * @param sourcePath
     * @return
     */
    public static String copyTable(String sourcePath) throws Exception {
        if (StringUtils.isEmpty(sourcePath)){
            return "";
        }
        // 去掉尾部多余的 "/" 字符串
        sourcePath = trimEndsChars(sourcePath, "/");

        // 判断表是否存在
        Boolean hasPath = existFile(sourcePath);
        if(!hasPath) {
            return "";
        }

        // HDFS 文件不存在，则直接返回
        List<Map<String, String>> listFile = listFile(sourcePath);
        if (listFile.size() == 0) {
            return "";
        }

        // 设置表地址
        String targetPath = sourcePath + "_" + randomString(10) + "_" + randomString(10);

        // 开始拷贝文件
        Iterator iteratorList = listFile.iterator();
        while (iteratorList.hasNext()) {
            Map map = (Map) iteratorList.next();
            String fileName = (String)map.get("fileName");
            String copyUrl = sourcePath + "/" + fileName;
            String copyDest = targetPath + "/" + fileName;
            copyFile(copyUrl, copyDest);
        }

        return targetPath;
    }

    /**
     * 判断HDFS文件是否存在
     * @param path
     * @return
     * @throws Exception
     */
    public static Boolean existFile(String path) throws Exception {
        if (StringUtils.isEmpty(path)){
            return false;
        }
        FileSystem fs = getFileSystem();
        Path srcPath = new Path(path);

        boolean isExists = fs.exists(srcPath);
        return isExists;
    }

    /**
     * 读取 HDFS 文件列表
     * @param path
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> listFile(String path) throws Exception {
        if (StringUtils.isEmpty(path) || !existFile(path)){
            return null;
        }

        // 目标路径
        Path srcPath = new Path(path);
        FileSystem fs = getFileSystem();
        // 递归找到所有文件
        RemoteIterator<LocatedFileStatus> filesList = fs.listFiles(srcPath, true);
        List<Map<String, String>> resultList = new ArrayList<>();

        while (filesList.hasNext()) {
            LocatedFileStatus next = filesList.next();
            String fileName = next.getPath().getName();
            Path filePath = next.getPath();
            Map<String, String> map = new HashMap<>(8);

            map.put("fileName", fileName);
            map.put("filePath", filePath.toString());

            resultList.add(map);
        }
        fs.close();

        return resultList;
    }

    /**
     * HDFS文件复制
     * @param sourcePath
     * @param targetPath
     * @throws Exception
     */
    public static Boolean copyFile(String sourcePath, String targetPath) throws Exception {
        // 原始文件路径
        Path oldPath = new Path(sourcePath);
        // 目标路径
        Path newPath = new Path(targetPath);

        FSDataInputStream inputStream = null;
        FSDataOutputStream outputStream = null;
        FileSystem fs = getFileSystem();
        try {
            inputStream = fs.open(oldPath);
            outputStream = fs.create(newPath);

            IOUtils.copyBytes(inputStream, outputStream, bufferSize, false);
        }catch (EditLogInputException e) {
            e.printStackTrace();
            return false;
        }finally {
            inputStream.close();
            outputStream.close();
            fs.close();
        }
        return true;
    }

    /**
     * 删除 HDFS 文件
     * @param path
     * @return
     * @throws Exception
     */
    public static Boolean deleteFile(String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return false;
        }

        if (!existFile(path)) {
            return false;
        }

        Path srcPath = new Path(path);
        FileSystem fs = getFileSystem();
        Boolean isOk = fs.deleteOnExit(srcPath);
        fs.close();
        return isOk;
    }

    /**
     * 生成随机字符
     * @params
     * @return
     */
    public static String randomString(int num) {
        String generatedString = RandomStringUtils.randomAlphabetic(num);

        return generatedString;
    }

    /**
     * 去掉尾部特定字符
     */
    public static String trimEndsChars(String srcStr, String splitter) {
        String regex = splitter + "*$";
        return srcStr.replaceAll(regex, "");
    }

    @PostConstruct
    public void getPath() {
        hdfsPath = this.path;
    }
    @PostConstruct
    public void getName() {
        hdfsName = this.username;
    }
}
