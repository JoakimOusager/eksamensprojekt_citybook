package dao;

import entities.User;

import java.sql.*;

public class UserDAO {
    public static User login(User user) {
        User foundUser = null;

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

            sql = "SELECT * FROM user WHERE username = \"" +
                    user.getUsername() + "\" AND user_password = \"" + user.getPassword()
                    +  "\"";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            if (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("user_email");
                int rank = rs.getInt("user_rank");
                foundUser = new User(username, email, rank);
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
        return foundUser;
    }

    //public static get


}
