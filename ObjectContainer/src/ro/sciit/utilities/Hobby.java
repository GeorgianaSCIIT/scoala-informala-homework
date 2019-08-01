package ro.sciit.utilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Georgiana
 * the hobby class
 */

public class Hobby {
    List<Adresa> adresa;
    private String hobbyName;
    private int frequency;


    public Hobby(String hobbyName, int frequency, ArrayList<Adresa> adresa) {
        this.hobbyName = hobbyName;
        this.frequency = frequency;
        this.adresa = adresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hobby)) return false;
        Hobby hobby = (Hobby) o;
        return frequency == hobby.frequency &&
                hobbyName.equals(hobby.hobbyName) &&
                adresa.equals(hobby.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hobbyName, frequency, adresa);
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobbyName='" + hobbyName + '\'' +
                ", frequency=" + frequency +
                ", List of Addresses where this hobby can be practiced =" + adresa +
                '}';
    }

}
