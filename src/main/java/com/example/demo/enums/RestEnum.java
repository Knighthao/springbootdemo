package com.example.demo.enums;

/**
 * Created by howard on 2017/6/8.
 */
public enum RestEnum {
    UnKnowError(255, "UnKnowError"),
    Sucess(0, "Success"),
    Error(-1, "Error");

    private String msg;

    private int code;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    RestEnum(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }
    }
