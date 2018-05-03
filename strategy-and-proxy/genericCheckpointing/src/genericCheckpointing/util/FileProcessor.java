package genericCheckpointing.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

import genericCheckpointing.util.MyLogger;

/**
 * @author jaydeep
 */
public class FileProcessor {
    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;
    FileReader fileReader = null;
    FileInputStream fileInputStream = null;

    /**
     * Parameterized constructor to create an object of BufferedReader
     *
     * @param fileName - fileName to create an object
     */
    public FileProcessor(String fileName) {
        MyLogger.writeMessage("FileProcessor Constructor ",
                MyLogger.DebugLevel.CONSTRUCTOR);
        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(fileReader);
    }

    /**
     * Function to read a single line from the file
     *
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