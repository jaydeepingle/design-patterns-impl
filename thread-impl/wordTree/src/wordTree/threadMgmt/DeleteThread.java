package wordTree.threadMgmt;

import wordTree.util.MyLogger;

public class DeleteThread implements Runnable {
    TreeBuilder treeBuilder;
    String deleteMessage = "";

    /**
     * Constructor function takes the String and TreeBuilder Object
     *
     * @param deleteMessage
     * @param treeBuilder
     */
    public DeleteThread(String deleteMessage, TreeBuilder treeBuilder) {
        MyLogger.writeMessage("DeleteThread Constructor ", MyLogger.DebugLevel.CONSTRUCTOR);
        this.deleteMessage = deleteMessage;
        this.treeBuilder = treeBuilder;
    }

    @Override
    public void run() {
        MyLogger.writeMessage("DeleteThread Run ", MyLogger.DebugLevel.IN_THREAD_RUN);
        // TODO Auto-generated method stub
        synchronized (treeBuilder) {
        	treeBuilder.delete(deleteMessage);
        }
    }
}