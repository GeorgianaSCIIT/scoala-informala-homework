package ro.siit.test;

/**
 * @author Georgiana
 * @version 1.0
 * @sience 26/08/2019
 * AthletesTest Class - implements tests for all relevant methods
 *
 */
import org.junit.Assert;
import org.junit.Test;
import ro.siit.comparators.AthletesFinalTimeComparator;
import ro.siit.entities.Athlete;
import static org.junit.Assert.*;

public class AthletesTest {

    /**
     * test the format date method
     */
    @Test
    public void formatTimeResult() {
        Athlete a = new Athlete(11, "Umar Joorgson", "Sk", "30:27",
                "xxxox", "xxxxx", "xxoxo");
        String timeResult = "30:27";
        assertEquals("30:27", a.formatTimeResult(timeResult));
    }

    /**
     * test the calculatePenalty() method
     */

    @Test
    public void calculatePenalty() {
        String penalty = "xxxox";
        Athlete a = new Athlete(11, "Umar Joorgson", "Sk", "30:27",
                "xxxox", "xxxxx", "xxoxo");
        assertEquals(10, a.calculatePenalty(penalty), 0.1);
    }

    /**
     * test the calculateTotalPenalty method
     */

    @Test
    public void calculateTotalPenalty() {
        Athlete a = new Athlete(11, "Umar Joorgson", "Sk", "30:27",
                "xxxox", "xxxxx", "xxoxo");
        assertEquals(30, a.calculateTotalPenalty(), 0.1);
    }

    /**
     * test the calculateFinalTime() method
     */

    @Test
    public void calculateFinalTime() {
        Athlete a = new Athlete(11, "Umar Joorgson", "Sk", "30:27",
                "xxxox", "xxxxx", "xxoxo");
        int penalty = 30;
        assertEquals("30:57", a.calculateFinalTime(penalty));
    }

    /**
     * test the comparator
     */

    @Test
    public void compare() {
        AthletesFinalTimeComparator comp = new AthletesFinalTimeComparator();
        Athlete umar = new Athlete(11, "Umar Joorgson", "Sk", "30:27",
                "xxxox", "xxxxx", "xxoxo");
        Athlete jimmy = new Athlete(1, "Jimmy Smiles", "UK", "29:15",
                "xxoox", "xooxo", "xxxxo");
        Assert.assertEquals(4, comp.compare(umar, jimmy) );
    }
}