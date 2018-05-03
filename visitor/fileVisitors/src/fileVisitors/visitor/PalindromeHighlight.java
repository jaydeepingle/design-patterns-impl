package fileVisitors.visitor;

import fileVisitors.util.MyLogger;

//http://www.geeksforgeeks.org/java-program-to-check-palindrome-using-library-methods/

public class PalindromeHighlight implements Visitor {
    Helper helper = null;

    /**
     * Constructor function
     * @param treeBuilder
     */
    public PalindromeHighlight(Helper helper) {
        this.helper = helper;
        MyLogger.writeMessage("PalindromeHighlight Constructor ",
                MyLogger.DebugLevel.CONSTRUCTOR);
    }

    public void traverseTree(TreeBuilder treeBuilder) {

        traverseTreeRec(treeBuilder.root);
    }

    /**
     * @param root , Root Node of the BST tree
     * @return nothing
     * @throws NullPointerException when Node is null.
     * @see NullPointerException
     */
    public void traverseTreeRec(Node root) {
        try {
            if (root != null) {
                traverseTreeRec(root.left);
                boolean result = helper.checkPalindrome(root.word);
                if (result == true && root.word.length() > 3) {
                    root.word = root.word.toUpperCase();
                }
                traverseTreeRec(root.right);
            }
        } catch (NullPointerException e) {
            System.out.println("Node is Null");
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Visit method to keep track
     * @param treeBuilder
     */
    public void visit(TreeBuilder treeBuilder) {
        MyLogger.writeMessage("PalindromeHighlight Visit called",
                MyLogger.DebugLevel.IN_VISIT);
        traverseTree(treeBuilder);
    }
}