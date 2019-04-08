package backupVisitors.myTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sourabh
 *	This class implements node structure and getter setter methods.	
 *
 */
public class BSTNode implements SubjectI, ObserverI{

	private BSTNode left, right;
	private int bNumber;
	private List<ObserverI> observers = new ArrayList<ObserverI>();
	private List<String> courses = new ArrayList<String>();
	
	
	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
		notifyObs();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for(String str : this.courses){
			sb.append(str + " ");
		}
		
		return (this.bNumber + " : " + sb);
	}
	
	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}



	public BSTNode(Integer data, String courseData) {
		left = null;
		right = null;
		bNumber = data;
		courses.add(courseData);
	}

	public BSTNode() {
		left = null;
		right = null;
		bNumber = 0;
		courses.add(null);
	}

	
	@Override
	public void updateObs(List<String> courses, int data) {
		// Logic of what to do after receiving updates.
		this.courses = courses;
	}

	public void notifyObs() {
		// Update all the observers through notify.
		for (ObserverI obs : this.observers) {
			obs.updateObs(courses, bNumber);
		}
	}

	@Override
	public void subscribeObs(ObserverI observer) {
		// System.out.println("Subject = " + this.hashCode() + " Observer = " +
		// observer.hashCode());
		this.observers.add(observer);
	}

	public List<ObserverI> getObservers() {
		return observers;
	}

	public void setObservers(List<ObserverI> observers) {
		this.observers = observers;
	}

	public int getbNumber() {
		return bNumber;
	}

}
