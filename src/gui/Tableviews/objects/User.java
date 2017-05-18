package gui.Tableviews.objects;

public class User {

    private String username;
    private String password;
    private String email;
    private String startDate;
    private int userRank;

    public User(String username, String password, String email, String startDate, int userRank) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.startDate = startDate;
        this.userRank = userRank;
    }

    public User() {
        this.username = "";
        this.password = "";
        this.email = "";
        this.startDate = "";
        this.userRank = 0;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getUserRank() {
        return userRank;
    }

    public void setUserRank(int userRank) {
        this.userRank = userRank;
    }


}
