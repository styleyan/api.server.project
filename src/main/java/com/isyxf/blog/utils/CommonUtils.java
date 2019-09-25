package com.isyxf.blog.utils;

import com.isyxf.blog.entity.Classify;
import com.isyxf.blog.entity.Tag;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xiaofei.yan
 * @Create 2019-09-25 11:07
 * @Descript 通用工具方法
 */
public class CommonUtils {

    /**
     * 标签 list 转 Map
     *
     * @url 参考文章: https://www.iteye.com/blog/bugyun-2433872
     * @param list
     * @return
     */
    public static Map<Integer, String> tagListToMap(List<Tag> list) {
        Map<Integer, String> result = list.stream().collect(Collectors.toMap(Tag::getId, tag -> tag.getName()));

        return result;
    }

    /**
     * 分类 list 转 Map
     *
     * @url 参考文章: https://www.iteye.com/blog/bugyun-2433872
     * @param list
     * @return
     */
    public static Map<Integer, String> classifyListToMap(List<Classify> list) {
        Map<Integer, String> result = list.stream().collect(Collectors.toMap(Classify::getId, classify -> classify.getTitle()));

        return result;
    }
}
