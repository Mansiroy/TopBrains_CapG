package com.cg.Service;

import java.util.List;
import com.cg.bean.Book;
import com.cg.dao.*;

public class BookService implements IBookService {

    IBookDao dao = new BookDao();

    public void addBook(Book book) throws Exception {
    	
    	 int generatedIsbn = (int)(Math.random() * 10000 + 1000);
         book = new Book(
             generatedIsbn,
             book.getTitle(),
             book.getPrice(),
             book.getAuthorId()
         );
        dao.insertBook(book);
    }

    public List<String> getBooksByAuthor(int authorId) throws Exception {
        return dao.getBooksByAuthor(authorId);
    }

    public void updateBookPriceByAuthor(String authorName, double price) throws Exception {
        dao.updateBookPriceByAuthor(authorName, price);
    }
}