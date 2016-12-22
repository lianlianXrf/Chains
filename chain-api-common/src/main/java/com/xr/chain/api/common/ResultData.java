package com.xr.chain.api.common;

import java.io.Serializable;

public class ResultData<T> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2361775385824123236L;
    public static final int SUCCESS = 200;

    public static final int FAIL = 500;

    public static final String COMMON_ERR_MSG = "网络异常";

    public static final String OBJECT_ISNULL_MSG = "对象不能为空";

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回描述
     */
    private String msg;

    /**
     * 返回对象
     */
    private T data;

    public ResultData() {
        this.code = FAIL;
        this.msg = "";
        this.data = null;
    }

    public ResultData(T data) {
        this.code = FAIL;
        this.msg = "";
        this.data = data;
    }

    public ResultData(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
