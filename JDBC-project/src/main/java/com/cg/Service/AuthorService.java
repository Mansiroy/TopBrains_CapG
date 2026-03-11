package com.cg.Service;

import com.cg.bean.Author;
import com.cg.dao.*;

public class AuthorService implements IAuthorService {

    IAuthorDao dao = new AuthorDao();

    public String addAuthor(Author author) throws Exception {
    	
    	int generatedId = (int)(Math.random() * 1000 + 100);
        author = new Author(
            generatedId,
            author.getFirstName(),
            author.getMiddleName(),
            author.getLastName(),
            author.getPhoneNo()
        );

        return dao.insertAuthor(author);
    }

    public Author getAuthor(int authorId) throws Exception {
        return dao.getAuthorById(authorId);
    }

    public String updateAuthorPhone(int authorId, String phone) throws Exception {
        return dao.updatePhone(authorId, phone);
    }

    public String deleteAuthor(int authorId) throws Exception {
        return dao.deleteAuthor(authorId);
    }
}