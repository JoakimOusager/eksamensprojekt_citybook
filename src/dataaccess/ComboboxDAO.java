package dataaccess;

import application.ScheduleDays;
import application.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//&/

public class ComboboxDAO implements GetDAO<ScheduleDays> {
    public List<ScheduleDays> get() {
        ArrayList<ScheduleDays> list = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(DAO.JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT username, total_hours FROM cbcrm.schedule");

            //STEP 5: Extract data from result set
            while (rs.next()) {

                // Username og hours detaljer
                String username = rs.getString("username");
                User user = new User(username);
                ScheduleDays scheduleDays = new ScheduleDays(user);
               // double hours = rs.getDouble("total_hours");
                list.add(new ScheduleDays(user));
                //list.add(new ScheduleDays(hours));
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

