package ro.scit.comparators;

import ro.scit.entities.Student;

import java.util.Comparator;

/**
 * @author Georgiana
 * class Comparator
 * compare students by name
 */

public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getLastName().compareTo(s2.getLastName());
    }

}
