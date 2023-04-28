package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.DiscussPost;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    // offset, limit 考虑分页情况
    List<DiscussPost> selectDiscussPosts(@Param("userId") int userId, @Param("offset") int offset, @Param("limit") int limit);

    // 获取分页数量
    int selectDiscussPostRows(@Param("userId") int userId);

}
