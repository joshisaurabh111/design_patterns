package myArrayList.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sourabh
 *	File input operations are done from here
 * 	Also reading of 
 */
public class FileProcessor {

	private BufferedReader br = null;

	public FileProcessor(String fIPath) {
		
		// constructor to get file path and handle 
		// no file present exception
		try {
			File file = new File(fIPath);
			FileReader fileReader;
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
		} catch (FileNotFoundException fe) {
			System.out.println("No such file OR Worng name");
		}
	}

	public Integer readData() throws NumberFormatException{
		
		// Reading of data or input from file
		try {
			String sNumber = "";
			 while((sNumber=br.readLine()) != null){
				 Integer number = Integer.parseInt(sNumber);
				 return number;
			 }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException ne) {
			System.out.println("Input is not a number ( " 
					+ ne.getMessage() + " )");
		}
		return null;
	}

}
