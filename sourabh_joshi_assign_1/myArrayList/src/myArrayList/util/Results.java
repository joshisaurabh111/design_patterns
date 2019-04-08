package myArrayList.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sourabh
 *	Implements 2 methods writeToFile and writeToScreen
 *	The first one output's contents to a file
 *	The second one prints stuff on Console 
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private List<String> resList = null;

	// constructor to create new result list
	public Results() {
		resList = new ArrayList<String>();
	}

	// method accepts string and stores in the result list
	public void saveToList(String s) {
		resList.add(s);
	}

	@Override
	public void writeToFile() {

		// File object creation and passing output file path
		File OFile = new File("output.txt");
		if (!OFile.exists()) {
			try {
				OFile.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		// Creating a file writer
		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(OFile);
			// System.out.println("Writer created");

			// Writing each line to the file
			for (String str : resList) {
				fileWriter.write(str + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void writeToScreen() {
		
		// Prints out the output to screen
		for (String str1 : resList){
			System.out.println(str1 + " \n");
		}

	}

}
