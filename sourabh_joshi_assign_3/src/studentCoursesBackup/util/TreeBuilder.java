package studentCoursesBackup.util;

import studentCoursesBackup.myTree.BST;
import studentCoursesBackup.myTree.BSTNode;
import studentCoursesBackup.myTree.ObserverI;

/**
 * @author sourabh
 *	This class creates and clones trees from the BSTNode and other classes
 */
public class TreeBuilder {

	BSTNode bstNode = new BSTNode();
	FileProcessor fp = null;
	public BST cloneTree1 = null, cloneTree2 = null;
	
	public TreeBuilder(FileProcessor fileProcessor) {
		this.fp = fileProcessor;
	}
	
	// Creating main tree and clone trees
	public BST buildTree()
	{
		BST tree = new BST();
		BST cloneTree1 = new BST();
		BST cloneTree2 = new BST();
		String st = "";
		while((st = fp.readFile()) != null){
			String[] stringData = st.split(":");
			BSTNode node = tree.insert(Integer.parseInt(stringData[0]), stringData[1]);
			BSTNode clone1 = cloneTree1.insert(Integer.parseInt(stringData[0]), stringData[1]);
			BSTNode clone2 = cloneTree2.insert(Integer.parseInt(stringData[0]), stringData[1]);
			node.Subscribe((ObserverI)clone1);
			node.Subscribe((ObserverI)clone2);	
		}
		this.cloneTree1 = cloneTree1;
		this.cloneTree2 = cloneTree2;
		return tree;
	}
}
