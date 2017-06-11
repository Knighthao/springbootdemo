package com.example.demo.exception;

import com.example.demo.enums.RestEnum;

/**
 * Created by howard on 2017/6/8.
 */
public class MyException extends RuntimeException {
    private int code;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MyException(String message, int code) {
        super(message);
        this.code = code;
    }

    public MyException(RestEnum en) {
        super(en.getMsg());
        this.code = en.getCode();
    }
}
