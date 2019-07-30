package ro.scit.utilities;

import java.util.Objects;

/**
 *
 * @author Georgiana
 */

public class Adresa {

    private String country;
    private String city;

    public Adresa(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }

    @Override
    public String toString() {
        return "Adresa{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
