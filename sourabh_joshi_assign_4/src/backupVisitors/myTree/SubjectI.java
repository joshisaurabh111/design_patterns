package backupVisitors.myTree;

/**
 * @author sourabh
 *	This is the Subject interface. Subject has to subscribe observers,
 *	as many it wants, so they have the ability to be notified and updated
 */
public interface SubjectI {
	
	void subscribeObs(ObserverI observer);
}