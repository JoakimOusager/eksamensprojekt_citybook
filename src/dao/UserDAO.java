package dao;

import application.User;
import gui.GUIController;

import java.sql.*;
import java.util.ArrayList;

/////////////////////////////////////////////// Jarl og Joakim ///////////////////////////////////////////

 /*
        Klassen som håndterer alt database interaktion fra User table i databasen til programmet.
 */
public class UserDAO implements BaseDAO<User> {
    // Boolean til at vise errorbesked, hvis sql ikke er gyldigt.
    boolean error = false;

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
            Class.forName(DAO.JDBC_DRIVER);

            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM user WHERE username = \"" +
                    user.getUsername() + "\" AND user_password = \"" + user.getPassword()
                    +  "\"";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("user_email");
                int rank = rs.getInt("user_rank");
                foundUser = new User(username, email, rank);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
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
        try {
            // Registrér JDBC driver
            Class.forName(DAO.JDBC_DRIVER);

            // Åben forbindelse til databasen.
            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            // Udfører en query.
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM cbcrm.user";
            ResultSet rs = stmt.executeQuery(sql);

            // Henter dataen ud i vores variabler.
            while (rs.next()) {

                // Company detaljer
                String username = rs.getString("username");
                String email = rs.getString("user_email");
                int rank = rs.getInt("user_rank");
                Timestamp startDate = rs.getTimestamp("user_created_on");

                userList.add(new User(username, email, rank, startDate));
            }

            // Lukker forbindelserne.
            rs.close();
            stmt.close();
            conn.close();

         // Nedenstående er hvordan vi håndterer vores exceptions.
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
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

        }
        return userList;
    }

    public void update(User user) {

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(DAO.JDBC_DRIVER);

            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            stmt = conn.createStatement();
            String sql;

            sql = "UPDATE user " +
                    "SET user_password = '" + user.getPassword() + "'," +
                    "user_email = '" + user.getEmail() + "'," +
                    "user_rank = '" + user.getRank() + "'" +
                    "WHERE username = '" + user.getUsername() + "'";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            error = true;
            se.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        GUIController.showErrorMessage(error);
    }

    public void insert(User user) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(DAO.JDBC_DRIVER);

            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            stmt = conn.createStatement();
            String sql;

            sql = "INSERT INTO user (username, user_password, user_email, user_rank)" +
                    "VALUES ('"+ user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail() + "', " +  user.getRank()+ ")";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
            error = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        GUIController.showErrorMessage(error);
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


}
