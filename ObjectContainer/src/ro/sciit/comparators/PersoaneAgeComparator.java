package ro.sciit.comparators;
import ro.sciit.entities.Persoane;
import java.util.Comparator;

/**
 * @author Georgiana
 *compares two persons by age
 */

public class PersoaneAgeComparator implements Comparator<Persoane> {

    @Override
    public int compare(Persoane p1, Persoane p2) {
        if(p1.getAge() > p2.getAge()){
            return 1;
        } else {
            return -1;
        }
    }
}
