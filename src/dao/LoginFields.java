package dao;

/**
 * Created by Daniel on 15-05-2017.
 */
public class LoginFields {

    private String username;
    private String password;
    private boolean admin;


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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


    public LoginFields() {
    }

}
