package com.mobiusVision.controller;

import com.mobiusVision.pojo.Author;
import com.mobiusVision.service.AutherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: zhangzhirong
 * @Description:
 * @Date:Created in 9:48 2018/6/15/015
 * @Modify By:
 **/
@Controller
public class AuthorController {

    //通过Id查询authors表单条数据
    @RequestMapping("/authorbyid")
    public @ResponseBody
    Author authorbyid() {

        AutherService autherService = new AutherService();
        Author author = autherService.findAuthorById(1);
        return author;
    }

    //查询authors表所有数据
    @RequestMapping("/authors")
    public @ResponseBody
    List<Author> authors() {

        AutherService autherService = new AutherService();
        List<Author> authorList = autherService.findAllAuthor();
        return authorList;
    }
}
