package fileVisitors.driver;

import fileVisitors.util.FileProcessor;
import fileVisitors.visitor.Helper;

import fileVisitors.store.Results;

import fileVisitors.util.MyLogger;
import fileVisitors.visitor.PalindromeHighlight;
import fileVisitors.visitor.PopulateVisitor;
import fileVisitors.visitor.PrimeLength;
import fileVisitors.visitor.PrintTree;
import fileVisitors.visitor.TreeBuilder;
import fileVisitors.visitor.Visitor;

public class Driver {
	/**
	 * Main function - Entry
	 * @param args - Filenames and Debug Level
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		if (args.length == 3) {
			String line = "";
			String path = args[0];
			String out = args[1];
			int debugLevel = Integer.parseInt(args[2]);

			if (debugLevel >= 0 && debugLevel <= 4) {
				MyLogger.setDebugValue(debugLevel);
			} else {
				System.err.println("Invalid Debug Level.");
				System.exit(0);
			}
			FileProcessor inputFileProcessor = new FileProcessor(path);
			Results results = new Results(out);
			Helper helper = new Helper();
			TreeBuilder treeBuilder = new TreeBuilder(results);
			Visitor populateVisitor = new PopulateVisitor(inputFileProcessor);
			treeBuilder.accept(populateVisitor);
			Visitor palindromeHighlight = new PalindromeHighlight(helper);
			treeBuilder.accept(palindromeHighlight);
			Visitor primeLength = new PrimeLength(helper);
			treeBuilder.accept(primeLength);
			Visitor printTree = new PrintTree(results);
			treeBuilder.accept(printTree);
		} else {
			System.err.println("Number of arguments provided are not valid.");
			System.exit(0);
		}
	}
}