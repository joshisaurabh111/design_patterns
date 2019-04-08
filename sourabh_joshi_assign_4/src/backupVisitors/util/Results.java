package backupVisitors.util;

import backupVisitors.myTree.BST;

/**
 * @author sourabh The class processes all the results and implements 2result
 *         producing interfaces FileDisplayInterface, StdoutDisplayInterface
 */

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	// File printing method
	@Override
	public void PrintToFile(BST tree, String fileName) {
		tree.setFileName(fileName);
		tree.traverseBST(2);
	}

	// Writing to console
	@Override
	public void writeToConsole(BST tree) {
		// System.out.println("Tree:\n");
		tree.traverseBST(1);
	}
}