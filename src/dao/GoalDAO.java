package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GoalDAO implements BaseDAO{

    public static void getTotalRevenue(){
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

        sql = "DELETE FROM companies WHERE company_cvr = ";
        stmt.executeUpdate(sql);

        //STEP 5: Clean-up environment
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
