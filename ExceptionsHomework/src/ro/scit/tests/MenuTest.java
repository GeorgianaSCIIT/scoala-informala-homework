package ro.scit.tests;

import org.junit.Assert;
import org.junit.Test;
import ro.scit.entities.Student;
import ro.scit.utilities.DateOfBirth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    List<Student> student = new ArrayList<>();

    @Test
    public void retrievebyAge() {
        Student student1 = new Student("1", "geo", "popescu", new DateOfBirth(8, 27, 2000), 19, "male");
        Student student2 = new Student("2", "iulia", "ionescu", new DateOfBirth(9, 15, 2000), 19, "female");
        Student student3 = new Student("3", "ionel", "ionel", new DateOfBirth(12, 27, 1984), 35, "male");
        Student student4 = new Student("4", "eugen", "vasile", new DateOfBirth(8, 23, 1982), 37, "male");
        student.add(student1);
        student.add(student2);
        student.add(student3);
        student.add(student4);
        int age = student1.getAge();
        assertEquals(student1.getAge(), student2.getAge());
    }

    @Test
    public void compare() {
        Student student1 = new Student("1", "geo", "popescu", new DateOfBirth(8, 27, 2000), 19, "male");
        Student student2 = new Student("2", "iulia", "ionescu", new DateOfBirth(9, 15, 2000), 19, "female");
        student.add(student1);
        student.add(student2);
        student1.getLastName().compareTo(student2.getLastName());
    }

    @Test
    public void testCalculateAge_Success() {
        DateOfBirth birthDate = new DateOfBirth(8, 27, 1963);
        LocalDate currentDate = LocalDate.now();
        // exercise
        int age = currentDate.getYear() - birthDate.getYear();
        Assert.assertEquals(56, age);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenParamIsIllegalArgumentException() {
        Student stud = new Student();
        student.add(stud);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenParamIsEmptyThrowsException() {
        Student student1 = new Student();
        student.remove(student1);
    }

}
