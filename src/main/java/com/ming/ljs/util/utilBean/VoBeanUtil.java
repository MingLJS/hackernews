package com.ming.ljs.util.utilBean;

import com.ming.ljs.bean.News;
import com.ming.ljs.bean.User;

/**
 * created by ZMX
 * Date 2019/4/10 Time 21:56
 */
public class VoBeanUtil {
    User user;
    News news;
    int like;

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "VoBeanUtil{" +
                "user=" + user +
                ", news=" + news +
                ", like=" + like +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
