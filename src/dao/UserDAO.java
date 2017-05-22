package dao;

import entities.User;

import java.sql.*;

public class UserDAO {

    //JDBC Driver name and Database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/citybook?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    //Database credentials
    static final String USER = "citybook";
    static final String PASS = "liverpool9";



    public static User login(User user) {

        Connection conn = null;
        Statement stmt = null;
        User foundUser;


        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM login WHERE username = \"" +
                    user.getUsername() + "\" AND password = \"" + user.getPassword()
                    + "\" AND admin = \"" + user.getRank() + "\"";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            if (rs.next()) {
                String userName = rs.getString("username");
                String email = rs.getString("email");
                String rank = rs.getString("rank");
                foundUser = new User();
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
        return user;
    }


}
