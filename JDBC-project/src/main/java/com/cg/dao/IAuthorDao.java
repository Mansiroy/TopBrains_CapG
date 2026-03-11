package com.cg.dao;

import com.cg.bean.Author;

public interface IAuthorDao {
    String insertAuthor(Author author) throws Exception;
    Author getAuthorById(int authorId) throws Exception;
    String updatePhone(int authorId, String phone) throws Exception;
    String deleteAuthor(int authorId) throws Exception;
}