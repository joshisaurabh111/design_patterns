package studentCoursesBackup.driver;

import studentCoursesBackup.myTree.BST;
import studentCoursesBackup.util.FileDisplayInterface;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.StdoutDisplayInterface;
import studentCoursesBackup.util.TreeBuilder;

/**
 * @author sourabh This is the driver class that creates objects and invokes
 *         respective methods
 */
public class Driver {

	public static void main(String[] args) {

		// Taking command line input
		String inputFile = null;
		String delFile = null;
		try {
			inputFile = args[0];
			delFile = args[1];
		} catch (Exception e) {
			if (inputFile == null || delFile == null) {
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
		
		// Writing tree to console.
		System.out.println("Main tree:\n");
		consoleOutput.writeToConsole(tree);
		System.out.println("\nFirst Observer:");
		consoleOutput.writeToConsole(builder.cloneTree1);
		System.out.println("\nSecond Observer:");
		consoleOutput.writeToConsole(builder.cloneTree2);

		// Printing the tree to console.
		FileDisplayInterface fileWriter = (FileDisplayInterface) consoleOutput;
		fileWriter.PrintToFile(tree, "mainTree.txt");
		fileWriter.PrintToFile(builder.cloneTree1, "cloneTree1.txt");
		fileWriter.PrintToFile(builder.cloneTree2, "cloneTree2.txt");

		tree.deleteCourses(fileProcessor.processDeleteFile(delFile));

		System.out.println();
		System.out.println();

		// Printing tree and clones after deletion to Console
		System.out.println("Main tree:\n");
		consoleOutput.writeToConsole(tree);
		System.out.println("\nFirst Observer:");
		consoleOutput.writeToConsole(builder.cloneTree1);
		System.out.println("\nSecond Observer:");
		consoleOutput.writeToConsole(builder.cloneTree2);

		// Printing tree and clones after deletion to File
		fileWriter.PrintToFile(tree, "mainTree.txt");
		fileWriter.PrintToFile(builder.cloneTree1, "cloneTree1.txt");
		fileWriter.PrintToFile(builder.cloneTree2, "cloneTree2.txt");

	}
}
