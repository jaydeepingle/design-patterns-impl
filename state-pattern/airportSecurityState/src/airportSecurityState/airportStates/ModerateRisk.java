package airportSecurityState.airportStates;

import airportSecurityState.airportStates.AirportStateI;
import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStates.AirportStateManager;

public class ModerateRisk implements AirportStateI {
    AirportStateManager airportState;
    StatePredictor statePredictor;

    float averageTrafficPerDay, averageProhibitedItemsPerDay;

    /**
     * Constructor which takes the instance of AirportStateManager as a param
     * @param newAirportState
     */
    public ModerateRisk (AirportStateManager newAirportState) {
        MyLogger.writeMessage("Moderate Risk: ", MyLogger.DebugLevel.CONSTRUCTOR);
        airportState = newAirportState;
        statePredictor = new StatePredictor();
    }

    /**
     * Method implemented
     * @param line
     * @return returns an integer array of Operation IDs
     */
    public int[] tightenOrLoosenSecurity(String line) {
        statePredictor.getMetricsValues(line);

        averageTrafficPerDay = statePredictor.averageTrafficPerDay;
        averageProhibitedItemsPerDay = statePredictor.averageProhibitedItemsPerDay;

        if((averageTrafficPerDay >= 8) || (averageProhibitedItemsPerDay >= 2)) {
                MyLogger.writeMessage("ModerateRisk => HighRisk", MyLogger.DebugLevel.IN_RUN);
                airportState.setAirportState(airportState.getHighRisk());
                return highOperationIDs;
        } else if((averageTrafficPerDay >= 4 && averageTrafficPerDay < 8) ||
            (averageProhibitedItemsPerDay >= 1 && averageProhibitedItemsPerDay < 2)) {
                airportState.setAirportState(airportState.getModerateRisk());
                return moderateOperationIDs;
        } else if((averageTrafficPerDay >= 0 && averageTrafficPerDay < 4) || 
            (averageProhibitedItemsPerDay >= 0 && averageProhibitedItemsPerDay < 1)) {
                MyLogger.writeMessage("ModerateRisk => LowRisk", MyLogger.DebugLevel.IN_RUN);
                airportState.setAirportState(airportState.getLowRisk());
                return lowOperationIDs;
        } else {
            return moderateOperationIDs;
        }
    }
}