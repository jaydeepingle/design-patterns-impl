package airportSecurityState.airportStates;

/**
 * Airport State Interface - To maintain the state of the airport
 */
public interface AirportStateI {    
    int[] lowOperationIDs = new int[]{1, 3, 5, 7, 9};
    int[] moderateOperationIDs = new int[]{2, 3, 5, 8, 9};
    int[] highOperationIDs = new int[]{2, 4, 6, 8, 10};

    /**
     * It tightens or loosens the security state
     * @param line
     * @return integer array
     */
    public int[] tightenOrLoosenSecurity(String line);
}