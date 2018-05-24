package studentCoursesBackup.myTree;

import java.util.ArrayList;

/**
 * @author jaydeep
 */
public class Node implements ObserverI, subjectI, Cloneable {
    public int bNumber;
    public ArrayList<String> courses;
    public String course;
    public String[] validCourses;
    public Node left, right, parent;
    public ArrayList<Node> backupList;

    /**
     * Constructor
     */
    public Node() {
        this.bNumber = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.course = "";
        this.courses = new ArrayList<String>();
        this.backupList = new ArrayList<Node>();
    }

    /**
     * Parameterized Constructor
     * @param bNumber
     * @param course
     */
    public Node(int bNumber, String course) {
        this.bNumber = bNumber;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.course = course;
        this.courses = new ArrayList<String>();
        this.backupList = new ArrayList<Node>();

        this.bNumber = bNumber;
        this.courses.add(course);
    }

    /**
     * getter for bNumber
     * @return bNumber
     */
    public int getBNumber() {
        return this.bNumber;
    }

    /**
     * setter for bNumber
     * @param bNumber
     */
    public void setBNumber(int bNumber) {
        this.bNumber = bNumber;
    }

    /**
     * getter for arrayList
     * @return
     */
    public ArrayList<String> getCourses() {
        return this.courses;
    }

    /**
     * getter for courses
     * @param courses
     */
    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    /**
     * Update function
     * @param s
     */
    public void update(Node node, String course) {
        if(node.courses.contains(course)) {
            node.courses.remove(course);
        }
    }

    /**
     * Function to register observer
     * @param observer
     */
    public void registerObserver(Node observer) {
        backupList.add(observer);
    }

    /**
     * Function to deregister observer
     * @param observer
     */
    public void deregisterObserver(Node observer) {
        if(backupList.contains(observer)) {
            backupList.remove(observer);
        }
    }

    /**
     * The method should be called in the observer
     * @param course
     */
    public void notifyAll(String course) {
        for(Node node: backupList) {
            update(node, course);
        }
    }

    /**
     * Function to clone Node Class Object
     */
    public Object clone() {
        return new Node(bNumber, course);
    }

}