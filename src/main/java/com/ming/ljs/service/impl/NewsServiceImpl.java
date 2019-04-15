package com.ming.ljs.service.impl;

import com.ming.ljs.bean.News;
import com.ming.ljs.bean.User;
import com.ming.ljs.mapper.CommentMapper;
import com.ming.ljs.mapper.NewsMapper;
import com.ming.ljs.service.NewsService;
import com.ming.ljs.util.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import com.ming.ljs.bean.Comment;
import java.util.Date;

/**
 * created by ZMX
 * Date 2019/4/11 Time 19:30
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsMapper newsMapper;

    @Autowired
    CommentMapper commentMapper;

    @Override
    public boolean addNews(News news) {
        news.setCreatedDate(new Date());
        news.setCommentCount(0);
        news.setLikeCount(0);
        int i = newsMapper.insertSelective(news);
        return i == 1;
    }

    @Override
    public String like(String newsId, String userId) {
        Jedis resource = JedisUtil.getJedisFromPool();
        resource.sadd(newsId, userId);
        Long scard = resource.scard(newsId);
        resource.close();
        return String.valueOf(scard);
    }

    @Override
    public String dislike(String newsId, String userId) {
        Jedis resource = JedisUtil.getJedisFromPool();
        resource.srem(newsId, userId);
        Long scard = resource.scard(newsId);
        resource.close();
        return String.valueOf(scard);
    }

    @Override
    public News findNewsByNewsId(int newsId) {
        News news = newsMapper.selectByPrimaryKey(newsId);
        return news;
    }

    @Override
    public User findUserByNewsId(int newsId) {
        User user = newsMapper.findUserByNewsId(newsId);
        return user;
    }

    @Override
    public boolean addComment(String content, int newsId ,int userId) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCreatedDate(new Date());
        comment.setEntityId(newsId);
        comment.setEntityType(1);
        comment.setUserId(userId);
        comment.setStatus(0);
        int insert = commentMapper.insert(comment);
        return insert == 1 ;
    }


}
