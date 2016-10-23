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
        <script type="text/javascript" src="parsecommand.js"></script>
        <script type="text/javascript" src="maps.js"></script>
        <script>
            var map;
            function initMap() {
                map = new google.maps.Map(document.getElementById('map'), {
                    center: {lat: 37.0902, lng: -95.7129},
                    zoom: 4,
                    mapTypeId: 'terrain'
                });
            }
            function init(){
                //document.getElementById('abc').onclick=function(){sendName(map)};
                initCommander(map);
                initM(map);
                document.getElementById('xyz').onclick=
                        function(){
                            var str = document.getElementById('comm_input').value;
                            var arr = str.split(" ");
                            var str2 = arr[1];
                            for(var i=2; i<arr.length; i++){
                                str2+=" "+arr[i];
                            }
                            parseCommand(arr[0], str2);
                            document.getElementById('comm_input').value = "";
                        }
            }
        </script>
        <style type="text/css"> 
            html, body { height: 100%; margin: 0px; padding: 0px }
            #map_canvas { height: 100%; }
        </style> 
    </head>
    <body onload="init()">
        <!-- embedded map -->
        <script src = "https://maps.googleapis.com/maps/api/js?key=AIzaSyDwT0mGyNuh1wwVQbi8EZlu5lWvpMXEYjQ&callback=initMap&libraries=places" 
                async defer>
        </script>
        <div id="map" style="height:90%; width:100%"></div>
        <!--TESTING-->
        <input type="text" rows="1" id="comm_input">
        <button id="xyz">Submit</button>
        <br>
        <!--<input type="text" rows="1" id="name_input">
        <button id="abc">Submit Name</button>-->
    </body>
</html>
