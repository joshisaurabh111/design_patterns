package studentCoursesBackup.myTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author sourabh Citation taken from online reference : URL :
 *         http://www.sanfoundry.com/java-program-implement-binary-search-tree/
 *			Bst opertation are displayed in this class.
 */
public class BST {

	private BSTNode root;
	private BSTNode newNode = null;
	private String outputFileName = "";
	private BufferedWriter bufferedWriter = null;

	/* Constructor */
	public BST() {
		root = null;
	}

	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	/* Functions to insert data */
	public BSTNode insert(int data, String courseData) {
		root = insert(root, data, courseData);
		return newNode;
	}

	public void print(BSTNode node) {
		// System.out.println("Printing.");
		System.out.println(node.getCourse() + " : " + node.getbNumber());
		// displayNode(this.root);
	}
	
	public void setFileName(String fileName)
	{
		this.outputFileName = fileName;
	}

	// Tree traversal with respect to operation writing to file 
	// or simple traversal
	public void traverseBST(int operation) {
		
		if (operation == 2) {
			try{
			File f = new File(this.outputFileName);
			FileWriter fileWriter = new FileWriter(f);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Binary Tree\n\n");
			traverseBST(this.root, operation);
			bufferedWriter.close();
			fileWriter.close();
			}catch(IOException ioex) {}
		}
		else 
		{
			traverseBST(this.root, operation);
		}
	}

	private void traverseBST(BSTNode node, int operation) {
		if (node != null) {
			if (operation == 1)
				print(node);
			else if (operation == 2)
				writeToFile(node);
			traverseBST(node.left, operation);
			traverseBST(node.right, operation);
		}
	}

	public void writeToFile(BSTNode node) {
		try{
			bufferedWriter.write(node.bNumber + ":" + node.course + "\n");
		}
		catch(IOException ioex){} 
	}

	/* Function to insert data recursively */

	private BSTNode insert(BSTNode node, Integer data, String courseData) {
		if (node == null)
			this.newNode = node = new BSTNode(data, courseData);
		else {
			if (data <= node.getbNumber())
				node.left = insert(node.left, data, courseData);
			else
				node.right = insert(node.right, data, courseData);
		}

		return node;
	}

	/* Functions to count number of nodes */
	public int countNodes() {
		return countNodes(root);
	}

	/* Function to count number of nodes recursively */
	private int countNodes(BSTNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.getLeft());
			l += countNodes(r.getRight());
			return l;
		}
	}

	public void deleteCourses(ArrayList<String> courses)
	{
		for(String course: courses)
			searchAndDeleteCourse(Integer.parseInt(course.split(":")[0]),course.split(":")[1]);  
	}
	
	/* Functions to search for an element */
	private boolean searchAndDeleteCourse(int val, String course) {
		BSTNode nodeOfInterest = search(root, val);
		if (nodeOfInterest == null)
			System.out.println("Invalid Bnumber/course .!");
		else
			nodeOfInterest.deleteAndUpdate(course);
		return false;
	}

	/* Function to search for an element recursively */
	private BSTNode search(BSTNode r, int val) {
		while (r != null) {
			int rval = r.getbNumber();
			if (val < rval)
				r = r.getLeft();
			else if (val > rval)
				r = r.getRight();
			else
				return r;
			// found = search(r, val);
		}
		return null;
	}
}
