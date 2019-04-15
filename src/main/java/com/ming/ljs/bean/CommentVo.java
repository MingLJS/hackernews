package com.ming.ljs.bean;

/**
 * created by ZMX
 * Date 2019/4/14 Time 23:03
 */
public class CommentVo {
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
        return "CommentVo{" +
                "user=" + user +
                ", comment=" + comment +
                '}';
    }
}
