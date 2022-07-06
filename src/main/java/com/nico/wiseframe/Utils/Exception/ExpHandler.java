package com.nico.wiseframe.Utils.Exception;

import com.nico.wiseframe.Utils.CommonResp.Result;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExpHandler{
    /*前端数据校验异常捕获*/
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Object exceptionHandler(MethodArgumentNotValidException e){
        String msg = null;
        ExpPojo pojo = new ExpPojo();
        pojo.setCode(500);
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            String defaultMessage = fieldError.getDefaultMessage();
            msg = defaultMessage;
        }
       return Result.Validfail(msg);
    }
    /*内部运行出错异常捕获*/
    @ExceptionHandler(value = ArithmeticException.class)
    public Object  ArithmeticHandler(ArithmeticException e){
        String msg = e.getMessage();
        ExpPojo pojo = new ExpPojo();
        pojo.setCode(500);
        return Result.Validfail(msg);
    }
    /*空指针异常*/
    @ExceptionHandler(value = NullPointerException.class)
    public Object otherHandler(NullPointerException e){
        String msg = "NullPointer";
        ExpPojo pojo = new ExpPojo();
        pojo.setCode(500);
        return Result.Validfail(msg);
    }
    /*未知错误*/
    @ExceptionHandler(value = RuntimeException.class)
    public Object otherHandler(RuntimeException e){
        String msg =  e.getMessage();
        ExpPojo pojo = new ExpPojo();
        pojo.setCode(500);
        return Result.Validfail(msg);
    }
}
