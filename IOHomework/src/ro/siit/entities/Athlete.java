package ro.siit.entities;

/**
 * @author Georgiana
 * @version 1.0
 * @sience 26/08/2019
 * Athlete Class
 *
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Athlete {
    private int number;
    private String name;
    private String countryCode;
    String timeResult;
    private String firstShoot;
    private String secondShoot;
    private String thirdShoot;
    String finalTime;

    /**
     * Creates a new Athlete using the following parameters:
     * @param number- number of athlete
     * @param name - name of athlete
     * @param countryCode - code of the athlete's country
     * @param timeResult - the initial time- ski time
     * @param firstShoot - results for first shooting range
     * @param secondShoot - results for second shooting range
     * @param thirdShoot - results for third shooting range
     */

    public Athlete(int number, String name, String countryCode, String timeResult, String firstShoot,
                   String secondShoot, String thirdShoot) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.timeResult = timeResult;
        this.firstShoot = firstShoot;
        this.secondShoot = secondShoot;
        this.thirdShoot = thirdShoot;
    }

    public String getName() {
        return name;
    }


    public String getTimeResult() {
        return timeResult;
    }


    public String getFirstShoot() {
        return firstShoot;
    }


    public String getSecondShoot() {
        return secondShoot;
    }


    public String getThirdShoot() {
        return thirdShoot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Athlete)) return false;
        Athlete athlete = (Athlete) o;
        return number == athlete.number &&
                name.equals(athlete.name) &&
                countryCode.equals(athlete.countryCode) &&
                timeResult.equals(athlete.timeResult) &&
                firstShoot.equals(athlete.firstShoot) &&
                secondShoot.equals(athlete.secondShoot) &&
                thirdShoot.equals(athlete.thirdShoot) &&
                finalTime.equals(athlete.finalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, countryCode, timeResult, firstShoot, secondShoot, thirdShoot, finalTime);
    }

    @Override
    public String toString() {
        return number + " " + name + " " + countryCode + " " + formatTimeResult(timeResult) + " " + firstShoot + " " + secondShoot +
                " " + thirdShoot + " " + calculateFinalTime(calculateTotalPenalty());
    }

    /**
     * Method for time format
     * @param timeResult - ski time
     * @return timeResult
     */

    public String formatTimeResult(String timeResult) {
        DateFormat formatter = new SimpleDateFormat("MM:ss");
        try {
            Date dt = formatter.parse(timeResult);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
        } catch (ParseException e) {
            // This can happen if you are trying to parse an invalid date, e.g., 19:12.
            e.printStackTrace();
        }
        return timeResult;
    }

    /**
     * method to calculate penalty based on missed shootings "o"
     * @param penalty
     * @return
     */

    public int calculatePenalty(String penalty){
        int sum=0;
        for(int i=0;i<penalty.length();i++){
            char c=penalty.charAt(i);
            if(c=='o'){
                sum=sum+10;
            }
        }
        return sum;
    }

    /**
     * method to calculate the total penalty
     * @return total penalty
     */

    public int calculateTotalPenalty(){
        String first = getFirstShoot();
        String second = getSecondShoot();
        String third = getThirdShoot();
        int totalPenalty = calculatePenalty(first)+ calculatePenalty(second)+ calculatePenalty(third);
        return totalPenalty;
    }



    /**
     * method to calculate the final time based on time results and missed shots
     * @param penalty
     * @return finalTime
     */

    public String calculateFinalTime(int penalty ){
        String minutes=getTimeResult().substring(0,2);
        String seconds=getTimeResult().substring(3);
        int timeInSeconds=Integer.parseInt(minutes)*60 + Integer.parseInt(seconds);
        int finalTime = timeInSeconds + penalty;
        String finalTimeToString = String.format("%02d:%02d", finalTime/60, finalTime%60);
        return finalTimeToString;
    }

}
