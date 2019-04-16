package com.ming.ljs.service.impl;

import com.ming.ljs.bean.Message;
import com.ming.ljs.util.utilBean.ConversationBeanUtil;
import com.ming.ljs.mapper.MessageMapper;
import com.ming.ljs.service.MessageService;
import com.ming.ljs.util.utilBean.MessageBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/15 Time 21:50
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<ConversationBeanUtil> msgList(Integer userId) {
        List<ConversationBeanUtil> conversations = messageMapper.msgList(userId);
        return conversations;
    }

    @Override
    public List<MessageBeanUtil> msgDetail(String conversationId) {
        List<MessageBeanUtil> messages = messageMapper.msgDetail(conversationId);
        int hasRead = 0;
        messageMapper.updateHasReadByConversationId(conversationId,hasRead);
        return messages;
    }

    @Override
    public boolean addMessage(int fromId,int toId, String content) {
        Message message = new Message();
        String conversationId = fromId >= toId ? (toId+"_"+fromId) : (fromId+"_"+toId) ;
        message.setContent(content);
        message.setCreatedDate(new Date());
        message.setHasRead(1);
        message.setFromId(fromId);
        message.setToId(toId);
        message.setConversationId(conversationId);
        int insert = messageMapper.insert(message);
        return insert == 1;
    }
}
