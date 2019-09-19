package ro.siit.readerwriter;
/**
 * @author Georgiana
 * @version 1.0
 * @sience 08/09/2019
 * Writer class
 *
 */

import java.io.*;
import java.util.List;

public class Writer {

    /**
     * @param pers list of objects or strings which will be written in the file
     * @param file -text file
     * @return file
     * @throws IOException
     */
    public static File writePerson(List pers, String file) throws IOException {

        FileWriter outFile = new FileWriter(file);
        BufferedWriter outStream = new BufferedWriter(outFile);
        for (int k = 0; k < pers.size(); k++)
            outStream.write(String.valueOf(pers.get(k)) + "\n");
        outStream.close();

        return new File(file);
    }


}

