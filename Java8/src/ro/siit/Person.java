package ro.siit;


import java.io.Serializable;
import java.util.Objects;

/**
 * @author Georgiana
 * @version 1.0
 * @sience 08/09/2019
 * Person Class
 *
 */
public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String dateOfBirth;


    /**
     * Create a new Person using the following parameters:
     * @param firstName
     * @param lastName
     * @param dateOfBirth
     */

    public Person(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                dateOfBirth.equals(person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth);
    }


    @Override
    public String toString() {
        return  firstName + " " + lastName + " " + dateOfBirth ;
    }

}
