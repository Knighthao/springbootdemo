package com.example.demo.util;

import com.example.demo.entity.Result;
import com.sun.net.httpserver.Authenticator;

/**
 * Created by howard on 2017/6/8.
 */
public class ResultUtil {

    public  static Result error(int code,String msg)
    {
        Result res=new Result();
        res.setCode(code);
        res.setMsg(msg);
        return res;
    }

    public static  Result success(){
return success(null);
    }

    public static Result success(Object obj)
    {
        Result res=new Result();
        res.setCode(0);
        res.setMsg("Success");
        res.setData(obj);
        return res;
    }

}
