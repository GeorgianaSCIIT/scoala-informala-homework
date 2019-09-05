package ro.siit;
/**
 * @author Georgiana
 * @version 1.0
 * @sience 31/08/2019
 * Main class
 *
 */

import ro.siit.ro.siit.thread.FileReader;
import ro.siit.ro.siit.thread.FileReaderNew;



public class Main {
    public static void main(String[] args) {

        FileReader r = new FileReader();
        FileReaderNew r2 = new FileReaderNew();
        r.run();
        r2.run();
    }

}