package dao;


import application.Company;

import java.sql.*;
import java.util.ArrayList;


////////////////////////////////////////////////////Daniel og Jarl////////////////////////////////////////////////


public class GoalDAO implements BaseDAO<Company> {


    public ArrayList<Company> get() {
        ArrayList<Company> list = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(DAO.JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT SUM(company_revenue) AS total_revenue FROM cbcrm.companies");

            //STEP 5: Extract data from result set
            if (rs.next()) {

                // Company detaljer
                double revenue = rs.getDouble("total_revenue");
                System.out.println(revenue);
                list.add(new Company(revenue));
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

    public void update(Company company) {

    }

    public void insert(Company company) {

    }

    public void delete(Company company) {

    }
}
