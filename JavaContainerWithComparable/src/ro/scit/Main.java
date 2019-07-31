package ro.scit;

import ro.scit.entities.Angajat;
import ro.scit.entities.Person;
import ro.scit.entities.Somer;
import ro.scit.entities.Student;
import ro.scit.utilities.Adresa;
import ro.scit.utilities.Hobby;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sorting using comparable");

        Set<Person> compAge = new TreeSet<Person>();

        compAge.add(new Somer("Mariana", 32));
        compAge.add(new Angajat("Ioana", 22));
        compAge.add(new Student("Ionel", 25));
        compAge.add(new Somer("Ioana", 28));

        for (Person p : compAge) {
            System.out.println(p);
        }



        Map<Person, Hobby> hobby = new HashMap<>();

        hobby.put(new Person("Mariana", 32), (new Hobby("Innot", 5, new Adresa("Romania", "Sibiu"))));
        hobby.put(new Person("Mariana", 32), (new Hobby("Desen", 3, new Adresa("Romania", "Sibiu"))));
        hobby.put(new Person("Mariana", 32), (new Hobby("Pian", 2, new Adresa("Romania", "Sibiu"))));



        System.out.println("List of Hobbies");

        for (Person i : hobby.keySet()) {
            System.out.println(i);
        }


        for (Hobby h : hobby.values()) {
            System.out.println(h);

        }


    }
}
