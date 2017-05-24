package backend;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Daniel on 23-05-2017.
 */
public class Datepicker {


    //static Calendar startTimestamp = Calendar.getInstance();
    //static Calendar endTimestamp = Calendar.getInstance();
    static DateFormat dateFormat = new SimpleDateFormat("HH:mm");

    long diffMinutesStart;
    long diffMinutesEnd;

    double timer1;
    double timer3;
    double timer5;
    double timer7;
    double timer9;

    public static long startDateStamp(){
        Calendar startTimestamp = Calendar.getInstance();
        Date start = startTimestamp.getTime();

        String startString = dateFormat.format(start);

        try{
            start = dateFormat.parse(startString);
        }catch(ParseException e1) {
            e1.printStackTrace();
        }

        long diff = start.getTime();
        long diffMinutesStart = diff / (60 * 1000);
        long diffHoursStart = diff / (60 * 60 * 1000);
        /*System.out.println("Time in seconds: " + diffSeconds + " seconds.");
        System.out.println("Time in minutes: " + diffMinutesStart + " minutes.");
        System.out.println("Time in hours: " + diffHoursStart + " hours.");
        System.out.println(diffMinutesStart+"diffminstart");*/

        return diffMinutesStart;
    }

    public static long endDateStamp(){
        Calendar endTimestamp = Calendar.getInstance();
        Date end = endTimestamp.getTime();



        String startString = dateFormat.format(end);

        try{
            end = dateFormat.parse(startString);
        }catch(ParseException e1) {
            e1.printStackTrace();
        }

        long diff = end.getTime();
        long diffMinutesEnd = diff / (60 * 1000);
        System.out.println(diffMinutesEnd+"difend method");
        /*System.out.println("Time in seconds: " + diffSeconds + " seconds.");
        System.out.println("Time in minutes: " + diffMinutesEnd + " minutes.");
        System.out.println("Time in hours: " + diffHoursEnd + " hours.");
        System.out.println(diffMinutesEnd+"endmin");*/

        return diffMinutesEnd;
    }

    public static double startTimeMeth(long diffMinutesStart, long diffMinutesEnd) {

        System.out.println(diffMinutesEnd+" + diff min end");
        System.out.println(diffMinutesStart+" diff min start");
        System.out.println(diffMinutesEnd-diffMinutesStart+"the difference");

        double difference = (diffMinutesEnd) - (diffMinutesStart);
        System.out.println(difference+" Difference");

        return difference;

    }

    public static double ugentligeTimer(double timer1, double timer3, double timer5, double timer7, double timer9){

        double totalUgentligeTimer = timer1+timer3+timer5+timer7+timer9;

        return totalUgentligeTimer;
    }

}
