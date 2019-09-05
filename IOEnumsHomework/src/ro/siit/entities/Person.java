package ro.siit.entities;

/**
 * @author Georgiana
 * @version 1.0
 * @sience 31/08/2019
 * Person Class
 *
 */

import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private String dateOfBirth;
    private String gender;

    /**
     *Create a new Person using the following parameters:
     * @param name
     * @param dateOfBirth
     * @param gender
     */

    public Person(String name, String dateOfBirth, String gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                dateOfBirth.equals(person.dateOfBirth) &&
                gender.equals(person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, gender);
    }

    @Override
    public String toString() {
        return  name + " " + dateOfBirth + " " + gender;
    }


    public Person validatePerson(List<String> personList, Person person){
        if (String.format(person.getDateOfBirth(), "yyyy-MM-dd").contains("08-28")) {
            if (gender.equals("female")||gender.equals("1")) {
                personList.add(person.getName() + person.getDateOfBirth() + " " + person.getGender());
                System.out.println(person.getName() + person.getDateOfBirth() + " " + person.getGender());
            }
        }
        return person;
    }


}

