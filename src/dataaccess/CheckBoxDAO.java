package dataaccess;

import gui.LoginGUI;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


//////////////////////////////////////////////////// Daniel //////////////////////////////////////////////

public class CheckBoxDAO {
    static String fileName = "src/dataaccess/usernameSave";

    //Metode til at hente en string fra en fil
    public static String getSavedUsername()throws Exception{

        String username = "";
        Scanner input = new Scanner(new File(fileName));
        while(input.hasNext()) {
            username = input.next();
        }

    return username;
    }

    //Metode til at gemme usernamet i en fil
    public static void setSavedUsername(String username, boolean saveMe)throws Exception{
        /*String username;
        username = LoginGUI.usernamefield.getText(); */
        PrintWriter output = new PrintWriter(fileName);

        if(!LoginGUI.saveMe) {
            output.println("");
            output.close();

        }else{
            output.println(username);
            output.close();
        }
    }
}
