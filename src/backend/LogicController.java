package backend;

import dao.CheckBoxDAO;
import dao.CompanyDAO;
import dao.ScheduleDAO;
import dao.UserDAO;
import entities.Company;
import entities.ScheduleDays;
import entities.User;

import java.util.ArrayList;

public class LogicController {
    public static User login (User loginUser) {
        User foundUser = UserDAO.login(loginUser);
        return foundUser;

    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> userList = new ArrayList<>(UserDAO.getUsers());
        return userList;
    }

    public static void addUser(User user) {
        UserDAO.addUser(user);
    }

    public static void deleteUser(User user) {
        UserDAO.deleteUser(user);
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
        ArrayList<Company> list = new ArrayList<>(CompanyDAO.getCompanies());
        return list;
    }

    public static void updateCompanies() {


    }

    public static void addCompany(Company company) {
        CompanyDAO.insertCompany(company);

    }

    public static void deleteCompany(Company company) {
        CompanyDAO.deleteCompany(company);

    }

    public static ArrayList<ScheduleDays> getSchedule(User user) {
        ArrayList<ScheduleDays> schedule = new ArrayList<>(ScheduleDAO.getSchedule(user));

        return schedule;

    }


}

