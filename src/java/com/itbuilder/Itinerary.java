
package com.itbuilder;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

/**
 *
 * @author alyacarina
 */

/*
    Data-Structure representing an itinerary
*/
class Itinerary {
    
    private ItineraryNode start_point, current_last;
    
    Itinerary(double start_lat, double start_long){
        start_point = new ItineraryNode(start_lat, start_long);
        current_last = start_point;
    }
    
    void addNode(double latitude, double longitude){
        current_last.next = new ItineraryNode(latitude, longitude);
        current_last = current_last.next;
    }
    
    // implemented for linked_list path
    void removeNode(int id){
        ItineraryNode i = start_point;
        ItineraryNode prev = i;
        while(i!=null){
            if(i.id == id){
                // found
                break;
            }
            prev = i;
            i = i.next;
        }
        
        if(i!=null && prev != i){
            prev.next = i.next; // toss out found node
        } else if(prev == start_point && i==null) {
            start_point = null;
        }
    }
    
    String getJSONString() {
        try {
            ItineraryNode it = start_point;
            String s = "";
            while(it != null){
                JSONObject j = new JSONObject();
                j.put("latitude", it.latitude);
                j.put("longitude", it.longitude);
                s+=j.toString()+"\n";
                it = it.next;
            }
            return s;
        } catch(JSONException jason){
            return "";
        }
    }
    
    boolean isValid(){
        return start_point != null;
    }
}
