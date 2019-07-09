package com.isyxf.blog.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Y.Jer
 * 统一 ajax 返回格式
 */
@Setter
@Getter
public class Result implements Serializable {
    /**
     * code码
     */
    private int code = 0;

    /**
     * 错误提示
     */
    private String message = "";

    /**
     * 返回状态(0: 失败, 1: 成功)
     */
    private int status;

    /**
     * 返回数据
     */
    private Object data;

    public Result(){}

    /**
     * 单纯成功, 不返回数据
     * @return
     */
    public static Result success() {
        Result result = new Result();
        result.setStatus(1);
        result.setData(new HashMap(0));
        return result;
    }

    /**
     * 单纯成功, 不返回数据
     * @return
     */
    public static Result success(int code, Object data) {
        Result result = new Result();
        result.setStatus(1);
        result.setCode(code);
        result.setData(data);
        return result;
    }

    /**
     * 返回指定数据
     * @param data
     * @return
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setStatus(1);
        result.setData(data);

        return result;
    }

    /**
     * 返回错误
     * @param code
     * @param message
     * @return
     */
    public static Result failure(int code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setStatus(0);

        return result;
    }

}
