package m10_io_files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Yevhenii Tykhonov.
 */
public class SimpleErr {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("D:");
            System.out.println("File opened");
        } catch (FileNotFoundException e) {
            System.err.println("File opening failed");
            e.printStackTrace();
        }
    }
}
