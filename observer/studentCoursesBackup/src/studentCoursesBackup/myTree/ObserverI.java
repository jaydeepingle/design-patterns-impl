package studentCoursesBackup.myTree;

import studentCoursesBackup.myTree.Node;
/**
 * @author jaydeep
 */
public interface ObserverI {
    /**
     * update function
     * @param s
     */
    public void update(Node node, String course);
}
