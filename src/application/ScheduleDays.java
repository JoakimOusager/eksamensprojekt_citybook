package application;


///////////////////////////////////////////// Daniel ////////////////////////////////////////

public class ScheduleDays {


    private User user;
    private double monday;
    private double tuesday;
    private double wednesday;
    private double thursday;
    private double friday;

    private double totalHours;

    public ScheduleDays(User user, double monday, double tuesday,
                        double wednesday, double thursday, double friday, double totalHours) {
        this.user = user;
        this.monday         = monday;
        this.tuesday        = tuesday;
        this.wednesday      = wednesday;
        this.thursday       = thursday;
        this.friday         = friday;
        this.totalHours     = totalHours;
    }

    public ScheduleDays(double totalHours) {

        this.totalHours     = totalHours;
    }

    public ScheduleDays( double monday, double tuesday,
                        double wednesday, double thursday, double friday, double totalHours) {
        this.monday         = monday;
        this.tuesday        = tuesday;
        this.wednesday      = wednesday;
        this.thursday       = thursday;
        this.friday         = friday;
        this.totalHours     = totalHours;
    }

    public ScheduleDays(User user, double totalHours) {
        this.user = user;
        this.totalHours     = totalHours;
    }

    public ScheduleDays(User user){
        this.user = user;
    }

    public ScheduleDays() {

    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
