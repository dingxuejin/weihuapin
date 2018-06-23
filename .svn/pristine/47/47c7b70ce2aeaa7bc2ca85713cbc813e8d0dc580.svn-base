package com.mobiusVision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 18:18 2018/6/13/013
 * @Modify By:
 **/
@Controller
public class FirstHandler {
    @RequestMapping("/handler")
    public ModelAndView handler(){
        System.out.println("login ok1");
        ModelAndView mav = new ModelAndView();
        System.out.println("login ok2");
        mav.addObject("name", "zhangsan");
        System.out.println("login ok3");
        mav.setViewName("index1");
        System.out.println("login ok4");
        String a_b="abc";
        System.out.println(a_b);
        return mav;
    }
}
