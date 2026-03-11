package com.cg.main;

import com.cg.bean.*;
import com.cg.Service.*;

public class Main {

    public static void main(String[] args) throws Exception {

        IAuthorService authorService = new AuthorService();
        IBookService bookService = new BookService();

        Author a = new Author(101, "John", "A", "Doe", "9999999999");
        System.out.println(authorService.addAuthor(a));

        Book b = new Book(1001, "JDBC Complete", 450, 101);
        bookService.addBook(b);

        for (String title : bookService.getBooksByAuthor(101)) {
            System.out.println(title);
        }

        bookService.updateBookPriceByAuthor("John", 500);
    }
}