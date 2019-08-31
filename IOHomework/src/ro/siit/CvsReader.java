package ro.siit;

/**
 * @author Georgiana
 * @version 1.0
 * @sience 26/08/2019
 * Cvs Reader Class - reads information from athletes.csv, save details in the in the Athlete Object,
 * prints the athletes list, sort the new list using AthletesFinalTimeComparator
 *
 */

import ro.siit.comparators.AthletesFinalTimeComparator;
import ro.siit.entities.Athlete;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CvsReader {

    //Delimiters used in the CSV file
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        BufferedReader br = null;
        try
        {
            //Reading the csv file
            br = new BufferedReader(new FileReader("athletes.csv"));

            //Create List for holding Athletes objects
            List<Athlete> athleteList = new ArrayList<>();

            String line = "";
            //Reading from the second line
            while ((line = br.readLine()) != null)
            {
                String[] athleteDetails = line.split(COMMA_DELIMITER);

                if(athleteDetails.length > 0 )
                {
                    //Save the athletes details in Athlete object

                    Athlete athlete = new Athlete(
                            Integer.parseInt(athleteDetails[0]),
                            athleteDetails[1],athleteDetails[2],
                            athleteDetails[3], athleteDetails[4],
                            athleteDetails[5], athleteDetails[6]);
                    athleteList.add(athlete);
                }
            }

            //Print the Athlete List
            for(Athlete a : athleteList) {
                System.out.println(a);
            }

            //Create a new Set with all athletes and sort it using AthletesFinalTimeComparator
            Set<Athlete > actualResults = new TreeSet<>(new AthletesFinalTimeComparator());
            actualResults.addAll(athleteList);

            //Print the final results
            System.out.println("The final results are: ");
            for (Athlete athlete : actualResults) {
                int penalty = athlete.calculateTotalPenalty();
                System.out.println(athlete.getName()+ " - " + athlete.calculateFinalTime(penalty) + "(" + athlete.getTimeResult()+
                        " + " + athlete.calculateTotalPenalty() + ")");
            }


        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        finally
        {
            //Close the reader
            try
            {
                br.close();
            }
            catch(IOException ie)
            {
                System.out.println("Error occured while closing the BufferedReader");
                ie.printStackTrace();
            }
        }
    }

}
