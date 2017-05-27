package dao;

import application.ScheduleDays;

import java.sql.*;
import java.util.ArrayList;

public class TopHoursDAO implements BaseDAO<ScheduleDays> {

    public ArrayList<ScheduleDays> get() {
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
            String sql;

            sql = "SELECT MAX(total_hours) AS total_hours FROM cbcrm.schedule";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {

                // Company detaljer
                double totalHours = rs.getDouble("total_hours");

                list.add(new ScheduleDays(totalHours));
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

    public void update(ScheduleDays scheduleDays) {

    }

    public void insert(ScheduleDays scheduleDays) {

    }

    public void delete(ScheduleDays scheduleDays) {

    }

}
