package ro.siit.ro.siit.thread;

/**
 * @author Georgiana
 * @version 1.0
 * @sience 31/08/2019
 * FileReader Class - implements methods from Reader Class
 * implemnts methods from Runnable
 * first thdread
 */

import java.io.*;
import static ro.siit.readwriter.Reader.read;
import static ro.siit.readwriter.Reader.write;


public class FileReader implements Runnable  {
    @Override
    public void run() {
        File file = new File("out.txt");
        try {
            read(new File("file2.txt"));
            write(file ,new File("file1.txt"), new File("file2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}