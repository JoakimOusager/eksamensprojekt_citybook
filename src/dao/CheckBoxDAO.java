package dao;

import gui.LoginGUI;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Daniel on 22-05-2017.
 */
public class CheckBoxDAO {
    static String fileName = "src/dao/usernameSave";

    public static String getSavedUsername()throws Exception{

        String username = "";
        Scanner input = new Scanner(new File(fileName));
        while(input.hasNext()) {
            username = input.next();
        }

    return username;
    }

    public static void setSavedUsername()throws Exception{
        String username;
        username = LoginGUI.usernamefield.getText();
        PrintWriter output = new PrintWriter(fileName);

        if(!LoginGUI.saveMe) {
            output.println("");
            output.close();

        }else{
            output.println(username);
            System.out.println(username);
            output.close();
        }
    }
}
