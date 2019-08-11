import ro.sciit.comparators.PersoaneAgeComparator;
import ro.sciit.comparators.PersoaneNameComparator;
import ro.sciit.entities.Angajat;
import ro.sciit.entities.Persoane;
import ro.sciit.entities.Somer;
import ro.sciit.entities.Student;
import ro.sciit.utilities.Adresa;
import ro.sciit.utilities.Hobby;

import java.util.*;

/**
 * @author Georgiana
 * Main class
 */

public class Main {

    public static void main(String[] args) {


        System.out.println("Sorting using age comparator");

        Set<Persoane> compAge = new TreeSet<Persoane>(new PersoaneAgeComparator());

        compAge.add(new Somer("Mariana", 32));
        compAge.add(new Angajat("Ioana", 22));
        compAge.add(new Student("Ionel", 25));
        compAge.add(new Somer("Ioana", 28));

        for (Persoane p : compAge) {
            System.out.println(p);
        }

//        pers.forEach(System.out::println);

        System.out.println("Sorting using name comparator");

        Set<Persoane> compName = new TreeSet<Persoane>(new PersoaneNameComparator());

        compName.add(new Somer("Mariana", 32));
        compName.add(new Angajat("Ioana", 22));
        compName.add(new Student("Ionel", 25));
        compName.add(new Somer("Ioana", 28));

        for (Persoane p : compName) {
            System.out.println(p);
        }


        List<Adresa> adresaInot = new ArrayList<>();
        adresaInot.add(new Adresa("Italia", "Roma"));
        adresaInot.add(new Adresa("Romania", "Sibiu"));
        adresaInot.add(new Adresa("Olanda", "Amsterdam"));

        List<Adresa> adresaDesen = new ArrayList<>();
        adresaDesen.add(new Adresa("Franta", "Paris"));
        adresaDesen.add(new Adresa("Romania", "Brasov"));

        List<Adresa> adresaPian = new ArrayList<>();
        adresaPian.add(new Adresa("Romania", "Bucuresti"));


        List<Hobby> hobbyList = new ArrayList<>();
        hobbyList.add(new Hobby("Innot", 5, (ArrayList<Adresa>) adresaInot));
        hobbyList.add(new Hobby("Desen", 4, (ArrayList<Adresa>) adresaDesen));
        hobbyList.add(new Hobby("Pian", 2, (ArrayList<Adresa>) adresaPian));


        Map<Persoane, ArrayList<Hobby>> hobby = new HashMap<>();
        hobby.put(new Persoane("Mariana", 32), (ArrayList<Hobby>) hobbyList);


        System.out.println("List of Hobbies");

        for (Persoane i : hobby.keySet()) {
            System.out.println(i);
        }


        for (ArrayList<Hobby> h : hobby.values()) {
            h.forEach(System.out::println);

        }

    }


}

