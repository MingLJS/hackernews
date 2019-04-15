package com.ming.ljs.controller;

import com.ming.ljs.bean.User;
import com.ming.ljs.bean.Vo;
import com.ming.ljs.mapper.UserMapper;
import com.ming.ljs.service.UserService;
import com.ming.ljs.service.VoService;
import com.ming.ljs.util.OResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * created by ZMX
 * Date 2019/4/10 Time 16:10
 */
@Controller
public class UserController {
    @Autowired
    VoService voService;
    @Autowired
    UserService userService;

    /**
     * 显示主界面
     * @param model
     * @return
     */
    @RequestMapping("home")
    public String home(Model  model){
        model.addAttribute("contextPath","");
        List<Vo> vos = voService.findAllVo();
        model.addAttribute("vos",vos);
        return "home";
    }

    /**
     * 用户登陆
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public OResult login(User user,  HttpSession session){
      OResult oResult = new OResult();
      if(userService.findUserName(user.getName())) {
        user = userService.login(user);
        if(user != null){
            session.setAttribute("user",user);
            oResult.setCode(0);
        }else {
            oResult.setCode(1);
            oResult.setMsgpwd("密码错误");
        }
      }else{
          oResult.setCode(1);
          oResult.setMsgname("用户名不存在");
      }
      return oResult;
    }

    /**
     * 用户注册
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("reg")
    @ResponseBody
    public OResult register(User user,  HttpSession session){
        OResult oResult = new OResult();
        if(!userService.findUserName(user.getName())) {
            boolean b = userService.register(user);
            if(b){
                user = userService.findUserbyName(user.getName());
                session.setAttribute("user",user);
                oResult.setCode(0);
            }else {
                oResult.setCode(1);
                oResult.setMsgpwd("注册失败请重试");
            }
        }else{
            oResult.setCode(1);
            oResult.setMsgname("用户名已存在");
        }
        return oResult;
    }

    /**
     * 用户注销
     * @param session
     * @return
     */
    @RequestMapping("logout")
    public ModelAndView logout(HttpSession session){
        if(session != null && session.getAttribute("user") != null){
            session.removeAttribute("user");
        }
        return new ModelAndView("redirect:/home");
    }




}
