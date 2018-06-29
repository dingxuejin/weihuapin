package com.mobiusVision.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 16:40 2018/6/14/014
 * @Modify By:
 **/
public class ApplicationContextUtil {
    private static ApplicationContext context;

    public static ApplicationContext getApplicationContext() {


                context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        return context;
    }
}
