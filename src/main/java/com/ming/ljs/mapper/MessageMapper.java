package com.ming.ljs.mapper;

import com.ming.ljs.util.utilBean.ConversationBeanUtil;
import com.ming.ljs.bean.Message;
import com.ming.ljs.util.utilBean.MessageBeanUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    /**
     * 通过userId查询用户站内信
     * @param userId
     * @return
     */
    List<ConversationBeanUtil> msgList(Integer userId);

    /**
     * 通过conversationId查询私信信息
     * @param conversationId
     * @return
     */
    List<MessageBeanUtil> msgDetail(String conversationId);

    /**
     * 更新同一个conversationId下的阅读状态
     * @param conversationId
     */
    void updateHasReadByConversationId(@Param("conversationId") String conversationId,@Param("hasRead") int hasRead);
}