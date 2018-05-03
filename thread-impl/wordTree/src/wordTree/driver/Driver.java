package wordTree.driver;

import wordTree.threadMgmt.CreateWorkers;
import wordTree.threadMgmt.TreeBuilder;
import wordTree.util.FileProcessor;

import wordTree.store.Results;

import wordTree.util.MyLogger;

public class Driver {
    /**
     * Main function - Entry
     * @param args - Filenames and Debug Level
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // Arguments check
        if (args.length == 5) {
            String line = "";
            String path = args[0];
            String out = args[1];
            int numberOfThreads = Integer.parseInt(args[2]);
            String deleteMessage = args[3];
            int debugLevel = Integer.parseInt(args[4]);

            if((numberOfThreads > 3 || numberOfThreads < 1) || (deleteMessage.split(" ").length != numberOfThreads)) {
                System.err.println("Invalid Arguments.");
                System.exit(0);
            }
            if (debugLevel >= 0 && debugLevel <= 4) {
                MyLogger.setDebugValue(debugLevel);
            } else {
                System.err.println("Invalid Debug Level.");
                System.exit(0);
            }
            FileProcessor inputFileProcessor = new FileProcessor(path);
            Results results = new Results(out);
            results.message = "";
            TreeBuilder treeBuilder =  new TreeBuilder(results);
            CreateWorkers createWorker = new CreateWorkers(inputFileProcessor, deleteMessage, results, treeBuilder);
            createWorker.startPopulateWorkers(numberOfThreads, treeBuilder);
            createWorker.startDeleteWorkers(numberOfThreads, treeBuilder);
            treeBuilder.inorder();
            String msg = treeBuilder.printNodes();
            results.writeSchedulesToFile(msg);
        } else {
            System.err.println("Number of arguments provided are not valid.");
            System.exit(0);
        }
    }
}