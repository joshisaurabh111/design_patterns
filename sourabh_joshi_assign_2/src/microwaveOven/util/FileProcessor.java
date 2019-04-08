package microwaveOven.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sourabh
 * The Fileprocessor class implements the logic for reading a file
 * contents and storing them for the other classes for use.
 *
 */
public class FileProcessor {

	private String fileName = "";
	private BufferedReader br = null;

	public FileProcessor(String input){
		this.fileName = input;
		try {
			File inputFile = new File(fileName);
			//System.out.println("got filename " + fileName);
			FileReader fileReader;
			fileReader = new FileReader(inputFile);
			br = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			System.out.println("File not found..!!");
			System.exit(1);
		}
	}
	
	public String readFile() {
		try {

			String st = "";
			while ((st = br.readLine()) != null) {
			//	System.out.println(st);
				return st;
			}

		}catch (IOException ioe) {
			System.out.println("Problem with BufferedReader");
		}
		 return null;
	}

}