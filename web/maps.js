/*
    Document   : maps
    Created on : Oct 22, 2016
    Author     : Nguyen Dinh Nguyen
*/

var infowindow;
var index = 0;
//var geocoding = new google.maps.Geocoder();
//var marker;
var map;

function initM(m){
    map = m;
}

function addMarker(latlnt){
    var myLatLng = {lat: latlnt.latitude, lng: latlnt.longitude};
    map.setCenter(myLatLng);
        var marker = new google.maps.Marker({
          position: myLatLng,
          map: map,
          title: 'Hello World!'
        });
    /*var loc = {
        lat: Number(latlnt.latitude),
        lng: Number(latlnt.longitude)
    };
    alert(loc);
    map.setCenter(loc);
    marker = new google.maps.Marker({
        position: loc,
        title: "NERD",
        map: map
    });
    map.checkResize();*/
    //infowindow = new google.maps.InfoWindow({
    //    content: address
    //});
    //addMarker(address);
    //infowindow.open(map, marker);
}

function infomaker(address){
    infowindow = new google.maps.InfoWindow({
        content: address
    });
    addMarker(address);
    infowindow.open(map, marker);
}

function transport(stops){
    var directionsService = new google.maps.DirectionsService;
    var directionsDisplay = new google.maps.DirectionsRenderer;
    
    directionsService.route({
        origin: stops[0],
        destination: stops[stops.length-1],
        travelMode: 'TRANSIT',
        //transitOptions: {depatureTime: },
        waypoints: stops.slice(1, stops.length-1),
        optimizeWaypoints: true
    }, function(result, status){
        if(status === 'OK'){
            directionsDisplay.setDirections(result);
        }
        else{
            alert("Error: " + status);
        }
    });

    
}

function mapper(coordinates, transportType){
    var leg;
    switch(transportType){
        case 'bus':
            leg = new google.maps.Polyline({
                path: coordinates,
                geodesic: true,
                strokeColor: '#ffff66',
                strokeOpacity: 0.75,
                strokeWeight: 2.5
            });
            break;
        case 'subway':
            leg = new google.maps.Polyline({
                path: coordinates,
                geodesic: true,
                strokeColor: '#00cc00',
                strokeOpacity: 0.75,
                strokeWeight: 2.5
            });
            break;
        case 'walking':
            leg = new google.maps.Polyline({
                path: coordinates,
                geodesic: true,
                strokeColor: '#0039e6',
                strokeOpacity: 0.75,
                strokeWeight: 2.5
            });
            break;
        default:
            leg = new google.maps.Polyline({
                path: coordinates,
                geodesic: true,
                strokeColor: '#000000',
                strokeOpacity: 0.75,
                strokeWeight: 2.5
            });
    }     
        
    leg.setMap(map);
}


