package myArrayList;

import java.util.Arrays;

/**
 * @author sourabh My array list class that stores an array and implements
 *         function on the same
 */
public class MyArrayList {

	// Private array and a counter for number of elements
	private int[] arr;
	public static int counter = 0;

	public MyArrayList() {

		// Default constructor that initializes all array locations
		// to maximum integer value
		arr = new int[50];
		for (int i = 0; i < 50; i++) {
			arr[i] = Integer.MAX_VALUE;
		}
	}

	// array getter.
	public int[] getArr() {
		return arr;
	}

	public void insertSorted(int number) {

		// Inserts provided elements and sorts them in
		// ascending order
		if (counter < arr.length) {
			arr[counter++] = number;
			Arrays.sort(arr);

			// If the inserted number of elements exceeds the array size
			// then array gets expanded.
		} else {
			int temp = arr.length;
			int[] newArr = new int[arr.length + 50];
			newArr = Arrays.copyOf(arr, arr.length + 50);
			arr = newArr;

			for (int i = temp; i < arr.length; i++) {
				arr[i] = Integer.MAX_VALUE;
			}

			// System.out.println("array length increased");
			if (counter < arr.length) {
				arr[counter++] = number;
				Arrays.sort(arr);
			}
		}

	}

	public void removeValue(int value) {

		// removing a value from array
		for (int i = 0; i < counter; i++) {
			if (arr[i] == value) {
				// System.out.println(arr[i] + " values is removed.");
				arr[i] = Integer.MAX_VALUE;
				counter--;
			}
		}
		Arrays.sort(arr);
	}

	public int sumOfElements() {

		// returns a sum of all elements in the array 
		int sum = 0;
		for (int j = 0; j < counter; j++)
			sum = sum + arr[j];

		return sum;
	}

	public int indexOf(int value) {

		// Prints the first found elements index
		int indexes = -1;
		for (int i = 0; i < counter; i++) {
			if (arr[i] == value) {
				indexes = i;
			}
		}
		return indexes;
	}

	public int size() {

		//Returns the filled size of the array
		return counter;

	}

	public String toString() {
		
		// Prints the array with tab spaces
		System.out.println("The array contains following " + "elements : " + "\n");
		for (int i = 0; i < counter; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n");
		return null;
	}

	/*
	 * public void printFullArray() {
	 * System.out.println("The array contains following " + "elements : " +
	 * "\n"); for (int i = 0; i < arr.length; i++) { System.out.print(arr[i] +
	 * "\t"); } System.out.println("\n"); }
	 */
	
	public void emptyArray() {

		// Removes all elements from the array
		// System.out.println("Currently noOfElements = " + counter);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.MAX_VALUE;
			counter = 0;
		}
		// System.out.println("Now the noOfElmenets = " + counter);
		// System.out.println("The myArrayList is empty.");
	}

}
