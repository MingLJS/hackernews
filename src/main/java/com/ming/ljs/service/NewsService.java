package com.ming.ljs.service;

import com.ming.ljs.bean.Comment;
import com.ming.ljs.bean.News;
import com.ming.ljs.bean.User;

/**
 * created by ZMX
 * Date 2019/4/11 Time 19:30
 */
public interface NewsService {

    /**
     * 添加新闻
     * @param news
     * @return 返回true表示添加成功,否则失败
     */
    boolean addNews(News news);

    /**
     * 增加点赞数
     * @param newsId
     * @param userId
     * @return
     */
    String like(String newsId, String userId);

    /**
     * 用户取消点赞
     * @param newsId
     * @param userId
     * @return
     */
    String dislike(String newsId, String userId);

    /**
     * 通过newsid获得news详细信息
     * @param newsId
     * @return
     */
    News findNewsByNewsId(int newsId);

    /**
     * 通过newsid获得user详细信息
     * @param newsId
     * @return
     */
    User findUserByNewsId(int newsId);

    /**
     * 增加新闻评论
     * @param content
     * @param newsId
     * @return
     */
    boolean addComment(String content ,int newsId,int userId);
}
