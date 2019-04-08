package myArrayList.driver;

import myArrayList.test.MyArrayListTest;
import myArrayList.util.Results;

/**
 * @author sourabh
 *  This class calls the main method and implements functionalities
 *  of other classes and their methods
 */
public class Driver {

	public static void main(String[] args) {
		Results displayFile = new Results();
		MyArrayListTest arrayListTest = new MyArrayListTest(displayFile);
		//FileProcessor fp=new FileProcessor("");
	
		arrayListTest.testMe();
		displayFile.writeToFile();
		displayFile.writeToScreen();
		
	}
}
