
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
    private int id = 0;
    
    Itinerary(double start_lat, double start_long){
        start_point = new ItineraryNode(id, start_lat, start_long);
        current_last = start_point;
        id++;
    }
    
    void addNode(double latitude, double longitude){
        current_last.next = new ItineraryNode(id, latitude, longitude);
        current_last = current_last.next;
        id++;
    }
    
    void addNode(double latitude, double longitude, String name){
        addNode(latitude, longitude);
        current_last.name = name;
    }
    
    // implemented for linked_list path
    void removeNode(int id){
        
        int x = 0;
        if(id == x){
            start_point = start_point.next;
            return;
        }
        
        ItineraryNode i = start_point.next;
        ItineraryNode prev = start_point;
        while(i!=null){
            if(x == id){
                // found
                prev.next = i.next;
                break;
            }
            prev = i;
            i = i.next;
            x++;
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
                j.put("name", it.name);
                s+=j.toString()+" ";
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
