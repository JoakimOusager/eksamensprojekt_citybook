package gui;

import static gui.HomeGUI.invalidSQLQuery;

public class GUIController {

	public static void showErrorMessage(boolean error) {
		invalidSQLQuery(error);
	}



}
