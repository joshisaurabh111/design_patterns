package backupVisitors.util;

import backupVisitors.myTree.BST;

/**
 * @author sourabh
 *	FileDisplayInterface has a method implemented in Results for writing 
 *	the output to the file. 
 */
public interface FileDisplayInterface {
	void PrintToFile(BST tree, String fileName);
}