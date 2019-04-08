package microwaveOven.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sourabh
 * Singleton instance of results. Class also contains functions to
 * save to and array list, display result to console and write result 
 * to a file.
 *
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private List<String> resList = null;

	// Singleton instance of Results created since it has to be used in
	// many classes to grab output for writing file
	private static Results resultInstance;
	
	public static Results getInstance() {
		if(resultInstance == null)
		{
			resultInstance = new Results();
		}
		return resultInstance;
	}
	
	// constructor to create new result list
	private Results() {
		resList = new ArrayList<String>();
	}

	public void saveToList(String s) {
		resList.add(s);
	//	System.out.println(s);
	}

	@Override
	public void DisplayToConsole() {
		// Prints out the output to screen
		for (String str1 : resList) {
			System.out.println(str1);
		}

	}

	@Override
	public void WriteToFile(String fileName) {

		// File object creation and passing output file path
		File OFile = new File(fileName);
		try {
			if (!OFile.exists()) {
				OFile.createNewFile();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
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

}
