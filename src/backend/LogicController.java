package backend;

import dao.*;
import entities.Comment;
import entities.Company;
import entities.ScheduleDays;
import entities.User;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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

    public static void addComment(Comment comment) {
        CommentDAO commentDAO = new CommentDAO();
        commentDAO.insert(comment);

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

    public static ArrayList<ScheduleDays> getUsernameHours() {
        ComboboxDAO comboboxDAO = new ComboboxDAO();
        ArrayList<ScheduleDays> list = new ArrayList<>(comboboxDAO.get());


        return list;

    }

    public static ArrayList<ScheduleDays> getHoursUsername() {
        TotalHoursUsernameDAO totalHoursUsernameDAO = new TotalHoursUsernameDAO();
        ArrayList<ScheduleDays> list = new ArrayList<>(totalHoursUsernameDAO.get());

        return list;

    }

    public static ArrayList<Comment> getComment() {
        CommentDAO commentDAO = new CommentDAO();
        ArrayList<Comment> list = new ArrayList<>(commentDAO.get());

        return list;

    }



    public static void comboboxLogic(ArrayList comboBoxArray2, ArrayList comboBoxArray1,
                                     ComboBox person1, Label personLabel1){

        backend.ComboBoxLogic comboboxObject = new ComboBoxLogic();
        comboboxObject.comboBoxAction(comboBoxArray2, comboBoxArray1,
                person1, personLabel1);
    }


    public static void scheduleLogicStart(int day, DateFormat dateFormat, Calendar cal, double mondayDB,
                                          double tuesdayDB, double wednesdayDB, double thursdayDB, double fridayDB, Label datoMandag, Label datoTirsdag,
                                          Label datoOnsdag, Label datoTorsdag, Label datoFredag, Label timerMandag, Label timerTirsdag, Label timerOnsdag,
                                          Label timerTorsdag, Label timerFredag){

        backend.ScheduleLogic scheduleLogicObjectStart = new ScheduleLogic();
        scheduleLogicObjectStart.scheduleStart(day, dateFormat, cal, mondayDB,
        tuesdayDB, wednesdayDB, thursdayDB, fridayDB, datoMandag, datoTirsdag,
                datoOnsdag, datoTorsdag, datoFredag, timerMandag, timerTirsdag, timerOnsdag,
                timerTorsdag, timerFredag);
    }

    public static void scheduleLogicEnd(int day, DateFormat dateFormat, Calendar cal, double mondayDB,
                                        double tuesdayDB, double wednesdayDB, double thursdayDB, double fridayDB, double totalHoursDB,
                                        Label datoMandag2, Label datoTirsdag2, Label datoOnsdag2, Label datoTorsdag2, Label datoFredag2,
                                        long diffMinutesEnd, long diffMinutesStart, Label totalTimer,
                                        Label timerMandag, Label timerTirsdag, Label timerOnsdag, Label timerTorsdag, Label timerFredag){

        backend.ScheduleLogic scheduleLogicObjectEnd = new ScheduleLogic();
        scheduleLogicObjectEnd.scheduleStop(day, dateFormat, cal, mondayDB,
        tuesdayDB, wednesdayDB, thursdayDB, fridayDB, totalHoursDB,
        datoMandag2, datoTirsdag2, datoOnsdag2, datoTorsdag2, datoFredag2,
        diffMinutesEnd, diffMinutesStart, totalTimer,
                timerMandag, timerTirsdag, timerOnsdag, timerTorsdag, timerFredag);
    }


}

