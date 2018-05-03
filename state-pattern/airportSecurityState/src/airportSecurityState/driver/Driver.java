package airportSecurityState.driver;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.Results;

import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStates.AirportStateManager;

public class Driver {
    /**
     * Main function - Entry
     * @param args - Filenames and Debug Level
     */
    public static void main(String[] args) {
        // Arguments check
        if (args.length != 3) {
            System.err.println("Number of arguments provided are not valid.");
            System.exit(0);
        }
        
        String line, operationID;
        int debugLevel;
        // File Processors
        FileProcessor inputFileProcessor = new FileProcessor(args[0]);

        AirportStateManager airportStateManager = new AirportStateManager();
        Results results = new Results(args[1]);
        debugLevel = Integer.parseInt(args[2]);
        if(debugLevel >= 0 && debugLevel <= 4) {
            MyLogger.setDebugValue(debugLevel);
        } else {
            System.err.println("Unexpected Debug Level Value.");
            System.exit(0);
        }
        results.message = "";
        while ((line = inputFileProcessor.readLine()) != null) {
            operationID = airportStateManager.initiate(line);
            results.message = results.message + operationID + "\n";
        }
        results.writeToFile(results.message);
    }
}