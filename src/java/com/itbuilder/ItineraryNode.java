
package com.itbuilder;

/**
 *
 * @author alyacarina
 */
class ItineraryNode {
    
    final int id;
    double latitude, longitude;
    String name;
    ItineraryNode next;
    
    ItineraryNode(int id, double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
        this.id = id;
        next = null;
    }
    
    boolean hasNext(){
        return next != null;
    }
    
}
