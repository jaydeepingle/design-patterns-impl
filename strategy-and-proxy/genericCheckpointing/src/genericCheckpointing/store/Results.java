package genericCheckpointing.store;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

import genericCheckpointing.util.MyLogger;
import genericCheckpointing.util.FileDisplayInterface;
import genericCheckpointing.util.StdoutDisplayInterface;

/**
 * @author jaydeep
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    public ArrayList<String> messages;
    public String message;
    BufferedWriter bufferedWriter;
    FileWriter fileWriter;

    /**
     * Constructor
     */
    public Results() {
        MyLogger.writeMessage("Result Constructor ",
                MyLogger.DebugLevel.CONSTRUCTOR);
        messages = new ArrayList<String>();
    }

    /**
     * Paremeterized constructor
     *
     * @param fileName
     */
    public Results(String fileName) {
        messages = new ArrayList<String>();
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedWriter = new BufferedWriter(fileWriter);
    }

    /**
     * Function to store the result in the message string
     *
     * @param message
     */
    public void storeResult(String message) {
        MyLogger.writeMessage("Storing new value in Results",
                MyLogger.DebugLevel.IN_RESULTS);
        this.message = message;
    }

    /**
     * Function which prints the schedules to file
     *
     * @param s
     */
    public void writeSchedulesToFile(String content) {
        MyLogger.writeMessage("Writing Results to File",
                MyLogger.DebugLevel.FROM_RESULTS);
        try {
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the output to stdout
     *
     * @param content
     */
    public void writeToScreen(String content) {
        System.out.println(content);
    }

    /**
     * writeToFile function
     * @param s
     */
    public void writeToFile(String string) {
        try {
            fileWriter.write(string);
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}