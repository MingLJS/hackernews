package com.ming.ljs.service;

import com.ming.ljs.util.utilBean.CommentVoBeanUtil;
import com.ming.ljs.util.utilBean.VoBeanUtil;

import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/10 Time 22:07
 */
public interface VoService {
    List<VoBeanUtil> findAllVo();

    List<CommentVoBeanUtil> findAllCommontVoByNewsId(int newsId);
}
