package backupVisitors.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import backupVisitors.myTree.BSTNode;

/**
 * @author sourabh FileProcessor does all the processing of files. Input file,
 *         reading parsing operations are done here.
 *         Writing operations and output file processing. 
 */
public class FileProcessor {

	// private String inputFile = null;
	// private String delInput = null;
	private String fileName = "";
	private String outputFileName = "";
	private BufferedReader bufferedReader = null;
	private BufferedWriter bufferedWriter = null;

	/* File Reading Code */
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
				// System.out.println(st);
				return st;
			}
		} catch (IOException e) {
			System.out.println("Error reading file. Skipped");
		}
		return null;
	}

	public void closeFile() {
		try {
			bufferedReader.close();
		} catch (IOException ioex) {
		}
	}

	/**************************************************************************************************/
	/* File Writing Code */

	public void openOutputFile(String output) {
		this.outputFileName = output;
		try {

			File file = new File(outputFileName);
			FileWriter fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
		} catch (Exception e) {
			System.out.println("File not found");
			System.exit(1);
		}
	}

	public void writeText(String text) {
		try {
			bufferedWriter.write(text + "\n");
		} catch (IOException e) {
			System.out.println("Error Writing to File");
		}
	}

	public void writeFile(BSTNode node) {
		try {
			bufferedWriter.write(node + "\n");
		} catch (IOException e) {
			System.out.println("Error Writing to File");
			System.exit(1);
		}
	}

	public void closeOutputFile() {
		try {
			bufferedWriter.close();
		} catch (IOException ioex) {
		}
	}

	/*********************************************************************************************/

	public List<String> processDeleteFile(String fileName) {
		ArrayList<String> deleteEntries = new ArrayList<String>();
		this.openFile(fileName);
		String str = null;
		while ((str = readFile()) != null)
			deleteEntries.add(str);
		this.closeFile();
		return deleteEntries;
	}
	/*
	 * public void writeToFile(String outputFile) { File file = new
	 * File(outputFile); FileWriter fileWriter = new FileWriter(file);
	 * fileWriter.write(str);
	 * 
	 * }
	 */
}