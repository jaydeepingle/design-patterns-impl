package studentCoursesBackup.util;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
        messages = new ArrayList<>();
    }

    /**
     * Paremeterized constructor
     * @param fileName
     */
    public Results(String fileName) {
        messages = new ArrayList<>();
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedWriter = new BufferedWriter(fileWriter);
    }

    /**
     * Function to store the result in the message string
     * @param message
     */
    public void storeResult(String message) {
        this.message = message;
    }

    /**
     * Function to write contents in the file
     * @param content
     */
    public void writeToFile(String content) {
        try {
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write the contents to standard output
     * @param content
     */
    public void writeToStdout(String content) {
        System.out.println(content);
    }
}
