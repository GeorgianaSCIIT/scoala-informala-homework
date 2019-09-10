package ro.siit;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        Person p1 = new Person("Adriana", "Popescu", "1982/11/28");
        Person p2 = new Person("Ionel", "Ionescu", "1983/11/24");
        Person p3 = new Person("Oana", "Iliescu", "1992/03/15");
        Person p4 = new Person("Bogdan", "Georgescu", "1995/03/12");
        Person p5 = new Person("Bianca", "Enescu", "1981/11/12");


        try {
            /**
             * Create a new File-input.txt and writing  objects in it
             */
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("input.txt" ));
            out.writeObject(p1);
            out.writeObject(p2);
            out.writeObject(p3);
            out.writeObject(p4);
            out.writeObject(p5);
            out.close();

            /**
             * Reading objects from input.txt
             */


            ObjectInputStream in = new ObjectInputStream(new FileInputStream("input.txt"));
            Person p1a = (Person) in.readObject();
            Person p2a = (Person) in.readObject();
            Person p3a = (Person) in.readObject();
            Person p4a = (Person) in.readObject();
            Person p5a = (Person) in.readObject();
            in.close();


            List<Person> pers = Arrays.asList(p1a, p2a, p3a, p4a, p5a);
            pers.forEach((s)-> System.out.println(s));

            /**
             * Sort list using strem(), by date of birth and name
             */

            List<String> result = pers.stream()
                    .filter(s ->s.getDateOfBirth().contains("11"))
                    .map(p -> p.getFirstName() + " " + p.getLastName())
                    .sorted()
                    .collect(Collectors.toList());


            /**
             * The result will be written in a new file-output.txt
             */


            ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("output.txt"));
            out1.writeObject(result);
            out1.close();
            System.out.println("------------Sorted list----------------------");
            result.forEach((s)-> System.out.println(s));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
