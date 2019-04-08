package backupVisitors.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import backupVisitors.myTree.BSTNode;
import backupVisitors.util.FileProcessor;

/**
 * @author sourabh
 *	Identical Records : Groups Identical records according to the courses. 
 */
public class IdenticalRecordsVisitorImpl implements TreeVisitorI {

	private HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
	private FileProcessor fileProcessor = new FileProcessor();
	private String identicalOp = "";

	public IdenticalRecordsVisitorImpl(String identical2) {
		this.identicalOp = identical2;
	}

	@Override
	public void visit(BSTNode node) {
		fileProcessor.openOutputFile(identicalOp);
		insertInGroup(node);
		for (String Key : map.keySet()) {
			if (!Key.isEmpty()) {
				fileProcessor.writeText(Key + " : " + map.get(Key));
			}
		}
		fileProcessor.closeOutputFile();
	}

	private void insertInGroup(BSTNode node) {
		if (node != null) {
			Collections.sort(node.getCourses());
			String Key = node.getCourses().toString();
			if (map.containsKey(Key)) {
				ArrayList<Integer> al = map.get(Key);
				al.add(node.getbNumber());
				map.put(Key, al);
			} else {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(node.getbNumber());
				map.put(Key, al);
			}
			insertInGroup(node.getLeft());
			insertInGroup(node.getRight());
		}
	}

}
