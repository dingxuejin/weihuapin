package com.mobiusVision.controller;

import com.mobiusVision.dao.AuthorMapper;
import com.mobiusVision.pojo.Author;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in ${time} ${date}
 * @Modify By:
 **/

@Controller
@RequestMapping("/kfc/brands")
public class JSONController {
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public @ResponseBody
    List<Object> getAuthorInJSON(@PathVariable int id) throws IOException {
        System.out.println("-----请求json数据--------");
//        InputStream inputStream = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
//        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
//        // 获取sqlSession,和Spring整理后由Spring管理
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        // 从sqlSession中获取Mapper接口的代理对象
//        AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "spring/applicationContext.xml");
        AuthorMapper authorMapper = (AuthorMapper) applicationContext.getBean("authorMapper");
        Author user  = authorMapper.findAuthorById(1);
        System.out.println(user);
        // 执行查询
        Author author=authorMapper.findAuthorById(id);
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("sucess张？","ok");
        map.put("list",author);
        map.put("sucess1","ok");
        map.put("list1",author);
        List<Object> listA=new LinkedList<>();
        listA.add(author);
        listA.add(map);
        return listA;
    }
}
