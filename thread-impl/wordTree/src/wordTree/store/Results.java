package wordTree.store;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import wordTree.util.MyLogger;
import wordTree.util.FileDisplayInterface;
import wordTree.util.StdoutDisplayInterface;
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
        MyLogger.writeMessage("Result Constructor ", MyLogger.DebugLevel.CONSTRUCTOR);
        messages = new ArrayList<String>();
    }

    /**
     * Paremeterized constructor
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
     * @param message
     */
    public void storeResult(String message) {
        MyLogger.writeMessage("Storing new value in Results", MyLogger.DebugLevel.IN_RESULTS);
        this.message = message;
    }


    /**
     * Function which prints the schedules to file
     * @param s
     */
    public void writeSchedulesToFile(String content) {
        MyLogger.writeMessage("Writing Results to File", MyLogger.DebugLevel.FROM_RESULTS);
        try {
            bufferedWriter.write(content);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void writeToScreen(String content) {
		// TODO Auto-generated method stub
        System.out.println(content);
	}
}