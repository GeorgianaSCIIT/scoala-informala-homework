package ro.scit;

import ro.scit.entities.Angajat;
import ro.scit.entities.Person;
import ro.scit.entities.Somer;
import ro.scit.entities.Student;
import ro.scit.utilities.Adresa;
import ro.scit.utilities.Hobby;

import java.util.*;

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


        List<Hobby> hobbyList = new ArrayList<>();
        hobbyList.add(new Hobby("Innot", 5, new Adresa("Romania", "Sibiu")));
        hobbyList.add(new Hobby("Desen", 4, new Adresa("Romania", "Brasov")));
        hobbyList.add(new Hobby("Pian", 2, new Adresa("Romania", "Cluj")));


        System.out.println("List of Hobbies");

        Map<Person, ArrayList<Hobby>> hobby = new HashMap<>();
        hobby.put(new Person("Mariana", 32), (ArrayList<Hobby>) hobbyList);



        for (Person i : hobby.keySet()) {
            System.out.println(i);
        }


        for (ArrayList<Hobby> h : hobby.values()) {
            h.forEach(System.out::println);

        }


    }
}
