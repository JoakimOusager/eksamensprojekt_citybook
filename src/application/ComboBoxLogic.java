package application;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;

/**
 * Created by Daniel on 26-05-2017.
 */
public class ComboBoxLogic {

    ArrayList<String> comboBoxArray2 = new ArrayList<>();
    ArrayList<Double> comboBoxArray1 = new ArrayList<>();
    ComboBox person1                 = new ComboBox();
    Label personLabel1               = new Label();

        public void comboBoxAction( ArrayList comboBoxArray2, ArrayList comboBoxArray1,
                                    ComboBox person1, Label personLabel1) {


            for (int i = 0; i < comboBoxArray2.size(); i++) {
                if (person1.getValue().equals(comboBoxArray2.get(i))) {
                    personLabel1.setText(String.valueOf(comboBoxArray1.get(i)));
                }
            }
        }
}
