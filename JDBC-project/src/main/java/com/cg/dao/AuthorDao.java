package com.cg.dao;

import java.sql.*;
import com.cg.bean.Author;
import com.cg.util.DBUtil;

public class AuthorDao implements IAuthorDao {

    public String insertAuthor(Author a) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps =
            con.prepareStatement("INSERT INTO author VALUES(?,?,?,?,?)");

        ps.setInt(1, a.getAuthorId());
        ps.setString(2, a.getFirstName());
        ps.setString(3, a.getMiddleName());
        ps.setString(4, a.getLastName());
        ps.setString(5, a.getPhoneNo());

        ps.executeUpdate();
        con.close();
        return "Author Inserted";
    }

    public Author getAuthorById(int id) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps =
            con.prepareStatement("SELECT * FROM author WHERE author_id=?");

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Author a = null;
        if (rs.next()) {
            a = new Author(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
        }
        con.close();
        return a;
    }

    public String updatePhone(int id, String phone) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps =
            con.prepareStatement("UPDATE author SET phone_no=? WHERE author_id=?");

        ps.setString(1, phone);
        ps.setInt(2, id);
        ps.executeUpdate();
        con.close();
        return "Author Updated";
    }

    public String deleteAuthor(int id) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps =
            con.prepareStatement("DELETE FROM author WHERE author_id=?");

        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
        return "Author Deleted";
    }
}