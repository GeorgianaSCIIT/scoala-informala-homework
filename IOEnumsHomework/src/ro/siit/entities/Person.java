package ro.siit.entities;
/**
 * @author Georgiana
 * @version 1.0
 * @sience 31/08/2019
 * Person Class
 *
 */
import ro.siit.enums.Gender;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public Person(String name, String dateOfBirth, String gender){
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

    /**
     * Filter all  females born on August 28
     * @param personList -the list where we save our result
     * @param person
     * @return Happy Birthay + name + year of birth
     * @throws ParseException
     */

    public Person validatePerson(List<String> personList, Person person) throws ParseException {
        if (getMonth().equals("08") && getDay().equals("28")) {
            if(gender.equals("female") || gender.equals("1")){
                personList.add(person.getName() + person.getDateOfBirth() + " " + Gender.selectGender("female", 1));
                System.out.println("Happy birthday " + " " + person.getName() + "( " + getYear() + " )!");;
            }
        }
        return person;
    }

    /**
     * Format date
     * @return formated date of birth
     * @throws ParseException
     */

    public String formatDate() throws ParseException {
        String birthDate = getDateOfBirth();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String newDateStr = simpleDateFormat.format(simpleDateFormat.parse(birthDate));
        return newDateStr;
    }

    /**
     * @return Year of Birth
     * @throws ParseException
     */

    public String getYear() throws ParseException {
        String str[] = formatDate().split("-");
        String year = str[0];;
        return year;
    }

    /**
     * @return Month of Birth
     * @throws ParseException
     */

    public String getMonth() throws ParseException {
        String str[] = formatDate().split("-");
        String month = str[1];
        return month ;
    }

    /**
     * @return Day of birth
     * @throws ParseException
     */
    public String getDay() throws ParseException {
        String str[] = formatDate().split("-");
        String day = str[2];
        return day;
    }

}

