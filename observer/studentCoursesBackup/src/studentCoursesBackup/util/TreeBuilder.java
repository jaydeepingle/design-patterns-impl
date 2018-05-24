package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.Results;

import java.util.ArrayList;

public class TreeBuilder {
    // Variables
    public Node rootNode;
    public String treePrint;

    /**
     * Constructor Function
     */
    public TreeBuilder() {
        rootNode = null;
        treePrint = "";
    }

    /**
     * Function to insert node
     * @return Node Class object
     */
    public Node insertNode(Node node) {
        rootNode = insertNodeRecursive(rootNode, node);
        return rootNode;
    }

    /**
     * Recursive function to insert node
     * @param root
     * @param bNumber
     * @param course
     */
    public Node insertNodeRecursive(Node rootNode, Node node) {
        if (rootNode == null) {
            rootNode = node;
            return node;
        }
        if (node.bNumber == rootNode.bNumber) {
            if (!rootNode.courses.contains(node.course)) {
                rootNode.courses.add(node.course);
            }
        }
        // recursive calls
        if (node.bNumber < rootNode.bNumber) {
            rootNode.left = insertNodeRecursive(rootNode.left, node);
        } else {
            rootNode.right = insertNodeRecursive(rootNode.right, node);
        }
        return rootNode;
    }

    /**
     * This function search for a specific node based on the BNumber
     * @param root
     * @param bNumber
     * @return
     */
    public Node searchNode(int bNumber) {
        Node temp = rootNode;
        while (temp != null) {
            if (temp.bNumber == bNumber) {
                return temp;
            } else if (temp.bNumber < bNumber) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return null;
    }

    /**
     * This function deletes the specified node
     * @param root
     * @param bNumber
     */
    public void deleteNode(Node root, String course) {
        if (root.courses.contains(course)) {
            root.courses.remove(course);
        }
    }

    /**
     * Prints the tree in inorder
     * @param node
     */
    public void printInorder() {
        printInorder(rootNode);
    }

    /**
     * Returns a string of formatted courses list
     * @param courses
     * @return
     */
    public String formattedCourseList(ArrayList<String> courses) {
        String courseList = "";
        int i = 0;
        for (String course : courses) {
            if (i == 0) {
                courseList = courseList + course;
                i++;
            } else {
                courseList = courseList + ", " + course;
            }
        }
        return courseList;
    }

    /**
     * Traverse the tree in inorder
     * @param node
     */
    public void printInorder(Node rootNode) {
        if (rootNode == null)
            return;
        printInorder(rootNode.left);
        treePrint = treePrint + rootNode.bNumber + ": " + formattedCourseList(rootNode.courses) + "\n";
        printInorder(rootNode.right);
    }

    /**
     * This function prints the messages in Result object
     * @param result
     */
    public void printNodes(Results result) {
        result.storeResult(treePrint);
    }

    /**
     * Function to validate the course
     * @param course
     * @return
     */
    public boolean validateCourse(String course) {
        return course.matches("[A-K]");
    }
}