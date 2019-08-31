package ro.siit.comparators;

/**
 * @author Georgiana
 * @version 1.0
 * @sience 26/08/2019
 * AthletesFInalTimeComaparator, sorts the athletes set by final time
 *
 */

import ro.siit.entities.Athlete;
import java.util.Comparator;

public class AthletesFinalTimeComparator implements Comparator<Athlete> {

    @Override
    public int compare(Athlete a1, Athlete a2) {
        int penalty = a1.calculateTotalPenalty();
        int penalty1 = a2.calculateTotalPenalty();
        return a1.calculateFinalTime(penalty).compareTo(a2.calculateFinalTime(penalty1));
    }



}
