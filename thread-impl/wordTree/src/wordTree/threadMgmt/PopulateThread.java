package wordTree.threadMgmt;

import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

public class PopulateThread implements Runnable {
    FileProcessor inputFileProcessor;
    String line;
    TreeBuilder treeBuilder;

    /**
     * @param inputFileProcessor
     * @param treeBuilder
     */
    public PopulateThread(FileProcessor inputFileProcessor, TreeBuilder treeBuilder) {
        MyLogger.writeMessage("PopulateThread Constructor ", MyLogger.DebugLevel.CONSTRUCTOR);
        this.inputFileProcessor = inputFileProcessor;
        this.treeBuilder = treeBuilder;
    }

    @Override
    /**
     *
     */
    public void run() {
        MyLogger.writeMessage("PopulateThread Run ", MyLogger.DebugLevel.IN_THREAD_RUN);
        synchronized (treeBuilder) {
            // TODO Auto-generated method stub
            while ((line = inputFileProcessor.readLine()) != null) {
                String[] input = line.split(" ");
                for (int i = 0; i < input.length; i++) {
                    if (!input[i].equals("") && !input[i].equals("\n") && !input[i].equals(" ")) {
                        treeBuilder.insert(input[i]);
                    }
                }
                // results.message = results.message + operationID + "\n";
            }
        }
    }

    /*public void print() {
        treeBuilder.inorder();
        treeBuilder.printNodes();
    }*/
}