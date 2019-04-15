package com.ming.ljs.mapper;

import com.ming.ljs.bean.CommentVo;
import com.ming.ljs.bean.Vo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/14 Time 23:21
 */
public interface VoMapper {
    /**
     * 找回所有的news
     * @return
     */
    List<Vo> findAllVo();


    /**
     * 通过newsId查找对应的news的评论
     * @param newsId
     * @return
     */
    List<CommentVo> findAllCommontVoByNewsId(@Param("newsId") int newsId);
}
