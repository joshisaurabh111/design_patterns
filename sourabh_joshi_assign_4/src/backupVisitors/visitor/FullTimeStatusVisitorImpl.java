package backupVisitors.visitor;

import java.util.ArrayList;
import java.util.List;

import backupVisitors.myTree.BSTNode;

/**
 * @author sourabh
 *	Full Time Status : This Visitor adds a course "S" when number of courses are less
 *	than 3. Else not adding any courses
 */
public class FullTimeStatusVisitorImpl implements TreeVisitorI {

	private void traverseBST(BSTNode node) {
		if (node != null) {
			if(node.getCourses().size() < 3){
				List<String> tempList = new ArrayList<String>(node.getCourses());
				tempList.add("S");
				node.setCourses(tempList);
			}
			System.out.println(node);
			traverseBST(node.getLeft());
			traverseBST(node.getRight());
		}
	}

	@Override
	public void visit(BSTNode node) {
		System.out.println("\n\nFullTime Status Visitor visiting : \n");
		traverseBST(node);		
	}

}