package fileVisitors.visitor;

import fileVisitors.util.MyLogger;

//http://www.geeksforgeeks.org/primality-test-set-1-introduction-and-school-method/
public class PrimeLength implements Visitor {
	Helper helper = null;

	public PrimeLength(Helper helper) {
		this.helper = helper;
		MyLogger.writeMessage("PrimeLength Constructor ",
				MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void traverseTree(TreeBuilder treeBuilder) {

		traverseTreeRec(treeBuilder.root);
	}

	/**
	 * @param root
	 *            , Root Node of the BST tree
	 * @return nothing
	 * @throws NullPointerException
	 *             when Node is null.
	 * @see NullPointerException
	 */
	public void traverseTreeRec(Node root) {
		try {
			if (root != null) {
				traverseTreeRec(root.left);
				boolean result = helper.isPrime(root.word.length());
				if (result == true) {
					root.word = root.word + "-PRIME";
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
	 * Override
	 * @param treeBuilder
	 */
	public void visit(TreeBuilder treeBuilder) {
		MyLogger.writeMessage("PrimeLength Visit called",
				MyLogger.DebugLevel.IN_VISIT);
		traverseTree(treeBuilder);
	}
}