package dao;

import entities.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements BaseDAO<User> {

    /*
        Vores metode der bestemmer om man kan logge ind eller ej
     */

    public static User login(User user) {
        /*
            foundUser er den variabel der indeholder en bruger hvis den indtastede bruger findes samt kodeordet er korrekt.
          */
        User foundUser = null;
        /*
            For at resette vores connection til databasen.
         */
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

    public ArrayList<User> get() {
        ArrayList<User> userList = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        int i = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(DAO.JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM cbcrm.user";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {

                // Company detaljer
                String username = rs.getString("username");
                String email = rs.getString("user_email");
                int rank = rs.getInt("user_rank");
                Timestamp startDate = rs.getTimestamp("user_created_on");

                userList.add(new User(username, email, rank, startDate));
                i++;
                System.out.println(i);
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
        return userList;
    }

    public void update(User user) {

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

            sql = "UPDATE user " +
                    "SET user_password = '" + user.getPassword() + "'," +
                    "user_email = '" + user.getEmail() + "'," +
                    "user_rank = '" + user.getRank() + "'" +
                    "WHERE username = '" + user.getUsername() + "'";
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

    public void insert(User user) {
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

            sql = "INSERT INTO user (username, user_password, user_email, user_rank)" +
                    "VALUES ('"+ user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail() + "', " +  user.getRank()+ ")";
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

    public void delete(User user) {
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

            sql = "DELETE FROM cbcrm.user WHERE username = '" + user.getUsername() + "'";
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


}
