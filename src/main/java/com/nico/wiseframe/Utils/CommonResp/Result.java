package com.nico.wiseframe.Utils.CommonResp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {
    /**
     * 1.status状态值：代表本次请求response的状态结果。
     */
    private Integer status;
    /**
     * 2.response描述：对本次状态码的描述。
     */
    private String desc;
    /**
     * 3.data数据：本次返回的数据。
     */
    private T data;
    /**
     * 4.额外备注字段
     */
    private String detail;
    /**
     * 成功，创建ResResult：没data数据
     */
    public static Result suc() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }
    /**
     * 成功，创建ResResult：有data数据
     */
    public static Result suc(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }
    /**
     * 失败，指定status、desc
     */
    public static Result fail(Integer status, String desc) {
        Result result = new Result();
        result.setStatus(status);
        result.setDesc(desc);
        return result;
    }
    public static Result Validfail(String msg) {
        Result result = new Result();
        result.setResultCode(ResultCode.SYSTEM_ERROR);
        result.setDetail(msg);
        Object List;
        List = Collections.emptyList();
        result.setData(List);
        return result;
    }
    /**
     * 失败，指定ResultCode枚举
     */
    public static Result fail(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }
    /**
     * 把ResultCode枚举转换为ResResult
     */
    private void setResultCode(ResultCode code) {
        this.status = code.code();
        this.desc = code.message();
    }
}
