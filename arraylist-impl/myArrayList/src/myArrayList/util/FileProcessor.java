package myArrayList.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
	BufferedReader bufferedReader = null;
	FileReader fileWriter = null;

	// Constructor
	public FileProcessor(String fileName) {
		try {
			fileWriter = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		bufferedReader = new BufferedReader(fileWriter);
	}
	
	// Reads a single line
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