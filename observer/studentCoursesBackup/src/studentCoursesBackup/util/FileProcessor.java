package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author jaydeep
 */
public class FileProcessor {
    BufferedReader bufferedReader = null;
    FileReader fileWriter = null;

    /**
     * Parameterized constructor to create an object of BufferedReader
     * @param fileName - fileName to create an object
     */
    public FileProcessor(String fileName) {
        try {
            fileWriter = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(fileWriter);
    }

    /**
     * Function to read a single line from the file
     * @return
     */
    public String readLine() {
        String line = "";
        String value = null;
        try {
            if ((line = bufferedReader.readLine()) != null) {
                value = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}