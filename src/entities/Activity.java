package entities;

import java.sql.Date;

public class Activity {
    private User user;
    private Company company;
    private Date time;
    private String comments;

    public Activity(User user, Company company, Date time, String comments) {
        this.user = user;
        this.company = company;
        this.time = time;
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
