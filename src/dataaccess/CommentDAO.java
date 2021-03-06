package dataaccess;

import application.Comment;
import gui.GUIController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//////////////////////////////////////////////////// Daniel og Anders //////////////////////////////////////////

public class CommentDAO implements BaseDAO<Comment> {
    boolean error;

    public List<Comment> get(){
        List<Comment> list = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(DAO.JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT comment FROM cbcrm.comment WHERE idcomment=(SELECT MAX(idcomment) FROM cbcrm.comment);");

            //STEP 5: Extract data from result set
            if (rs.next()) {

                // Company detaljer
                String comment = rs.getString("comment");
                list.add(new Comment(comment));

            }

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

        }
        return list;
    }

    public void insert(Comment comment) {
        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(DAO.JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql;

            sql = "INSERT INTO comment (comment)" +
                    "VALUES ( '" + comment.getComment()+"')";
            stmt.executeUpdate(sql);

            //STEP 5: Extract data from result set
            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            error = true;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        GUIController.showErrorMessage(error);
    }

    public void update(Comment comment) {

    }

    public void delete(Comment comment) {

    }
}
