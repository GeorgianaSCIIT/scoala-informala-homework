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


        Map<Persoane, Hobby> hobby = new HashMap<>();

        hobby.put(new Persoane("Mariana", 32), (new Hobby("Innot", 5, new Adresa("Romania", "Sibiu"))));
        hobby.put(new Persoane("Mariana", 32), (new Hobby("Desen", 3, new Adresa("Romania", "Sibiu"))));
        hobby.put(new Persoane("Mariana", 32), (new Hobby("Pian", 2, new Adresa("Romania", "Sibiu"))));



        System.out.println("List of Hobbies");

        for (Persoane i : hobby.keySet()) {
            System.out.println(i);
        }


        for (Hobby h : hobby.values()) {
            System.out.println(h);

        }


//        hobby.put(new("Mariana"), (new Hobby("Innot", 5, new Adresa("Romania", "Sibiu"))));
//        hobby.put("Ioana", (new Hobby("Desen", 5, new Adresa("Romania", "Brasov"))));
//        hobby.put("Ionel", (new Hobby("Fotbal", 5, new Adresa("Romania", "Brasov"))));
//        hobby.put("Ioana", (new Hobby("Pian", 5, new Adresa("Romania", "Ploiesti"))));
//
//
//        System.out.println("List of Hobbies");
//
//        for (String i : hobby.keySet()) {
//            System.out.println("Name: " + i + " " + hobby.get(i));
//
//        }

//        Persoane [] persoane = new Persoane [10];
//
//        persoane [0] = new Somer ("Maria");
//        persoane [1] = new Angajat("Ion");
//        persoane [2] = new Student("Ioana");
//        persoane [3] = new Angajat("Madalina");
//        persoane [4] = new Angajat("Ion");
//        persoane [5] = new Somer("Ion");
//        persoane [6] = new Somer("Ion");
//        persoane [7] = new Student("Ion");
//        persoane [8] = new Student("Ion");
//        persoane [9] = new Angajat("Ion");
//        persoane [10] = new Angajat("Ion");
//
//        List<Persoane> pers = new ArrayList<>();
//        pers.add(new Somer("Maria"));
//        pers.add(new Angajat("Ion"));
//        pers.add(new Student("Matei"));
//
//        pers.forEach(System.out::println);
//
//        List<Persoane> persons = new LinkedList();
//        persons.add(new Somer("Maria"));
//        persons.add(new Angajat("Ionel"));
//        persons.add(new Student("Liana"));
//
//        persons.forEach(System.out::println);
//
//        Set<Persoane> persons1 = new HashSet<Persoane>();
//
//        persons1.add(new Somer("Mariana", "282"));
//        persons1.add(new Angajat("Ioana", "281"));
//        persons1.add(new Student("Ionel", "18306"));
//        persons1.add(new Student("Ionel ", "18306"));
//
//        for(Persoane p: persons1){
//            System.out.println(p.getName());
//
//        }
//
//
//        Map <String, Persoane> persons2 = new HashMap<>();
//
//        persons2.put("somer", new Somer("Mariana", "123"));
//        persons2.put("angajat", new Angajat("Mariana", "123"));
//        persons2.put("student", new Student("Mariana", "123"));
//        persons2.put("somer", new Somer("Ioana", "123"));
//
//        System.out.println(persons2.get("somer"));
//        System.out.println(persons2.get("angajat"));
//        System.out.println(persons2.get("student"));


//        for(int i = 0; i <persoane.length; i++){
//            System.out.println(persoane[i].getName());
//        }


//        for(Persoane p : persoane){
//            System.out.println(p.getName());
//        }
//
        }



}

