package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<Comment> selectCommentByEntity(@Param("entityType") int entityType, @Param("entityId") int entityId, @Param("offset") int offset, @Param("limit") int limit);

    int selectCountByEntity(@Param("entityType") int entityType, @Param("entityId") int entityId);

    int insertComment(Comment comment);

    Comment selectCommentById(@Param("id") int id);

}
