package myArrayList.driver;

import myArrayList.util.FileProcessor;
import myArrayList.util.Results;
import myArrayList.test.MyArrayListTest;
import myArrayList.MyArrayList;
import myArrayList.ValueNotInRangeException;

public class Driver {
	public static void main(String[] args) {
		int value = 0;
		String message = "", line;
		Results myResults = new Results(args[1]);
		MyArrayListTest myTest = new MyArrayListTest();
		FileProcessor fileProcessor = new FileProcessor(args[0]);
		MyArrayList myArrayListObj = new MyArrayList(fileProcessor);
		
		// Arguments check
		if (args.length != 2) {
			System.err.println("Number of arguments provided are not valid.");
			System.exit(0);
		}
		while ((line = fileProcessor.readLine()) != null) {
			try {
				value = Integer.parseInt(line);
				try {
					myArrayListObj.insertSorted(value);
				} catch (ValueNotInRangeException e) {
					e.printStackTrace();
				}
			} catch (NumberFormatException e) {
				continue;
			}
		}
		myTest.testMe(myArrayListObj, myResults);
		for (String str : myResults.messages) {
			message = message + str + "\n";
		}
		message = "The sum of all the values in the array list is: " + myArrayListObj.sum() + "\n" + message;
		myResults.writeToFile(message);
	}
}
