package backupVisitors.visitor;

import backupVisitors.myTree.BSTNode;

/**
 * @author sourabh
 *	Interface for all the Visitor methods.
 */
public interface TreeVisitorI {

	void visit(BSTNode node);
	
}
