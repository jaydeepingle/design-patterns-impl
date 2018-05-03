package airportSecurityState.airportStates;

import airportSecurityState.airportStates.AirportStateI;
import java.util.ArrayList;
import java.util.Arrays;
import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStates.AirportStateManager;

public class StatePredictor {
    AirportStateI state;
    int lowRisk, highRisk, moderateRisk;

    ArrayList<String> prohibitedItemList;
    String item;
    int day;
    static int travellerCount, prohibitedItemCount;

    float averageTrafficPerDay;
    float averageProhibitedItemsPerDay;

    public StatePredictor () {
        travellerCount = 0;
        prohibitedItemCount = 0;
        item  = "";
        lowRisk = 0;
        moderateRisk = 0;
        highRisk = 0;
        day = 0; 
        prohibitedItemList = new ArrayList<String>();

        prohibitedItemList.add("Blade");
        prohibitedItemList.add("NailCutter");
        prohibitedItemList.add("Gun");
        prohibitedItemList.add("Knife");
    }

    /**
     * It calculates the values of averageProhibitedItemsPerDay and averageTrafficPerDay
     * @param line
     */
    public void getMetricsValues(String line) {
        day = Integer.parseInt(line.split(";")[0].split(":")[1]);
        item = line.split(";")[3].split(":")[1];
        
        travellerCount = travellerCount + 1;
        this.averageTrafficPerDay = ((float)travellerCount / day);
        
        if(prohibitedItemList.contains(item)) {
            prohibitedItemCount = prohibitedItemCount + 1;
        }
        this.averageProhibitedItemsPerDay = ((float) prohibitedItemCount / day);
    }
} 