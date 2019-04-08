package backupVisitors.driver;

import java.util.List;

import backupVisitors.myTree.BST;
import backupVisitors.util.FileDisplayInterface;
import backupVisitors.util.FileProcessor;
import backupVisitors.util.Results;
import backupVisitors.util.StdoutDisplayInterface;
import backupVisitors.util.TreeBuilder;
import backupVisitors.visitor.FullTimeStatusVisitorImpl;
import backupVisitors.visitor.IdenticalRecordsVisitorImpl;
import backupVisitors.visitor.SortedRecordsVisitorImpl;
import backupVisitors.visitor.StatsVisitorImpl;
import backupVisitors.visitor.TreeVisitorI;

/**
 * @author sourabh
 *	Driver code to create objects and implement respective methods. 
 *
 */
public class Driver {

	public static void main(String[] args) {

		// Taking command line input
		String inputFile = "";
		String delFile = "";
		String sorted = "";
		String stats = "";
		String identical = "";
		try {
			inputFile = args[0];
			delFile = args[1];
			sorted = args[2];
			stats =  args[3];
			identical = args[4];
		} catch (Exception e) {
			if (inputFile==null || delFile==null || sorted==null || stats==null || identical==null) {
				System.out.println("Invalid input.Exiting Program!");
				System.exit(1);
			}
		}

		StdoutDisplayInterface consoleOutput = new Results();
		FileProcessor fileProcessor = new FileProcessor();
		fileProcessor.openFile(inputFile);

		TreeBuilder builder = new TreeBuilder(fileProcessor);
		BST tree = builder.buildTree();
		fileProcessor.closeFile();
		FileDisplayInterface fileWriter = (FileDisplayInterface) consoleOutput;
		
		// Printing to Console
		consolePrinting(builder, tree, consoleOutput);
		// Printing the tree to console.
		filePrinting(fileWriter, builder, tree);

		List<String> deleteList = fileProcessor.processDeleteFile(delFile);
		tree.deleteCourses(deleteList);
		System.out.println("\n\n");

		consolePrinting(builder, tree, consoleOutput);
		filePrinting(fileWriter, builder, tree);
		
		TreeVisitorI i = new FullTimeStatusVisitorImpl();
		tree.accept(i);
		
		consolePrinting(builder, tree, consoleOutput);

		TreeVisitorI i2 = new SortedRecordsVisitorImpl(sorted);
		tree.accept(i2);
		
		TreeVisitorI i3 = new StatsVisitorImpl(stats);
		tree.accept(i3);
		
		TreeVisitorI i4 = new IdenticalRecordsVisitorImpl(identical);
		tree.accept(i4);
		
	}

	public static void consolePrinting(TreeBuilder builder, BST tree, StdoutDisplayInterface consoleOutput) {
		// Writing tree to console.
		System.out.println("Main tree:\n");
		consoleOutput.writeToConsole(tree);
		System.out.println("\nFirst Observer:");
		consoleOutput.writeToConsole(builder.cloneTree1);
		System.out.println("\nSecond Observer:");
		consoleOutput.writeToConsole(builder.cloneTree2);
	}
	
	public static void filePrinting(FileDisplayInterface fileWriter, TreeBuilder builder, BST tree){
		// Printing tree and clones after deletion to File
				fileWriter.PrintToFile(tree, "mainTree.txt");
				fileWriter.PrintToFile(builder.cloneTree1, "cloneTree1.txt");
				fileWriter.PrintToFile(builder.cloneTree2, "cloneTree2.txt");
	}
}
