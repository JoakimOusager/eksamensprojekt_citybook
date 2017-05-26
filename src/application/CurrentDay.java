package application;

import java.util.Calendar;

/**
 * Created by Daniel on 23-05-2017.
 */
public class CurrentDay {

    public static void currentDay() {
        Calendar calendar   = Calendar.getInstance();
        int day             = calendar.get(Calendar.DAY_OF_WEEK);
    }

}
