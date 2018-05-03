package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

public class CreateWorkers {
    TreeBuilder treeBuilder;
    FileProcessor inputFileProcessor;
    PopulateThread populateThread;
    DeleteThread deleteThread;
    Thread insertThread[], deleteThreadArray[];
    Results results;
    String deleteMessage = "";

    /**
     * Constructor Function
     *
     * @param inputFileProcessor
     * @param deleteMessage
     * @param results
     * @param treeBuilder
     */
    public CreateWorkers(FileProcessor inputFileProcessor, String deleteMessage, Results results, TreeBuilder treeBuilder) {
        MyLogger.writeMessage("CreateWorker Constructor ", MyLogger.DebugLevel.CONSTRUCTOR);
        this.inputFileProcessor = inputFileProcessor;
        this.results = results;
        this.treeBuilder = treeBuilder;
        this.deleteMessage = deleteMessage;
//    	populateThread = new PopulateThread(inputFileProcessor);
    }

    /**
     * Function starts the populate workers
     *
     * @param numberOfThreads
     * @param treeBuilder
     * @throws InterruptedException
     */
    public void startPopulateWorkers(int numberOfThreads, TreeBuilder treeBuilder) throws InterruptedException {
        insertThread = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            insertThread[i] = new Thread(new PopulateThread(inputFileProcessor, treeBuilder));
            insertThread[i].start();
        }
        for (int i = 0; i < numberOfThreads; i++) {
            insertThread[i].join();
        }
    }

    /**
     * Function which starts the delete worker threads
     *
     * @param numberOfThreads
     * @param treeBuilder
     * @throws InterruptedException
     */
    public void startDeleteWorkers(int numberOfThreads, TreeBuilder treeBuilder) throws InterruptedException {
        deleteThreadArray = new Thread[numberOfThreads];
        String[] input = deleteMessage.split(" ");
        for (int i = 0; i < numberOfThreads; i++) {
            if (!input[i].equals("") && !input[i].equals("\n") && !input[i].equals(" ")) {
            	deleteThreadArray[i] = new Thread(new DeleteThread(input[i], treeBuilder));
            	deleteThreadArray[i].start();
            }
        }
        for (int i = 0; i < numberOfThreads; i++) {
            deleteThreadArray[i].join();
        }
    }
}