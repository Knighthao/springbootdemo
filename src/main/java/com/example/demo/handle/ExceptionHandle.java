package com.example.demo.handle;


import com.example.demo.entity.Result;
import com.example.demo.exception.MyException;
import com.example.demo.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by howard on 2017/6/8.
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result Handle(Exception ex)
    {
        if(ex instanceof  MyException)
        {
            MyException my=(MyException)ex;
            return ResultUtil.error(((MyException) ex).getCode(),((MyException) ex).getMessage());
        }
        else
        {

        }

        return ResultUtil.error(100,"");

    }
}
