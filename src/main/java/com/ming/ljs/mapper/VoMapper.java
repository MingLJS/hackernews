package com.ming.ljs.mapper;

import com.ming.ljs.util.utilBean.CommentVoBeanUtil;
import com.ming.ljs.util.utilBean.VoBeanUtil;
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
    List<VoBeanUtil> findAllVo();


    /**
     * 通过newsId查找对应的news的评论
     * @param newsId
     * @return
     */
    List<CommentVoBeanUtil> findAllCommontVoByNewsId(@Param("newsId") int newsId);
}
