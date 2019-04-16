package com.ming.ljs.util.utilBean;

import com.ming.ljs.bean.Comment;
import com.ming.ljs.bean.User;

/**
 * created by ZMX
 * Date 2019/4/14 Time 23:03
 */
public class CommentVoBeanUtil {
    User user;
    Comment comment;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentVoBeanUtil{" +
                "user=" + user +
                ", comment=" + comment +
                '}';
    }
}
