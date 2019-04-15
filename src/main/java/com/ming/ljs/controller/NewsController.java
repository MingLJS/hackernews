package com.ming.ljs.controller;

import com.ming.ljs.bean.Comment;
import com.ming.ljs.bean.CommentVo;
import com.ming.ljs.bean.News;
import com.ming.ljs.bean.User;
import com.ming.ljs.service.NewsService;
import com.ming.ljs.service.VoService;
import com.ming.ljs.util.OResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * created by ZMX
 * Date 2019/4/11 Time 19:29
 */
@Controller
public class NewsController {
    @Autowired
    NewsService newsService;
    @Autowired
    VoService voService;
    @Value("${imgae-dir}")
    String imgaeDir;

    /**
     * 图片上传
     * @param file
     * @return
     */
    @RequestMapping("uploadImage")
    @ResponseBody
    public OResult uploadImage(MultipartFile file){
        OResult oResult = new OResult();
        String filename = file.getOriginalFilename();
        filename = UUID.randomUUID().toString() + filename;
        URL resource = NewsController.class.getClassLoader().getResource("static/images/img/");
        String path = resource.getPath();
        File fileImage = new File(path + filename);
        try {
            file.transferTo(fileImage);
            oResult.setCode(0);
            oResult.setMsg(imgaeDir+filename);
        } catch (IOException e) {
            e.printStackTrace();
            oResult.setCode(1);
        }
        return oResult;
    }

    /**
     * 新增news信息
     * @param news
     * @param session
     * @return
     */
    @RequestMapping("user/addNews")
    @ResponseBody
    public OResult addNews(News news, HttpSession session){
        User user = (User) session.getAttribute("user");
        OResult oResult = new OResult();
        news.setUserId(user.getId());
        boolean b = newsService.addNews(news);
        if(b){
            oResult.setCode(0);
            oResult.setMsg(news.getImage());
        }
        return oResult;
    }

    /**
     * redis存储点赞数
     * @return
     */
    @RequestMapping("like")
    @ResponseBody
    public OResult like(int newsId ,HttpSession session){
        OResult oResult = new OResult();
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        String msg = newsService.like(String.valueOf(newsId),String.valueOf(userId));
        oResult.setCode(0);
        oResult.setMsg(msg);
        return oResult;
    }

    /**
     * redis取消点赞
     * @return
     */
    @RequestMapping("dislike")
    @ResponseBody
    public OResult dislike(int newsId ,HttpSession session){
        OResult oResult = new OResult();
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        String msg = newsService.dislike(String.valueOf(newsId),String.valueOf(userId));
        oResult.setCode(0);
        oResult.setMsg(msg);
        return oResult;
    }

    @RequestMapping("news/{newsId}")
    public String showNews(@PathVariable("newsId")int newsId,Model model){
        //通过newsId获取对应user信息
        User user = newsService.findUserByNewsId(newsId);
        //通过newsId获取news信息
        News news = newsService.findNewsByNewsId(newsId);
        //获取like信息
        Integer likeCount = news.getLikeCount();
        //获取当前新闻所有评论列表
        List<CommentVo> comments = voService.findAllCommontVoByNewsId(newsId);
        model.addAttribute("owner",user);
        model.addAttribute("like",likeCount);
        model.addAttribute("contextPath","");
        model.addAttribute("news",news);
        model.addAttribute("comments",comments);
        return "detail";
    }

    /**
     * 增加评论
     * @param content
     * @param newsId
     * @param session
     * @return
     */
    @RequestMapping("addComment")
    public ModelAndView addComment(String content ,int newsId,HttpSession session){
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        newsService.addComment(content ,newsId,userId);
        return new ModelAndView("redirect:/news/" + newsId );
    }
}
