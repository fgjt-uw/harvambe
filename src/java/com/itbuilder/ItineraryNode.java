
package com.itbuilder;

/**
 *
 * @author alyacarina
 */
class ItineraryNode {
    
    double latitude, longitude;
    ItineraryNode next;
    
    ItineraryNode(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
        next = null;
    }
    
    boolean hasNext(){
        return next != null;
    }
}
