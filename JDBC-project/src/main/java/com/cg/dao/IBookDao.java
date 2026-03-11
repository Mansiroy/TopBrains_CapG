package com.cg.dao;

import java.util.List;
import com.cg.bean.Book;

public interface IBookDao {
    void insertBook(Book book) throws Exception;
    List<String> getBooksByAuthor(int authorId) throws Exception;
    void updateBookPriceByAuthor(String authorName, double price) throws Exception;
}