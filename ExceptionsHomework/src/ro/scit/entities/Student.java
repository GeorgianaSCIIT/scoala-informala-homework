package ro.scit.entities;
import ro.scit.utilities.DateOfBirth;
import java.util.Objects;

/**
 * @author Georgiana
 * Student class
 */

public class Student {
    //    private static int nextId = 1;
//    private int id;
    private String cnp;
    private String firstName;
    private String lastName;
    DateOfBirth birthDate;
    private int age;
    private String gender;


    public Student(String cnp, String firstName, String lastName, DateOfBirth birthDate, int age, String gender) {
        //       this.id = Student.nextId;
//        Student.nextId++;
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
        this.gender = gender;
    }


    public Student() {
    }

    public String getCnp() {
        return cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public DateOfBirth getBirthDate() {
        return birthDate;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age &&
                cnp.equals(student.cnp) &&
                firstName.equals(student.firstName) &&
                lastName.equals(student.lastName) &&
                birthDate.equals(student.birthDate) &&
                gender.equals(student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp, firstName, lastName, birthDate, age, gender);
    }

    @Override
    public String toString() {
        return "Student:" +
                "cnp='" + cnp + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ';';
    }

}
