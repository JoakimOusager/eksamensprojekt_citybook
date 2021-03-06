package dataaccess;

import application.ScheduleDays;
import application.User;
import com.mysql.cj.api.x.io.ResultStreamer;
import gui.GUIController;
import gui.HomeGUI;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//////////////////////////////////////////////// Daniel ///////////////////////////////////////////

public class ScheduleDAO implements GetDAO<ScheduleDays>{
    boolean error = false;

    public int getUserID() {
        int userID = 0;
        List<ScheduleDays> list = new ArrayList<ScheduleDays>();

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(DAO.JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "SELECT user_id FROM user WHERE username = '" + HomeGUI.loggedInUser.getUsername() + "' ";
            ResultSet rs = stmt.executeQuery(sql);


            if (rs.next()) {
                userID = rs.getInt("user_id");
            }

            //STEP 5: Extract data from result set

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
        return userID;
    }



    public List<ScheduleDays> get() {
        int userID = 0;
        List<ScheduleDays> list = new ArrayList<ScheduleDays>();

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(DAO.JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();


              String sql = "SELECT * FROM cbcrm.schedule WHERE user_id = " + getUserID() + " ";
             ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {

                // Company detaljer
                double monday = rs.getDouble("monday");
                double tuesday = rs.getDouble("tuesday");
                double wednesday = rs.getDouble("wednesday");
                double thursday = rs.getDouble("thursday");
                double friday = rs.getDouble("friday");
                double totalHours = rs.getDouble("total_hours");

                list.add(new ScheduleDays(monday, tuesday, wednesday, thursday, friday,
                        totalHours));
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

    /////////////////////////////////////////////// Daniel og Anders ///////////////////////////////////////
    public void update(ScheduleDays scheduleDays, User user) {
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

            sql = "UPDATE schedule " +
                    " SET monday = '" + scheduleDays.getMonday() + "',"+
                    " tuesday = '" +scheduleDays.getTuesday() +"'," +
                    " wednesday = '" + scheduleDays.getWednesday() + "'," +
                    " thursday =  '" + scheduleDays.getThursday() + "'," +
                    " friday =  '" + scheduleDays.getFriday() + "'," +
                    " total_hours = '" + scheduleDays.getTotalHours() + "'" +
                    " WHERE user_id = '" + getUserID() + "'";
            stmt.executeUpdate(sql);

            //STEP 5: Extract data from result set
            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            error = true;
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
        GUIController.showErrorMessage(error);
    }

    public void insert(ScheduleDays scheduleDays) {
        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(DAO.JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();

           String sql = "INSERT INTO schedule (user_id, monday, tuesday, wednesday, thursday, friday, total_hours)" +
                    "VALUES ( '" + getUserID() + "', '" +scheduleDays.getMonday()+ "', '" +scheduleDays.getTuesday()
                    + "', '" +scheduleDays.getWednesday()+ "', '" +scheduleDays.getThursday()+ "', '" +scheduleDays.getFriday()
                    + "', '" +scheduleDays.getTotalHours() +
                    "')";

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
