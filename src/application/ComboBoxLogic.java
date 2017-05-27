package application;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;


//////////////////////////////////// Daniel /////////////////////////////

//Metode til at få fat i de forskellige fields der skal bruges til comboboxen
public class ComboBoxLogic {

    //Arraylist til navnene
    ArrayList<String> comboboxNavne = new ArrayList<>();
    //Arraylist til timer
    ArrayList<Double> comboboxTimer = new ArrayList<>();

    //Her bliver comboxen oprettet til person 1
    ComboBox person1                 = new ComboBox();
    Label personLabel1               = new Label();

        public void comboBoxAction( ArrayList comboboxNavne, ArrayList comboboxTimer,
                                    ComboBox person1, Label personLabel1) {


            for (int i = 0; i < comboboxNavne.size(); i++) {
                if (person1.getValue().equals(comboboxNavne.get(i))) {
                    personLabel1.setText(String.valueOf(comboboxTimer.get(i)));
                }
            }
        }
}
