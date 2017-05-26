package entities;

/**
 * Created by Daniel on 25-05-2017.
 */
public class ScheduleDays {


    private String username;
    private double monday;
    private double tuesday;
    private double wednesday;
    private double thursday;
    private double friday;

    private double totalHours;

    public ScheduleDays(String username, double monday, double tuesday,
                        double wednesday, double thursday, double friday, double totalHours) {
        this.username = username;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.totalHours = totalHours;
    }

    public ScheduleDays(double totalHours) {

        this.totalHours = totalHours;
    }

    public ScheduleDays( double monday, double tuesday,
                        double wednesday, double thursday, double friday, double totalHours) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.totalHours = totalHours;
    }

    public ScheduleDays(String username, double totalHours) {
        this.username = username;
        this.totalHours = totalHours;
    }

    public ScheduleDays(String username){
        this.username = username;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getMonday() {
        return monday;
    }

    public void setMonday(double monday) {
        this.monday = monday;
    }

    public double getTuesday() {
        return tuesday;
    }

    public void setTuesday(double tuesday) {
        this.tuesday = tuesday;
    }

    public double getWednesday() {
        return wednesday;
    }

    public void setWednesday(double wednesday) {
        this.wednesday = wednesday;
    }

    public double getThursday() {
        return thursday;
    }

    public void setThursday(double thursday) {
        this.thursday = thursday;
    }

    public double getFriday() {
        return friday;
    }

    public void setFriday(double friday) {
        this.friday = friday;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }
}
