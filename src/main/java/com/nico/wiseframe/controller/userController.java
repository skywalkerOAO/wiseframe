package com.nico.wiseframe.controller;

import com.nico.wiseframe.pojo.user;
import com.nico.wiseframe.services.userImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class userController {
    @Autowired
    userImpl userImpl;
    
    @RequestMapping("/user_Query_All")
    public Object queryUserInfo(@RequestBody user user){
        return userImpl.queryAll();
    }
    @RequestMapping("/user_Query_ById")
    public Object queryUserById(@Valid @RequestBody user user) {
        return userImpl.queryId(user.getGwid());
    }


}
