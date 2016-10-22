<%-- 
    Document   : index
    Created on : Oct 21, 2016, 11:32:18 PM
    Author     : alyacarina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wandaless</title>
        <!-- embedded map customizations -->
        <script>
            var map;
            function initMap() {
                map = new google.maps.Map(document.getElementById('map'), {
                    center: {lat: 37.0902, lng: -95.7129},
                    zoom: 4,
                    mapTypeId: 'terrain'
                });
            }
        </script>
        <script type="text/javascript" src="servercomm.js"></script>
        <style type="text/css"> 
            html, body { height: 100%; margin: 0px; padding: 0px }
            #map_canvas { height: 100%; }
        </style> 
    </head>
    <body onload="init()">
        <!-- embedded map -->
        <script src = "https://maps.googleapis.com/maps/api/js?key=AIzaSyDwT0mGyNuh1wwVQbi8EZlu5lWvpMXEYjQ&callback=initMap" 
                async defer>
        </script>
        <div id="map" style="height:90%; width:100%"></div>
        <div id="test"></div>
    </body>
</html>
