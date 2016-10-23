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
                initM(map);
                initCommander(map);
            }
            function submitall() {
                //bot
                xmlhttp = new XMLHttpRequest();
                xmlhttp.open("GET", "https://api.motion.ai/1.0/getConversations?key=770b5f26f9733897f86e87ef0b7d3713&botID=15046&botType=webchat", true);
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState == XMLHttpRequest.DONE && xmlhttp.status == 200) {
                        parseCommand("add", xmlhttp.responseText.messages[0].result);
                    }
                };
                xmlhttp.send();
            }
        </script>
        <style type="text/css"> 
            html, body { height: 100%; margin: 0px; padding: 0px }
            #map_canvas { height: 100%; }
        </style> 
    </head>
    <body>
        <!-- embedded map -->
        <script src = "https://maps.googleapis.com/maps/api/js?key=AIzaSyDwT0mGyNuh1wwVQbi8EZlu5lWvpMXEYjQ&callback=initMap&libraries=places" 
                async defer>
        </script>
        <div id="map" style="height:95%; width:100%"></div>
        <!--<input type="text" rows="1" id="name_input">-->
        <button id="abc" onclick="submitall()">Refresh</button>
        <link href="https://api.motion.ai/sdk/webchat.css" rel="stylesheet" type="text/css">
        <script src="https://api.motion.ai/sdk/webchat.js"></script>
        <script>
            motionAI_Init('15046?color=62a8ea&sendBtn=SEND&inputBox=Type+something...&token=b7940a78e2ab89083afb4eb28448a8a7', true, 400, 470); /* botID with access token, display bot icon?, modal width, modal height */
            /* you may also invoke motionAI_Open(); to manually open the modal */
        </script>
    </body>
</html>
