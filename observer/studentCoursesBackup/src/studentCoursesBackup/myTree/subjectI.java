package studentCoursesBackup.myTree;

import studentCoursesBackup.myTree.Node;

/**
 * @author jaydeep
 */
public interface subjectI {
    /**
     * Function to register observer
     * @param observer
     */
    public void registerObserver(Node observer);

    /**
     * Function to deregister observer
     * @param observer
     */
    public void deregisterObserver(Node observer);

    /**
     * Function to notify the observers
     * @param course
     */
    public void notifyAll(String course);
}