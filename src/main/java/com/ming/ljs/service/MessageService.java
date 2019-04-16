package com.ming.ljs.service;

import com.ming.ljs.util.utilBean.ConversationBeanUtil;

import com.ming.ljs.util.utilBean.MessageBeanUtil;

import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/15 Time 21:50
 */
public interface MessageService {
    /**
     * 通过用户Id查询所有站内信
     * @param userId
     * @return
     */
    List<ConversationBeanUtil> msgList(Integer userId);

    /**
     * 通过conversationId查询私信信息并更新阅读状态(由1变为0)
     * @param conversationId
     * @return
     */
    List<MessageBeanUtil> msgDetail(String conversationId);

    /**
     * 增加私信
     * @param fromId
     * @param toId
     * @param content
     */
    boolean addMessage(int fromId,int toId, String content);

}
