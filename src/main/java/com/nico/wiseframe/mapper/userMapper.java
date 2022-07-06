package com.nico.wiseframe.mapper;

import com.nico.wiseframe.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface userMapper {
    //查询
    @Select("SELECT * FROM user_List")
    public List<user> queryAll();
    //以ID查询
    @Select("SELECT * FROM user_List WHERE gwid = #{gwid}")
    public List<user> queryId(String gwid);

}
