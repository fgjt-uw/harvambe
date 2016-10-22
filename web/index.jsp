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
        <script type="text/javascript" src="/config/private_keys"></script>
        <!-- embedded map customizations -->
        <script>
            var map;
            function initMap() {
                map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: 37.0902, lng: -95.7129},
                zoom: 4
            }
        </script>
    </head>
    <body>
        <!-- embedded map -->
        <script src="https://maps.googleapis.com/maps/api/js?key=api_keys.google_maps"
                async defer>
        </script>
    </body>
</html>
