package com.mobiusVision.test;

import com.mobiusVision.dao.AuthorMapper;
import com.mobiusVision.pojo.Author;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 15:37 2018/6/13/013
 * @Modify By:
 **/
public class AuthorTest {

    private SqlSessionFactory sqlSessionFactory;

    private ApplicationContext applicationContext;

    /**
     * 初始化工厂
     *
     * @throws Exception
     */
    @Before
    public void init() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建spring容器

        this.applicationContext = new ClassPathXmlApplicationContext(
                "spring/applicationContext.xml");
    }

    /**
     * 通过ID查询一个结果
     */
    @Test
    public void testAuthor() {
        // 获取sqlSession,和Spring整理后由Spring管理
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        // 从sqlSession中获取Mapper接口的代理对象
        AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);

        // 执行查询
        Author aut=authorMapper.findAuthorById(10);
        System.out.println(aut.toString());

        // 和Spring整理后由Spring管理
        sqlSession.close();
    }
    @Test
    public void noSpring() throws IOException{
        InputStream inputStream = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession,和Spring整理后由Spring管理
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 从sqlSession中获取Mapper接口的代理对象
        AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);

        // 执行查询
        Author aut=authorMapper.findAuthorById(10);
        System.out.println(aut.toString());

        // 和Spring整理后由Spring管理
        sqlSession.close();
    }

    @Test
    public void testAuthorBySpring() {
        AuthorMapper userMapper = (AuthorMapper) applicationContext.getBean("authorMapper");
        Author user  = userMapper.findAuthorById(1);
        System.out.println(user);
    }
}
