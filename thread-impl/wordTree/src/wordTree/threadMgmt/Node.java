package wordTree.threadMgmt;

import java.io.IOException;
import java.util.ArrayList;
import wordTree.util.MyLogger;

/**
 * This is a Node implementation which sets B_Number, Courses and subject Link to the observers
 * This class implements Interface Cloneable, ObserverI and SubjectI
 *
 * @author Siddhesh Dandekar
 * @version 1.0
 * @since 09-27-2017
 */

public class Node {
    public Node left, right;
    public int count;
    String word = "";

    /**
     * @param B_no,   B_number of the tree node
     * @param C_Name, Course_Name of the tree node
     */
    public Node(String str) {
        MyLogger.writeMessage("Node Constructor ", MyLogger.DebugLevel.CONSTRUCTOR);
        left = null;
        right = null;
        count = 1;
        word = str;
    }
}
