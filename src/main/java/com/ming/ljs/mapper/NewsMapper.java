package com.ming.ljs.mapper;

import com.ming.ljs.bean.News;
import com.ming.ljs.bean.User;


public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    /**
     * 通过newsid获得user详细信息
     * @param newsId
     * @return
     */
    User findUserByNewsId(int newsId);
}