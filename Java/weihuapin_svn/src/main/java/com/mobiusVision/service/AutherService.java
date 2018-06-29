package com.mobiusVision.service;

import com.mobiusVision.dao.AuthorMapper;
import com.mobiusVision.pojo.Author;
import com.mobiusVision.util.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 9:44 2018/6/15/015
 * @Modify By:
 **/
public class AutherService {
    private ApplicationContext aplc;
    //public Author findAuthorById(int id);
    public Author findAuthorById(int id){

        //获取SpringBean
        aplc= ApplicationContextUtil.getApplicationContext();
        AuthorMapper authorMapper=(AuthorMapper)aplc.getBean("authorMapper");
        Author author=authorMapper.findAuthorById(id);


        return author;
    }

    //
    public List<Author> findAllAuthor(){

        //获取SpringBean
        aplc= ApplicationContextUtil.getApplicationContext();
        AuthorMapper authorMapper=(AuthorMapper)aplc.getBean("authorMapper");
        List<Author> authorList=authorMapper.findAllAuthor();


        return authorList;
    }
}
