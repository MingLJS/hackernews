package com.ming.ljs.service;

import com.ming.ljs.bean.CommentVo;
import com.ming.ljs.bean.Vo;

import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/10 Time 22:07
 */
public interface VoService {
    List<Vo> findAllVo();

    List<CommentVo> findAllCommontVoByNewsId(int newsId);
}
