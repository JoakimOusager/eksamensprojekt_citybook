package backend;

import dao.*;
import entities.Company;
import entities.ScheduleDays;
import entities.User;

import java.util.ArrayList;

public class LogicController {
    public static User login (User loginUser) {
        UserDAO userDAO = new UserDAO();
        User foundUser = userDAO.login(loginUser);
        return foundUser;

    }

    public static ArrayList<User> getUsers() {
        UserDAO userDAO = new UserDAO();
        ArrayList<User> userList = new ArrayList<>(userDAO.get());
        return userList;
    }

    public static void addUser(User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.insert(user);
    }

    public static void deleteUser(User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.delete(user);
    }

    public static String getSavedUsername() {
        String username = "";
        try {
            username = CheckBoxDAO.getSavedUsername();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return username;
    }

    public static void setSavedUsername(String username, boolean saveMe) {
        try {
            CheckBoxDAO.setSavedUsername(username, saveMe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Company> getCompanies() {
        CompanyDAO companyDAO = new CompanyDAO();
        ArrayList<Company> list = new ArrayList<>(companyDAO.get());
        return list;
    }

    public static void updateCompanies() {
        CompanyDAO userDAO = new CompanyDAO();


    }

    public static void addCompany(Company company) {
        CompanyDAO companyDAO = new CompanyDAO();
        companyDAO.insert(company);

    }

    public static void deleteCompany(Company company) {
        CompanyDAO companyDAO = new CompanyDAO();
        companyDAO.delete(company);

    }

    public static ArrayList<ScheduleDays> getSchedule(User user) {
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        ArrayList<ScheduleDays> schedule = new ArrayList<>(scheduleDAO.get(user));

        return schedule;

    }

    public static ArrayList<Company> getTotalRevenue() {
        GoalDAO goalDAO = new GoalDAO();
        ArrayList<Company> list = new ArrayList<>(goalDAO.get());

        return list;

    }

    public static ArrayList<ScheduleDays> getMaxHours() {
        MaxHoursDAO maxHoursDAO = new MaxHoursDAO();
        ArrayList<ScheduleDays> list = new ArrayList<>(maxHoursDAO.get());

        return list;

    }

    public static ArrayList<ScheduleDays> getTopHours() {
        TopHoursDAO topHoursDAO = new TopHoursDAO();
        ArrayList<ScheduleDays> list = new ArrayList<>(topHoursDAO.get());

        return list;

    }


}

