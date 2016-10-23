
package com.itbuilder;

/**
 *
 * @author alyacarina
 */
class ItineraryNode {
    
    double latitude, longitude;
    String name;
    ItineraryNode next;
    
    ItineraryNode(int id, double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
        next = null;
    }
    
    boolean hasNext(){
        return next != null;
    }
    
}
