package sample;
import DAO.DB_login;
import gui.GUI;
import javafx.application.Application;
import javafx.stage.Stage;

import static gui.GUI.login;


public class Controller extends Application {

    public static boolean isValidUserCreds(String sUsername, String sPassword, int admin){
        DB_login DB_user_Object = new DB_login();

        return DB_user_Object.isValidUserCreds(sUsername, sPassword, admin);
    }


    @Override
    public void start(Stage primaryStage) {
        login(primaryStage);
    }


        public static void loginCreds(Stage primaryStage){

            String username = GUI.username;
            String password = GUI.password;


            int admin1 = 0;
            int admin2 = 1;


            if(isValidUserCreds(username,password,admin2)) {
                GUI.backgroundTemplate(primaryStage);
            }else if(isValidUserCreds(username,password,admin1)){
                GUI.backgroundTemplate(primaryStage);
            }else{
                GUI.wrongCreds();

            }

        }

    }


