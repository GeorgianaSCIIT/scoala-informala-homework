package ro.siit.readwriter;
/**
 * @author Georgiana
 * @version 1.0
 * @sience 31/08/2019
 * Reader Class - reads information from file1.txt and file2.txt, save details in the in the Person Object.
 * Filter all the female persons whose birthday is today and output a message in the console wishing them a happy birthday
 * The console output is written to the  file.
 */

import ro.siit.entities.Person;
import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Reader {

    /**
     * Method to read from a file
     * @param file - the file wich contains the list of persons
     * @return a list with persons
     * @throws ParseException
     * @throws FileNotFoundException
     */

    public static List<String> read(File file) throws FileNotFoundException, ParseException {
        Scanner scanner = new Scanner(file);
        List<String> personList = null;
        while (scanner.hasNextLine()) {
            personList = new ArrayList<>();
            String line = scanner.nextLine();
            String personDetails[] = line.split(",");
            Person person = new Person(personDetails[0], personDetails[1], personDetails[2]);
            person.validatePerson(personList, person);
        }
        scanner.close();
        return personList;
    }

    /**
     *
     * @param fileWriter - the text file where will be writed the message from console
     * @param fileReader - the file wich contains first list of persons
     * @param fileReader1 - the file wich contains the second list of persons
     * @return
     * @throws ParseException
     * @throws FileNotFoundException
     */

    public static File write (File fileWriter, File fileReader, File fileReader1) throws FileNotFoundException, ParseException {
        PrintStream console = System.out;
        File file = new File(String.valueOf(fileWriter));
        FileOutputStream fos = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);
        System.out.println(read(new File(String.valueOf(fileReader))));
        System.out.println(read(new File(String.valueOf(fileReader1))));
        System.setOut(console);
        return fileWriter;
    }



}
