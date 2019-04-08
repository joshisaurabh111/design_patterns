package studentCoursesBackup.myTree;

/**
 * @author sourabh
 *	This is the interface for observer. The observer is called upon one method
 *	ie. update and the observers are updated for any change.
 */
public interface ObserverI {
	
	void Update(String course, int data);
	
}
