package dao;

import entities.Company;
import entities.ContactPerson;
import entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joakim on 23/05/2017.
 */
public class CompanyDAO implements BaseDAO<Company> {

    public ArrayList<Company> get() {
        ArrayList<Company> list = new ArrayList<Company>();

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
            String sql;

            sql = "INSERT INTO companies (company_name, company_address, company_zipcode, company_cvr," +
                    " company_email, company_phone, company_revenue, company_comments, company_created_on, company_created_by," +
                    " company_contact_person)" +
                    "VALUES ( '"+ company.getName() + "', " + company.getAddress() + ",  '" + company.getZipCode() + "', '" +  company.getCvrNumber() + "', '" + company.getEmail()+ "', " +
                    " '" + company.getPhoneNumber() + "', '" + company.getRevenue() + "','" + company.getComments() + "','" + company.getCreatedOn() + "','" + company.getCreatedBy() + "', '"  +
                    "'" + company.getContactPerson() + "'')";
            System.out.println(sql);
           // stmt.executeUpdate(sql);

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

            sql = "UPDATE companies" +
                    "SET company_name = '" + company.getName() + "',  company_address = '" +company.getAddress() +"'," +
                    "company_zipcode = + '" + company.getZipCode() + "'," +
                    "company_email =  '" + company.getEmail() + "'," +
                    "company_phone =  '" + company.getPhoneNumber() + "'," +
                    "company_revenue = '" + company.getRevenue() + "'," +
                    "company_comments = '" + company.getComments() + "'" +
                    "WHERE company_cvr = '" + company.getCvrNumber() + "'";
            System.out.println(sql);
            // stmt.executeUpdate(sql);

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
