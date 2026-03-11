package com.cg.dao;

import java.sql.*;
import java.util.*;
import com.cg.bean.Book;
import com.cg.util.DBUtil;

public class BookDao implements IBookDao {

    public void insertBook(Book b) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps =
            con.prepareStatement("INSERT INTO book VALUES(?,?,?,?)");

        ps.setInt(1, b.getIsbn());
        ps.setString(2, b.getTitle());
        ps.setDouble(3, b.getPrice());
        ps.setInt(4, b.getAuthorId());

        ps.executeUpdate();
        con.close();
    }

    public List<String> getBooksByAuthor(int authorId) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps =
            con.prepareStatement("SELECT title FROM book WHERE author_id=?");

        ps.setInt(1, authorId);
        ResultSet rs = ps.executeQuery();

        List<String> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        con.close();
        return list;
    }

    public void updateBookPriceByAuthor(String authorName, double price) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps =
            con.prepareStatement(
                "UPDATE book b JOIN author a ON b.author_id=a.author_id " +
                "SET b.price=? WHERE a.first_name=?"
            );

        ps.setDouble(1, price);
        ps.setString(2, authorName);
        ps.executeUpdate();
        con.close();
    }
}