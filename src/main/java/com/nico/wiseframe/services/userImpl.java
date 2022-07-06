package com.nico.wiseframe.services;

import com.nico.wiseframe.mapper.userMapper;
import com.nico.wiseframe.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userImpl {
    @Autowired
    userMapper userMapper;
    public List<user> queryAll(){
        return userMapper.queryAll();
    }
    public List<user> queryId(String gwid){
            return  userMapper.queryId(gwid);
    }

}
