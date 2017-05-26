package backend;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by Daniel on 26-05-2017.
 */
public class ScheduleLogic {



    public void scheduleStart(int day, DateFormat dateFormat, Calendar cal, double mondayDB,
                              double tuesdayDB, double wednesdayDB, double thursdayDB, double fridayDB, Label datoMandag, Label datoTirsdag,
                              Label datoOnsdag, Label datoTorsdag, Label datoFredag, TextField timerMandag, TextField timerTirsdag, TextField timerOnsdag,
                              TextField timerTorsdag, TextField timerFredag
                              ){
        switch (day){
            case 2:
                datoMandag.setText(dateFormat.format(cal.getTime()));

                mondayDB = 0.0;
                tuesdayDB = 0.0;
                wednesdayDB = 0.0;
                thursdayDB = 0.0;
                fridayDB = 0.0;

                timerMandag.setText(String.valueOf(mondayDB));
                timerTirsdag.setText(String.valueOf(tuesdayDB));
                timerOnsdag.setText(String.valueOf(wednesdayDB));
                timerTorsdag.setText(String.valueOf(thursdayDB));
                timerFredag.setText(String.valueOf(fridayDB));


                break;
            case 3:
                datoTirsdag.setText(dateFormat.format(cal.getTime()));

                tuesdayDB = 0.0;
                wednesdayDB = 0.0;
                thursdayDB = 0.0;
                fridayDB = 0.0;
                timerMandag.setText(String.valueOf(mondayDB));
                timerTirsdag.setText(String.valueOf(tuesdayDB));
                timerOnsdag.setText(String.valueOf(wednesdayDB));
                timerTorsdag.setText(String.valueOf(thursdayDB));
                timerFredag.setText(String.valueOf(fridayDB));


                break;
            case 4:
                datoOnsdag.setText(dateFormat.format(cal.getTime()));

                wednesdayDB = 0.0;
                thursdayDB = 0.0;
                fridayDB = 0.0;
                timerMandag.setText(String.valueOf(mondayDB));
                timerTirsdag.setText(String.valueOf(tuesdayDB));
                timerOnsdag.setText(String.valueOf(wednesdayDB));
                timerTorsdag.setText(String.valueOf(thursdayDB));
                timerFredag.setText(String.valueOf(fridayDB));


                break;
            case 5:
                datoTorsdag.setText(dateFormat.format(cal.getTime()));
                thursdayDB = 0.0;
                fridayDB = 0.0;
                timerMandag.setText(String.valueOf(mondayDB));
                timerTirsdag.setText(String.valueOf(tuesdayDB));
                timerOnsdag.setText(String.valueOf(wednesdayDB));
                timerTorsdag.setText(String.valueOf(thursdayDB));
                timerFredag.setText(String.valueOf(fridayDB));

                break;
            case 6:
                fridayDB = 0.0;
                datoFredag.setText(dateFormat.format(cal.getTime()));
                timerMandag.setText(String.valueOf(mondayDB));
                timerTirsdag.setText(String.valueOf(tuesdayDB));
                timerOnsdag.setText(String.valueOf(wednesdayDB));
                timerTorsdag.setText(String.valueOf(thursdayDB));
                timerFredag.setText(String.valueOf(fridayDB));
                break;
        }
    }



    public void scheduleStop(int day, DateFormat dateFormat, Calendar cal, double mondayDB,
                             double tuesdayDB, double wednesdayDB, double thursdayDB, double fridayDB, double totalHoursDB,
                             Label datoMandag2, Label datoTirsdag2, Label datoOnsdag2, Label datoTorsdag2, Label datoFredag2,
                             long diffMinutesEnd, long diffMinutesStart, TextField totalTimer,
                             TextField timerMandag, TextField timerTirsdag, TextField timerOnsdag, TextField timerTorsdag,
                             TextField timerFredag) {

        switch (day) {
            case 2:
                mondayDB = 0.0;
                tuesdayDB = 0.0;
                wednesdayDB = 0.0;
                thursdayDB = 0.0;
                fridayDB = 0.0;

                diffMinutesEnd = backend.Datepicker.endDateStamp();
                datoMandag2.setText(dateFormat.format(cal.getTime()));
                mondayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                String timer2 = String.valueOf(mondayDB);
                timerMandag.setText(timer2);
                break;
            case 3:

                tuesdayDB = 0.0;
                wednesdayDB = 0.0;
                thursdayDB = 0.0;
                fridayDB = 0.0;

                datoTirsdag2.setText(dateFormat.format(cal.getTime()));
                tuesdayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                String timer4 = String.valueOf(tuesdayDB);
                timerTirsdag.setText(timer4);
                break;
            case 4:

                wednesdayDB = 0.0;
                thursdayDB = 0.0;
                fridayDB = 0.0;

                diffMinutesEnd = backend.Datepicker.endDateStamp();
                datoOnsdag2.setText(dateFormat.format(cal.getTime()));
                wednesdayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                String timer6 = String.valueOf(wednesdayDB);
                timerOnsdag.setText(timer6);
                break;
            case 5:
                thursdayDB = 0.0;
                fridayDB = 0.0;

                diffMinutesEnd = backend.Datepicker.endDateStamp();
                datoTorsdag2.setText(dateFormat.format(cal.getTime()));
                thursdayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                String timer8 = String.valueOf(thursdayDB);
                timerTorsdag.setText(timer8);
                break;
            case 6:

                fridayDB = 0.0;
                diffMinutesEnd = backend.Datepicker.endDateStamp();
                datoFredag2.setText(dateFormat.format(cal.getTime()));
                fridayDB = backend.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                String timer10 = String.valueOf(fridayDB);
                timerFredag.setText(timer10);
        }

        totalHoursDB = Datepicker.ugentligeTimer(mondayDB, tuesdayDB, wednesdayDB, thursdayDB, fridayDB);
        String totalTimerString = String.valueOf(totalHoursDB);
        totalTimer.setText(totalTimerString);

    }

}
