package m10_io_files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by Yevhenii Tykhonov.
 */
public class SimpleCopyFile {
    public static void main(String[] args) {
        File sourceFile = new File("D:\\sourceFile.txt");
        File targetFile = new File("D:\\targetFile.txt");

        try {
            Files.copy(sourceFile.toPath(), targetFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
