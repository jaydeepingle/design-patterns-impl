package myArrayList.util;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	public ArrayList<String> messages;
	BufferedWriter bufferedWriter;
	FileWriter fileWriter;
	public Results() {
		messages = new ArrayList<>();
	}
	public Results(String fileName) {
		messages = new ArrayList<>();
		try {
			fileWriter = new FileWriter(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bufferedWriter = new BufferedWriter(fileWriter);
	}
	public void storeResult(String message) {
		messages.add(message);
	}
	//writes to file
	public void writeToFile(String content) {
		try {
			bufferedWriter.write(content);
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//writes to console
	public void writeToStdout(String content) {
		System.out.println(content);
	}
}
