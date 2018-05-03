package airportSecurityState.airportStates;

import airportSecurityState.airportStates.AirportStateI;
import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStates.StatePredictor;

/**
 * Context class to play around the Airport States
 */
public class AirportStateManager {
    AirportStateI highRisk;
    AirportStateI moderateRisk;
    AirportStateI lowRisk;
    
    AirportStateI state;

    StatePredictor statePredictor;

    float averageTrafficPerDay;
    float averageProhibitedItemsPerDay;

    int[] operationIDs;
    int i;
    String returnValue;

    /**
     * Constructor
     */
    public AirportStateManager () {
        MyLogger.writeMessage("Context Class: ", MyLogger.DebugLevel.CONSTRUCTOR);
        statePredictor = new StatePredictor();
        highRisk = new HighRisk(this);
        lowRisk = new LowRisk(this);
        moderateRisk = new ModerateRisk(this);

        state = lowRisk;
    }

    /**
     * Function which initiates the state transitions
     * @param line
     * @return string consists of a sequence of IDs
     */
    public String initiate(String line) {
        operationIDs = state.tightenOrLoosenSecurity(line);
        returnValue = "";
        for(i = 0; i < operationIDs.length; i++) {
            returnValue = returnValue + operationIDs[i] + " ";
        }
        return returnValue;
    }

    /**
     * It sets the current state
     * @param newAirtportState
     */
    public void setAirportState(AirportStateI newAirtportState) {
        state = newAirtportState;
    }

    /**
     * Returns a current state
     * @return - state
     */
    public AirportStateI getState() {
        return state;
    }

    /**
     * Returns a highRisk State
     * @return - highRisk
     */
    public AirportStateI getHighRisk() {
        return highRisk;
    }

    /**
     * Returns a moderateRisk State
     * @return - moderateRisk
     */
    public AirportStateI getModerateRisk() {
        return moderateRisk;
    }

    /**
     * Returns a lowRisk State
     * @return - lowRisk
     */
    public AirportStateI getLowRisk() {
        return lowRisk;
    }
}