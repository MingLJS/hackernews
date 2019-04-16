package com.ming.ljs;

import com.ming.ljs.util.utilBean.ConversationBeanUtil;
import com.ming.ljs.util.utilBean.VoBeanUtil;
import com.ming.ljs.mapper.MessageMapper;
import com.ming.ljs.mapper.VoMapper;
import com.ming.ljs.util.utilBean.MessageBeanUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LjsApplicationTests {
    @Autowired
    VoMapper userMapper;

    @Test
    public void contextLoads() {
//        测试数据库连接
        /**
        User user = new User();
        user.setHeadUrl("123");
        user.setName("123");
        user.setPassword("123442");
        int i = userMapper.insert(user);
        Assert.assertTrue(i==1);
         **/
        List<VoBeanUtil> allVo = userMapper.findAllVo();
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.error("allVo:"+allVo);

    }



}
