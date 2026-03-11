package com.cg.Service;

import java.util.List;
import com.cg.bean.Book;

public interface IBookService {
    void addBook(Book book) throws Exception;
    List<String> getBooksByAuthor(int authorId) throws Exception;
    void updateBookPriceByAuthor(String authorName, double price) throws Exception;
}