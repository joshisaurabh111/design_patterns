package myArrayList.test;

import myArrayList.MyArrayList;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;

/**
 * @author sourabh
 * All the test cases are defined in this class.
 * The test cases are implemented here and called from driver
 */
public class MyArrayListTest {

	private MyArrayList mal = new MyArrayList();
	private Results results = null;

	public MyArrayListTest(Results results) {
		this.results=results;
	}
	public void testMe() {
		
		// Function calls to the methods implemented below
		// The basicRequirement and 10 test cases. 
		mal.emptyArray();
		results.saveToList("The sum of all the values "
				+ "in the array list is :  " + basicRequirent());
		mal.emptyArray();
		results.saveToList("\n");
		
		boolean rest1 = testCase1();
		results.saveToList("Testing count of elements "
				+ "in the myArrayList  :  " + rest1);
		mal.emptyArray();

		boolean rest2 = testCase2();
		results.saveToList("Testing data input from "
				+ "a file in myArrayList  :  " + rest2);
		
		boolean rest3 = testCase3();
		results.saveToList("Testing empty myArrayList "
				+ "with respect to counter  :  " + rest3);
		mal.emptyArray();

		boolean rest4 = testCase4();
		results.saveToList("Testing removal of elements "
				+ "in an empty myArrayList  :  " + rest4);
		mal.emptyArray();


		boolean rest5 = testCase5();
		results.saveToList("More elements than the "
				+ "myArrayList size (Dynamically expanding array) :"
				+ "  " + rest5);
		mal.emptyArray();

		
		boolean rest6 = testCase6();
		results.saveToList("Testing count of elements "
				+ "in the myArrayList  :  " + rest6);
		mal.emptyArray();


		boolean rest7 = testCase7();
		results.saveToList("Testing change in index "
				+ "after element insertion  :  " + rest7);
		mal.emptyArray();
		
		boolean rest8 = testCase8();
		results.saveToList("Rigorous testing : Random "
				+ "insertions and removals  :  " + rest8);
		mal.emptyArray();

		
		boolean rest9 = testCase9();
		results.saveToList("Testing sum of elements "
				+ "after insertions and removals  :  " + rest9);
		mal.emptyArray();

		
		boolean rest10 = testCase10();
		results.saveToList("Testing maintaining indexes "
				+ "after sorting  :  " + rest10);
		//mal.emptyArray();
		
	}

	public int basicRequirent(){
		
		// Prints the sum of all the inserted elements
		int sum=0;
		mal.insertSorted(10);
		mal.insertSorted(24);
		mal.insertSorted(34);
		sum = mal.sumOfElements();
		return sum;
	}
	
	public boolean testCase1() {
		
		// Test case to show number of elements in the myArrayList
		// Inserted 3 elements :
		// makeSure variable is used to get boolean result of the 
		// test case either true or false 

		Boolean makeSure;
		mal.insertSorted(1);
		mal.insertSorted(1);
		mal.insertSorted(1);
		// Expected count is 3
		int expectedValue = 3;
		// Compare number of elements
		if (expectedValue == MyArrayList.counter) {
			makeSure = true;
		} else {
			makeSure = false;
		}
		return makeSure;
	}
		
	public boolean testCase2() {

		// Inputs data in the array from a file (input.txt)
		FileProcessor fileProcessor = new FileProcessor("testing.txt");
	//	System.out.println("After File processor");

		//Enters Data till the end of file
		Integer i = null;
		try{
			do {
				i = fileProcessor.readData();
				if (i != null)
					mal.insertSorted(i);
			} while (i != null);
			return true;
		}catch(Exception ex){
			//System.out.println("Error in insertion of data.");
			return false;
		}		
	}

	public boolean testCase3() {

		// Testing myArrayList empty function with respect to counter 
		// Once the array list is empty the counter resets to 0
		mal.emptyArray();
		if (MyArrayList.counter == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean testCase4() {
		//Removing an element from empty list
		Boolean makeSure = false;
		mal.emptyArray();
		try{
			mal.removeValue(5);
			//System.out.println("Working");
			makeSure = true;
		}catch (Exception e) {
			makeSure = false;
		}
		return makeSure;
	}
	
	public boolean testCase5(){
		// Inserting elements more than the array size
		boolean makeSure = false;
		int sum=0;
	//	System.out.println(MyArrayList.counter);
		for (int i = 0; i < 75; i++) {
			mal.insertSorted(1);
		}
	//	System.out.println(MyArrayList.counter);
		mal.toString();
		sum = mal.sumOfElements();
		System.out.println("sum of elements = "+ sum);
		if(MyArrayList.counter == 75)
			makeSure = true; 
				
		return makeSure;
	}
	
	public boolean testCase6() {
		
		//Index of a non-existing element
		boolean makeSure = false;
		int index =0;
		int expectedValue= -1;
		index = mal.indexOf(5);
		if(index == expectedValue)
			makeSure = true;
		
		return makeSure;
		
	}
	
	public boolean testCase7() {
		//Change in index after sorting
		int currentIndex=0, afterIndex=0;
		boolean makeSure = false;
		mal.insertSorted(12);
		currentIndex = mal.indexOf(12);
		mal.insertSorted(5);
		afterIndex = mal.indexOf(12);
		if(currentIndex != afterIndex && afterIndex != 0)
			makeSure = true;
			
		return makeSure;
	}


	public boolean testCase8() {
		
		boolean makeSure = true;
		// Rigorous testing inserting and removing 
		// random 100 numbers
		for(int i=0; i<1000; i++)
		{
			mal.insertSorted((int) (Math.random()*100));			
		}
		
		// Elements might be removed that don't exist
		// But it won't throw and error
		for(int i=0; i<1000; i++)
		{
			mal.removeValue((int) (Math.random()*100));					
		}

		return makeSure;
	}
	
	public boolean testCase9() {
		
		// Insert and remove combined with sum
		int expectedResult =50;
		boolean makeSure = false;
		
		mal.insertSorted(10);
		mal.insertSorted(20);
		mal.removeValue(10);
		mal.insertSorted(30);
		// Also removing a non existing value
		mal.removeValue(10);
		mal.removeValue(30);
		mal.insertSorted(30);
		int sum = mal.sumOfElements();
		if(sum == expectedResult)
			makeSure = true;
		return makeSure;
	}
	
	public boolean testCase10() {
		
		// getting first index of a multiple instance of a value
		boolean makeSure = false;
		int expectedValue = 3, receivedValue=0;
		mal.insertSorted(20);
		mal.insertSorted(40);		
		mal.insertSorted(20);
		mal.insertSorted(10);
		receivedValue = mal.indexOf(40);
		if(expectedValue == receivedValue)
			makeSure = true;
		
		return makeSure;
	}
	
}
