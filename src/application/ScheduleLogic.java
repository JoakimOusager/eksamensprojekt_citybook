package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.util.Calendar;

//////////////////////////////////////////////////Lavet af Daniel/////////////////////////////////////////

public class ScheduleLogic {



    //Metode lavet til at få logic ud af GUI
    //Metode som skal finde ud af hvilken dag på ugen det er og sætte labels i forhold til timer og totaltimer
    public void scheduleStart(int day, DateFormat dateFormat, Calendar cal, double mondayDB,
                              double tuesdayDB, double wednesdayDB, double thursdayDB, double fridayDB, Label datoMandag, Label datoTirsdag,
                              Label datoOnsdag, Label datoTorsdag, Label datoFredag, TextField timerMandag, TextField timerTirsdag, TextField timerOnsdag,
                              TextField timerTorsdag, TextField timerFredag){

        //Switch lavet til at bestemme hvilken dag det er på ugen, her er gjort brug af javas inbyggede kalenderfunktion
        //Den kalender starter om søndagen, så case 1 er søndag og 2 er mandag osv.
        switch (day){
            case 1:
                datoFredag.setText(dateFormat.format(cal.getTime()));
                timerMandag.setText(String.valueOf(mondayDB));
                timerTirsdag.setText(String.valueOf(tuesdayDB));
                timerOnsdag.setText(String.valueOf(wednesdayDB));
                timerTorsdag.setText(String.valueOf(thursdayDB));
                timerFredag.setText(String.valueOf(fridayDB));
                break;
            case 2:
                //Label datoMandag bliver set til den lokaletid i det sekund der bliver trykket på start
                datoMandag.setText(dateFormat.format(cal.getTime()));

                //Disse variabler bliver brugt til at sætte alle dagene til 0 igen da det bliver gemt i databasen
                //Det vil sige at der allerede ligger timer der inde der lige skal fjernes
                mondayDB = 0.0;
                tuesdayDB = 0.0;
                wednesdayDB = 0.0;
                thursdayDB = 0.0;
                fridayDB = 0.0;

                //Her bliver labelsne sat til hvad mondayDB, tuedayDB osv er sat til
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

            case 7:
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
                //Her bliver de resettet igen
                mondayDB = 0.0;
                tuesdayDB = 0.0;
                wednesdayDB = 0.0;
                thursdayDB = 0.0;
                fridayDB = 0.0;

                //Her få vi fat i slut tidspunktet i timer
                diffMinutesEnd = application.Datepicker.endDateStamp();
                //Her bliver labelen datoMandag2 sat til sluttiden
                datoMandag2.setText(dateFormat.format(cal.getTime()));
                //Her kalder vi en metode som udregner hvor lang tid vi har arbejdet i timer
                mondayDB = application.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                //Her bliver timerMandag så sat til hvor mange timer vi har arbejdet
                String timer2 = String.valueOf(mondayDB);
                timerMandag.setText(timer2);
                break;
            case 3:

                tuesdayDB = 0.0;
                wednesdayDB = 0.0;
                thursdayDB = 0.0;
                fridayDB = 0.0;

                datoTirsdag2.setText(dateFormat.format(cal.getTime()));
                tuesdayDB = application.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                String timer4 = String.valueOf(tuesdayDB);
                timerTirsdag.setText(timer4);
                break;
            case 4:

                wednesdayDB = 0.0;
                thursdayDB = 0.0;
                fridayDB = 0.0;

                diffMinutesEnd = application.Datepicker.endDateStamp();
                datoOnsdag2.setText(dateFormat.format(cal.getTime()));
                wednesdayDB = application.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                String timer6 = String.valueOf(wednesdayDB);
                timerOnsdag.setText(timer6);
                break;
            case 5:
                thursdayDB = 0.0;
                fridayDB = 0.0;

                diffMinutesEnd = application.Datepicker.endDateStamp();
                datoTorsdag2.setText(dateFormat.format(cal.getTime()));
                thursdayDB = application.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                String timer8 = String.valueOf(thursdayDB);
                timerTorsdag.setText(timer8);
                break;
            case 6:

                fridayDB = 0.0;
                diffMinutesEnd = application.Datepicker.endDateStamp();
                datoFredag2.setText(dateFormat.format(cal.getTime()));
                fridayDB = application.Datepicker.startTimeMeth(diffMinutesStart, diffMinutesEnd);
                String timer10 = String.valueOf(fridayDB);
                timerFredag.setText(timer10);

        }

        //Her udregner vi de totale antal timer for hele ugen
        totalHoursDB = Datepicker.ugentligeTimer(mondayDB, tuesdayDB, wednesdayDB, thursdayDB, fridayDB);
        //Her sætter vi totalTimer labelet til de totaltimer
        String totalTimerString = String.valueOf(totalHoursDB);
        totalTimer.setText(totalTimerString);

    }

    //Metode til udregning af de totaltimer
    public double totalHoursMeth(double mondayDB, double tuesdayDB, double wednesdayDB, double thursdayDB, double fridayDB, double totalHoursDB){
        totalHoursDB = Datepicker.ugentligeTimer(mondayDB, tuesdayDB, wednesdayDB, thursdayDB, fridayDB);
        return totalHoursDB;
    }

}
