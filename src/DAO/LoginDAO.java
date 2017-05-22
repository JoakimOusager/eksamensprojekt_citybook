/*package backend;

import gui.GUI;

import java.sql.*;

public class DB_login {

    //JDBC Driver name and Database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/citybook?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    //Database credentials
    static final String USER = "root";
    static final String PASS = "root";


    static String sUsername = GUI.username;
    static String sPassword = GUI.password;
    static int admin = 1;

    public static boolean isValidUserCreds(String sUsername, String sPassword, int admin) {
        boolean isValidUser = false;

        Connection conn = null;
        Statement stmt = null;


        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM login WHERE username = \"" +
                    sUsername + "\" AND password = \"" + sPassword + "\" AND admin = \"" + admin + "\"";
          //sql = "SELECT * FROM login";


            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                isValidUser = true;
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
        return isValidUser;
    }

}*/

