package studentCoursesBackup.driver;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.exception.ValueNotInRangeException;

/**
 * Driver class
 */
public class Driver {
    /**
     * Main function which takes 5 arguments array including input, delete and output file names
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 5) {
            System.err.println("Number of arguments provided are not valid.");
            System.exit(0);
        }

        String line, course;
        int bNumber;
        // File Processors
        FileProcessor inputFileProcessor = new FileProcessor(args[0]);
        FileProcessor deleteFileProcessor = new FileProcessor(args[1]);

        // TreeBuilder objects
        TreeBuilder tree = new TreeBuilder();
        TreeBuilder backup1 = new TreeBuilder();
        TreeBuilder backup2 = new TreeBuilder();

        // Node objects
        Node node = null;
        Node nodeBackup1 = null;
        Node nodeBackup2 = null;
        Node currentNode = null;
        boolean present = true;

        // Results Object
        Results result1 = null;
        Results result2 = null;
        Results result3 = null;

        // Read File
        while ((line = inputFileProcessor.readLine()) != null) {
            try {
                bNumber = Integer.parseInt(line.split(":")[0].trim());
                course = line.split(":")[1].trim();
                currentNode = tree.searchNode(bNumber);

                if(course.matches("[A-K]")) {
                    if (currentNode != null) {
                        if(!currentNode.courses.contains(course)) {
                            currentNode.courses.add(course);
                            currentNode.backupList.get(0).courses.add(course);
                            currentNode.backupList.get(1).courses.add(course);
                        }
                    } else {
                        node = new Node(bNumber, course);
                        nodeBackup1 = (Node) node.clone();
                        nodeBackup2 = (Node) node.clone();
                        node.registerObserver(nodeBackup1);
                        node.registerObserver(nodeBackup2);
                        tree.insertNode(node);
                        backup1.insertNode(nodeBackup1);
                        backup2.insertNode(nodeBackup2);
                    }
                } else {
                    continue;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        // Test Code
        while ((line = deleteFileProcessor.readLine()) != null) {
            try {
                bNumber = Integer.parseInt(line.split(":")[0].trim());
                course = line.split(":")[1].trim();
                currentNode = tree.searchNode(bNumber);
                if(currentNode != null) {
                    tree.deleteNode(currentNode, course);
                    currentNode.notifyAll(course);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        result1 = new Results(args[2]);
        tree.printInorder();
        tree.printNodes(result1);
        result1.writeToFile(result1.message);

        result2 = new Results(args[3]);
        backup1.printInorder();
        backup1.printNodes(result2);
        result2.writeToFile(result2.message);

        result3 = new Results(args[4]);
        backup2.printInorder();
        backup2.printNodes(result3);
        result3.writeToFile(result3.message);
    }
}