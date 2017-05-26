package entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.input.DataFormat;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class User {

    private String username;
    private String password;
    private String email;
    private Timestamp startDate;
    private int rank;

    public User() {
    }

    // Constructoren som vi bruger til at tjekke login med
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Constructoren som databasen bruger, når den returnerer en bruger. Der er ingen grund til at have password med
    // Men de andre fields kan bruges, ex. til at skrive "Hej Joakim" på loginskærmen, hvis det er Joakim som logger ind
    public User(String username, String email, int rank) {
        this.username = username;
        this.email = email;
        this.rank = rank;
    }

    /*
        Constructor vi bruger til at load brugere ind i vores tableview.
     */

    public User(String username, String email, int rank, Timestamp startDate) {
        this.username = username;
        this.email = email;
        this.startDate = startDate;
        this.rank = rank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


}
