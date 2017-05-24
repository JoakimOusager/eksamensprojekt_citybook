package backend;

import dao.CheckBoxDAO;
import dao.CompanyDAO;
import dao.UserDAO;
import entities.Company;
import entities.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LogicController {
    public static User login (User loginUser) {
        User foundUser = UserDAO.login(loginUser);
        return foundUser;

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
        ArrayList<Company> list = new ArrayList<Company>(CompanyDAO.getCompanies());
        return list;
    }

    public static void updateCompanies() {


    }







}

