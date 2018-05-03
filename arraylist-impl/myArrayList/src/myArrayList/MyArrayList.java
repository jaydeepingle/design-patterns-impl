package myArrayList;

import java.util.Arrays;
import myArrayList.util.FileProcessor;

public class MyArrayList {
	private int[] myArrayList;
	private int[] tempArray;
	private int elements;
	private int size;

	public MyArrayList() {
		myArrayList = new int[50];
		elements = 0;
		size = 50;
	}

	public MyArrayList(FileProcessor fp) {
		myArrayList = new int[50];
		elements = 0;
		size = 50;
	}

	/*
	 * Method used for resizing
	 */
	public void copyArray() {
		tempArray = new int[size];
		int i;
		for (i = 0; i < elements; i++) {
			tempArray[i] = myArrayList[i];
		}
		size = size + (size / 2);
		myArrayList = new int[size];
		for (i = 0; i < elements; i++) {
			myArrayList[i] = tempArray[i];
		}
	}

	/*
	 * Inserts the element and preserves the order
	 */
	public void insertSorted(int value) throws ValueNotInRangeException {
		if (value >= 0 && value <= 10000) {
			if (size == elements) {
				copyArray();
			}
			myArrayList[elements] = value;
			elements++;
			Arrays.sort(myArrayList, 0, elements);
		} else {
			throw new ValueNotInRangeException("Value is not in between 0 and 10000");
		}
	}
	/*
	 * Removes the value and if the value is not present returns -1
	 */
	public int removeValue(int value) throws EmptyListException {
		if (elements != 0) {
			if (indexOf(value) != -1) {
				int len = myArrayList.length;
				int i, j;
				for (i = 0; i < len; i++) {
					if (myArrayList[i] == value) {
						for (j = i; j < len - 1; j++) {
							myArrayList[j] = myArrayList[j + 1];
						}
						elements--;
					}
				}
				return 1;
			} else {
				System.err.println("Value is not present in the ArrayList.");
				return -1;
			}
		} else {
			throw new EmptyListException("Tried to remove from empty list");
		}
	}
	/*
	 * Gives the index of the number in the list
	 */
	public int indexOf(int value) {
		int index = -1;
		for (int i = 0; i < myArrayList.length; i++) {
			if (value == myArrayList[i]) {
				index = i;
				break;
			}
		}
		return index;
	}

	/*
	 * Returns the number of elements present in the list
	 */
	public int size() {
		return elements;
	}

	/*
	 * Returns the sum of the entire arraylist
	 */
	public int sum() {
		int total = 0;
		for (int i = 0; i < elements; i++) {
			total = total + myArrayList[i];
		}
		return total;
	}
	/*
	 * Converts the ArrayList to String
	 */
	public String toString() {
		String formattedString = "";
		for (int i = 0; i < elements; i++) {
			formattedString = formattedString + myArrayList[i] + " ";
		}
		return formattedString;
	}
}
