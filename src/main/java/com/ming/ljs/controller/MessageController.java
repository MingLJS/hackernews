package com.ming.ljs.controller;

import com.ming.ljs.service.UserService;
import com.ming.ljs.util.OResult;
import com.ming.ljs.util.utilBean.ConversationBeanUtil;
import com.ming.ljs.bean.User;
import com.ming.ljs.service.MessageService;

import com.ming.ljs.util.utilBean.MessageBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/15 Time 21:33
 */
@Controller
public class MessageController {
    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    /**
     * 查看站内信所有列表
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("msg/list")
    public String msgList(HttpSession session , Model model){
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        List<ConversationBeanUtil> conversations = messageService.msgList(userId);
        model.addAttribute("conversations",conversations);
        model.addAttribute("contextPath","");
        return "letter";
    }

    /**
     * 查询与某个用户的所有站内信
     * @param conversationId
     * @param model
     * @return
     */
    @RequestMapping("msg/detail")
    public String msgDetail(String conversationId, Model model){
       List<MessageBeanUtil> messages = messageService.msgDetail(conversationId);
        model.addAttribute("messages",messages);
        model.addAttribute("contextPath","");
       return "letterDetail";
    }

    /**
     * 用户跳转发送私信界面
     * @param model
     * @return
     */
    @RequestMapping("user/tosendmsg")
    public String userToSendMsg(Model model){
        model.addAttribute("contextPath","");
        return "sendmsg";
    }

    /**
     * 给其他用户发送私信
     * @param session
     * @param toName
     * @param content
     * @return
     */
    @RequestMapping("user/msg/addMessage")
    @ResponseBody
    public OResult userMsgAddMessage(HttpSession session, String toName, String content){
        OResult oResult = new OResult();
        //判断要寄往的用户名是否存在
        if(userService.findUserName(toName)){
            User user = (User) session.getAttribute("user");
            Integer fromId = user.getId();
            Integer toId = userService.findUserbyName(toName).getId();
            boolean b = messageService.addMessage(fromId, toId, content);
            if(b) {
                oResult.setCode(0);
            }else {
                oResult.setCode(1);
                oResult.setMsg("发送失败,请重试");
            }
        }else {
            oResult.setCode(1);
            oResult.setMsg("用户名不存在");
        }
        return oResult;
    }

}
