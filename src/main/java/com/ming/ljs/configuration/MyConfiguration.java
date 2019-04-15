package com.ming.ljs.configuration;


import com.ming.ljs.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



/**
 * created by ZMX
 * Date 2019/4/11 Time 21:50
 */

@Configuration
public class MyConfiguration implements WebMvcConfigurer {
    @Autowired
    MyInterceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] exclude = new String[]{"/","/home","/static/**"};
        String[] addPath = new String[]{"/like/**","/dislike/**","/user/**"};
        registry.addInterceptor(new MyInterceptor()).addPathPatterns(addPath);
    }
}
