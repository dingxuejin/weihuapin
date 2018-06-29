package com.mobiusVision.dao;


import com.mobiusVision.pojo.Author;

import java.util.List;

public interface AuthorMapper {
    /**
     * 通过Id查询Author表数据
     * @param id
     * @return Author
     */
    public Author findAuthorById(int id);

    /**
     * 查询Author表所有数据
     * @param
     * @return List<Author>
     */
    public List<Author> findAllAuthor();
}
