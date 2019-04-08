package fileProcessorDecorator.fileOperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {

	private FileReader fileReader = null;
	private BufferedReader br = null;
	private FileWriter fileWriter =  null;
	private BufferedWriter bw =  null;  
	
/*******************************************************************/
	// Reading from an input file
	
	public void getInputFileName(String inputName) {

		try {
			File iFile = new File(inputName);
			fileReader = new FileReader(iFile);
			br = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			System.out.println("File Reading Error ..!!");
			System.exit(1);
		}
	}

	public String readInputFile() {
		String st = "";
		try {
			while ((st = br.readLine()) != null) {
				return st;
			}
			
		} catch (IOException e) {
			System.out.println("Data reading error");
			System.exit(1);
		}
		return null;
	}
	
	public void closeInputFile(){
		try {
			br.close();
			fileReader.close();
		} catch (IOException e) {
			System.out.println("File Closing Error");
			System.exit(1);
		}
	}
	
/*******************************************************************/
	// Writing to output file:

	public void getOuputFileName(String outputName) {

		try {
			File oFile = new File(outputName);
			if (!oFile.exists()) {
				oFile.createNewFile();
			}
			fileWriter = new FileWriter(oFile, true);
			bw = new BufferedWriter(fileWriter);
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("File Reading Error ..!!");
			System.exit(1);
		}
	}

	public String writeOutputFile(String st) {

		try {
			if(st != null) {
				//System.out.println(st + "Hello");
				bw.write(st + "\n");
			}
		} catch (IOException e) {
			System.out.println("Data Writing error");
			System.exit(1);
		}
		return null;
	}
	
	public void closeOutputFile(){
		try {
			bw.close();
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("File Closing Error");
			System.exit(1);
		}
	}
	
}
