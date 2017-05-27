package dao;

import application.Comment;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Daniel on 26-05-2017.
 */
public class CommentDAO implements BaseDAO<Comment> {
    public ArrayList<Comment> get(){
        ArrayList<Comment> list = new ArrayList<>();

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
                System.out.println(comment);
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
        // System.out.println(i);
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

            // Statement som finder ud af hvilket id brugeren, som har logget ind har
            String sqlUpdateCreatedBy;


            String sql;

            sql = "INSERT INTO comment (comment)" +
                    "VALUES ( '" + comment.getComment()+"')";
            System.out.println(sql);
            stmt.executeUpdate(sql);

            //STEP 5: Extract data from result set
            //STEP 6: Clean-up environment
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
    }

    public void update(Comment comment) {

    }

    public void delete(Comment comment) {

    }
}
