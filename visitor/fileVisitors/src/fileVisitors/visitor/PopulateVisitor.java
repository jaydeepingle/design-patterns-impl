package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;

public class PopulateVisitor implements Visitor {
	FileProcessor inputFileProcessor;
	String line;

	/**
	 * Constructor
	 * @param inputFileProcessor
	 * @param treeBuilder
	 */
	public PopulateVisitor(FileProcessor inputFileProcessor) {
		MyLogger.writeMessage("PopulateVisitor Constructor ",
				MyLogger.DebugLevel.CONSTRUCTOR);
		this.inputFileProcessor = inputFileProcessor;
	}

	/**
	 * Function to read data and insert the same in the tree
	 */
	public void readData(TreeBuilder treeBuilder) {
		while ((line = inputFileProcessor.readLine()) != null) {
			String[] input = line.split(" ");
			for (int i = 0; i < input.length; i++) {
				if (!input[i].equals("") && !input[i].equals("\n")
						&& !input[i].equals(" ")) {
					treeBuilder.insert(input[i]);
				}
			}
		}
	}

	/**
	 * Function which is overridden
	 * @param treeBuilder
	 */
	public void visit(TreeBuilder treeBuilder) {
		MyLogger.writeMessage("PopulateVisitor Visit called",
				MyLogger.DebugLevel.IN_VISIT);
		readData(treeBuilder);
	}

}