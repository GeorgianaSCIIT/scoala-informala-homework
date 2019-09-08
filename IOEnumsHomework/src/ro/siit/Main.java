package ro.siit;
import ro.siit.thread.FileReader;
import ro.siit.thread.FileReaderNew;

/**
 * @author Georgiana
 * @version 1.0
 * @sience 31/08/2019
 * Main class - implements Thread methods run() and sleep()
 *
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        long longtime = System.currentTimeMillis();

        FileReader r = new FileReader();
        FileReaderNew r2 = new FileReaderNew();
        r.run();
        r2.sleep(3000);
        r2.run();

        System.out.println("Total time " + longtime);
    }
}