package com.ming.ljs.util.utilBean;

import java.util.Date;

/**
 * created by ZMX
 * Date 2019/4/16 Time 9:10
 */
public class MessageBeanUtil {
    int userId;
    String headUrl;
    String content;
    Date createdDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
