package com.ming.ljs.util.utilBean;


import com.ming.ljs.bean.Message;
import com.ming.ljs.bean.User;

/**
 * created by ZMX
 * Date 2019/4/15 Time 21:59
 */
public class ConversationBeanUtil {
    Message message;
    User user;
    int unread;
    int count;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
