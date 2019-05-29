package com.isyxf.blog.dto;

/**
 * 请求统一返回格式
 * @param <T>
 */
public class GlobalResult<T> {
    private boolean status;
    private T data;
    private String error;
    private Integer code;

    public GlobalResult(boolean status, T data) {
        this.status = status;
        this.data = data;
    }

    public GlobalResult(boolean status, String error, Integer code) {
        this.status = status;
        this.error = error;
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "GlobalResult{" +
                "status=" + status +
                ", data=" + data +
                ", error='" + error + '\'' +
                ", code=" + code +
                '}';
    }
}
