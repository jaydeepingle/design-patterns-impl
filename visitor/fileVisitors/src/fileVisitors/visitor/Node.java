package fileVisitors.visitor;

import java.io.IOException;
import java.util.ArrayList;

import fileVisitors.util.MyLogger;

/**
 * This is a Node implementation which sets word *
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
     * @param str - Word to store in a node
     */
    public Node(String str) {
        MyLogger.writeMessage("Node Constructor ",
                MyLogger.DebugLevel.CONSTRUCTOR);
        left = null;
        right = null;
        count = 1;
        word = str;
    }
}
