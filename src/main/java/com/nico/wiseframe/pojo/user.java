package com.nico.wiseframe.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class user {
    private int userid;
    private String psw;
    private String username;
    private int status;
    @NotBlank(message = "gwid不能为空")
    private String gwid;
    private String dept;
    private String data3;
    private String data4;
    private String data5;
}
