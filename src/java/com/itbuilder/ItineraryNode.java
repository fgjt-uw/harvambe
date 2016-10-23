
package com.itbuilder;

/**
 *
 * @author alyacarina
 */
class ItineraryNode {
    
    static int LAST_ID = 0;
    final int id;
    double latitude, longitude;
    ItineraryNode next;
    
    ItineraryNode(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
        id = LAST_ID;
        LAST_ID++;
        next = null;
    }
    
    boolean hasNext(){
        return next != null;
    }
    
}
