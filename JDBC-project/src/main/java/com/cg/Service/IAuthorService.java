package com.cg.Service;

import com.cg.bean.Author;

public interface IAuthorService {
    String addAuthor(Author author) throws Exception;
    Author getAuthor(int authorId) throws Exception;
    String updateAuthorPhone(int authorId, String phone) throws Exception;
    String deleteAuthor(int authorId) throws Exception;
}
