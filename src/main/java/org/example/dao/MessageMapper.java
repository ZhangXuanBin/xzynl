package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Message;

import java.util.List;

@Mapper
public interface MessageMapper {

    List<Message> selectConversations(@Param("userId") int userId, @Param("offset") int offset, @Param("limit") int limit);

    int selectConversationCount(@Param("userId") int userId);

    List<Message> selectLetters(@Param("conversationId")String conversationId, @Param("offset")int offset, @Param("limit")int limit);

    int selectLetterCount(@Param("conversationId") String conversationId);

    int selectLetterUnreadCount(@Param("userId") int userId, @Param("conversationId")String conversationId);

    // 新增消息
    int insertMessage(Message message);

    // 修改消息状态(已读、删除)
    int updateStatus(@Param("ids") List<Integer> ids, @Param("status") int status);

    // 查询某个主题下最新的通知
    Message selectLastedNotice(@Param("userId") int userId, @Param("topic")String topic);

    // 查询某个主题所包含的通知数量
    int selectNoticeCount(@Param("userId") int userId, @Param("topic")String topic);

    // 查询未读的通知数量
    int selectNoticeUnreadCount(@Param("userId") int userId, @Param("topic")String topic);

    // 查询某个主题所包含的通知列表
    List<Message> selectNotices(@Param("userId") int userId, @Param("topic")String topic, @Param("offset") int offset, @Param("limit") int limit);

}
