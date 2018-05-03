package myArrayList.test;
import myArrayList.EmptyListException;
import myArrayList.ValueNotInRangeException;
import myArrayList.util.Results;
import myArrayList.MyArrayList;
import java.util.Random;
public class MyArrayListTest {
	Random rand;
	public MyArrayListTest() {
		rand = new Random();
	}
	public void insertElements(MyArrayList myArrayList, int limit) {
		for(int i = 0; i < limit; i++) {
			try {
				myArrayList.insertSorted(rand.nextInt(10000));
			} catch (ValueNotInRangeException e) {
				e.printStackTrace();
			} 
		}
	}
	/*
	 * It calls 10 different test methods
	 */
	public void testMe(MyArrayList myArrayList, Results results) {
		results.storeResult(sizeCheckUnderflow(myArrayList));
		results.storeResult(sizeCheckOverflow(myArrayList));
		results.storeResult(removeFromEmptyCheck(myArrayList));
		results.storeResult(toStringCheck(myArrayList));
		results.storeResult(insertSortedCheck(myArrayList));
		results.storeResult(removeValueCheck(myArrayList));
		results.storeResult(insertAndSumCheck(myArrayList));
		results.storeResult(removeAndSumCheck(myArrayList));
		results.storeResult(insertRemoveAndIndexOf(myArrayList));
		results.storeResult(valueNotInRangeCheck(myArrayList));
	}
	/*
	 * It checks by inserting the number of elements below the limit
	 */
	public String sizeCheckUnderflow (MyArrayList myArrayList) {
		String message = "";
		myArrayList = new MyArrayList();
		insertElements(myArrayList, 45);
		if(myArrayList.size() == 45) {
			message = "Test 1: sizeCheckUnderflow passed.";
		} else {
			message = "Test 1: sizeCheckUnderflow failed.";
		}
		return message;
	}
	/*
	 * It checks by inserting the number of elements above the limit
	 */
	public String sizeCheckOverflow (MyArrayList myArrayList) {
		String message = "";
		myArrayList = new MyArrayList();
		insertElements(myArrayList, 55);
		if(myArrayList.size() == 55) {
			message = "Test 2: sizeCheckOverflow passed.";
		} else {
			message = "Test 2: sizeCheckOverflow failed.";
		}
		return message;
	}
	/*
	 * It tests the EmptyListException
	 */
	public String removeFromEmptyCheck (MyArrayList myArrayList) {
		String message = "";
		myArrayList = new MyArrayList();
		insertElements(myArrayList, 0);
		try {
			myArrayList.removeValue(5);
		} catch (EmptyListException e) {
			message = "Test 3: removeFromEmptyCheck passed.";
		}
		if(message.equals("")) {
			message = "Test 3: removeFromEmptyCheck failed.";
		}
		return message;
	}
	/*
	 * It tests the toString method
	 */
	public String toStringCheck (MyArrayList myArrayList) {
		String message = "";
		myArrayList = new MyArrayList();
		try {
			myArrayList.insertSorted(1);
			myArrayList.insertSorted(5);
			myArrayList.insertSorted(3);
		} catch (ValueNotInRangeException e) {
			e.printStackTrace();
		}
		
		if(myArrayList.toString().trim().equals("1 3 5")) {
			message = "Test 4: toStringCheck passed.";
		} else {
			message = "Test 4: toStringCheck failed.";
		}
		return message;
	}
	/*
	 * It tests the insertSortedMethod
	 */
	public String insertSortedCheck (MyArrayList myArrayList) {
		String message = "";
		myArrayList = new MyArrayList();
		try {
			myArrayList.insertSorted(10);
			myArrayList.insertSorted(70);
			myArrayList.insertSorted(40);
			myArrayList.insertSorted(90);
		} catch (ValueNotInRangeException e) {
			e.printStackTrace();
		}
		
		if(myArrayList.toString().trim().equals("10 40 70 90")) {
			message = "Test 5: insertSortedCheck passed.";
		} else {
			message = "Test 5: insertSortedCheck failed.";
		}
		return message;
	}
	/*
	 * It tests the removeValue method
	 */
	public String removeValueCheck (MyArrayList myArrayList) {
		String message = "";
		myArrayList = new MyArrayList();
		try {
			myArrayList.insertSorted(10);
			myArrayList.insertSorted(70);
			myArrayList.insertSorted(40);
			myArrayList.insertSorted(90);
		} catch (ValueNotInRangeException e1) {
			e1.printStackTrace();
		}
		try {
			myArrayList.removeValue(40);
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		if(myArrayList.toString().trim().equals("10 70 90")) {
			message = "Test 6: removeValueCheck passed.";
		} else {
			message = "Test 6: removeValueCheck failed.";
		}
		return message;
	}
	/*
	 * This method adds a number and check for the updated sum
	 */
	public String insertAndSumCheck (MyArrayList myArrayList) {
		String message = "";
		myArrayList = new MyArrayList();
		try {
			myArrayList.insertSorted(10);
			myArrayList.insertSorted(10);
		} catch (ValueNotInRangeException e) {
			e.printStackTrace();
		}
		
		if(myArrayList.sum() == 20) {
			message = "Test 7: insertAndSumCheck passed.";
		} else {
			message = "Test 7: insertAndSumCheck passed.";
		}
		return message;
	}
	/*
	 * This method removes a number and check for the updated sum
	 */
	public String removeAndSumCheck (MyArrayList myArrayList) {
		String message = "";
		myArrayList = new MyArrayList();
		try {
			myArrayList.insertSorted(10);
			myArrayList.insertSorted(10);
		} catch (ValueNotInRangeException e1) {
			e1.printStackTrace();
		}
		
		try {
			myArrayList.removeValue(10);
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		if(myArrayList.sum() == 10) {
			message = "Test 8: removeAndSumCheck passed.";
		} else {
			message = "Test 8: removeAndSumCheck passed.";
		}
		return message;
	}
	/*
	 * This method inserts and removes and check for the indexOf Operation
	 */
	public String insertRemoveAndIndexOf (MyArrayList myArrayList) {
		String message = "";
		myArrayList = new MyArrayList();
		try {
			myArrayList.insertSorted(10);
			myArrayList.insertSorted(30);
			myArrayList.insertSorted(20);
			myArrayList.insertSorted(40);
		} catch (ValueNotInRangeException e) {
			e.printStackTrace();
		}
		
		try {
			myArrayList.removeValue(10);
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		if(myArrayList.indexOf(20) == 0) {
			message = "Test 9: insertRemoveAndIndexOf passed.";
		} else {
			message = "Test 9: insertRemoveAndIndexOf failed.";
		}
		return message;
	}
	/*
	 * This method validates the valueNotInRange Exception
	 */
	public String valueNotInRangeCheck (MyArrayList myArrayList) {
		String message = "";
		myArrayList = new MyArrayList();
		try {
			myArrayList.insertSorted(-10);
		} catch (ValueNotInRangeException e1) {
			message = "Test 10: valueNotInRangeCheck passed.";
		}
		if(message.equals("")) {
			message = "Test 10: valueNotInRangeCheck failed.";
		}
		return message;
	}
}
