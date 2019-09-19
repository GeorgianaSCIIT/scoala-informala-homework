package ro.siit;

/**
 * @author Georgiana
 * @version 1.0
 * @sience 08/09/2019
 * Main class
 *
 */

import ro.siit.entities.Person;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static ro.siit.readerwriter.Reader.read;
import static ro.siit.readerwriter.Writer.writePerson;

public class App {

    public static void main(String[] args) throws ParseException {
        /**
         * Create a new list to save the person objects
         */
        List<Person> pers = new ArrayList<>();
        pers.add(new Person("Ioana", "Constantinescu", "1992/11/22"));
        pers.add(new Person("Adriana", "Popescu", "1982/11/28"));
        pers.add(new Person("Oana", "Iliescu", "1992/03/15"));
        pers.add(new Person("Bogdan", "Georgescu", "1995/03/12"));
        pers.add(new Person("Bianca", "Enescu", "1981/11/12"));


        try {
            /**
             * Writing objects in  a new File - input.txt
             */
            writePerson(pers, "input.txt");


            /**
             * Read objects from the input.txt
             */
            List<Person> persList = new ArrayList<>();
            read(persList, "input.txt");
            pers.forEach((s)-> System.out.println(s));


            /**Sort and map objects using stream().
             * the result will be saved in a new list- "result"
             */

            List<String> result = pers.stream()
                    .filter(s ->s.getDateOfBirth().contains("11"))
                    .map(p ->  p.getFirstName() + " " + p.getLastName())
                    .sorted()
                    .collect(Collectors.toList());

            /**
             * Print result
             */

            System.out.println("------------Sorted list----------------------");
            result.forEach((s)-> System.out.println(s));

            /**
             * Write the new sorted list in a new file "output.txt"
             */
            writePerson(result, "output.txt" );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
