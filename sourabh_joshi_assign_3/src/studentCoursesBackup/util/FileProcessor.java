package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author sourabh
 *	FileProcessor does all the processing of files.
 *	Input file, reading parsing operations are done here.
 */
public class FileProcessor {

	//private String inputFile = null;
	//private String delInput = null;
	private String fileName = "";
	private BufferedReader bufferedReader = null;

	public void openFile(String input) {
		this.fileName = input;
		try {

			File file = new File(this.fileName);
			FileReader fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
		} catch (Exception e) {
			System.out.println("File not found");
			System.exit(1);
		}
	}

	public String readFile() {
		String st = null;
		try {
			while ((st = bufferedReader.readLine()) != null) {
			//	System.out.println(st);
				return st;
			}
		} catch (IOException e) {
			System.out.println("Error reading file. Skipped");
		}
		return null;
	}
	
	public void closeFile()
	{
		try{
		bufferedReader.close();
		bufferedReader = null;
		}
		catch(IOException ioex) {}
	}
	
	
	public ArrayList<String> processDeleteFile(String fileName)
	{
		ArrayList<String> deleteEntries = new ArrayList<String>();
		this.openFile(fileName);
		String str = null;
		while((str = readFile()) != null)
			deleteEntries.add(str);
		this.closeFile();
		return deleteEntries;
	}
/*	
	public void writeToFile(String outputFile) {
		File file = new File(outputFile);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(str);

	}
*/
}
