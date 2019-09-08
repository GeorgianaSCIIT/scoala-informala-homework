package ro.siit.thread;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import static ro.siit.readwriter.Reader.read;
import static ro.siit.readwriter.Reader.write;
/**
 * @author Georgiana
 * @version 1.0
 * @sience 31/08/2019
 * FileReader Class - implements methods from Reader Class
 * implemnts methods from Runnable
 * second thdread
 */
public class FileReaderNew implements Runnable {

    @Override
    public void run() {
        File file = new File("out.txt");
        try {
            read(new File("file1.txt"));
            write(file, new File("file1.txt"), new File("file2.txt"));


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(long millis) throws InterruptedException{

    }
}
