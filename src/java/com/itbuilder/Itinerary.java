
package com.itbuilder;

/**
 *
 * @author alyacarina
 */

/*
    Data-Structure representing an itinerary
*/
class Itinerary {
    
    private ItineraryNode start_point, current;
    
    Itinerary(double start_lat, double start_long){
        start_point = new ItineraryNode(start_lat, start_long);
        current = start_point;
    }
    
    void addNode(double latitude, double longitude){
        current.next = new ItineraryNode(latitude, longitude);
        current = current.next;
    }
    
    // implemented for linked_list path
    void removeNode(double latitude, double longitude){
        ItineraryNode i = start_point;
        ItineraryNode prev = i;
        while(i!=null){
            if(i.latitude == latitude && i.longitude == longitude){
                // found
                break;
            }
            prev = i;
            i = i.next;
        }
        
        if(i!=null){
            prev.next = i.next; // toss out found node
        }
    }
    
    String getJSON(){
        return "test";
    }
}
