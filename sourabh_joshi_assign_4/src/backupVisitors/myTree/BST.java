package backupVisitors.myTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import backupVisitors.visitor.TreeVisitorI;

/**
 * @author sourabh Citation taken from online reference : URL :
 *         http://www.sanfoundry.com/java-program-implement-binary-search-tree/
 *         Bst opertation are displayed in this class.
 */
public class BST {

	private BSTNode root;
	// private ChildBSTNode newNode = null;
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
		BSTNode tNode = insert(root, data, courseData);
		if (root == null)
			root = tNode;
		return tNode;
	}

	public void print(BSTNode node) {
		// System.out.println("Printing.");
		// inorder(node);
		// System.out.println(node.getbNumber() + " : " + node.getCourse());
		System.out.println(node);
		// displayNode(this.root);
	}

	public void setFileName(String fileName) {
		this.outputFileName = fileName;
	}

	// Tree traversal with respect to operation writing to file
	// or simple traversal
	public void traverseBST(int operation) {

		if (operation == 2) {
			try {
				File f = new File(this.outputFileName);
				FileWriter fileWriter = new FileWriter(f);
				bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write("Binary Tree\n\n");
				traverseBST(this.root, operation);
				bufferedWriter.close();
				fileWriter.close();
			} catch (IOException ioex) {
			}
		} else {
			traverseBST(this.root, operation);
		}
	}

	private void traverseBST(BSTNode node, int operation) {
		if (node != null) {
			traverseBST(node.getLeft(), operation);
			if (operation == 1)
				print(node);
			else if (operation == 2)
				writeToFile(node);
			traverseBST(node.getRight(), operation);
		}
	}

	public void writeToFile(BSTNode node) {
		try {
			bufferedWriter.write(node + "\n");
		} catch (IOException ioex) {
		}
	}

	/* Function to insert data recursively */

	private BSTNode insert(BSTNode node, Integer data, String courseData) {

		BSTNode tempNode = search(node, data);
		if (tempNode == null) {
			// this.newNode = (ChildBSTNode) (tempNode = new ChildBSTNode(data,
			// courseData));
			List<BSTNode> tList = new ArrayList<BSTNode>();
			node = insertHelper(node, data, courseData, tList);
			tempNode = tList.get(0);
		} else {
			List<String> searchList = tempNode.getCourses();
			if (searchList.contains(courseData)) {

			} else {
				List<String> tempList = new ArrayList<String>(searchList);
				tempList.add(courseData.toUpperCase());
				tempNode.setCourses(tempList);
			}
		}
		return tempNode;
	}

	private BSTNode insertHelper(BSTNode node, Integer data, String courseData, List<BSTNode> tList) {

		if (node == null) {
			node = new BSTNode(data, courseData);
			tList.add(node);
			return node;
		}

		/* Otherwise, recur down the tree */
		if (data < node.getbNumber())
			node.setLeft(insertHelper(node.getLeft(), data, courseData, tList));
		else if (data > node.getbNumber())
			node.setRight(insertHelper(node.getRight(), data, courseData, tList));
		/* return the (unchanged) node pointer */
		// newNode = node;
		return node;
	}

	/* Function to count number of nodes recursively */
	public int countNodes(BSTNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.getLeft());
			l += countNodes(r.getRight());
			return l;
		}
	}

	private void delete(BSTNode tempNode, String courseData) {
		List<String> searchList = tempNode.getCourses();
		if (searchList.contains(courseData.toUpperCase())) {
			List<String> tempList = new ArrayList<String>(searchList);
			tempList.remove(courseData);
			tempNode.setCourses(tempList);
		}
	}
	
	private void deleteWrapper(Integer bNumber, String courseData){
		BSTNode tempNode = search(root, bNumber);
		delete(tempNode, courseData);
	}
	

	public void deleteCourses(List<String> courses) {
		for (String course : courses)
			deleteWrapper(Integer.parseInt((course.split(":")[0])), course.split(":")[1]);
	}

	/* Functions to search for an element */
	/*
	 * private boolean searchAndDeleteCourse(int val, String course) {
	 * ChildBSTNode nodeOfInterest = search(root, val); if (nodeOfInterest ==
	 * null) System.out.println("Invalid Bnumber/course .!"); else
	 * nodeOfInterest.deleteAndUpdate(course); return false; }
	 */
	/* Function to search for an element recursively */
	public BSTNode search(BSTNode r, int val) {
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

	public void inorder() {
		inorder(root);
	}

	private void inorder(BSTNode r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r);
			inorder(r.getRight());
		}
	}
	
	public void accept(TreeVisitorI i){
		i.visit(root);
	}

}