package fileVisitors.visitor;

import fileVisitors.store.Results;
import fileVisitors.util.MyLogger;

/**
 * @author jaydeep
 */
public class PrintTree implements Visitor {
	Results results;

	/**
	 * Constructor
	 * @param treeBuilder
	 * @param results
	 */
	public PrintTree(Results results) {
		MyLogger.writeMessage("PrintTree Constructor",
				MyLogger.DebugLevel.CONSTRUCTOR);
		this.results = results;
	}

	/**
	 * Function to print the tree
	 */
	public void print(TreeBuilder treeBuilder) {
		treeBuilder.inorder();
		String msg = treeBuilder.printNodes();
		results.writeSchedulesToFile(msg);
	}

	/**
	 * Overridden method
	 * @param treeBuilder
	 */
	public void visit(TreeBuilder treeBuilder) {
		MyLogger.writeMessage("PrintTree Visit called",
				MyLogger.DebugLevel.IN_VISIT);
		print(treeBuilder);
	}
}