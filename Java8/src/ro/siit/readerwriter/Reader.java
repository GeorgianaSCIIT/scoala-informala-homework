package ro.siit.readerwriter;


/**
 * @author Georgiana
 * @version 1.0
 * @sience 08/09/2019
 * Reader class
 *
 */

import ro.siit.entities.Person;
import java.io.*;
import java.util.List;

public class Reader {

    /**
     * Read method - read input.txt file
     * @param pers -list where the objects are saved
     * @param file- file which will be read
     * @return file
     * @throws IOException
     */

    public static File read(List pers, String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        //Create List for holding Person objects
        String line = " ";
        while ((line = br.readLine()) != null)
        {
            String[] personDetails = line.split(" ");
            if(personDetails.length > 0 )
            {
                //Save the person details in Person object
                Person person = new Person(
                        personDetails[0],
                        personDetails[1], personDetails[2]);
                pers.add(person);
            }
        }
        br.close();
        return new File(file);
    }
}
