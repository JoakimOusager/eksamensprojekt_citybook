package dao;

import entities.Company;
import entities.ContactPerson;
import entities.User;
import gui.HomeGUI;

import java.sql.*;
import java.util.List;

public class ContactPersonDAO implements BaseDAO<ContactPerson> {
    @Override
    public List<ContactPerson> get() {
      return null;
    }

    public int getContactIDForCompany(Company company) {
      /* Denne metode bruges til at finde id, til den kontaktperson som bliver added sammen med et firma. */
        Connection conn = null;
        Statement stmt = null;
        int contactID = 0;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(DAO.JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();
            String sql;



            sql = "SELECT contact_id FROM contact_person WHERE contact_name = '" + company.getContactPerson().getName() + "'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                contactID = rs.getInt("contact_id");

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
        return contactID;
    }


    @Override
    public void update(ContactPerson contactPerson) {

    }

    @Override
    public void insert(ContactPerson contactPerson) {
        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName(DAO.JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DAO.DB_URL, DAO.USER, DAO.PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            // Statement som finder ud af hvilket id brugeren, som har logget ind har
            String sqlUpdateCreatedBy;

            sqlUpdateCreatedBy = "SELECT user_id FROM user WHERE username = '" + HomeGUI.loggedInUser.getUsername() + "'";
            ResultSet rs = stmt.executeQuery(sqlUpdateCreatedBy);

            int userId = 0;
            while (rs.next()) {
                userId = rs.getInt("user_id");
            }

            String sql;

            sql = "INSERT INTO contact_person (contact_name, contact_email, contact_phone) " +
                    "VALUES ('" + contactPerson.getName() + "', '" + contactPerson.getEmail() +  "', '" + contactPerson.getPhone() + "')";
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



    @Override
    public void delete(ContactPerson element) {

    }
}
