package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//////////////////////////////////////// Lavet af Daniel //////////////////////////////////////

public class Datepicker {

    //En måde at formatere tiden tiden på
    static DateFormat dateFormat        = new SimpleDateFormat("HH:mm");


    //Tiden der bliver sat når man trykker start
    long diffMinutesStart;
    //Tiden der bliver sat når man trykker stop
    long diffMinutesEnd;

    //variabler der indeholder totalantal timer for dagen
    double timerMandag;
    double timerTirsdag;
    double timerOnsdag;
    double timerTorsdag;
    double timerFredag;

    //metode til at hente startdato og tid
    public static long startDateStamp(){

        //"Metoden" til at få fat i den lokale tid
        Calendar startTimestamp         = Calendar.getInstance();
        Date start                      = startTimestamp.getTime();

        String startString              = dateFormat.format(start);

        //Her laves et try catch da den ellers vil crashe
        try{
            start                       = dateFormat.parse(startString);
        }catch(ParseException e1) {
            e1.printStackTrace();
        }

        //Her henter vi den lokale tid igen og omregner til minutter og timer
        long diff                       = start.getTime();
        long diffHoursStart           = diff / (60 * 1000);

        return diffHoursStart;
    }

    //Metode til slut resultat
    public static long endDateStamp(){

        //"Metoden" til at få fat i den lokale tid
        Calendar endTimestamp           = Calendar.getInstance();
        Date end                        = endTimestamp.getTime();



        String startString              = dateFormat.format(end);

        //Her laves et try catch da den ellers vil crashe
        try{
            end                         = dateFormat.parse(startString);
        }catch(ParseException e1) {
            e1.printStackTrace();
        }

        //Variabel til at finde sluttiden
        long diff = end.getTime();
        //Her omregnes den til timer
        long diffHoursEnd             = diff / (60 * 1000);


        return diffHoursEnd;
    }

    //Metode til at få fat i differencen, altså hvor meget man har arbejdet
    public static double startTimeMeth(long diffMinutesStart, long diffMinutesEnd) {

        //her sker udreningen
        double difference               = (diffMinutesEnd) - (diffMinutesStart);

        return difference;

    }

    //Metode til at få fat på det totalte antal timer man har arbejdet i ugen
    public static double ugentligeTimer(double timer1, double timer3, double timer5, double timer7, double timer9){

        //Her sker udrengingen
        double totalUgentligeTimer      = timer1+timer3+timer5+timer7+timer9;

        return totalUgentligeTimer;
    }

}
