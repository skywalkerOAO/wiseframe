package com.nico.wiseframe.Utils.CommonResp;

import com.alibaba.fastjson2.JSON;
import com.nico.wiseframe.Utils.Exception.ExpPojo;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

@ControllerAdvice(basePackages = "com.nico.wiseframe.controller")
public class ResponseHandler implements ResponseBodyAdvice<Object> {
    /**
     * 是否支持advice功能
     * treu=支持，false=不支持
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }
    /**
     *
     * 处理response的具体业务方法
     */
    @Override

    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ExpPojo pojo = new ExpPojo();
        if(pojo.getCode() == 500){
            return null;
        }
        if (o instanceof String) {
            return JSON.toJSON(Result.suc(o));
        }
        return Result.suc(o);
    }
}
