package dao;

import entities.ScheduleDays;
import entities.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Daniel on 25-05-2017.
 */
public class ScheduleDAO {

    public static ArrayList<ScheduleDays> getSchedule(User user) {
        ArrayList<ScheduleDays> list = new ArrayList<ScheduleDays>();

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

                sql = "SELECT * FROM cbcrm.schedule WHERE username = '" + user.getUsername() + "' ";
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
                i++;
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
}
