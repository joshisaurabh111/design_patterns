package studentCoursesBackup.myTree;

import java.util.ArrayList;

/**
 * @author sourabh
 *	Citation : BST implementation taken from online reference : 
 *	URL : http://www.sanfoundry.com/java-program-implement-binary-search-tree/
 *	This is node implementation.
 */
public class BSTNode implements SubjectI, ObserverI {

    BSTNode left, right;
    Integer bNumber;
	String course;
	ArrayList<ObserverI> observers = new ArrayList<ObserverI>();
    /* Constructor */

    public BSTNode()
    {
    	left = null;
        right = null;
        bNumber = 0;
        course  = null;
    }
    /* Constructor */
    
    public BSTNode(int num, String courseData)
    {
        left = null;
        right = null;
        bNumber = num;
        course = courseData;
    }
    
    public void deleteAndUpdate(String course)
    {
    	//System.out.println("deleting course : " + course + "current course = " + this.course);
    	if(this.course.equalsIgnoreCase(course))
    	{
    		System.out.println("\ndeleting course : " + course);
    		this.setCourse("");
    	}
    }

    /* Function to set left node */

    public void setLeft(BSTNode n)
    {
        left = n;
    }
    /* Function to set right node */ 

    public void setRight(BSTNode n)
    {
        right = n;
    }
    /* Function to get left node */

    public BSTNode getLeft()
    {
        return left;
    }
    /* Function to get right node */

    public BSTNode getRight()
    {
        return right;
    }
    /* Function to set data to node */

    public void setData(Integer num, String courseData)
    {
    	bNumber = num;
    	course = courseData;
    }
    /* Function to get data from node */

    public String getData()
    {
    	return this.bNumber.toString() + ":" + course; 
    }    
    
    public Integer getbNumber() {
		return bNumber;
	}

	public void setbNumber(Integer bNumber) {
		this.bNumber = bNumber;
		Notify();
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
		Notify();
	}

	@Override
	public void Update(String course, int data) {
		//	Logic of what to do after receiving updates.
		this.course = "-";
	}
	
	public void Notify()
	{
		//	Update all the observers through notify.
		for(ObserverI obs : this.observers)
		{
			obs.Update(course, bNumber);
		}
	}

	@Override
	public void Subscribe(ObserverI observer)
	{
	//	System.out.println("Subject = " + this.hashCode() + " Observer = " + observer.hashCode());
		this.observers.add(observer);
	}

}
