/*package backend;

import dao.LoginFields;
import dao.UserDAO;
import entities.User;
import gui.HomeGUI;
import gui.LoginGUI;
import javafx.application.Application;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class BackendController extends Application {

    public static boolean isValidUserCreds(String sUsername, String sPassword, int admin){
        UserDAO DB_user_Object = new UserDAO();

        return DB_user_Object.isValidUserCreds(sUsername, sPassword, admin);
    }


    @Override
    public void start(Stage primaryStage) {
        loginCreds(primaryStage);
    }


        public static void loginCreds(Stage primaryStage){


            int admin1 = 0;
            int admin2 = 1;


            if(isValidUserCreds(username,password,admin2)) {
                HomeGUI.backgroundTemplate(primaryStage);
            }else if(isValidUserCreds(username,password,admin1)){
                HomeGUI.backgroundTemplate(primaryStage);
            }else{
                LoginGUI.wrongCreds(TextField usernamefield, PasswordField passwordfield);

            }

        }

    }*/


