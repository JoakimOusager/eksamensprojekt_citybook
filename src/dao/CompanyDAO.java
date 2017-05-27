package dao;

import application.Company;
import application.ContactPerson;
import application.User;
import gui.HomeGUI;

import java.sql.*;
import java.util.ArrayList;


////////////////////////////////////////////// Joakim og Jarl /////////////////////////////////////////////////////

public class CompanyDAO implements BaseDAO<Company> {

    public ArrayList<Company> get() {
        ArrayList<Company> list = new ArrayList<Company>();

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

            sql = "SELECT * FROM cbcrm.companies " +
                    "INNER JOIN user ON companies.company_created_by = user.user_id " +
                    "INNER JOIN contact_person ON companies.company_contact_person = contact_person.contact_id;";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {

                // Company detaljer
                String name = rs.getString("company_name");
                String address = rs.getString("company_address");
                String zipcode = rs.getString("company_zipcode");
                String cvr = rs.getString("company_cvr");
                String email = rs.getString("company_email");
                String phone = rs.getString("company_phone");
                String comments = rs.getString("company_comments");
                double revenue = rs.getDouble("company_revenue");
                Timestamp createdOn = rs.getTimestamp("company_created_on");


                // Den bruger som har oprettet virksomheden, bliver oprettet som et bruger objekt
                String username = rs.getString("username");
                String userEmail = rs.getString("user_email");
                int userRank = rs.getInt("user_rank");
                User createdBy = new User(username, userEmail, userRank);

                // Kontaktperson
                String contactNavn = rs.getString("contact_name");
                String contactEmail = rs.getString("contact_email");
                String contactPhone = rs.getString("contact_phone");
                ContactPerson contactPerson = new ContactPerson(contactNavn, contactEmail, contactPhone);

                list.add(new Company(cvr, name, address, zipcode, email, phone,
                        comments, revenue, createdOn, contactPerson, createdBy));

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

    public void delete(Company company) {
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

            sql = "DELETE FROM companies WHERE company_cvr = '" + company.getCvrNumber() + "'";
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

    public void insert(Company company) {
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
            ContactPersonDAO contactPersonDAO = new ContactPersonDAO();
            int contactPersonID = contactPersonDAO.getContactIDForCompany(company);

            String sql;

            sql = "INSERT INTO companies (company_name, company_address, company_zipcode, company_cvr," +
                    " company_email, company_phone, company_revenue, company_comments, company_created_by, company_contact_person" +
                    ")" +
                    "VALUES ( '" + company.getName() + "', '" + company.getAddress() + "' ,'" + company.getZipCode() + "', '" +  company.getCvrNumber() + "', '" + company.getEmail()+ "', " +
                    " '" + company.getPhoneNumber() + "', '" + company.getRevenue() + "','" + company.getComments() + "','" + userId + "', '" + contactPersonID +  "')";
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

    public void update(Company company) {
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

            sql = "UPDATE companies " +
                    "SET company_name = '" + company.getName() + "',  company_address = '" +company.getAddress() +"'," +
                    "company_zipcode =  '" + company.getZipCode() + "'," +
                    "company_email =  '" + company.getEmail() + "'," +
                    "company_phone =  '" + company.getPhoneNumber() + "'," +
                    "company_revenue = '" + company.getRevenue() + "'," +
                    "company_comments = '" + company.getComments() + "' " +
                    "WHERE company_cvr = '" + company.getCvrNumber() + "'";
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

    public double getRevenue() {
        double revenue = 0;

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
                revenue = rs.getDouble("total_revenue");
                System.out.println(revenue);
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
        return revenue;
    }

}
