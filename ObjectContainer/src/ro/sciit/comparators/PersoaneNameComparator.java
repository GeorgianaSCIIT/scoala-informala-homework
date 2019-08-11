package ro.sciit.comparators;
import ro.sciit.entities.Persoane;
import java.util.Comparator;
/**
 * @author Georgiana
 *compares two persons y name
 */

public class PersoaneNameComparator implements Comparator<Persoane> {

    @Override
    public int compare(Persoane p1, Persoane p2)
    {
        return p1.getName().compareTo(p2.getName());
    }
}
