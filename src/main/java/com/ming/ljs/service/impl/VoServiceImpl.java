package com.ming.ljs.service.impl;

import com.ming.ljs.bean.CommentVo;
import com.ming.ljs.bean.Vo;
import com.ming.ljs.mapper.UserMapper;
import com.ming.ljs.mapper.VoMapper;
import com.ming.ljs.service.VoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/10 Time 22:08
 */
@Service("voService")
public class VoServiceImpl implements VoService {
    @Autowired
    VoMapper voMapper;

    @Override
    public List<Vo> findAllVo() {
        List<Vo> vo = voMapper.findAllVo();
        return vo;
    }

    @Override
    public List<CommentVo> findAllCommontVoByNewsId(int newsId) {
        List<CommentVo> comments = voMapper.findAllCommontVoByNewsId(newsId);
        return comments;
    }
}
