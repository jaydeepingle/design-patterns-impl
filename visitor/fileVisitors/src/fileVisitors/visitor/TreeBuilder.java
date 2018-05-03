package fileVisitors.visitor;

import java.io.IOException;
import java.util.ArrayList;

import fileVisitors.store.Results;
import fileVisitors.util.MyLogger;

/**
 * This is a BST Tree implementation which insert node in the tree
 *
 * @author Siddhesh Dandekar
 * @version 1.0
 * @since 10-27-2017 Citation -
 * http://www.geeksforgeeks.org/binary-search-tree-set
 * -1-search-and-insertion/
 */

public class TreeBuilder {
    public Node root;
    private int noWords = 0, noChars = 0, noDistWords = 0;
    public ArrayList<Node> Node_Data = new ArrayList<Node>();
    Results results;

    /**
     * Constructor Function
     *
     * @param results
     */
    public TreeBuilder(Results results) {
        MyLogger.writeMessage("TreeBuilder Constructor ",
                MyLogger.DebugLevel.CONSTRUCTOR);
        root = null;
        this.results = results;
    }

    /**
     * @param B_no , B_Number of the student
     * @return Node, Node from the tree if present otherwise null
     * @throws Exception when integer is wrong.
     * @see Exception
     */
    public Node search(String delWord) {
        try {
            Node check_node = root;
            while (check_node != null) {
                if (check_node.word.equals(delWord)) {
                    return check_node;
                }
                if (delWord.compareTo(check_node.word) < 0) {
                    check_node = check_node.left;
                } else if (delWord.compareTo(check_node.word) > 0) {
                    check_node = check_node.right;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    /**
     * @param new_node - Node to be inserted in the BST tree
     * @return Node - Root node if Tree is not empty otherwise NULL
     * @throws NullPointerException when Node is null.
     * @see NullPointerException
     */
    public Node insert(String str) {
        try {
            root = insertNode(root, str);
            return root;
        } catch (NullPointerException e) {
            System.out.println("Node is Null");
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    /**
     * @param root - Root of the BST tree
     * @param new_node - Node to be inserted in the BST tree
     * @return Node - Root node if Tree is not empty otherwise NULL
     * @throws NullPointerException when Node is null.
     * @see NullPointerException
     */
    public Node insertNode(Node root, String str) {
        try {
            if (root == null) {
                root = new Node(str);
                return root;
            }

            if (str.equals(root.word)) {
                root.count++;
            } else if (str.compareTo(root.word) < 0) {
                root.left = insertNode(root.left, str);
            } else if (str.compareTo(root.word) > 0) {
                root.right = insertNode(root.right, str);
            }
            return root;
        } catch (NullPointerException e) {
            System.out.println("Node is Null");
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    /**
     * @param n - Node from which courses to be deleted
     * @param Course - Course Name to be deleted
     * @return nothing
     * @throws NullPointerException when Node is null.
     * @see NullPointerException
     */
    public void delete(String delWord) {
        try {
            Node delNode = search(delWord);
            if (delNode != null) {
                if (delNode.count > 0) {
                    delNode.count--;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Node is Null");
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Inorder traversal
     */
    public void inorder() {
        inorderRec(root);
    }

    /**
     * @param root, Root Node of the BST tree
     * @return nothing
     * @throws NullPointerException when Node is null.
     * @see NullPointerException
     */
    public void inorderRec(Node root) {
        try {
            if (root != null) {
                inorderRec(root.left);
                Node_Data.add(root);
                inorderRec(root.right);
            }
        } catch (NullPointerException e) {
            System.out.println("Node is Null");
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * @param R - Results class object
     * @return nothing
     */
    public String printNodes() {
        String returnValue = "";
        try {
            for (int i = 0; i < Node_Data.size(); i++) {
                if (i > 0) {
                    returnValue = returnValue + "" + Node_Data.get(i).word + "\n";
                } else {
                    returnValue = Node_Data.get(i).word + "\n";
                }
            }
            results.storeResult(returnValue);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return returnValue;
    }

    /**
     * accept method for visitors
     * @param visitor
     */
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
