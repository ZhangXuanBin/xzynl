package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.User;

@Mapper
public interface UserMapper {

     User selectById(@Param("id") int id);

}
