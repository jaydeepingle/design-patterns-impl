package wordTree.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import wordTree.util.MyLogger;

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
        MyLogger.writeMessage("FileProcessor Constructor ", MyLogger.DebugLevel.CONSTRUCTOR);
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
    public synchronized String readLine() {
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